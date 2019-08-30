package top.axbt.pta.controller;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.axbt.pta.domain.GroupAve;
import top.axbt.pta.domain.TbInfo;
import top.axbt.pta.service.InfoService;

import top.axbt.pta.entity.PageResult;
import top.axbt.pta.entity.Result;
/**
 * controller
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/info")
public class InfoController {

	@Autowired
	private InfoService infoService;
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findAll")
	public List<TbInfo> findAll(){
		return infoService.findAll();
	}
	
	
	/**
	 * 返回全部列表
	 * @return
	 */
	@RequestMapping("/findPage")
	public PageResult  findPage(int page,int rows){			
		return infoService.findPage(page, rows);
	}
	
	/**
	 * 增加
	 * @param info
	 * @return
	 */
	@RequestMapping("/add")
	public Result add(@RequestBody TbInfo info){
		System.out.println("添加时间："+new Date());
		try {
			//info.setDate(new Date());
			if (info.getImgurl()==null){
				return new Result(false, "请上传截图哦");
			}
			if (info.getL01()==null||info.getL02()==null||info.getL03()==null){
				return new Result(false, "题目分数不能为空哦");
			}
			if(info.getDate()==null){
				return new Result(false, "请输入对应题目的提交日期哦");
			}
			infoService.add(info);
			return new Result(true, "增加成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "题目分数不能为空哦");
		}
	}
	
	/**
	 * 修改
	 * @param info
	 * @return
	 */
	@RequestMapping("/update")
	public Result update(@RequestBody TbInfo info){
		try {
			infoService.update(info);
			return new Result(true, "修改成功");
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "修改失败");
		}
	}	
	
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	@RequestMapping("/findOne")
	public TbInfo findOne(Integer id){
		return infoService.findOne(id);		
	}
	
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete")
	public Result delete(Integer [] ids){
		try {
			infoService.delete(ids);
			return new Result(true, "删除成功"); 
		} catch (Exception e) {
			e.printStackTrace();
			return new Result(false, "删除失败");
		}
	}
	
		/**
	 * 查询+分页
	 * @param
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/search")
	public PageResult search(@RequestBody TbInfo info, int page, int rows  ){
		return infoService.findPage(info, page, rows);		
	}

	//查询指定日期的组均分排名1.输入日期，查询该日期5个组的分数计算平均值，得出最高值
	@RequestMapping("/searchGroupAve")
	public GroupAve searchGroupAve(/*@RequestBody TbInfo info, int page, int rows */ ){
		TbInfo info = new TbInfo();

	    Calendar calendar = Calendar.getInstance();
	    int year = calendar.get(Calendar.YEAR);
	    int month = calendar.get(Calendar.MONTH);
	    int day = calendar.get(Calendar.DAY_OF_MONTH);

        calendar.set(year,month,day,0,0,0);

        info.setDate(calendar.getTime());
		String[] arr = {"V","W","X","Y","Z"};
		int[] peoples = {14,21,22,21,12};
		List<Double> totalList = new ArrayList<>();
		for(int i = 0;i<arr.length;i++){
			info.setNum(arr[i]);
			PageResult pageResult = infoService.findPage(info,1,20);
			List<TbInfo> tbInfoListV = (List<TbInfo>) pageResult.getRows();

			if (tbInfoListV.size()==0){
                //System.out.println("0");
                totalList.add(0.0);
            }else{
                int total = 0;
                for(TbInfo tbInfo:tbInfoListV){
                    int m = tbInfo.getL01() + tbInfo.getL02() + tbInfo.getL03();
                    total+=m;
                }
                totalList.add((double)total/peoples[i]);
            }

		}
        List<GroupAve> groupAves = new ArrayList<>();
		Double max = Collections.max(totalList);
		GroupAve groupAve = new GroupAve();
		groupAve.setAve(totalList);
		groupAve.setHigh(max);

		return groupAve;
    }
	//查询今天之前的组均分排名1.取得今天的日期，计算与21日的天数，调用第一个函数查出所有天数的分数
	//查询指定校区的今日总分排名
	//查询指定校区的今日之前总分排名
}

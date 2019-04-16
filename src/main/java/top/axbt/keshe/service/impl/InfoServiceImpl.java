package top.axbt.keshe.service.impl;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import top.axbt.keshe.dao.TbInfoMapper;
import top.axbt.keshe.domain.TbInfo;
import top.axbt.keshe.domain.TbInfoExample;
import top.axbt.keshe.service.InfoService;

import top.axbt.entity.PageResult;

/**
 * 服务实现层
 * @author Administrator
 *
 */
@Service
public class InfoServiceImpl implements InfoService {

	@Autowired
	private TbInfoMapper infoMapper;
	
	/**
	 * 查询全部
	 */
	@Override
	public List<TbInfo> findAll() {
		TbInfoExample example=new TbInfoExample();
		example.setOrderByClause("date desc");
		return infoMapper.selectByExample(example);
	}

	/**
	 * 按分页查询
	 */
	@Override
	public PageResult findPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		TbInfoExample example=new TbInfoExample();
		example.setOrderByClause("id desc");
		Page<TbInfo> page=   (Page<TbInfo>) infoMapper.selectByExample(example);
		return new PageResult(page.getTotal(), page.getResult());
	}

	/**
	 * 增加
	 */
	@Override
	public void add(TbInfo info) {
		infoMapper.insert(info);
	}

	
	/**
	 * 修改
	 */
	@Override
	public void update(TbInfo info){
		infoMapper.updateByPrimaryKey(info);
	}	
	
	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	@Override
	public TbInfo findOne(Integer id){
		return infoMapper.selectByPrimaryKey(id);
	}

	/**
	 * 批量删除
	 */
	@Override
	public void delete(Integer[] ids) {
		for(Integer id:ids){
			infoMapper.deleteByPrimaryKey(id);
		}		
	}
	
	
		@Override
	public PageResult findPage(TbInfo info, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		
		TbInfoExample example=new TbInfoExample();
		TbInfoExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause("id desc");
		if(info!=null){			
			if(info.getNum()!=null && info.getNum().length()>0){
				criteria.andNumLike("%"+info.getNum()+"%");
			}
			if(info.getName()!=null && info.getName().length()>0){
				criteria.andNameLike("%"+info.getName()+"%");
			}
			if(info.getImgurl()!=null && info.getImgurl().length()>0){
				criteria.andImgurlLike("%"+info.getImgurl()+"%");
			}
			if(info.getDate()!=null){
				Date date = info.getDate();

				Calendar calendar = Calendar.getInstance();
				calendar.setTime(date);
				calendar.add(Calendar.DAY_OF_MONTH,1);
				System.out.println(calendar.getTime());
				criteria.andDateBetween(info.getDate(), calendar.getTime());
			}

	
		}
		
		Page<TbInfo> page= (Page<TbInfo>)infoMapper.selectByExample(example);		
		return new PageResult(page.getTotal(), page.getResult());
	}


	//查询第一组
	private List<TbInfo> findGroup(String num){
		TbInfoExample example=new TbInfoExample();
		TbInfoExample.Criteria criteria = example.createCriteria();
		criteria.andNumLike(num);
		List<TbInfo> tbInfoList = infoMapper.selectByExample(example);
		return tbInfoList;
	}

	@Override
	public List<TbInfo> findZhuXiao(){
		List<TbInfo> one = findGroup("%T1%");
		List<TbInfo> two = findGroup("%T2%");
		List<TbInfo> three = findGroup("%T3%");
		List<TbInfo> four = findGroup("%T6Z%");
		List<TbInfo> result = new ArrayList<>();
		result.addAll(one);
		result.addAll(two);
		result.addAll(three);
		result.addAll(four);
		return result;
	}

	@Override
	public List<TbInfo> findJinChen(){
		List<TbInfo> one = findGroup("%Y%");
		List<TbInfo> two = findGroup("%T5%");
		List<TbInfo> three = findGroup("%T6J%");
		List<TbInfo> result = new ArrayList<>();
		result.addAll(one);
		result.addAll(two);
		result.addAll(three);
		Collections.sort(result,new Comparator<TbInfo>(){

			@Override
			public int compare(TbInfo o1, TbInfo o2) {

				return o1.getName().compareTo(o2.getName());
			}
		});
		return result;
	}



	
}

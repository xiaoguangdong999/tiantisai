package top.axbt.keshe.service;
import java.util.List;

import top.axbt.entity.PageResult;
import top.axbt.keshe.domain.TbInfo;

/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface InfoService {

	/**
	 * 返回全部列表
	 * @return
	 */
	public List<TbInfo> findAll();
	
	
	/**
	 * 返回分页列表
	 * @return
	 */
	public PageResult findPage(int pageNum, int pageSize);
	
	
	/**
	 * 增加
	*/
	public void add(TbInfo info);
	
	
	/**
	 * 修改
	 */
	public void update(TbInfo info);
	

	/**
	 * 根据ID获取实体
	 * @param id
	 * @return
	 */
	public TbInfo findOne(Integer id);
	
	
	/**
	 * 批量删除
	 * @param ids
	 */
	public void delete(Integer[] ids);

	/**
	 * 分页
	 * @param pageNum 当前页 码
	 * @param pageSize 每页记录数
	 * @return
	 */
	public PageResult findPage(TbInfo info, int pageNum, int pageSize);


	List<TbInfo> findZhuXiao();

	List<TbInfo> findJinChen();
	
}

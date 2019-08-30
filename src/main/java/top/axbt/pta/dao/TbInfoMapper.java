package top.axbt.pta.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import top.axbt.pta.domain.TbInfo;
import top.axbt.pta.domain.TbInfoExample;

import java.util.List;

@Repository
public interface TbInfoMapper {
    long countByExample(TbInfoExample example);

    int deleteByExample(TbInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TbInfo record);

    int insertSelective(TbInfo record);

    List<TbInfo> selectByExample(TbInfoExample example);

    TbInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TbInfo record, @Param("example") TbInfoExample example);

    int updateByExample(@Param("record") TbInfo record, @Param("example") TbInfoExample example);

    int updateByPrimaryKeySelective(TbInfo record);

    int updateByPrimaryKey(TbInfo record);
}
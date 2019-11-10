package com.lei.dao;

import com.lei.po.User_identity;
import com.lei.po.User_identityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface User_identityMapper {
    long countByExample(User_identityExample example);

    int deleteByExample(User_identityExample example);

    int deleteByPrimaryKey(Integer iid);

    int insert(User_identity record);

    int insertSelective(User_identity record);

    List<User_identity> selectByExample(User_identityExample example);

    User_identity selectByPrimaryKey(Integer iid);

    int updateByExampleSelective(@Param("record") User_identity record, @Param("example") User_identityExample example);

    int updateByExample(@Param("record") User_identity record, @Param("example") User_identityExample example);

    int updateByPrimaryKeySelective(User_identity record);

    int updateByPrimaryKey(User_identity record);
}
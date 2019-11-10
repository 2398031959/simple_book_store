package com.lei.dao;

import com.lei.po.Book_type;
import com.lei.po.Book_typeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Book_typeMapper {
    long countByExample(Book_typeExample example);

    int deleteByExample(Book_typeExample example);

    int deleteByPrimaryKey(Integer tid);

    int insert(Book_type record);

    int insertSelective(Book_type record);

    List<Book_type> selectByExample(Book_typeExample example);

    Book_type selectByPrimaryKey(Integer tid);

    int updateByExampleSelective(@Param("record") Book_type record, @Param("example") Book_typeExample example);

    int updateByExample(@Param("record") Book_type record, @Param("example") Book_typeExample example);

    int updateByPrimaryKeySelective(Book_type record);

    int updateByPrimaryKey(Book_type record);
}
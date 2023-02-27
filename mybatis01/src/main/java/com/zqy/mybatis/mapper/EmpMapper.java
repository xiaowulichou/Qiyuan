package com.zqy.mybatis.mapper;

import com.zqy.mybatis.pojo.Emp;
import org.apache.ibatis.annotations.Param;

public interface EmpMapper {
    Emp getEmpAndDeptById(@Param("id") int id);
    Emp getEmpAndDeptById2(@Param("id") int id);
    Emp getEmpAndDeptById3(@Param("id") int id);
}

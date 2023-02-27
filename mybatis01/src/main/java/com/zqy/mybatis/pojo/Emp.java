package com.zqy.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Emp {
    private Integer id ;
    private String name ;
    private String gender ;
    private Double salary ;
    private Date joinDate;
    private Integer deptId;

    private Dept dept=new Dept();
}
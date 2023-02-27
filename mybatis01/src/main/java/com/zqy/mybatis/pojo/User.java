package com.zqy.mybatis.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class User {
    private Integer id;
    private String name;
    private  String pass;
    private  Integer age;
    private  String sex;
    private  String email;
}

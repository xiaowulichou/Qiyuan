package com.zqy.mybatis.mapper;

import com.zqy.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 添加用户信息
     */
    int insertUser();

    List<User> getUserList();

    int deleteUser();

    int updateUser();

    User getUserById();

    User getUserById2(@Param("id")int id,
                      @Param("name")String name);

    List<User> testMohu(@Param("mohu") String mohu);

    int zqy(@Param("tableName")String tableName);

    int deleteMore(@Param("ids") String ids);

    List<User> getAllUser(@Param("tableName") String tableName);
}

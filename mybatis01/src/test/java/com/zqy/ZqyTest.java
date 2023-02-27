package com.zqy;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.zqy.mybatis.mapper.DeptMapper;
import com.zqy.mybatis.mapper.UserMapper;
import com.zqy.mybatis.pojo.Dept;
import com.zqy.mybatis.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ZqyTest {

    private  SqlSession sqlSession ;
    @Before
    public void init()throws  IOException{
        //读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
         sqlSession= sqlSessionFactory.openSession(true);
    }
    @Test
    public void insertTest() throws IOException {

        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配  映射文件中的SQL标签，并执行标签中的SQL语句
        int result = userMapper.insertUser();
        //sqlSession.commit();
        System.out.println("结果：" + result);
    }
    @Test
    public void getUserListTest() throws IOException {
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User>userList=userMapper.getUserList();
        for (User user : userList) {
            System.out.println("user = " + user);
        }
    }
    @Test
    public void deleteTest() throws IOException {
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i=userMapper.deleteUser();
        System.out.println("i = " + i);
    }
    @Test
    public void updateTest() throws IOException {
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i=userMapper.updateUser();
        System.out.println("i = " + i);
    }

    @Test
    public void getUserByIdTest() throws IOException {
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user=userMapper.getUserById2(6,"ybc");
        System.out.println("user = " + user);
    }

    @Test
    public void mohuTest() throws IOException {
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
       List<User>userList=userMapper.testMohu("y");
        for (User user : userList) {
            System.out.println("user = " + user);
        }
    }

    @Test
    public void zqyTest() throws IOException {
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i=userMapper.zqy("t_user");
        System.out.println("i = " + i);
    }

    @Test
    public void deleteMoreTest() throws IOException {
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int i=userMapper.deleteMore("4,5,6");
        System.out.println("i = " + i);
    }

    @Test
    public void getAllUserTest() throws IOException {
        //通过代理模式创建UserMapper接口的代理实现类对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User>userList=userMapper.getAllUser("t_user");
        for (User user : userList) {
            System.out.println("user = " + user);
        }
    }

}

package com.zqy;

import com.zqy.mybatis.mapper.EmpMapper;
import com.zqy.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class EmpMapperTest {
    private SqlSession sqlSession ;
    @Before
    public void init() throws IOException {
        //读取MyBatis的核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //通过核心配置文件所对应的字节输入流创建工厂类SqlSessionFactory，生产SqlSession对象
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都必须手动提交或回滚事务
//        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建SqlSession对象，此时通过SqlSession对象所操作的sql都会自动提交
        sqlSession = sqlSessionFactory.openSession(true);
    }

    @Test
    public void getEmpAndDeptByIdTest(){
        //通过代理模式创建UserMapper接口的代理实现类对象
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配
        //映射文件中的SQL标签，并执行标签中的SQL语句.
        Emp emp = empMapper.getEmpAndDeptById(1);
        System.out.println("id:"+emp.getId());
        System.out.println("name:"+emp.getName());
        System.out.println("gender:"+emp.getGender());
        System.out.println("salary:"+emp.getSalary());
        System.out.println("joinDate:"+ emp.getJoinDate().toLocaleString());
        System.out.println("deptId:"+emp.getDeptId());
        System.out.println("dept.id:"+emp.getDept().getId());
        System.out.println("dept.name:"+emp.getDept().getName());
    }

    @Test
    public void getEmpAndDeptById2Test(){
        //通过代理模式创建UserMapper接口的代理实现类对象
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配
        //映射文件中的SQL标签，并执行标签中的SQL语句.
        Emp emp = empMapper.getEmpAndDeptById2(1);
        System.out.println("id:"+emp.getId());
        System.out.println("name:"+emp.getName());
        System.out.println("gender:"+emp.getGender());
        System.out.println("salary:"+emp.getSalary());
        System.out.println("joinDate:"+ emp.getJoinDate().toLocaleString());
        System.out.println("deptId:"+emp.getDeptId());
        System.out.println("dept.id:"+emp.getDept().getId());
        System.out.println("dept.name:"+emp.getDept().getName());
    }

    @Test
    public void getEmpAndDeptById3Test(){
        //通过代理模式创建UserMapper接口的代理实现类对象
        EmpMapper empMapper = sqlSession.getMapper(EmpMapper.class);
        //调用UserMapper接口中的方法，就可以根据UserMapper的全类名匹配元素文件，通过调用的方法名匹配
        //映射文件中的SQL标签，并执行标签中的SQL语句.
        Emp emp = empMapper.getEmpAndDeptById3(1);
        System.out.println("id:"+emp.getId());
        System.out.println("name:"+emp.getName());
        System.out.println("gender:"+emp.getGender());
        System.out.println("salary:"+emp.getSalary());
        System.out.println("joinDate:"+ emp.getJoinDate().toLocaleString());
        System.out.println("deptId:"+emp.getDeptId());
        System.out.println("dept.id:"+emp.getDept().getId());
        System.out.println("dept.name:"+emp.getDept().getName());
    }
}

package org.example.test;


import org.example.Config.DataSourceConfig;
import org.example.Config.SpringContext;
import org.example.Service.StudentService;
import org.example.Service.UserService;
import org.example.ServiceImpl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;

//进行测试的依赖文件
@RunWith(SpringJUnit4ClassRunner.class)
//导入注解
@ComponentScan("org.example")
//导入核心类
@ContextConfiguration(classes = SpringContext.class)
public class SpringTest {

//    @Qualifier("userService")
    @Autowired
    private StudentService studentService;

    @Autowired
    private DataSource dataTest;


    @Test
    public void test1() throws Exception {
        studentService.save();
        System.out.println(dataTest.getConnection());
    }
}

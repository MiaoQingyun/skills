package org.example.Web;

import org.example.Config.SpringContext;
import org.example.Dao.User;
import org.example.Dao.UserDao;
import org.example.Service.UserService;
import org.example.ServiceImpl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class WebService {
    public static void main(String[] args) throws SQLException {

        //ApplicationContext 应用上下文，通过实例化来获得bean对象
        //ClassPathXmlApplicationContext 从类的根路径下加载配置文件
        //1.使用配置文件xml
        //2.使用类
      ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext app=new AnnotationConfigApplicationContext(SpringContext.class);
        //getBean 1、通过id的方式 2、通过类的方式
        //类的方式在spring中只能存在一个，class路径只能有一个
        //UserService user=(UserService) app.getBean("userService");
        UserService user = (UserService) app.getBean("userService");
        user.save();
//        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
        DataSource dataSource=(DataSource) app.getBean("dataSource");
        //导入包的类型错了。
        Connection con=dataSource.getConnection();
        System.out.println(con);
        con.close();
        //
    }
}

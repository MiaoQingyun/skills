package org.example.Web;

import org.example.Config.SpringContext;
import org.example.Service.StudentService;
import org.example.ServiceImpl.StudentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebStudent {
    public static void main(String[] args) {
        //无论是注解还是bean 只要加载xml文件都会调用无参构造和初始化方法
        //通过注解的方式加载类,那么xml文件里面的东西就不会生成
//        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        //通过加载核心类的方式创建Spring容器
        ApplicationContext app=new AnnotationConfigApplicationContext(SpringContext.class);
        StudentService stu= app.getBean(StudentServiceImpl.class);
        stu.save();
    }
}

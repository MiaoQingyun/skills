import org.example.Dao.UserDao;

import org.example.Dao.UserDao1;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpingTest {
    @Test
    //用来测试scope标签的作用范围:bean对象的作用范围 prototype:多例，singleton:单例-
    public void test1(){
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao=(UserDao) app.getBean("UserDao");
        UserDao userDao1=(UserDao) app.getBean("UserDao");
        System.out.println(userDao1);
        System.out.println(userDao);
    }
    //测试静态工厂
    @Test
    void test2(){
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao1 userDao=(UserDao1) app.getBean("userDao1");
        System.out.println(userDao);
    }
    //测试动态工程
    @Test
    void test3(){
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao1 userDao=(UserDao1) app.getBean("userDaoDy");
        System.out.println(userDao);
    }
}

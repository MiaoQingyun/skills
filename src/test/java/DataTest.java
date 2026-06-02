import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.example.Config.SpringContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assumptions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataTest {
    @Test
    //c3p0手动配置数据库链接源
    public void test1() throws Exception{
//        ComboPooledDataSource com=new ComboPooledDataSource();
//        com.setDriverClass("com.mysql.cj.jdbc.Driver");
//        com.setJdbcUrl("jdbc:mysql://localhost:3306/test1");
//        com.setUser("root");
//        com.setPassword("root");

//        Connection connection= com.getConnection();
//        System.out.println(connection);
//        connection.close();
    }
    @Test
    //通过配置properties 文件导入数据
    public void test2() throws  Exception{
        //读取配置文件 文件的目录存放在resources 不需要后缀
        ResourceBundle re=ResourceBundle.getBundle("jdbc");
        String driver= re.getString("jdbc.driver");
        String url= re.getString("jdbc.url");
        String username= re.getString("jdbc.username");
        String password= re.getString("jdbc.password");
        //创建数据源对象，设置连接参数

        ComboPooledDataSource com=new ComboPooledDataSource();
        com.setDriverClass(driver);
        com.setJdbcUrl(url);
        com.setPassword(password);
        com.setUser(username);

        Assumptions.assumeTrue(canConnect(driver, url, username, password),
                "需要本地可用的 MySQL 数据库 test1");
        Connection con=com.getConnection();
        System.out.println(con);
        con.close();
    }
    //通过spring将里面的bean 注入
    @Test
    public void test3()throws Exception {


//        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext-jdbc.xml");
      ApplicationContext app=new AnnotationConfigApplicationContext(SpringContext.class);
        DataSource dataSource=(DataSource) app.getBean("dataSource");
        //导入包的类型错了。
        Assumptions.assumeTrue(canConnect("com.mysql.cj.jdbc.Driver",
                "jdbc:mysql://localhost:3306/test1", "root", "root"),
                "需要本地可用的 MySQL 数据库 test1");
        Connection con=dataSource.getConnection();
        System.out.println(con);
        con.close();

    }

    private boolean canConnect(String driver, String url, String username, String password) {
        try {
            Class.forName(driver);
            DriverManager.setLoginTimeout(3);
            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                return connection != null;
            }
        } catch (Exception ex) {
            return false;
        }
    }
}

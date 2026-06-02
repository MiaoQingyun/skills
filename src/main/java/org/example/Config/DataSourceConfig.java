package org.example.Config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
//分配置文件
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfig {
    @Value("${jdbc.driver}")
    private String drive;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    @Bean("dataSource")//将当前方法的返回值以指定的名称保存到bean 里面
    //在里面注入值可以使用@Value(${})将值传递过去
    public DataSource dataSources() throws Exception {
        ComboPooledDataSource com = new ComboPooledDataSource();
        com.setDriverClass(drive);
        com.setJdbcUrl(url);
        com.setUser(username);
        com.setPassword(password);
//        com.close();
        return com;
    }
}

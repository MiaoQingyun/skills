package org.example.Config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

//注解扫描 <context:component-scan base-package="org.example"/>
@ComponentScan("org.example")
//加载配置文件
@PropertySource("classpath:jdbc.properties")
//导入子配置文件类,有多个类就可以使用{,}里面用逗号分隔,一次导入多个配置
@Import(DataSourceConfig.class)
public class SpringContext {

    }

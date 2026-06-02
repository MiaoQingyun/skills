package org.example.ServiceImpl;

import org.example.Dao.StudentDao;
import org.example.DaoImpl.StudentDaoImpl;
import org.example.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

//添加注解
@Service("studentService")
//添加Scope 的值
@Scope("prototype")
public class StudentServiceImpl implements StudentService {

    @Value("${jdbc.driver}")
    //常量注入,可以在里面注入${}
    private String name;

    @Autowired
    //<property name="studentDao" ref="studentDao">
    @Qualifier("studentDao")//这里的值是ref 你要注入的类的实例
    //如果是通过注解的方式注入的就不需要set方法,Qualifier要配合Auto方法一块使用,
    //只是用Auto,是按照类型去自动匹配,如果多有个相同的类就没法实现
    private StudentDao studentDao;

//    public void setStudentDao(StudentDaoImpl studentDao) {
//        this.studentDao = studentDao;
//    }


    @PostConstruct
    //初始化方法,相当于bean里面的init-method="init"
    public void init(){
        System.out.println("初始化");
    }
    @PreDestroy
    public void destroy(){
        System.out.println("销毁化");
    }


    @Override
    public void save() {
        studentDao.save();
        System.out.println(name);
    }
}

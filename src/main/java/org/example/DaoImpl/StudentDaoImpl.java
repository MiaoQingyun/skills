package org.example.DaoImpl;

import org.example.Dao.StudentDao;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//用注解的方式代替 bean
//@Component("studentDao") Component指的是在类上实例化bean
//Repository 指在dao层进行实例化
@Repository("studentDao")
public class StudentDaoImpl implements StudentDao {
    @Override
    public void save() {
        System.out.println("通过注解实现");
    }
}

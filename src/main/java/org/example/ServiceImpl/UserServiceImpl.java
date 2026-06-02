package org.example.ServiceImpl;

import org.example.Dao.UserDao;
import org.example.Service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImpl implements UserService {

    //依赖注入

    private UserDao UserDao;
    // 1. 通过 set方法在spring内部将userDao对象传递给Service
//     public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

//2.通过有参构造器注入对象
    public UserServiceImpl(UserDao UserDao){
        this.UserDao=UserDao;
    }
    public UserServiceImpl(){
        System.out.println("调用了service层的方法");
    }
    @Override
    public void save() {
            UserDao.save();
    }
}

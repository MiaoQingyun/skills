package org.example.DaoImpl;

import org.example.Dao.UserDao1;

public class UserDao1Impl implements UserDao1 {
    public UserDao1Impl(){
        System.out.println("静态工厂构造对象");
    }
    @Override
    public void save() {
    System.out.println("通过工厂静态方法进行构造 bean 对象");
    }
}

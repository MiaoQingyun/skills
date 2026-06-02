package org.example.Factory;

import org.example.DaoImpl.UserDao1Impl;

//动态工厂创建对象
public class DyFactory {
    public UserDao1Impl getUserDao1(){
        return new UserDao1Impl();
    }

}

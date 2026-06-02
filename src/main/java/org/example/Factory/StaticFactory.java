package org.example.Factory;

import org.example.Dao.UserDao1;
import org.example.DaoImpl.UserDao1Impl;

public class StaticFactory {
    public static UserDao1 getUserDao (){
        return  new UserDao1Impl();
    }
}

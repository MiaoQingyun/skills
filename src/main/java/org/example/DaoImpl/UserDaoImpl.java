package org.example.DaoImpl;

import org.example.Dao.User;
import org.example.Dao.UserDao;

import java.util.List;
import java.util.Map;

public class UserDaoImpl implements UserDao {

    //注入常量
    private String name;
    private String age;

    //注入集合
    private List<String> strList;
    private Map<String, User> userMap;

    public void setStrList(List<String> strList) {
        this.strList = strList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    //默认调用了无参构造
    public UserDaoImpl() {
        System.out.println("创建了 UserDao 的对象");
    }

    void init() {
        System.out.println("初始化方法");
    }

    @Override
    public void save() {
        System.out.println("实现了 UserDao里的方法");
        //依赖注入常量
        System.out.println("姓名:"+name);
        System.out.println("年龄:"+age);
        System.out.println(strList);
        System.out.println(userMap);
    }

    public Map<String, User> getUserMap() {
        return userMap;
    }
}

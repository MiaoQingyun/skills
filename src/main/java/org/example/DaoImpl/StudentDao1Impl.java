package org.example.DaoImpl;

import org.example.Dao.StudentDao;
import org.springframework.stereotype.Repository;

@Repository("studentDao1")
public class StudentDao1Impl implements StudentDao {
    @Override
    public void save() {
    System.out.println("实现方法2");
    }
}

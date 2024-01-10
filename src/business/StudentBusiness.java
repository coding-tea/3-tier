package business;

import java.util.List;

import dao.StudentDao;
import dao.StudentDaoJson;
import models.Student;

public class StudentBusiness implements Services {

    
    private static StudentBusiness instance = null;
    public static StudentBusiness getInstance(StudentDao dao) {
        if(instance == null)
            instance = new StudentBusiness(dao);
        return instance;
    }


    //Bridge design pattern
    private StudentDao dao;
    private StudentBusiness(StudentDao dao) {
        this.dao = dao;
        
    }

    public List<Student> selectALL() {

        return this.dao.selectALL();

    }

    public Student find(String cin) {
        return this.dao.find(cin);
    }

    public boolean create(String cin, String name, int age) {
        return this.dao.create(cin, name, age);
    }

    public boolean update(String cin, String name, int age) {
        return this.dao.update(cin, name, age);
    }

    public boolean delete(String cin) {
        return this.dao.delete(cin);
    }
}

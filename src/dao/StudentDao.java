package dao;

import java.util.List;

import models.Student;

public interface StudentDao {

    public List<Student> selectALL();

    public Student find(String cin);

    public void create(
            String cin,
            String name,
            int age);

    public void update(
            String cin,
            String name,
            int age);

    public void delete(String cin);

}
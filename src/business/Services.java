package business;

import java.util.List;

import models.Student;

public interface Services {
    public List<Student> selectALL();

    public Student find(String cin);

    public boolean create(
            String cin,
            String name,
            int age);

    public boolean update(
            String cin,
            String name,
            int age);

    public boolean delete(String cin);
}

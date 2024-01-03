package business;

import java.util.List;

import dao.StudentDaoJson;
import models.Student;

public class StudentBusiness {

    private StudentDaoJson studentDaoJson;

    public StudentBusiness() {
        this.studentDaoJson = new StudentDaoJson();
    }

    public void selectALL() {

        List<Student> students = this.studentDaoJson.selectALL();
        if (students.size() > 0) {
            for (Student student : students) {
                System.out.println(student);
            }
        }

    }

    public void find(String cin) {
        Student student = this.studentDaoJson.find(cin);
        System.out.println(student);
    }

    public void create(String cin, String name, int age) {
        boolean check = this.studentDaoJson.create(cin, name, age);
        if (check)
            System.out.println("student created successfuly");
    }

    public void update(String cin, String name, int age) {
        boolean check = this.studentDaoJson.update(cin, name, age);
        if (check)
            System.out.println("student updated successfuly");
    }

    public void delete(String cin) {
        boolean check = this.studentDaoJson.delete(cin);
        if (check)
            System.out.println("student deleted successfuly");
    }
}

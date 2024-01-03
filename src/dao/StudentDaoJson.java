package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;

import models.Student;

public class StudentDaoJson implements StudentDao {

    private List<Student> students;
    private Gson gson;
    private File file;
    private Type type;

    public StudentDaoJson() {
        this.students = new ArrayList<Student>();
        this.gson = new Gson();
        this.type = new TypeToken<Vector<Student>>() {
        }.getType();
        try {
            this.file = new File("student.json");
            if (this.file.createNewFile()) {
                System.out.println("File created: " + this.file.getName());
            } else {
                Scanner scanner = new Scanner(new FileReader("student.json"));
                String studentString = scanner.nextLine();
                this.students = gson.fromJson(studentString, this.type);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> selectALL() {
        try {
            Scanner scanner = new Scanner(new FileReader("student.json"));
            String studentString = scanner.nextLine();
            this.students = gson.fromJson(studentString, this.type);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return this.students;
    }

    @Override
    public Student find(String cin) {
        for (Student student : students) {
            if (student.getCin().equals(cin))
                return student;
        }
        return null;
    }

    @Override
    public boolean create(String cin, String name, int age) {
        this.students.add(new Student(cin, name, age));
        String studentsString = this.gson.toJson(students);
        try {
            FileWriter myWriter = new FileWriter("student.json");
            myWriter.write(studentsString);
            myWriter.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean update(String cin, String name, int age) {
        Student student = this.find(cin);
        this.students.remove(student);
        Student studentToBeUpdated = new Student(cin, name, age);
        this.students.add(studentToBeUpdated);
        String studentsString = this.gson.toJson(students);
        try {
            FileWriter myWriter = new FileWriter("student.json");
            myWriter.write(studentsString);
            myWriter.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(String cin) {
        this.students.remove(this.find(cin));
        String studentsString = this.gson.toJson(students);
        try {
            FileWriter myWriter = new FileWriter("student.json");
            myWriter.write(studentsString);
            myWriter.close();
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
}

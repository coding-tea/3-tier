package dao;

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

    public StudentDaoJson(){
        this.gson = new Gson(); 
        this.type = new TypeToken<Vector<Student>>() {}.getType();
        try{
            this.file = new File("student.json");
            if (this.file.createNewFile()) {
                System.out.println("File created: " + this.file.getName());
            } else {
                System.out.println("File already exists.");
            }
        }catch(Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    
    @Override
    public List<Student> selectALL() {
        try{
            Scanner scanner = new Scanner(new File("students.json"));
            String studentsString = scanner.nextLine();
            students = gson.fromJson(studentsString, this.type);
        }catch(Exception e){
            System.out.println("An error occurred.");
            e.printStackTrace();    
        }
        return students;
    }

    @Override
    public Student find(String cin) {
        for(Student student:students){
            if(student.getCin().equals(cin))
                return student;
        }
        return null;
    }

    @Override
    public void create(String cin, String name, int age) {
        Student student = new Student(cin, name, age);
        this.students.add(student);
        String studentsString = this.gson.toJson(students);
        try{
            FileWriter myWriter = new FileWriter("student.json");
            myWriter.write(studentsString);
        }catch(Exception e){
            System.out.println(e);
        }

    }

    @Override
    public void update(String cin, String name, int age) {
        Student student = this.find(cin);
        this.students.remove(student);
        Student studentToBeUpdated = new Student(cin, name, age);
        this.students.add(studentToBeUpdated);
        String studentsString = this.gson.toJson(students);
        try{
            FileWriter myWriter = new FileWriter("student.json");
            myWriter.write(studentsString);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    @Override
    public void delete(String cin) {
        Student student = this.find(cin);
        this.students.remove(student);
        String studentsString = this.gson.toJson(students);
        try{
            FileWriter myWriter = new FileWriter("student.json");
            myWriter.write(studentsString);
        }catch(Exception e){
            System.out.println(e);
        }
    }
}

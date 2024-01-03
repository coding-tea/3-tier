package models;

public class Student {

    private String cin;
    private String name;
    private int age;

    public Student() {
    }

    public Student(String cin, String name, int age) {
        this.cin = cin;
        this.name = name;
        this.age = age;
    }

    public String getCin() {
        return this.cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "{" +
                " cin='" + getCin() + "'" +
                ", name='" + getName() + "'" +
                ", age='" + getAge() + "'" +
                "}";
    }

}

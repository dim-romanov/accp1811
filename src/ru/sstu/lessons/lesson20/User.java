package ru.sstu.lessons.lesson20;


import ru.sstu.lessons.lesson17.sax.Document;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@BaseAnnotation(level = 11, sqlQuery = "select * from table")
public class User {
    //@BaseAnnotation(level = 11, sqlQuery = "select * from table")
    private int id;
    private String name;
    public int age;
    private double salary;
    private Date dateCreate;
    private List<Document> documents = new ArrayList<>();
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User() {

    }

    public User(int id, String name, int age, double salary, Date dateCreate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.dateCreate = dateCreate;
    }

    public User(int id, String name, int age, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public User(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @SecurityAnnotation(level = "")
    public Date getDateCreate() {
        return dateCreate;
    }


    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    @SecurityAnnotation(level = "")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @SecurityAnnotation(level = "")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @XmlElement(name = "doc")
    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age &&
                Double.compare(user.salary, salary) == 0 &&
                Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, salary);
    }

    @Override
    public String toString() {
        String str = "User{" +
                "id='" + id + '\'' +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", date=" + dateCreate +
                '}';
        for (Document d : documents) {
            str += "\n" + d.toString();
        }
        return str;
    }

    public void addDocument(Document d) {
        documents.add(d);
    }
}

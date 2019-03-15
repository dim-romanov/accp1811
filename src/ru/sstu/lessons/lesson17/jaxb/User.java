package ru.sstu.lessons.lesson17.jaxb;


import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.Date;
import java.util.List;
import java.util.Objects;


@XmlRootElement//указние корневого элемента
@XmlType(propOrder = {"id", "name", "age", "salary", "documents"})//какие поля необходимо включить в XML
public class User {
    private int id;
    private String name;
    private int age;
    private double salary;
    private Date dateCreate;
    private List<Document> documents;


    public User() {

    }

    @XmlElement(name = "doc")//задать имя для тега
    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
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

    @XmlAttribute//указание атрибута
    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @XmlElement(name = "firstName")//переиеновать тег
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

        return str;
    }
}

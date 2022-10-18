package by.tms.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank(message = "Field cant be empty")
    private String name;

    @NotBlank(message = "Field cant be empty")
    private String surname;

    @NotBlank(message = "Field cant be empty")
    private String password;

    @Size(min = 1)
    @OneToMany(cascade = CascadeType.ALL)
    private Set<Subject> subjects;

    private double GPA;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Result> results;

    public Student() {
    }

    public Student(long id, String name, String surname, String password, Set<Subject> subjects, double GPA, List<Result> results) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.subjects = subjects;
        this.GPA = GPA;
        this.results = results;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", subjects=" + subjects +
                ", GPA=" + GPA +
                ", results=" + results +
                '}';
    }
}

package by.tms.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.*;

@Entity(name = "Student")
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
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @Size(min = 1)
    private Set<Subject> subjects;
//    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
//    @MapKey(name = "subject")
//    @Enumerated(EnumType.STRING)
//    @Size(min = 1)
//    private Map<Subject, Ratings> performance;
    private double GPA;

    public Student() {
    }

    public Student(long id, String name, String surname, String password, Set<Subject> subjects, double GPA) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.subjects = subjects;
        this.GPA = GPA;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", subjects=" + subjects +
                ", GPA=" + GPA +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Double.compare(student.GPA, GPA) == 0 && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(password, student.password) && Objects.equals(subjects, student.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, password, subjects, GPA);
    }
}

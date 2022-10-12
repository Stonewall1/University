package by.tms.domain;

import java.util.*;

public class Student {
    private long id;
    private String name;
    private String surname;
    private Map<Subject, List<Integer>> performance = new HashMap<>();
    private double GPA;

    public Student() {
    }

    public Student(long id, String name, String surname, Map<Subject, List<Integer>> performance, double GPA) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.performance = performance;
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

    public Map<Subject, List<Integer>> getPerformance() {
        return performance;
    }

    public void setPerformance(Map<Subject, List<Integer>> performance) {
        this.performance = performance;
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
                ", performance=" + performance +
                ", GPA=" + GPA +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id && Double.compare(student.GPA, GPA) == 0 && Objects.equals(name, student.name) && Objects.equals(surname, student.surname) && Objects.equals(performance, student.performance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, performance, GPA);
    }

}

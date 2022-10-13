package by.tms.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity(name = "Teacher")
@Table(name = "teachers")
public class Teacher {
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

    public Teacher() {
    }

    public Teacher(long id, String name, String surname, String password, Set<Subject> subjects) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.subjects = subjects;
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

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", subjects=" + subjects +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return id == teacher.id && Objects.equals(name, teacher.name) && Objects.equals(surname, teacher.surname) && Objects.equals(password, teacher.password) && Objects.equals(subjects, teacher.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, password, subjects);
    }
}

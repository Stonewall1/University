package by.tms.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    private long id;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Student> students;

    @OneToOne(cascade = CascadeType.ALL)
    private Teacher teacher;

    @OneToOne(cascade = CascadeType.ALL)
    private Subject subject;

    public Lesson() {
    }

    public Lesson(long id, Set<Student> students, Teacher teacher, Subject subject) {
        this.id = id;
        this.students = students;
        this.teacher = teacher;
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", students=" + students +
                ", teacher=" + teacher +
                ", subject=" + subject +
                '}';
    }
}

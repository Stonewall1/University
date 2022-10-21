package by.tms.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String lessonTheme;

    @ManyToMany//(cascade = CascadeType.ALL)
    private List<Student> students;

    @ManyToOne//(cascade = CascadeType.ALL) // ManyToOne
    private Teacher teacher;

    @ManyToOne//(cascade = CascadeType.ALL) //ManyToOne
    private Subject subject;

    public Lesson() {
    }

    public Lesson(long id, String lessonTheme, List<Student> students, Teacher teacher, Subject subject) {
        this.id = id;
        this.lessonTheme = lessonTheme;
        this.students = students;
        this.teacher = teacher;
        this.subject = subject;
    }

    public Lesson(String lessonTheme, Teacher teacher, Subject subject) {
        this.lessonTheme = lessonTheme;
        this.teacher = teacher;
        this.subject = subject;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLessonTheme() {
        return lessonTheme;
    }

    public void setLessonTheme(String lessonTheme) {
        this.lessonTheme = lessonTheme;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
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
                ", lessonTheme='" + lessonTheme + '\'' +
                ", students=" + students +
                ", teacher=" + teacher +
                ", subject=" + subject +
                '}';
    }
}

package by.tms.entity;

import javax.persistence.*;

@Entity
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne//(cascade = CascadeType.ALL)
    private Student student;

    @OneToOne//(cascade = CascadeType.ALL) //ManyToOne
    private Lesson lesson;

    private int performance;

    public Result() {
    }

    public Result(long id, Student student, Lesson lesson, int performance) {
        this.id = id;
        this.student = student;
        this.lesson = lesson;
        this.performance = performance;
    }

    public Result(Student student, Lesson lesson, int performance) {
        this.student = student;
        this.lesson = lesson;
        this.performance = performance;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Lesson getLesson() {
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }

    public int getPerformance() {
        return performance;
    }

    public void setPerformance(int performance) {
        this.performance = performance;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", student=" + student +
                ", lesson=" + lesson +
                ", performance=" + performance +
                '}';
    }
}

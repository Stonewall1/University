package by.tms.domain;

import javax.persistence.*;

@Entity
@Table(name = "results")
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = CascadeType.ALL)
    private Student student;
    @Enumerated(EnumType.STRING)
    private Subject subject;
    private Integer performance;

    public Result() {
    }

    public Result(long id, Student student, Subject subject, Integer performance) {
        this.id = id;
        this.student = student;
        this.subject = subject;
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

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Integer getPerformance() {
        return performance;
    }

    public void setPerformance(Integer performance) {
        this.performance = performance;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", student=" + student +
                ", subject=" + subject +
                ", performance=" + performance +
                '}';
    }
}

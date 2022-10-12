package by.tms.domain;

import javax.persistence.*;
import java.util.List;

@Entity(name = "Ratings")
public class Ratings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Student student;
    @Enumerated(EnumType.STRING)
    private Subject subject;
    @ElementCollection
    private List<Integer> performance;

    public Ratings() {
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

    public List<Integer> getPerformance() {
        return performance;
    }

    public void setPerformance(List<Integer> performance) {
        this.performance = performance;
    }

    @Override
    public String toString() {
        return "Ratings{" +
                "id=" + id +
                ", student=" + student +
                ", subject=" + subject +
                ", performance=" + performance +
                '}';
    }
}

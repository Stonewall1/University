package by.tms.dao;

import by.tms.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component("HibernateStudentDao")
public class HibernateStudentDao implements HibernateDao<Student, Long> {
    private final SessionFactory sessionFactory;

    public HibernateStudentDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Student save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
        return student;
    }

    @Override
    public Optional<Student> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Student delete(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(student);
        return student;
    }

    @Override
    public Student update(Long aLong, String param1, String param2) {
        return null;
    }

    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return null;
    }
}

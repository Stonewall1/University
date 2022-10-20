package by.tms.dao;

import by.tms.entity.Student;
import by.tms.entity.Teacher;
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
    public Optional<Student> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Student student = session.find(Student.class, id);
        return Optional.of(student);
    }

    @Override
    public Student delete(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(student);
        return student;
    }

    @Override
    public Student update(Long id, String name, String surname , String password) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Student set name =: nameP , surname =:surnameP , password =:passwordP where id =: ip")
                .setParameter("ip" , id)
                .setParameter("nameP" , name)
                .setParameter("surnameP" , surname)
                .setParameter("passwordP" , password)
                .executeUpdate();
        return session.find(Student.class , id);
    }

    @Override
    public List<Student> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student" , Student.class).getResultList();
    }

    @Override
    public Student findByParameter(String surname) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Student where surname =:s", Student.class)
                .setParameter("s", surname)
                .getSingleResult();
    }
}

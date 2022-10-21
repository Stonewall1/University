package by.tms.dao;

import by.tms.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component("HibernateTeacherDao")
public class HibernateTeacherDao implements HibernateDao<Teacher , Long> {
    private final SessionFactory sessionFactory;

    public HibernateTeacherDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Teacher save(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);
        return teacher;
    }

    @Override
    public Optional<Teacher> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Teacher teacher = session.find(Teacher.class, id);
        return Optional.of(teacher);
    }

    @Override
    public Teacher delete(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(teacher);
        return teacher;
    }

    @Override
    public Teacher update(Long id, String name, String surname , String password) {
        Session session = sessionFactory.getCurrentSession();
        session.createQuery("update Teacher set name = :nameP , surname = : surnameP , password =: passwordP where id = :ip")
                .setParameter("ip" , id)
                .setParameter("nameP" , name)
                .setParameter("surnameP" , surname)
                .setParameter("passwordP" , password)
                .executeUpdate();
        return session.find(Teacher.class , id);
    }

    @Override
    public List<Teacher> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Teacher" , Teacher.class).getResultList();
    }

    @Override
    public Teacher findByParameter(String surname) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Teacher where surname =:s", Teacher.class)
                .setParameter("s", surname)
                .getSingleResult();
    }

    @Override
    public Teacher update(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.update(teacher);
        return teacher;
    }
}

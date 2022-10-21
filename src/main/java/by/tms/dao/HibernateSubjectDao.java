package by.tms.dao;

import by.tms.entity.Subject;
import by.tms.entity.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component("HibernateSubjectDao")
public class HibernateSubjectDao implements HibernateDao<Subject, Long> {
    private final SessionFactory sessionFactory;

    public HibernateSubjectDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Subject save(Subject subject) {
        Session session = sessionFactory.getCurrentSession();
        session.save(subject);
        return subject;
    }

    @Override
    public Optional<Subject> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Subject subject = session.find(Subject.class, id);
        return Optional.of(subject);
    }

    @Override
    public Subject delete(Subject subject) {
        return null;
    }

    @Override
    public Subject update(Long id, String param1, String param2, String param3) {
        return null;
    }

    @Override
    public List<Subject> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Subject" , Subject.class).getResultList();
    }

    @Override
    public Subject findByParameter(String subjectName) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Subject where subjectName =:s", Subject.class)
                .setParameter("s", subjectName)
                .getSingleResult();
    }

    @Override
    public Subject update(Subject entity) {
        return null;
    }
}

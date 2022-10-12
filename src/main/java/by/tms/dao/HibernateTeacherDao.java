package by.tms.dao;

import by.tms.domain.Teacher;
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
    public Teacher save(Teacher element) {
        return null;
    }

    @Override
    public Optional<Teacher> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public Teacher delete(Teacher element) {
        return null;
    }

    @Override
    public Teacher update(Long aLong, String param1, String param2) {
        return null;
    }

    @Override
    public List<Teacher> findAll() {
        return null;
    }
}

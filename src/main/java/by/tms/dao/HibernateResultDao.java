package by.tms.dao;

import by.tms.entity.Result;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
@Component("HibernateResultDao")
public class HibernateResultDao implements HibernateDao<Result, Long>{
    private final SessionFactory sessionFactory;

    public HibernateResultDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Result save(Result result) {
        Session session = sessionFactory.getCurrentSession();
        session.save(result);
        return result;
    }

    @Override
    public Optional<Result> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Result result = session.find(Result.class, id);
        return Optional.of(result);
    }

    @Override
    public Result delete(Result result) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(result);
        return result;
    }

    @Override
    public Result update(Long aLong, String param1, String param2, String param3) {
        return null;
    }

    @Override
    public List<Result> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Result " , Result.class).getResultList();
    }

    @Override
    public Result findByParameter(String param) {
        return null;
    }
}

package by.tms.dao;

import by.tms.entity.Admin;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component("HibernateAdminDao")
public class HibernateAdminDao implements HibernateDao<Admin, Long> {
    private final SessionFactory sessionFactory;

    public HibernateAdminDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Admin save(Admin admin) {
        Session session = sessionFactory.getCurrentSession();
        session.save(admin);
        return admin;
    }

    @Override
    public Optional<Admin> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Admin admin = session.find(Admin.class, id);
        return Optional.of(admin);
    }

    @Override
    public Admin delete(Admin admin) {
        return null;
    }

    @Override
    public Admin update(Long id, String param1, String param2, String param3) {
        return null;
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }
}

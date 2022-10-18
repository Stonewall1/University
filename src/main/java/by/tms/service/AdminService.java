package by.tms.service;

import by.tms.dao.HibernateDao;
import by.tms.entity.Admin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AdminService {

    @Qualifier("HibernateAdminDao")
    private final HibernateDao<Admin, Long> hibernateAdminDao;

    public AdminService(HibernateDao<Admin, Long> hibernateAdminDao) {
        this.hibernateAdminDao = hibernateAdminDao;
    }

    @Transactional
    public Admin save(Admin admin) {
        return hibernateAdminDao.save(admin);
    }
}

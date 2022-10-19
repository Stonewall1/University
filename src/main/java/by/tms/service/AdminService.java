package by.tms.service;

import by.tms.dao.HibernateDao;
import by.tms.entity.Admin;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    @Transactional(readOnly = true)
    public List<Admin> findAll(){
        return hibernateAdminDao.findAll();
    }
    @Transactional
    public boolean isInBase(Admin admin){
        List<Admin> admins = findAll().stream().filter(admin1 -> admin1.equals(admin)).toList();
        return admins.size() > 0;
    }
}

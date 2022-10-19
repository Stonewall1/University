package by.tms.service;

import by.tms.dao.HibernateDao;
import by.tms.entity.Subject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SubjectService {
    @Qualifier("HibernateSubjectDao")
    private final HibernateDao<Subject, Long> hibernateSubjectDao;

    public SubjectService(HibernateDao<Subject, Long> hibernateSubjectDao) {
        this.hibernateSubjectDao = hibernateSubjectDao;
    }

    @Transactional
    public List<Subject> findAll() {
        return hibernateSubjectDao.findAll();
    }

    @Transactional
    public Subject save(Subject subject) {
        return hibernateSubjectDao.save(subject);
    }
}

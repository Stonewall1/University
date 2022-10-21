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

    @Transactional(readOnly = true)
    public List<Subject> findAll() {
        return hibernateSubjectDao.findAll();
    }

    @Transactional
    public Subject save(Subject subject) {
        return hibernateSubjectDao.save(subject);
    }
    @Transactional
    public boolean isInBase(Subject subject){
        List<Subject> subjects = findAll().stream().filter(sub -> sub.equals(subject)).toList();
        return subjects.size() > 0;
    }
    @Transactional(readOnly = true)
    public Subject findBySubjectName(String subjectName){
        return hibernateSubjectDao.findByParameter(subjectName);
    }
}

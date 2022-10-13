package by.tms.service;

import by.tms.dao.HibernateDao;
import by.tms.domain.Result;
import by.tms.domain.Teacher;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Qualifier("HibernateTeacherDao")
    private final HibernateDao<Teacher, Long> hibernateTeacherDao;

    public TeacherService(HibernateDao<Teacher, Long> hibernateTeacherDao) {
        this.hibernateTeacherDao = hibernateTeacherDao;
    }

    @Transactional
    public Teacher save(Teacher teacher) {
        return hibernateTeacherDao.save(teacher);
    }

    @Transactional(readOnly = true)
    public Optional<Teacher> findById(Long id) {
        return hibernateTeacherDao.findById(id);
    }

    @Transactional
    public Teacher delete(Teacher teacher) {
        return hibernateTeacherDao.delete(teacher);
    }

    @Transactional
    public Teacher update(Long id, String name, String surname, String password) {
        return hibernateTeacherDao.update(id, name, surname, password);
    }

    @Transactional(readOnly = true)
    public List<Teacher> findAll() {
        return hibernateTeacherDao.findAll();
    }

    @Transactional
    public void toRate(Result ratings) {

    }
}

package by.tms.service;

import by.tms.dao.HibernateDao;
import by.tms.entity.Teacher;
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
    public boolean isInBase(Teacher teacher){
        List<Teacher> teachers = findAll().stream().filter(teacher1 -> teacher1.equals(teacher)).toList();
        return teachers.size() > 0;
    }
    @Transactional
    public Teacher bySurname(String surname){
        return hibernateTeacherDao.findByParameter(surname);
    }
}

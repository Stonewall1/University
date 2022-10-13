package by.tms.service;

import by.tms.dao.HibernateDao;
import by.tms.domain.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
   @Qualifier("HibernateStudentDao")
    private final HibernateDao<Student, Long> hibernateStudentDao;

    public StudentService(HibernateDao<Student, Long> hibernateStudentDao) {
        this.hibernateStudentDao = hibernateStudentDao;
    }


    @Transactional
    public Student save(Student student) {
        return hibernateStudentDao.save(student);
    }

    @Transactional(readOnly = true)
    public Optional<Student> findById(Long id) {
        return hibernateStudentDao.findById(id);
    }

    @Transactional
    public Student delete(Student student) {
        return hibernateStudentDao.delete(student);
    }

    @Transactional
    public Student update(Long id, String name, String surname , String password) {
        return hibernateStudentDao.update(id, name, surname , password);
    }

    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return hibernateStudentDao.findAll();
    }
}

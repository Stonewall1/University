package by.tms.service;

import by.tms.dao.HibernateDao;
import by.tms.entity.Result;
import by.tms.entity.Student;
import by.tms.entity.Teacher;
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
    public Student update(Long id, String name, String surname, String password) {
        return hibernateStudentDao.update(id, name, surname, password);
    }

    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return hibernateStudentDao.findAll();
    }

    @Transactional
    public boolean isInBase(Student student) {
        List<Student> students = findAll().stream().filter(student1 -> student1.equals(student)).toList();
        return students.size() > 0;
    }

    @Transactional(readOnly = true)
    public Student bySurname(String surname) {
        return hibernateStudentDao.findByParameter(surname);
    }

    @Transactional
    public Student update(Student student) {
        return hibernateStudentDao.update(student);
    }

    @Transactional
    public double calculateStudentGPA(Student student) {
        List<Result> results = student.getResults();
        double sum = 0;
        for (Result res : results) {
            sum = sum + res.getPerformance();
        }
        if (results.size() != 0) {
            return sum / results.size();
        }
        return 0;
    }
}

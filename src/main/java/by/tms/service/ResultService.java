package by.tms.service;

import by.tms.dao.HibernateDao;
import by.tms.domain.Result;
import by.tms.domain.Subject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class ResultService {
    @Qualifier("HibernateResultDao")
    private final HibernateDao<Result, Long> hibernateResultDao;

    public ResultService(HibernateDao<Result, Long> hibernateResultDao) {
        this.hibernateResultDao = hibernateResultDao;
    }
    @Transactional
    public List<Result> findAll() {
        return hibernateResultDao.findAll();
    }
    @Transactional
    public Map<Subject, List<Integer>> performanceByStudent(Long id){
        Map<Subject , List<Integer>> map = new HashMap<>();
        List<Result> resultsOfStudent = findAll()
                .stream()
                .filter(result -> result.getStudent().getId() == id)
                .toList();
        Set<Subject> subjectSet = resultsOfStudent.get(0).getStudent().getSubjects();
        for(Subject sub : subjectSet){
            List<Integer> list = new ArrayList<>();
            for(Result res : resultsOfStudent){
                if(res.getSubject().equals(sub)){
                    list.add(res.getPerformance());
                }
            }
            map.put(sub , list);
        }
        return map;
    }
}




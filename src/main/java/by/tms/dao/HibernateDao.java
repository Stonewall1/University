package by.tms.dao;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HibernateDao<T , ID> extends CrudDao<T , ID> {
    T update(ID id , String param1 , String param2 , String param3);
    List<T> findAll();
}

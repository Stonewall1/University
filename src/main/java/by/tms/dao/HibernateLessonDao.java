package by.tms.dao;

import by.tms.entity.Lesson;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Component("HibernateLessonDao")
public class HibernateLessonDao implements HibernateDao<Lesson, Long> {
    private final SessionFactory sessionFactory;

    public HibernateLessonDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Lesson save(Lesson lesson) {
        Session session = sessionFactory.getCurrentSession();
        session.save(lesson);
        return lesson;
    }

    @Override
    public Optional<Lesson> findById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Lesson lesson = session.find(Lesson.class, id);
        return Optional.of(lesson);
    }

    @Override
    public Lesson delete(Lesson lesson) {
        return null;
    }

    @Override
    public Lesson update(Long id, String param1, String param2, String param3) {
        return null;
    }

    @Override
    public List<Lesson> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Lesson ", Lesson.class).getResultList();
    }

    @Override
    public Lesson findByParameter(String lessonTheme) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Lesson where lessonTheme =:s", Lesson.class)
                .setParameter("s", lessonTheme)
                .getSingleResult();
    }

    @Override
    public Lesson update(Lesson lesson) {
        Session session = sessionFactory.getCurrentSession();
        session.update(lesson);
        return lesson;
    }

    @Override
    public List<Lesson> findAllByParameter(String teacherSurname) {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Lesson where teacher.surname =:s", Lesson.class)
                .setParameter("s", teacherSurname)
                .getResultList();
    }
}

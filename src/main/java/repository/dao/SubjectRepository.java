package repository.dao;

import config.HibernateConfig;
import models.entity.Subject;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.DaoRepositoryImpl;

import java.util.Collections;
import java.util.List;

public class SubjectRepository implements DaoRepositoryImpl<Subject> {
    private static SubjectRepository instance;
    public static SubjectRepository getInstance() {
        if(instance == null)
            instance = new SubjectRepository();
        return instance;
    }
    private SubjectRepository() {}

    public List<Subject> getList() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Subject> query = session.createQuery("from Subject", Subject.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();

        }
    }

    public Subject getById(int id) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            return (Subject) session.createQuery("from Subject where id = :id")
                    .setParameter("id", id)
                    .uniqueResult();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void save(Subject subject) {
        if (subject == null) return;

        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.save(subject);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(Subject subject) {
        if (subject == null) return;
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(subject);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Subject getByString(String strParam, String strLookParam) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            return (Subject) session.createQuery("from Subject where " + strParam +" = :" + strParam)
                    .setParameter(strParam, strLookParam)
                    .uniqueResult();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

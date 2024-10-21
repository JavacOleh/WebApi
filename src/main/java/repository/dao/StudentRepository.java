package repository.dao;

import config.HibernateConfig;
import models.entity.Student;
import models.entity.Subject;
import org.apache.commons.lang3.ArrayUtils;
import repository.DaoRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class StudentRepository implements DaoRepositoryImpl<Student> {
    private static StudentRepository instance;
    private StudentRepository() {}
    public static StudentRepository getInstance() {
        if(instance == null)
            instance = new StudentRepository();
        return instance;
    }

    public List<Subject> getSubjectList(Student student) {
        int[] subjectIds = student.getSubjectIds();
        if (subjectIds == null || subjectIds.length == 0) {
            return Collections.emptyList();
        }

        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Subject> query = session.createQuery("from Subject where id IN (:ids)", Subject.class);
                query.setParameter("ids", Arrays.asList(ArrayUtils.toObject(subjectIds)));
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public List<Student> getList() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Student> query = session.createQuery("from Student", Student.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();

        }
    }

    public Student getById(int id) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            return (Student) session.createQuery("from Student where id = :id")
                    .setParameter("id", id)
                    .uniqueResult();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void save(Student student) {
        if (student == null) return;

        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.save(student);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(Student student) {
        if (student == null) return;

        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Student getByString(String strParam, String strLookParam) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            return (Student) session.createQuery("from Student where " + strParam +" = :" + strParam)
                    .setParameter(strParam, strLookParam)
                    .uniqueResult();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public <T> Student getByStrings(String strParam, T[] strLookParam) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            return (Student) session.createQuery("from Student where " + strParam +" = :" + strParam)
                    .setParameter(strParam, strLookParam)
                    .uniqueResult();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

package repository.dao;

import config.HibernateConfig;

import java.util.Arrays;
import java.util.Collections;

import models.entity.Student;
import models.entity.Subject;
import models.entity.Teacher;
import org.apache.commons.lang3.ArrayUtils;
import repository.DaoRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TeacherRepository implements DaoRepositoryImpl<Teacher> {
    private static TeacherRepository instance;

    public static TeacherRepository getInstance() {
        if(instance == null)
            instance = new TeacherRepository();
        return instance;
    }

    private TeacherRepository() {}

    public List<Subject> getSubjectList(Teacher teacher) {
        int[] subjectIds = teacher.getSubjectIds();
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

    public List<Teacher> getList() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Teacher> query = session.createQuery("from Teacher", Teacher.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();

        }
    }

    public Teacher getById(int id) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            return (Teacher) session.createQuery("from Teacher where id = :id")
                    .setParameter("id", id)
                    .uniqueResult();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void save(Teacher teacher) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.save(teacher);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(Teacher teacher) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(teacher);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Teacher getByString(String strParam, String strLookParam) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            return (Teacher) session.createQuery("from Teacher where " + strParam +" = :" + strParam)
                    .setParameter(strParam, strLookParam)
                    .uniqueResult();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

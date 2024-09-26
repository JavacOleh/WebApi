package model.dao;

import config.HibernateConfig;
import model.Teacher;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TeacherDAO {
    public List<Teacher> getList() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Teacher> query = session.createQuery("from Teacher", Teacher.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;

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
    public Teacher getByLastName(String LastName) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            return (Teacher) session.createQuery("from Teacher where LastName = :LastName")
                    .setParameter("LastName", LastName)
                    .uniqueResult();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

package model.dao;

import config.HibernateConfig;
import model.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class StudentDAO {
    public List<Student> getList() {
        try (Session session = HibernateConfig.getSessionFactory().openSession()) {
            Query<Student> query = session.createQuery("from Student", Student.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;

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
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.save(student);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void delete(Student student) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.delete(student);
            session.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Student getByLastName(String LastName) {
        try(Session session = HibernateConfig.getSessionFactory().openSession()) {
            return (Student) session.createQuery("from Student where LastName = :LastName")
                    .setParameter("LastName", LastName)
                    .uniqueResult();
        }
        catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

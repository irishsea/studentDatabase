package DAO;

import DAO.interfaces.StudentDAO;
import models.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;
//import utils.HibernateSessionFactoryUtil;

public class StudentDAOImpl implements StudentDAO {
    public Student findById(int id) {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        Student result = session.get(Student.class, id);
        tr.commit();
        session.close();
        return result;
    }

    public void save(Student student) {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        session.save(student);
        tr.commit();
        session.close();
    }

    public void update(Student student) {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        session.update(student);
        tr.commit();
        session.close();
    }

    public void delete(Student student) {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        session.delete(student);
        tr.commit();
        session.close();
    }

    private Session getSession() {
        return HibernateUtil.getCurrentSession();
    }
}

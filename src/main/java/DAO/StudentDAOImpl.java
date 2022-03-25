package DAO;

import DAO.interfaces.StudentDAO;
import models.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import utils.HibernateUtil;

import java.util.List;
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

    @Override
    public void deleteAllStudents() {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        session.createQuery("delete from Student s", Student.class).executeUpdate();
        tr.commit();
        session.close();
    }

    @Override
    public List<Student> filterByFirstName(String firstName) {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        Query<Student> query = session.createQuery("from Student s where s.firstName like :firstName", Student.class);
        query.setParameter("firstName", firstName + "%");
        List<Student> students = query.list();
        tr.commit();
        session.close();
        return students;
    }

    @Override
    public List<Student> filterByGroup(String groupName) {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        Query<Student> query = session.createQuery
                ("select s from Student s " +
                                "inner join s.group g " +
//                                "where  s.group = g.id " +
                                "where g.name like :groupName"
                        , Student.class);
        query.setParameter("groupName", "%" + groupName + "%");
        List<Student> students = query.list();
        tr.commit();
        session.close();
        return students;
    }

    private Session getSession() {
        return HibernateUtil.getCurrentSession();
    }
}

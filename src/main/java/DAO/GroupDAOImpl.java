package DAO;

import DAO.interfaces.GroupDAO;
import models.Group;
import models.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateSessionFactoryUtil;

import java.util.List;

public class GroupDAOImpl implements GroupDAO {
    public Group findById(String id) {
        return getSession().get(Group.class, id);
    }

    public void save(Group group) {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        session.save(group);
        tr.commit();
        session.close();
    }

    public void update(Group group) {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        session.update(group);
        tr.commit();
        session.close();
    }

    public void delete(Group group) {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        session.delete(group);
        tr.commit();
        session.close();
    }

//    public List<Student> findAllStudents() {
//        List<Student> students = getSession().createQuery("SELECT FROM student", Student.class).list();
//        return students;
//    }
//
//    public List<Group> findAllGroups() {
//        List<Group> groups = getSession().createQuery("SELECT FROM group", Group.class).list();
//        return groups;
//    }

    private Session getSession() {
        return HibernateSessionFactoryUtil.getSessionFactory().openSession();
    }
}

package DAO;

import DAO.interfaces.GroupDAO;
import models.Group;
import models.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
//import utils.HibernateSessionFactoryUtil;
import utils.HibernateUtil;

import java.util.List;

public class GroupDAOImpl implements GroupDAO {
    public Group findById(int id) {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        Group result = session.get(Group.class, id);
        tr.commit();
        session.close();
        return result;
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

    public List<Student> findAllStudents() {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        List<Student> students = session.createQuery("from Student", Student.class).list();
        tr.commit();
        session.close();
        return students;
    }

    public List<Group> findAllGroups() {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        List<Group> groups = session.createQuery("from Group", Group.class).list();
        tr.commit();
        session.close();
        return groups;
    }

    private Session getSession() {
        return HibernateUtil.getCurrentSession();
    }
}

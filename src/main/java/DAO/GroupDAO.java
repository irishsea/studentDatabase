package DAO;

import services.interfaces.IGroupDAO;
import models.Group;
import models.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class GroupDAO implements IGroupDAO {
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

    @Override
    public void deleteAllGroups() {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        session.createQuery("delete from Group g").executeUpdate();
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

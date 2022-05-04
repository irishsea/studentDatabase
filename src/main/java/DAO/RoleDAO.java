package DAO;

import DAO.interfaces.IRoleDAO;
import models.Role;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

import java.util.List;

public class RoleDAO implements IRoleDAO {

    @Override
    public Role findById(int id) {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        Role result = session.get(Role.class, id);
        tr.commit();
        session.close();
        return result;
    }

    @Override
    public List<Role> findAllRoles(){
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        List<Role> roles = session.createQuery("from Role", Role.class).list();
        tr.commit();
        session.close();
        return roles;
    }

    @Override
    public void save(Role role) {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        session.save(role);
        tr.commit();
        session.close();
    }

    @Override
    public void update(Role role) {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        session.update(role);
        tr.commit();
        session.close();
    }

    @Override
    public void delete(Role role) {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        session.delete(role);
        tr.commit();
        session.close();
    }

    @Override
    public void deleteAllRoles() {
        Session session = getSession();
        Transaction tr = session.beginTransaction();
        session.createQuery("delete from Role r").executeUpdate();
        tr.commit();
        session.close();
    }

    private Session getSession() {
        return HibernateUtil.getCurrentSession();
    }
}

package services;

import DAO.RoleDAO;
import models.Role;
import models.Student;

public class RoleService {

    RoleDAO roleDAO = new RoleDAO();

    public Role findRole(int id) {
        return roleDAO.findById(id);
    }

    public void saveRole(Role Role) {
        roleDAO.save(Role);
    }

    public void updateRole(Role Role) {
        roleDAO.update(Role);
    }

    public void deleteRole(Role Role) {
        roleDAO.delete(Role);
    }

    public void deleteAllRoles() {
        roleDAO.deleteAllRoles();
    }
}
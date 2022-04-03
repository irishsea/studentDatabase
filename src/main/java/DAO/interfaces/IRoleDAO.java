package DAO.interfaces;

import models.Role;

public interface IRoleDAO {
    Role findById(int id);

    void save(Role role
    );

    void update(Role role
    );

    void delete(Role role
    );

    void deleteAllRoles();

}

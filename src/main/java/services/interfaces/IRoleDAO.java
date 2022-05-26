package services.interfaces;

import models.Role;

import java.util.List;

public interface IRoleDAO {
    Role findById(int id);

    List<Role> findAllRoles();

    void save(Role role
    );

    void update(Role role
    );

    void delete(Role role
    );

    void deleteAllRoles();

}

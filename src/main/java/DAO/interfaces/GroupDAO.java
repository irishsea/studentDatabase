package DAO.interfaces;

import models.Group;
import models.Student;

import java.util.List;

public interface GroupDAO {
    Group findById(int id);

    void save(Group group);

    void update(Group group);

    void delete(Group group);

    List<Student> findAllStudents();

    List<Group> findAllGroups();

}

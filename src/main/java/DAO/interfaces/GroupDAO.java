package DAO.interfaces;

import models.Group;
import models.Student;

import java.util.List;

public interface GroupDAO {
    public Group findById(String id);

    public void save(Group group);

    public void update(Group group);

    public void delete(Group group);

//    public List<Student> findAllStudents();
//
//    public List<Group> findAllGroups();

}

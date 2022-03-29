package services;

import DAO.GroupDAOImpl;
import models.Group;
import models.Student;

import java.util.List;

public class GroupService {
    GroupDAOImpl groupDAO = new GroupDAOImpl();

    public GroupService() {
    }

    public Group findGroup(int id) {
        return groupDAO.findById(id);
    }

    public void saveGroup(Group group) {
        groupDAO.save(group);
    }

    public void updateGroup(Group group) {
        groupDAO.update(group);
    }

    public void deleteGroup(Group group) {
        groupDAO.delete(group);
    }

    public void deleteAllGroups() {
        groupDAO.deleteAllGroups();
    }

    public List<Group> findAllGroups() {
        return groupDAO.findAllGroups();
    }

    public List<Student> findAllStudents() {
        return groupDAO.findAllStudents();
    }


}

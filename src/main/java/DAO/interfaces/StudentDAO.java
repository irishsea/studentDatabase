package DAO.interfaces;

import models.Group;
import models.Student;

import java.util.List;

public interface StudentDAO {

    Student findById(int id);

    void save(Student student);

    void update(Student student);

    void delete(Student student);

    void deleteAllStudents();

    List<Student> filterByFirstName(String firstName);

    List<Student> filterByGroup(String groupName);
}

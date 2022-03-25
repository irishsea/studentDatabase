package services;

import DAO.GroupDAOImpl;
import DAO.StudentDAOImpl;
import models.Group;
import models.Student;

import java.util.List;

public class StudentService {
    StudentDAOImpl studentDAO = new StudentDAOImpl();

    public StudentService() {
    }

    public Student findStudent(int id) {
        return studentDAO.findById(id);
    }

    public void saveStudent(Student student) {
        studentDAO.save(student);
    }

    public void updateStudent(Student student) {
        studentDAO.update(student);
    }

    public void deleteStudent(Student student) {
        studentDAO.delete(student);
    }

    public void deleteAllStudents(){
        studentDAO.deleteAllStudents();
    }

    public List<Student> filterByFirstName(String firstName) {
        return studentDAO.filterByFirstName(firstName);
    }

    public List<Student> filterByGroup(String groupName) {
        return studentDAO.filterByGroup(groupName);
    }


}

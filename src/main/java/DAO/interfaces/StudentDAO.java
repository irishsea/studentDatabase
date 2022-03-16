package DAO.interfaces;

import models.Group;
import models.Student;

import java.util.List;

public interface StudentDAO {

    public Student findById(long id);

    public void save(Student student);

    public void update(Student student);

    public void delete(Student student);

}

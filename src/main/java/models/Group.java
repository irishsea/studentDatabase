package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "student_group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column (name = "faculty")
    private String faculty;

    @Column (name = "name")
    private String name;

//    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Student> students;

    public Group(){}

    public Group(String faculty, String name){
        this.faculty = faculty;
        this.name = name;
        //students = new ArrayList<Student>();
    }

//    public void addStudent(Student student){
//        student.setGroup(this);
//        students.add(student);
//    }

//    public void removeStudent(Student student){
//        students.remove(student);
//    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

//    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }

    //    @Override
    //    public String toString() {
    //        return "Group{" +
    //                "number='" + number + '\'' +
    //                ", faculty='" + faculty + '\'' +
    //                ", students=" + students +
    //                '}';
    //    }
}

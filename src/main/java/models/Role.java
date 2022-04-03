package models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "student_role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "role_name")
    private String roleName;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "student_role_link",
            joinColumns = {@JoinColumn(name = "role_id")},
            inverseJoinColumns = {@JoinColumn(name = "student_id")}
    )
    private Set<Student> students = new HashSet<>();

    public Set<Student> getStudents(){
        return students;
    }

    public void setStudents(Set<Student> students){
        this.students = students;
    }

    public void addStudent(Student student, boolean needLinkOtherSide){
        this.students.add(student);

        if(needLinkOtherSide) {
            student.addRole(this, false);
        }
    }

    public void removeStudent(Student student, boolean needLinkOtherSide) {
        this.students.remove(student);

        if (needLinkOtherSide) {
            student.removeRole(this, false);
        }
    }

    public Role() {
    }

    public Role(String roleName) {
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Role)) return false;
        Role role = (Role) o;
        return id == role.id && roleName.equals(role.roleName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleName);
    }
}

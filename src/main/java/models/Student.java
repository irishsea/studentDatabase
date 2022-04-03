package models;


import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

//    @Column(name = "last_name")
//    private String lastName;
//
//    @Column(name = "patronymic")
//    private String patronymic;
//
//    @Column(name = "birth_date")
//    private Date birthDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "group_id")
    private Group group;

    //    @ManyToMany
//    @JoinTable(name = "student_role_link",
//            joinColumns = @JoinColumn(name = "student_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id"))
    @ManyToMany(mappedBy = "students")
    private Set<Role> roles = new HashSet<>();

    public Student() {

    }

    public Student(String firstName) {
        this.firstName = firstName;
    }

    public Student(int id, String firstName) {
        this.id = id;
        this.firstName = firstName;
    }


//    public Student(String firstName, String lastName, String patronymic, Date birthDate) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.patronymic = patronymic;
//        this.birthDate = birthDate;;
//    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getPatronymic() {
//        return patronymic;
//    }
//
//    public void setPatronymic(String patronymic) {
//        this.patronymic = patronymic;
//    }
//
//    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Group getGroup() {
        return group;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void addRole(Role role, boolean needLinkOtherSide) {
        this.roles.add(role);

        if (needLinkOtherSide) {
            role.addStudent(this, false);
        }
    }

    public void removeRole(Role role, boolean needLinkOtherSide) {
        this.roles.remove(role);

        if (needLinkOtherSide) {
            role.removeStudent(this, false);
        }
    }

//    @Override
//    public String toString() {
//        return "Student{" +
//                "id=" + id +
//                ", firstName='" + firstName + '\'' +
//                ", lastName='" + lastName + '\'' +
//                ", patronymic='" + patronymic + '\'' +
//                ", birthDate=" + birthDate +
//                '}';
//    }


    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return id == student.id && firstName.equals(student.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName);
    }
}

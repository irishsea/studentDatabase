package models;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "student")
//@Table (name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

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

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "group_id")
//    private Group group;

    public Student(){

    }

    public Student(String firstName) {
        this.firstName = firstName;
    }

//    public Student(String firstName, String lastName, String patronymic, Date birthDate) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.patronymic = patronymic;
//        this.birthDate = birthDate;;
//    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

//    public void setGroup(Group group) {
//        this.group = group;
//    }


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

}

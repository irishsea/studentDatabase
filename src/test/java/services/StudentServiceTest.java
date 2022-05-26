package services;

import models.Group;
import models.Role;
import models.Student;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentServiceTest {

    static GroupService groupService = new GroupService();
    static StudentService studentService = new StudentService();
    static RoleService roleService = new RoleService();

    static Group group1 = new Group("Automation", "8T71");
    static Group group2 = new Group("Design", "8D71");
    static Group group3 = new Group("Robotics", "8E71");

    static Student student1 = new Student("Sucrose");
    static Student student2 = new Student("Thoma");
    static Student student3 = new Student("Klee");
    static Student student4 = new Student("Itto");
    static Student student5 = new Student("Morax");
    static Student student6 = new Student( "Fischl");
    static Student student7 = new Student("Beidou");
    static Student student8 = new Student("Bennett");
    static Student student9 = new Student("Tartaglia");
    static Student student10 = new Student("Kaeya");

    Role role1 = new Role("excellent");
    Role role2 = new Role("cultural member");
    Role role3 = new Role("profession member");

    @BeforeAll
    static void setUp() {
        studentService.deleteAllStudents();
        groupService.deleteAllGroups();
        roleService.deleteAllRoles();
    }


    @AfterEach
    public void cleanAll() {
        studentService.deleteAllStudents();
        groupService.deleteAllGroups();
        roleService.deleteAllRoles();
    }

    @Test
    void findStudentTest() {
        studentService.saveStudent(student6);
        studentService.saveStudent(student7);
        List<Student> studentList = groupService.findAllStudents();
        int lastStudentID = studentList.get(studentList.size() - 1).getId();
        assertEquals(studentService.findStudent(lastStudentID).getFirstName(), student7.getFirstName());
    }

    @Test
    void saveStudentTest() {
        studentService.saveStudent(student2);
        List<Student> studentList = groupService.findAllStudents();
        assertEquals(student2.getFirstName(), studentList.get(studentList.size() - 1).getFirstName());
    }

    @Test
    void updateStudentTest() {
        studentService.saveStudent(student1);
        student1.setFirstName("Qiqi");
        studentService.updateStudent(student1);
        List<Student> studentList = groupService.findAllStudents();
        assertEquals("Qiqi", studentList.get(studentList.size() - 1).getFirstName());
    }

    @Test
    void deleteStudentTest() {
        studentService.saveStudent(student3);
        studentService.deleteStudent(student3);
        assertEquals(0, studentService.filterByFirstName(student3.getFirstName()).size());
    }

    @Test
    void filterByFirstNameTest() {
        studentService.saveStudent(student4);
        List<Student> studentList = studentService.filterByFirstName(student4.getFirstName());
        assertEquals(student4.getFirstName(), studentList.get(studentList.size() - 1).getFirstName());
    }

    @Test
    void filterByGroupTest() {
        studentService.saveStudent(student5);
        groupService.saveGroup(group2);
        student5.setGroup(group2);
        group2.addStudent(student5);
        groupService.updateGroup(group2);
        List<Student> studentList = studentService.filterByGroup(group2.getName());
        assertEquals(student5.getFirstName(), studentList.get(studentList.size() - 1).getFirstName());

    }

    @Test
    void deleteAllStudents() {
        studentService.saveStudent(student6);
        studentService.saveStudent(student7);
        studentService.deleteAllStudents();
        assertEquals(0, groupService.findAllStudents().size());
    }

    @Test
    void getFellowsTest() {
        roleService.saveRole(role1);
        roleService.saveRole(role2);
        roleService.saveRole(role3);

        student8.addRole(role1, true);
        student8.addRole(role2, true);
        student8.addRole(role3, true);

        student9.addRole(role1, true);
        student9.addRole(role2, true);

        student10.addRole(role3, true);

        roleService.updateRole(role1);
        roleService.updateRole(role2);
        roleService.updateRole(role3);

        studentService.updateStudent(student8);
        studentService.updateStudent(student9);
        studentService.updateStudent(student10);

        List<Student> studentList = studentService.getFellows();
        for(Student s: studentList){
            System.out.println(s.getFirstName());
        }
        assertEquals(2, studentList.size());
        assertTrue(studentList.contains(student8));
        assertTrue(studentList.contains(student9));

    }
}
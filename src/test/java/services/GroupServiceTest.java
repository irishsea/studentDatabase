package services;

import models.Group;
import models.Student;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupServiceTest {

    static GroupService groupService = new GroupService();
    static StudentService studentService = new StudentService();

    static Group group1 = new Group("Automation", "8T71");
    static Group group2 = new Group("Design", "8D71");
    static Group group3 = new Group("Robotics", "8E71");
    static Group group4 = new Group("Software Engineering", "8K71");
    static Group group5 = new Group("Applied informatics", "8I71");
    static Group group6 = new Group("Physics", "8P71");
    static Group group7 = new Group("Industrial safety", "8B71");
    static Group group8 = new Group("Chemistry", "8O71");
    static Group group9 = new Group("Astronomy", "8G71");
    static Group group10 = new Group("Economics", "8N71");
    static Group group11 = new Group("Innovation", "8M71");

    static Student student1 = new Student("Sucrose");
    static Student student2 = new Student("Thoma");
    static Student student3 = new Student("Klee");
    static Student student4 = new Student("Itto");
    static Student student5 = new Student("Morax");
    static Student student6 = new Student(1, "Fischl");
    static Student student7 = new Student(2, "Beidou");
    static Student student8 = new Student("Bennett");
    static Student student9 = new Student("Tartaglia");
    static Student student10 = new Student("Kaeya");

    @BeforeEach
    public void setUp() {
        studentService.deleteAllStudents();
        groupService.deleteAllGroups();
    }

    @AfterEach
    public void cleanAll() {
        studentService.deleteAllStudents();
        groupService.deleteAllGroups();
    }

    @Test
    void findGroup() {
        groupService.saveGroup(group1);
        groupService.saveGroup(group2);
        List<Group> groupList = groupService.findAllGroups();
        int lastGroupID = groupList.get(groupList.size() - 1).getId();
        assertEquals(groupService.findGroup(lastGroupID).getName(), group2.getName());
    }

    @Test
    void saveGroup() {
        groupService.saveGroup(group3);
        List<Group> groupList = groupService.findAllGroups();
        assertEquals(group3.getName(), groupList.get(groupList.size() - 1).getName());
    }

    @Test
    void updateGroup() {
        groupService.saveGroup(group4);
        group4.setName("8T7B");
        groupService.updateGroup(group4);
        List<Group> groupList = groupService.findAllGroups();
        assertEquals("8T7B", groupList.get(groupList.size() - 1).getName());
    }


    @Test
    void deleteAllGroups() {
        groupService.saveGroup(group5);
        groupService.saveGroup(group6);
        groupService.deleteAllGroups();
        assertEquals(0, groupService.findAllGroups().size());
    }

    @Test
    void deleteGroup() {
        groupService.saveGroup(group7);
        groupService.saveGroup(group8);
        groupService.deleteGroup(group7);
        assertEquals(1, groupService.findAllGroups().size());
    }

    @Test
    void findAllGroups() {
        groupService.saveGroup(group9);
        groupService.saveGroup(group10);
        groupService.saveGroup(group11);
        List<Group> groupList = groupService.findAllGroups();
        assertEquals(group9.getName(), groupList.get(0).getName());
        assertEquals(group10.getName(), groupList.get(1).getName());
        assertEquals(group11.getName(), groupList.get(2).getName());
    }

    @Test
    void findAllStudents() {
        studentService.saveStudent(student1);
        studentService.saveStudent(student2);
        studentService.saveStudent(student3);
        studentService.saveStudent(student4);
        List<Student> studentList = groupService.findAllStudents();
        assertEquals(student1.getFirstName(), studentList.get(0).getFirstName());
        assertEquals(student2.getFirstName(), studentList.get(1).getFirstName());
        assertEquals(student3.getFirstName(), studentList.get(2).getFirstName());
        assertEquals(student4.getFirstName(), studentList.get(3).getFirstName());
    }
}
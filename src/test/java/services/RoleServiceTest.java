package services;

import models.Group;
import models.Role;
import models.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RoleServiceTest {

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
    static Student student6 = new Student(1, "Fischl");
    static Student student7 = new Student(2, "Beidou");
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
    void findRole() {
        roleService.saveRole(role1);
        roleService.saveRole(role2);
        List<Role> roleList = roleService.findAllRoles();
        int lastRoleID = roleList.get(roleList.size() - 1).getId();
        assertEquals(roleService.findRole(lastRoleID).getRoleName(), role2.getRoleName());
    }

    @Test
    void saveRole() {
        roleService.saveRole(role2);
        List<Role> roleList = roleService.findAllRoles();
        assertEquals(role2.getRoleName(), roleList.get(roleList.size() - 1).getRoleName());
    }

    @Test
    void updateRole() {
        roleService.saveRole(role1);
        role1.setRoleName("Fool");
        roleService.updateRole(role1);
        List<Role> roleList = roleService.findAllRoles();
        assertEquals("Fool", roleList.get(roleList.size() - 1).getRoleName());
    }

    @Test
    void deleteRole() {
        roleService.saveRole(role3);
        roleService.saveRole(role2);
        roleService.deleteRole(role3);
        assertEquals(1, roleService.findAllRoles().size());
    }

    @Test
    void deleteAllRoles() {
        roleService.saveRole(role1);
        roleService.saveRole(role2);
        roleService.deleteAllRoles();
        assertEquals(0, roleService.findAllRoles().size());
    }
}
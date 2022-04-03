

import models.Group;
import models.Role;
import models.Student;
import services.GroupService;
import services.RoleService;
import services.StudentService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GroupService groupService = new GroupService();
        StudentService studentService = new StudentService();
        RoleService roleService = new RoleService();
//        Group group1 = new Group("Automation", "8К71");
//        groupService.saveGroup(group1);
//        groupService.deleteAllGroups();
//
//        Student student1 = new Student(1, "Sucrose");
//            studentService.updateStudent(student1);
//        studentService.saveStudent(student1);

//        Student student2 = new Student(2, "Sucrose2");
//        studentService.saveStudent(student2);

//        Student student1 = new Student("Olya");
//        student1.setGroup(group1);
//        group1.addStudent(student1);
////
//        Student student2 = new Student("Andrew");
//        student2.setGroup(group1);
//        group1.addStudent(student2);
//        groupService.updateGroup(group1);

//        List<Group> gotGroups = groupService.findAllGroups();
//        for (Group g : gotGroups) {
//            System.out.println(g);
//        }
//        List<Student> gotStudent = groupService.findAllStudents();
//        for(Student s: gotStudent){
//            System.out.println(s);
//        }

//        System.out.println(groupService.findGroup(1));
//        System.out.println(studentService.findStudent(4));

//        groupService.deleteGroup(groupService.findGroup(7));

//        List<Student> gotStudent = studentService.filterByFirstName("Su");
//        for(Student s: gotStudent){
//            System.out.println(s);
//        }

//        List<Student> gotStudent = studentService.filterByGroup("К");
//        for (Student s : gotStudent) {
//            System.out.println(s);
//        }
//        groupService.deleteAllGroups();
//        studentService.deleteAllStudents();

//        System.out.println(studentService.findStudent(2));

        /**
         * Вставка ролей, пользователей и групп
         */

        Group group1 = new Group("Automation", "8К71");
        Group group2 = new Group("Design", "8A71");
        groupService.saveGroup(group1);
        groupService.saveGroup(group2);

        Student student1 = new Student("Sucrose");
        student1.setGroup(group1);
        group1.addStudent(student1);

        Student student2 = new Student("Zhongli");
        student2.setGroup(group2);
        group2.addStudent(student2);
        groupService.updateGroup(group1);
        groupService.updateGroup(group2);

        Role role1 = new Role("excellent");
        Role role2 = new Role("cultural member");
        Role role3 = new Role("profession member");
        roleService.saveRole(role1);
        roleService.saveRole(role2);
        roleService.saveRole(role3);

        student1.addRole(role1, true);
        student1.addRole(role2, true);
        student2.addRole(role3, true);
        roleService.updateRole(role1);
        roleService.updateRole(role2);
        roleService.updateRole(role3);

        studentService.updateStudent(student1);
        studentService.updateStudent(student2);
    }
}


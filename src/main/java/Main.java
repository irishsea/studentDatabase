

import models.Group;
import models.Student;
import services.GroupService;
import services.StudentService;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GroupService groupService = new GroupService();
        StudentService studentService = new StudentService();
        Group group1 = new Group("Automation", "8К71");
        groupService.saveGroup(group1);
//
//            Student student1 = new Student("Sucrose");
//            studentService.updateStudent(student1);
//            studentService.saveStudent(student1);

        Student student1 = new Student("Olya");
        student1.setGroup(group1);
        group1.addStudent(student1);
//
        Student student2 = new Student("Andrew");
        student2.setGroup(group1);
        group1.addStudent(student2);
        groupService.updateGroup(group1);

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

        List<Student> gotStudent = studentService.filterByGroup("К");
        for (Student s : gotStudent) {
            System.out.println(s);
        }
    }
}


import models.Group;
import models.Student;
import services.GroupService;

public class Main {
    public static void main(String[] args) {
        GroupService groupService = new GroupService();
        Group group1 = new Group("Automation", "8T71");
        groupService.saveGroup(group1);

        Student student1 = new Student();
//        student1.setGroup(group1);
//        group1.addStudent(student1);

        Student student2 = new Student();
//        student2.setGroup(group1);
//        group1.addStudent(student2);
//        groupService.updateGroup(group1);
    }
}

package presention;

import model.Student;
import service.StudentService;
import utils.ConnectionDB;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentService studentService = new StudentService();
        int choice = -1;

        while(true){
            System.out.println("""
                    ----------- MENU STUDENT MANAGER ------------
                    1. Hiển thị danh sách sinh viên.
                    2. Thêm mới sinh viên.
                    3. Sửa sinh viên.
                    4. Xóa sinh viên.
                    5. Tìm kiếm sinh viên.
                    6. Thoát .
                    """);
            try{
                System.out.println("Enter your choice: ");
                choice = Integer.parseInt(sc.nextLine());
                switch (choice){
                    case 1:
                        List<Student> students = studentService.getStudent();
                        students.forEach(student -> System.out.println(student));
                        break;
                    case 2:
                        studentService.addStudent(sc);
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        System.out.println("Exitting...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice...");
                        break;
                }
            } catch (NumberFormatException e){
                System.out.println("Invalid choice...");
            }
        }
    }
}
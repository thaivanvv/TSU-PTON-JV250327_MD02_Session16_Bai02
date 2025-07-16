package service;

import business.dao.StudentDao;
import model.Student;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    private final StudentDao studentDao =  new StudentDao();

    public List<Student> getStudent(){
        try{
            System.out.println("List of students: ");
            return studentDao.getStudent();
        } catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public boolean addStudent(Scanner sc){
        Student student = new Student();
        System.out.println("Enter Student Name: ");
        student.setFullName(sc.nextLine());
        System.out.println("Enter Student Date of Birth: ");
        student.setDateOfBirth(LocalDate.parse(sc.nextLine()));
        System.out.println("Enter Student Email: ");
        student.setEmail(sc.nextLine());

        return studentDao.addStudent(student);
    }
}

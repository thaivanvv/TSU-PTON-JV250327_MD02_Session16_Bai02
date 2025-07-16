package business.dao;

import model.Student;
import utils.ConnectionDB;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public List<Student> getStudent(){
        List<Student> students =new ArrayList<Student>();
        try(Connection connection = ConnectionDB.getConnection()){
            CallableStatement call = connection.prepareCall("{CALL get_all_students()}");
            ResultSet rs = call.executeQuery();
            while(rs.next()){
                Student student = new Student(
                        rs.getInt("student_id"),
                        rs.getString("full_name"),
                        rs.getDate("date_of_birth").toLocalDate(),
                        rs.getString("email")
                );

                students.add(student);
            }
            return students;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public boolean addStudent(Student student){
        try(Connection connection = ConnectionDB.getConnection()){
            CallableStatement call = connection.prepareCall("{CALL add_student(?,?,?)}");
            call.setString(1,student.getFullName());
            call.setDate(2, Date.valueOf(student.getDateOfBirth()));
            call.setString(3, student.getEmail());

            return call.executeUpdate()>0;
        } catch (Exception e){
            System.out.println(e.getMessage());;
            return false;
        }
    }
}

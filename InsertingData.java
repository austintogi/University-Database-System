import java.sql.*;

/*************************************************************************************
 * University Database Project
 *
 * @author Austin Togi
 * @version CS 1103 - University Database Project
 ************************************************************************************ */
 
public class InsertingData 
{
    public static void main(String[] args)
    {
        try 
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/q8wun/Downloads/CS-1103-Project.db");
            Statement statement = conn.createStatement();

            
            statement.execute("ALTER TABLE Instructor ADD COLUMN income INTEGER");
            
            // to add a column tax in table Instructor
            statement.execute("ALTER TABLE Instructor ADD COLUMN tax INTEGER");
            statement.execute("UPDATE Instructor SET tax = income * 0.10");

            // Inserting sample data
            statement.execute("INSERT INTO Buildings (name) VALUES ('Willy')");
            statement.execute("INSERT INTO Buildings (name) VALUES ('Wonka')");
            statement.execute("INSERT INTO Buildings (name) VALUES ('Nail')");

            statement.execute("INSERT INTO Departments (name, building_id) VALUES ('Computer Science', 1)");
            statement.execute("INSERT INTO Departments (name, building_id) VALUES ('Math', 2)");
            statement.execute("INSERT INTO Departments (name, building_id) VALUES ('Business', 3)");

            statement.execute("INSERT INTO Instructor (name, department_id, income, tax) VALUES ('Mark Nail', 1, 50000, 5000)");
            statement.execute("INSERT INTO Instructor (name, department_id, income, tax) VALUES ('Queer Klain', 2, 60000, 6000)");
            statement.execute("INSERT INTO Instructor (name, department_id, income, tax) VALUES ('Brabus Carry', 3, 55000, 5500)");

            statement.execute("INSERT INTO Student (name, department_id) VALUES ('Krajier Hong', 1)");
            statement.execute("INSERT INTO Student (name, department_id) VALUES ('Braun Sheer', 2)");
            statement.execute("INSERT INTO Student (name, department_id) VALUES ('Justin Bro', 3)");

            statement.execute("INSERT INTO Courses (name, instructor_id, department_id) VALUES ('MATH 1003', 1, 2)");
            statement.execute("INSERT INTO Courses (name, instructor_id, department_id) VALUES ('BA 1501', 2, 3)");
            statement.execute("INSERT INTO Courses (name, instructor_id, department_id) VALUES ('CS 2335', 3, 1)");

            // Insert sample data for newly added tables
            statement.execute("INSERT INTO Instructor_Student (instructor_id, student_id, strength_of_class, semester, grade) VALUES (1, 1, 20, 1, 80)");
            statement.execute("INSERT INTO Instructor_Student (instructor_id, student_id, strength_of_class, semester, grade) VALUES (2, 2, 35, 2, 90)");
            statement.execute("INSERT INTO Instructor_Student (instructor_id, student_id, strength_of_class, semester, grade) VALUES (3, 3, 25, 1, 85)");
            
            statement.execute("INSERT INTO Course_Department (name, course_id, department_id, sessions) VALUES ('Cyber Security', 1, 1, 2)");
            statement.execute("INSERT INTO Course_Department (name, course_id, department_id, sessions) VALUES ('Arithmetic Progressions', 1, 2, 1)");
            statement.execute("INSERT INTO Course_Department (name, course_id, department_id, sessions) VALUES ('Digital Marketing', 1, 3, 2)");
            
            statement.execute("INSERT INTO Departments_Buildings (name, department_id, building_id, number_of_rooms) VALUES ('Computer Club', 1, 1, 6)");
            statement.execute("INSERT INTO Departments_Buildings (name, department_id, building_id, number_of_rooms) VALUES ('Math Club', 2, 2, 8)");
            statement.execute("INSERT INTO Departments_Buildings (name, department_id, building_id, number_of_rooms) VALUES ('Business Club', 3, 3, 9)");
            
            statement.execute("INSERT INTO Courses_Taught (name, course_id, instructor_id, number_of_rooms) VALUES ('CS 1003', 1, 1, 2)");
            statement.execute("INSERT INTO Courses_Taught (name, course_id, instructor_id, number_of_rooms) VALUES ('MATH 1003', 2, 2, 3)");
            statement.execute("INSERT INTO Courses_Taught (name, course_id, instructor_id, number_of_rooms) VALUES ('BA 1501', 3, 3, 4)");

            // Print confirmation
            System.out.println("Sample data inserted successfully.");

            // Close resources
            statement.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}

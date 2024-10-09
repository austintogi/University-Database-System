import java.sql.*;

/*************************************************************************************
 * University Database Project
 *
 * @author Austin Togi
 * @version CS 1103 - University Database Project
 ************************************************************************************ */
 
public class PrintingData 
{
    public static void main(String[] args) 
    {
        try 
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/q8wun/Downloads/CS-1103-Project.db");
            Statement statement = conn.createStatement();

            // Query and print data for existing tables
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Buildings");
            System.out.println("Buildings:");
            while (resultSet.next()) 
            {
                System.out.println("Building ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name"));
            }

            resultSet = statement.executeQuery("SELECT * FROM Departments");
            System.out.println("\nDepartments:");
            while (resultSet.next()) 
            {
                System.out.println("Department ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") + ", Building ID: " + resultSet.getInt("building_id"));
            }

            resultSet = statement.executeQuery("SELECT * FROM Instructor");
            System.out.println("\nInstructors:");
            while (resultSet.next()) 
            {
                System.out.println("Instructor ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") + ", Department ID: " + resultSet.getInt("department_id") + ", Income: " + resultSet.getInt("income") + ", Tax: " + resultSet.getInt("tax"));
            }

            resultSet = statement.executeQuery("SELECT * FROM Student");
            System.out.println("\nStudents:");
            while (resultSet.next()) 
            {
                System.out.println("Student ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") + ", Department ID: " + resultSet.getInt("department_id"));
            }

            resultSet = statement.executeQuery("SELECT * FROM Courses");
            System.out.println("\nCourses:");
            while (resultSet.next()) 
            {
                System.out.println("Course ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") + ", Instructor ID: " + resultSet.getInt("instructor_id") + ", Department ID: " + resultSet.getInt("department_id"));
            }

            // Query and print data for newly added tables
            resultSet = statement.executeQuery("SELECT * FROM Instructor_Student");
            System.out.println("\nInstructor_Student:");
            while (resultSet.next()) 
            {
                System.out.println("ID: " + resultSet.getInt("id") + ", Instructor ID: " + resultSet.getInt("instructor_id") + ", Student ID: " + resultSet.getInt("student_id") + ", Strength of Class: " + resultSet.getInt("strength_of_class") + ", Semester: " + resultSet.getInt("semester") + ", Grade: " + resultSet.getInt("grade"));
            }

            resultSet = statement.executeQuery("SELECT * FROM Course_Department");
            System.out.println("\nCourse_Department:");
            while (resultSet.next()) 
            {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") + ", Course ID: " + resultSet.getInt("course_id") + ", Department ID: " + resultSet.getInt("department_id") + ", Sessions: " + resultSet.getInt("sessions"));
            }

            resultSet = statement.executeQuery("SELECT * FROM Departments_Buildings");
            System.out.println("\nDepartments_Buildings:");
            while (resultSet.next()) 
            {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") + ", Department ID: " + resultSet.getInt("department_id") + ", Building ID: " + resultSet.getInt("building_id") + ", Number of Rooms: " + resultSet.getInt("number_of_rooms"));
            }

            resultSet = statement.executeQuery("SELECT * FROM Courses_Taught");
            System.out.println("\nCourses_Taught:");
            while (resultSet.next()) 
            {
                System.out.println("ID: " + resultSet.getInt("id") + ", Name: " + resultSet.getString("name") + ", Course ID: " + resultSet.getInt("course_id") + ", Instructor ID: " + resultSet.getInt("instructor_id") + ", Number of Rooms: " + resultSet.getInt("number_of_rooms"));
            }

            // Close resources
            resultSet.close();
            statement.close();
            conn.close();
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}

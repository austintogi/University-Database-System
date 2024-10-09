import java.sql.*;
/*************************************************************************************
 * University Database Project
 *
 * @author Austin Togi
 * @version CS 1103 - University Database Project
 ************************************************************************************ */
public class CreatingTables 
{
    public static void main(String[] args) 
    {
        try 
        {
            // Connect to the database
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/q8wun/Downloads/CS-1103-Project.db");
            Statement statement = conn.createStatement();

            // Creating tables
            statement.execute("CREATE TABLE IF NOT EXISTS Student" +
            "(id INTEGER PRIMARY KEY, name varchar(50), department_id INTEGER)");
            statement.execute("CREATE TABLE IF NOT EXISTS Instructor" +
            "(id INTEGER PRIMARY KEY, name varchar(50), department_id INTEGER, income INTEGER)");
            statement.execute("CREATE TABLE IF NOT EXISTS Courses" +
            "(id INTEGER PRIMARY KEY, name varchar(50), instructor_id INTEGER, department_id INTEGER)");
            statement.execute("CREATE TABLE IF NOT EXISTS Departments" +
            "(id INTEGER PRIMARY KEY, name varchar(50), building_id INTEGER)");
            statement.execute("CREATE TABLE IF NOT EXISTS Buildings" +
            "(id INTEGER PRIMARY KEY, name varchar(50))");

            // Creating tables for relationships
            statement.execute("CREATE TABLE IF NOT EXISTS Instructor_Student" +
            "(id INTEGER PRIMARY KEY, instructor_id INTEGER, student_id INTEGER, strength_of_class INTEGER, semester INTEGER, grade INTEGER)");
            statement.execute("CREATE TABLE IF NOT EXISTS Course_Department" +
            "(id INTEGER PRIMARY KEY, name varchar(50), course_id INTEGER, department_id INTEGER, sessions INTEGER)");
            statement.execute("CREATE TABLE IF NOT EXISTS Departments_Buildings"+
            "(id INTEGER PRIMARY KEY, name varchar(50), department_id INTEGER, building_id INTEGER, number_of_rooms INTEGER)");
            statement.execute("CREATE TABLE IF NOT EXISTS Courses_Taught" +
            "(id INTEGER PRIMARY KEY, name varchar(50), course_id INTEGER, instructor_id INTEGER, number_of_rooms INTEGER)");

            // Print confirmation
            System.out.println("Tables created");

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

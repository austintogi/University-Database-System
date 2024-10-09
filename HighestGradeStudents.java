import java.sql.*;

/*************************************************************************************
 * University Database Project
 *
 * @author Austin Togi
 * @version CS 1103 - University Database Project
 ************************************************************************************ */
 
public class HighestGradeStudents 
{
    public static void main(String[] args) 
    {
        try
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/q8wun/Downloads/CS-1103-Project.db");
            Statement myStatement = conn.createStatement();
             
            // To find the student with the highest grade in each semester
            String query = "SELECT id, MAX(grade) AS max_grade, semester FROM Instructor_Student GROUP BY semester";
            ResultSet myResultSet = myStatement.executeQuery(query);
            
            // To print the results
            while (myResultSet.next()) 
            {
                int studentId = myResultSet.getInt("id");
                int maxGrade = myResultSet.getInt("max_grade");
                int semester = myResultSet.getInt("semester");

                System.out.println("In semester: " + semester + ", Student ID: " + studentId + " obtained the highest grade: " + maxGrade);
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }
}

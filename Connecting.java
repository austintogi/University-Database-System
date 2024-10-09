import java.sql.Connection;
import java.sql.DriverManager;

/*************************************************************************************
 * University Database Project
 *
 * @author Austin Togi
 * @version CS 1103 - University Database Project
 ************************************************************************************ */

public class Connecting
{
    public static void main(String[] args) 
    {
        try 
        {
            Connection conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/q8wun/Downloads/CS-1103-Project.db");
            System.out.println("connected");
            conn.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
}



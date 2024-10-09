import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/*************************************************************************************
 * University Database Project
 *
 * @author Austin Togi
 * @version CS 1103 - University Database Project
 ************************************************************************************ */
 

public class ClearDatabase 
{

    private static final String DB_URL = "jdbc:sqlite:C:/Users/q8wun/Downloads/CS-1103-Project.db";

    public static void main(String[] args) 
    {
        try (Connection conn = DriverManager.getConnection(DB_URL)) 
        {
            clearDatabase(conn);
            System.out.println("Database cleared successfully.");
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
    }

    private static void clearDatabase(Connection conn) throws SQLException 
    {
        List<String> tableNames = getTableNames(conn);
        dropTables(conn, tableNames);
        createTables(conn);
    }

    private static List<String> getTableNames(Connection conn) throws SQLException 
    {
        List<String> tableNames = new ArrayList<>();
        try (Statement statement = conn.createStatement();
             var resultSet = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table'")) 
        {
            while (resultSet.next()) 
            {
                tableNames.add(resultSet.getString("name"));
            }
        }
        return tableNames;
    }

    private static void dropTables(Connection conn, List<String> tableNames) throws SQLException 
    {
        try (Statement statement = conn.createStatement()) 
        {
            for (String tableName : tableNames) 
            {
                statement.executeUpdate("DROP TABLE IF EXISTS " + tableName);
            }
        }
    }

    private static void createTables(Connection conn) throws SQLException 
    {
        // Add your table creation statements here
        try (Statement statement = conn.createStatement()) 
        {
            statement.execute("CREATE TABLE IF NOT EXISTS Student (id INTEGER PRIMARY KEY, name TEXT, department_id INTEGER)");
            statement.execute("CREATE TABLE IF NOT EXISTS Instructor (id INTEGER PRIMARY KEY, name TEXT, department_id INTEGER)");
            statement.execute("CREATE TABLE IF NOT EXISTS Courses (id INTEGER PRIMARY KEY, name TEXT, instructor_id INTEGER, department_id INTEGER)");
            statement.execute("CREATE TABLE IF NOT EXISTS Departments (id INTEGER PRIMARY KEY, name TEXT, building_id INTEGER)");
            statement.execute("CREATE TABLE IF NOT EXISTS Buildings (id INTEGER PRIMARY KEY, name TEXT)");
        }
    }
}

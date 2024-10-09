import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.sql.*;

/*************************************************************************************
 * University Database Project
 *
 * @author Austin Togi
 * @version CS 1103 - University Database Project
 ************************************************************************************ */
 
public class Menu extends Application 
{
    private Connection conn;

    @Override
    public void start(Stage primaryStage) 
    {
        //Setting title
        primaryStage.setTitle("Menu");

        // Creating buttons
        Button studentButton = new Button("Student");
        studentButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-size: 12px; -fx-pref-width: 100px; -fx-pref-height: 30px; -fx-border-radius: 5px;-fx-font-weight: bold;");
        Button instructorButton = new Button("Instructor");
        instructorButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-size: 12px; -fx-pref-width: 100px; -fx-pref-height: 30px; -fx-border-radius: 5px;-fx-font-weight: bold; ");
        Button coursesButton = new Button("Courses");
        coursesButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-size: 12px; -fx-pref-width: 100px; -fx-pref-height: 30px; -fx-border-radius: 5px;-fx-font-weight: bold;");
        Button departmentsButton = new Button("Departments");
        departmentsButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-size: 12px; -fx-pref-width: 100px; -fx-pref-height: 30px; -fx-border-radius: 5px;-fx-font-weight: bold;");
        Button buildingsButton = new Button("Buildings");
        buildingsButton.setStyle("-fx-background-color: #f44336; -fx-text-fill: white; -fx-font-size: 12px; -fx-pref-width: 100px; -fx-pref-height: 30px; -fx-border-radius: 5px;-fx-font-weight: bold;");

        // Setting actions for buttons
        studentButton.setOnAction(e -> openPage("Student"));
        instructorButton.setOnAction(e -> openPage("Instructor"));
        coursesButton.setOnAction(e -> openPage("Courses"));
        departmentsButton.setOnAction(e -> openPage("Departments"));
        buildingsButton.setOnAction(e -> openPage("Buildings"));

        // Setting up a layout and adding buttons to it
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setStyle("-fx-background-color: black;");
        gridPane.add(studentButton, 0, 0);
        gridPane.add(instructorButton, 1, 0);
        gridPane.add(coursesButton, 2, 0);
        gridPane.add(departmentsButton, 0, 1);
        gridPane.add(buildingsButton, 1, 1);

        // Setting up scene to connect with stage
        Scene scene = new Scene(gridPane, 320, 120);
        primaryStage.setScene(scene);
        primaryStage.show();

        // Connecting to the database
        try
        {
            conn = DriverManager.getConnection("jdbc:sqlite:C:/Users/q8wun/Downloads/CS-1103-Project.db");
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }

    private void openPage(String pageName) 
    {
        Stage myStage = new Stage();
        myStage.setTitle(pageName);

        // Setting space to display table content
        TextArea space = new TextArea();
        space.setEditable(false);
        space.setStyle("-fx-font-family: 'Courier New'; -fx-font-size: 12;"); 

        // Creating layout for all pages in general
        VBox layout = new VBox(10);
        layout.setStyle("-fx-background-color: black; -fx-padding: 10px;");
        layout.getChildren().add(space);

        // Setting up scene for all pages in general
        Scene myScene = new Scene(layout, 800, 150);
        myStage.setScene(myScene);
        myStage.show();

        // To dispay content in table format
        try 
        {
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM " + pageName);
            StringBuilder sb = new StringBuilder();
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();

            // Append column names
            for (int i = 1; i <= columnCount; i++) 
            {
                sb.append(padRight(metaData.getColumnName(i), 20)).append("\t");
            }
            sb.append("\n");

            // Append data rows
            while (resultSet.next()) 
            {
                for (int i = 1; i <= columnCount; i++) 
                {
                    sb.append(padRight(resultSet.getString(i), 20)).append("\t");
                }
                sb.append("\n");
            }
            space.setText(sb.toString());

            resultSet.close();
            statement.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }

    private String padRight(String s, int n) 
    {
        return String.format("%-" + n + "s", s);
    }

    @Override
    public void stop() throws Exception 
    {
        super.stop();
        if (conn != null) 
        {
            conn.close();
        }
    }
}

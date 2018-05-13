/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Task;
import Observer.TaskObservable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sebastian
 */
public class TaskController extends TaskObservable{
    DatabaseController dbc;
    String url = "jdbc:mysql://localhost:3306/javauppgift?zeroDateTimeBehavior=convertToNull&useSSL=false";
    String user = "root";
    String password = "hejsan";
    
    PreparedStatement selectAllTasks;
    String taskSelect = "Select t.taskID,tc.taskCategoryName,t.taskDescription,tm.taskManagerName\n" +
"FROM tasktbl t\n" +
"Join taskcategorytbl tc\n" +
"ON t.taskCategoryID = tc.taskCategoryID\n" +
"Join taskmanagertbl tm\n" +
"ON t.taskManagerID = tm.taskManagerID \n"+
"ORDER BY t.taskID DESC";
    
    
 Connection conn = DriverManager.getConnection(url,user,password);

    public TaskController() throws SQLException{
       
     selectAllTasks = conn.prepareStatement(taskSelect);   
        
    }
    
    
    
    public ArrayList<Task> getAllTasks() throws SQLException{
        ArrayList<Task> taskList = new ArrayList<>();
        ResultSet rs = null;
       conn = DriverManager.getConnection(url,user,password);
        rs = selectAllTasks.executeQuery();
        
        while(rs.next()){
            taskList.add(new Task(rs.getInt(1)
                    ,rs.getString(2)
                    ,rs.getString(3)
                    ,rs.getString(4)));
        }
        conn.close();
        return taskList;
        
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Database;
import Observer.TaskObservable;
import java.sql.Array;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sebastian
 */
public class DatabaseController extends TaskObservable{
    
    
    Connection conn = null;
    String url = "jdbc:mysql://localhost:3306/javauppgift?zeroDateTimeBehavior=convertToNull&useSSL=false";
    String user = "root";
    String password = "hejsan";
    
    //Preparedstatment för att göra ett nytt ärende
    PreparedStatement insertTask;
    String SQLTASKINSERT = "INSERT INTO tasktbl(taskCategoryID,taskManagerID,taskDescription) VALUES (?,?,?)";
    
    //Preparedstatement för att göra en ny arbetsuppgift.
    PreparedStatement insertCase;
    String SQLCASEINSERT = "INSERT INTO casetbl(taskID,caseCategory,caseBudgetTime) VALUES (LAST_INSERT_ID(),?,?)";
    
    //Preparedstatement för att se alla ärenden.
    PreparedStatement selectAllTasks;
    String taskSelect = "Select t.taskID,tc.taskCategoryName,t.taskDescription,tm.taskManagerName\n" +
    "FROM tasktbl t\n" +
    "Join taskcategorytbl tc\n" +
    "ON t.taskCategoryID = tc.taskCategoryID\n" +
    "Join taskmanagertbl tm\n" +
    "ON t.taskManagerID = tm.taskManagerID\n";
    
    //PreparedStatement för att hämta processledare
    PreparedStatement taskManagerSelect;
    String SQLTASKMANAGERSELECT = "Select taskManagerName from taskmanagertbl";
    
    //PreparedStatement för att uppdatera en rad i ärende tabellen.
    PreparedStatement UpdateOneTask;
    String SQLTASKUPDATE = "Update tasktbl\n" +
    " set taskDescription = ?\n" +
    " where taskID = ?";
    
    //PreparedStatement för att tabort en rad i ärendetabellen
    PreparedStatement deleteOneTask;
    String SQLTASKDELETE = "DELETE FROM tasktbl WHERE taskID = ?";
    
    //PreparedStatement för att hämta arbetsuppgift data kopplad till ett ärendeID.
    PreparedStatement selectTheCasesConnectedToTask;
    String SQLCASESELECT = "Select t.taskID ,cc.caseCategoryName, c.caseBudgetTime,c.casePerfomedTime,c.caseEmployeeID,c.caseComment,c.caseStatus\n" +
" From casetbl c\n" +
" Inner join tasktbl t\n" +
" On c.taskID = t.taskID\n" +
" Inner join casecategorytbl cc\n" +
" On c.caseCategory = cc.caseCategoryID\n" +
"\n" +
" ORDER BY taskID";
    
    PreparedStatement updateCaseRow;
    String SQLCaseUpdate = "UPDATE casetbl\n" +
"SET caseStatus = 'Attesterad'\n" +
"Where taskID = ?";
    
    //öppna uppkoppling mot databas
    public void connectToDB() throws SQLException{
        conn = DriverManager.getConnection(url,user,password);
        insertTask = conn.prepareStatement(SQLTASKINSERT);
        insertCase = conn.prepareStatement(SQLCASEINSERT);
        taskManagerSelect = conn.prepareStatement(SQLTASKMANAGERSELECT);
        UpdateOneTask = conn.prepareStatement(SQLTASKUPDATE);
        deleteOneTask = conn.prepareStatement(SQLTASKDELETE);
        selectTheCasesConnectedToTask = conn.prepareStatement(SQLCASESELECT);
        updateCaseRow = conn.prepareStatement(SQLCaseUpdate);
    }
    
    //Stäng uppkopplingen mot databasen
    public void closeConnectionToDB() throws SQLException{
        conn.close();
    }
    
    //Returnera connection till databasen.
    public Connection getConnection() {
        try {
            conn = DriverManager.getConnection(url,user,password);
            System.out.println("Connectad till databasen");
            return conn;
        } catch (SQLException ex) {
            System.out.println("Misslyckades att koppla upp mot databas");
            ex.getMessage();
            return null;
        }
       
    }
    
    //Lägg till ett ärende i databasen
    public int addTask(int category,int taskManager,String description) throws SQLException{
        int ret = 0;
        connectToDB();
        insertTask.setInt(1, category);
        insertTask.setInt(2, taskManager);
        insertTask.setString(3, description);
        
        ret = insertTask.executeUpdate();
       closeConnectionToDB();
       super.notifyTaskObservers();
        return ret;
    }
    
    
    
    
    //Lägg till en ny arbetsuppgift.
    public void addCase(int caseCategory,String budgetTime) throws SQLException{
       
       connectToDB();
       insertCase.setInt(1, caseCategory);
       insertCase.setString(2, budgetTime);
       
       insertCase.addBatch();
      
       int[]updateCounts = insertCase.executeBatch();
       super.notifyTaskObservers();
      
       
    }
    
public int updateTask(String description, int id) throws SQLException{
    
    int ret = 0;
    connectToDB();
    UpdateOneTask.setString(1, description);
    UpdateOneTask.setInt(2, id);
    ret = UpdateOneTask.executeUpdate();
    super.notifyTaskObservers();
    return ret;
}

public int deleteTask(int id) throws SQLException{
    int ret = 0;
    connectToDB();
    deleteOneTask.setInt(1, id);
    ret = deleteOneTask.executeUpdate();
    super.notifyTaskObservers();
    return ret;
    
}

public int getCasesConnectedToTaskID(int id) throws SQLException{
    int ret = 0;
    connectToDB();
    selectTheCasesConnectedToTask.setInt(1, id);
    ret = selectTheCasesConnectedToTask.executeUpdate();
    super.notifyTaskObservers();
    return ret;
}

public int updateCase(int id) throws SQLException{
    
    int ret = 0;
    connectToDB();
    updateCaseRow.setInt(1, id);
    
    
    ret = updateCaseRow.executeUpdate();
    super.notifyTaskObservers();
    return ret;
}





    
    
    
 
    
    
}

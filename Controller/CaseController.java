/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Case;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author sebastian
 */
public class CaseController {
   
   DatabaseController dbc;
   
   
    String dutySelect = " Select t.taskID ,cc.caseCategoryName, c.caseBudgetTime,c.casePerfomedTime,c.caseEmployeeID,c.caseComment,c.caseStatus\n" +
" From casetbl c\n" +
" Inner join tasktbl t\n" +
" On c.taskID = t.taskID\n" +
" Inner join casecategorytbl cc\n" +
" On c.caseCategory = cc.caseCategoryID\n" +
"\n" +
" ORDER BY taskID";
    
    //Preparedstatement för att hämta arbetsuppgifter kopplade till ett ärende.
    PreparedStatement selectTheCasesConnectedToTask;
    String dutySelectOne = "Select cc.caseCategoryName, c.caseBudgetTime,c.casePerfomedTime,c.caseComment,c.caseStatus\n" +
" From casetbl c\n" +
" Inner join tasktbl t\n" +
" On c.taskID = t.taskID\n" +
" Inner join casecategorytbl cc\n" +
" On c.caseCategory = cc.caseCategoryID\n" +
" WHERE t.taskID = ?";
    
    PreparedStatement ps;
    
    

    public CaseController() throws SQLException {
       
        this.dbc = new DatabaseController();
        ps = dbc.getConnection().prepareStatement(dutySelect);
        selectTheCasesConnectedToTask = dbc.getConnection().prepareStatement(dutySelectOne);
    }
    
    
    
    public ArrayList<Case> getAllDutys() throws SQLException{
        ArrayList<Case> dutyList = new ArrayList<>();
        ResultSet rs = null;
        dbc.connectToDB();
        rs = ps.executeQuery();
        
        while(rs.next()){
            dutyList.add(new Case(
                     rs.getInt(1)
                    ,rs.getString(2)
                    ,rs.getInt(3)
                    ,rs.getInt(4)
                    ,rs.getInt(5)
                    ,rs.getString(6)
                    ,rs.getString(7)));
        }
        dbc.closeConnectionToDB();
        return dutyList;
        
        
    }
    
    
    public ArrayList<Case> getSelectedDutys() throws SQLException{
        ArrayList<Case> dutyList = new ArrayList<>();
        ResultSet rs = null;
        dbc.connectToDB();
        rs = selectTheCasesConnectedToTask.executeQuery();
        
        while(rs.next()){
            dutyList.add(new Case(
                     rs.getInt(1)
                    ,rs.getString(2)
                    ,rs.getInt(3)
                    ,rs.getInt(4)
                    ,rs.getInt(5)
                    ,rs.getString(6)
                    ,rs.getString(7)));
        }
        dbc.closeConnectionToDB();
        return dutyList;
        
        
    }
    
    
}
    
    
    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author sebastian
 */
public class Case {
    
    int caseCategory;
    int budgetTime;
    int timePerformed;
    String comment;
    String status;
    int taskID;
    int caseEmployeeID;

    public Case(int taskID,int caseCategory, int budgetTime, int timePerformed,int caseEmployeeID, String comment, String status) {
        this.taskID = taskID;
        this.caseCategory = caseCategory;
        this.budgetTime = budgetTime;
        this.timePerformed = timePerformed;
        this.caseEmployeeID = caseEmployeeID;
        this.comment = comment;
        this.status = status;
        
        
    }
    
    public Case (int budgetTime,int caseCategory){
        this.budgetTime = budgetTime;
        this.caseCategory = caseCategory;
    }


    public int getDutyCase() {
        return caseCategory;
    }

    public void setDutyCase(int dutyCase) {
        this.caseCategory = dutyCase;
    }

    public int getBudgetTime() {
        return budgetTime;
    }

    public void setBudgetTime(int budgetTime) {
        this.budgetTime = budgetTime;
    }

    public int getTimePerformed() {
        return timePerformed;
    }

    public void setTimePerformed(int timePerformed) {
        this.timePerformed = timePerformed;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public int getCaseEmployeeID() {
        return caseEmployeeID;
    }

    public void setCaseEmployeeID(int caseEmployeeID) {
        this.caseEmployeeID = caseEmployeeID;
    }

    
    
    
}

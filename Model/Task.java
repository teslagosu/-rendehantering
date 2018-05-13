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
public class Task {
    
    private int taskID;
    private String category;
    private String description;
    private String taskManagerName;

    public Task(int taskID, String category, String description, String taskManagerName) {
        this.taskID = taskID;
        this.category = category;
        this.description = description;
        this.taskManagerName = taskManagerName;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskManagerName() {
        return taskManagerName;
    }

    public void setTaskManagerName(String taskManagerName) {
        this.taskManagerName = taskManagerName;
    }

 
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observer;

import java.util.ArrayList;

/**
 *
 * @author sebastian
 */
public class TaskObservable {
    
    private static ArrayList<TaskObserver> observers = new ArrayList<TaskObserver>();
    
    public void addListener(TaskObserver to){
        observers.add(to);
    }
    
    public void removeListener(TaskObserver to){
        observers.remove(to);
    }
    public void notifyTaskObservers(){
        for(TaskObserver to : observers){
            to.update();
        }
    }
}

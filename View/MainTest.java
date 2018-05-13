package View;

import Controller.DatabaseController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sebastian
 */
public class MainTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatabaseController dbc = new DatabaseController();
        dbc.getConnection();
       
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.DatabaseController;
import com.mysql.jdbc.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author sebastian
 */
public class CreateNewTask extends javax.swing.JFrame {
    DatabaseController dbc;
    /**
     * Creates new form CreateNewTask
     */
    public CreateNewTask() throws SQLException {
        this.dbc = new DatabaseController();
        initComponents();
        fillTaskManagerComboBox();
        fillCategoryComboBox();
      
    }
    
    
    //Öppna upp en connection till databasen
    public Connection getConnection() {
        Connection conn = null;
        try {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javauppgift?zeroDateTimeBehavior=convertToNull&useSSL=false","root","hejsan");
            System.out.println("Connectad till databasen");
            return conn;
           
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        }
        
    }
    //Fyll comboboxen för taskmasters med namn
    public void fillTaskManagerComboBox() throws SQLException{
        dbc.connectToDB();
        
            Statement st = (Statement) getConnection().createStatement();
            ResultSet rs = st.executeQuery("Select taskManagerName from taskmanagertbl");
            while(rs.next()){
                combo_box_taskmanager.addItem(rs.getString("taskManagerName"));
            }
            dbc.closeConnectionToDB();
       
    }
    
    //Fyll comboboxen med olika kategorier
    public void fillCategoryComboBox(){
        getConnection();
        try {
            Statement st = (Statement) getConnection().createStatement();
            ResultSet rs = st.executeQuery("Select taskcategoryName from taskcategorytbl");
            while(rs.next()){
                combo_box_taskCategory.addItem(rs.getString("taskcategoryName"));
            }
            getConnection().close();
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combo_box_taskmanager = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        combo_box_taskCategory = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textArea_taskDescription = new javax.swing.JTextArea();
        button_cancel = new javax.swing.JButton();
        button_save1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        button_addCase = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocation(new java.awt.Point(700, 200));

        combo_box_taskmanager.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jLabel1.setText("Processledare:");

        combo_box_taskCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));

        jLabel2.setText("Kategori:");

        jLabel3.setText("Beskrivning: ");

        textArea_taskDescription.setColumns(20);
        textArea_taskDescription.setLineWrap(true);
        textArea_taskDescription.setRows(5);
        jScrollPane1.setViewportView(textArea_taskDescription);

        button_cancel.setText("Avbryt");
        button_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_cancelActionPerformed(evt);
            }
        });

        button_save1.setText("Spara");
        button_save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_save1ActionPerformed(evt);
            }
        });

        jLabel4.setText("Arbetsuppgift");

        button_addCase.setText("Lägg till");
        button_addCase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_addCaseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_cancel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(button_save1)
                .addGap(18, 18, 18))
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(button_addCase)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel2)
                        .addComponent(jLabel1)
                        .addComponent(combo_box_taskCategory, 0, 133, Short.MAX_VALUE)
                        .addComponent(combo_box_taskmanager, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_box_taskmanager, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_box_taskCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button_addCase)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_cancel)
                    .addComponent(button_save1))
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_save1ActionPerformed
    try {
                //Exekvera metoden som lägger till ett meddelande i db
           
                int status = dbc.addTask(combo_box_taskCategory.getSelectedIndex(), combo_box_taskmanager.getSelectedIndex(), textArea_taskDescription.getText());
                JOptionPane.showMessageDialog(null, "Ett nytt ärende har skapats");
                TaskExecutor te = new TaskExecutor();
                dispose();
                
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(rootPane, "Det gick inte att lägga till ett nytt ärende");
                System.out.println(ex.getMessage());
            }
    }//GEN-LAST:event_button_save1ActionPerformed

    private void button_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_cancelActionPerformed
     int dialogButton = JOptionPane.showConfirmDialog(null, "Det nya ärendet kommer att gå förlorat.", "Nytt ärende", JOptionPane.YES_NO_OPTION);
     if (dialogButton == JOptionPane.YES_OPTION){
        dispose();
     }else{
        this.setVisible(true);
     }
    }//GEN-LAST:event_button_cancelActionPerformed

    private void button_addCaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_addCaseActionPerformed
    
    }//GEN-LAST:event_button_addCaseActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CreateNewTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateNewTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateNewTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateNewTask.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new CreateNewTask().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(CreateNewTask.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_addCase;
    private javax.swing.JButton button_cancel;
    private javax.swing.JButton button_save1;
    private javax.swing.JComboBox<String> combo_box_taskCategory;
    private javax.swing.JComboBox<String> combo_box_taskmanager;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea textArea_taskDescription;
    // End of variables declaration//GEN-END:variables
}
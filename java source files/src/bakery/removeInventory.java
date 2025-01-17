//Class for removing inventory from the inventory table
package bakery;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class removeInventory extends javax.swing.JFrame {

    //Global variables of the class
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    boolean listLoaded = false;
    
    //Constructor for initialist components
    public removeInventory() {
        initComponents();
        centerFrame();  //Set frame in the center of the screen
        conn = ConnectToDatabase.getConnection();   //Get connection to the database
        setComboBoxValues();    //Set the combo box values
        listLoaded = true;  //List has been loaded completely
    }
    
    //Functin to set frame in the center of the screen
    public void centerFrame() {
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation((size.width/2 - getWidth()/2),(size.height/2 - getHeight()/2));
    }
    
    //Function to set the values of the combo box using the item id in the billing table
    public void setComboBoxValues() {
        String sql = "select inId from inventory where inActive=?";
        
        cbo_inId.removeAllItems();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,"Yes");
            rs = pst.executeQuery();
            
            while (rs.next()) {
                cbo_inId.addItem(rs.getString(1));
            }
            
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Inventory list cannot be loaded");
        }finally {
            try{
                rs.close();
                pst.close();
                
            }catch(Exception e) {}
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

        pnl_main = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_iniName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_inQty = new javax.swing.JTextField();
        btn_back = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_item_iId = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbo_inId = new javax.swing.JComboBox<>();
        btn_delete = new javax.swing.JButton();
        txt_inDate = new org.jdesktop.swingx.JXDatePicker();
        btn_clea = new javax.swing.JButton();
        lbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Remove inventory from inventory table");
        setResizable(false);

        pnl_main.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Remove item from inventory :");
        pnl_main.add(jLabel1);
        jLabel1.setBounds(30, 10, 230, 23);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel3.setText("Inventory date : ");
        pnl_main.add(jLabel3);
        jLabel3.setBounds(40, 110, 110, 16);

        txt_iniName.setEditable(false);
        txt_iniName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        pnl_main.add(txt_iniName);
        txt_iniName.setBounds(150, 200, 210, 30);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel5.setText("Item name : ");
        pnl_main.add(jLabel5);
        jLabel5.setBounds(40, 210, 110, 16);

        txt_inQty.setEditable(false);
        txt_inQty.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        pnl_main.add(txt_inQty);
        txt_inQty.setBounds(150, 250, 210, 30);

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        pnl_main.add(btn_back);
        btn_back.setBounds(310, 10, 80, 30);

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel7.setText("Item quantity : ");
        pnl_main.add(jLabel7);
        jLabel7.setBounds(40, 260, 120, 16);

        txt_item_iId.setEditable(false);
        txt_item_iId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        pnl_main.add(txt_item_iId);
        txt_item_iId.setBounds(150, 150, 210, 30);

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel8.setText("Item Id :");
        pnl_main.add(jLabel8);
        jLabel8.setBounds(40, 160, 120, 16);

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel6.setText("Select Inventory id : ");
        pnl_main.add(jLabel6);
        jLabel6.setBounds(40, 60, 110, 16);

        cbo_inId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbo_inId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_inIdItemStateChanged(evt);
            }
        });
        pnl_main.add(cbo_inId);
        cbo_inId.setBounds(150, 50, 210, 30);

        btn_delete.setText("Delete item");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        pnl_main.add(btn_delete);
        btn_delete.setBounds(60, 310, 130, 40);

        txt_inDate.setEditable(false);
        pnl_main.add(txt_inDate);
        txt_inDate.setBounds(150, 100, 210, 30);

        btn_clea.setText("Clear");
        btn_clea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cleaActionPerformed(evt);
            }
        });
        pnl_main.add(btn_clea);
        btn_clea.setBounds(200, 310, 130, 40);

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.images/Background image.jpeg"))); // NOI18N
        pnl_main.add(lbl_background);
        lbl_background.setBounds(0, 0, 410, 380);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
   
    //Action performed to delete the item in the inventory list
    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if((txt_iniName.getText()).equals("")) {    //Check to see if any inventory item is selected
            JOptionPane.showMessageDialog(null,"Please select the inventory id to delete");
        } else {
            String sql ="update inventory set inActive=? where inId=?"; 
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1,"No");
                pst.setString(2,cbo_inId.getSelectedItem().toString());
                pst.execute();
                
                JOptionPane.showMessageDialog(null, "Record removed");
                
                //Reset combo box values
                listLoaded = false;
                setComboBoxValues();    //Set the combo box values
                listLoaded = true;  //List has been loaded completely

            }catch(Exception e) {
                JOptionPane.showMessageDialog(null,e);
            }finally {
                try{
                    rs.close();
                    pst.close();
                }catch(Exception e) {}
            }
        }
    }//GEN-LAST:event_btn_deleteActionPerformed
    
    //Action performed when clear button is clicked
    private void btn_cleaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cleaActionPerformed
        
        //Code to remove all selected item details       
        txt_inDate.setDate(null);
        txt_iniName.setText("");
        txt_item_iId.setText("");
        txt_iniName.setText("");
        txt_inQty.setText("");
    }//GEN-LAST:event_btn_cleaActionPerformed

    //Action performed to show the details of the item of bill when bill id is selected
    private void cbo_inIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_inIdItemStateChanged
        if(listLoaded) {
            String sql = "select * from inventory where inId=?";
        
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1,cbo_inId.getSelectedItem().toString());
                rs = pst.executeQuery();
                rs.next();  //Move resultset to the first pointer
                        
                txt_inDate.setDate(rs.getDate(2));
                txt_item_iId.setText(rs.getString(3));
                txt_iniName.setText(rs.getString(4));
                txt_inQty.setText(rs.getString(5));

            }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Inventory details cannot be found");
            }finally {
                try{
                    rs.close();
                    pst.close();
                }catch(Exception e) {}
            }
        }
    }//GEN-LAST:event_cbo_inIdItemStateChanged

    //Code to go back
    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        inventory i = new inventory();
        i.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_backActionPerformed

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
            java.util.logging.Logger.getLogger(removeInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(removeInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(removeInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(removeInventory.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new removeInventory().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clea;
    private javax.swing.JButton btn_delete;
    private javax.swing.JComboBox<String> cbo_inId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JPanel pnl_main;
    private org.jdesktop.swingx.JXDatePicker txt_inDate;
    private javax.swing.JTextField txt_inQty;
    private javax.swing.JTextField txt_iniName;
    private javax.swing.JTextField txt_item_iId;
    // End of variables declaration//GEN-END:variables
}

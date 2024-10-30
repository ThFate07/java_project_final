//Class for add, update or delete item data
package bakery;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;


public class itemList extends javax.swing.JFrame {

   
    //Global variables of the class
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    //Variable to store the details if list has been loaded or not for combo box
    //Else the state change event function starts even before the components are loaded
    boolean listLoaded = false; 
    
    //Constructor to initialise components
    public itemList() {
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
    
    //Function to set the values of the combo box using the item names in the items table
    public void setComboBoxValues() {
        String sql = "select iName from item where iActive=? order by iName asc";
        
        cbo_search.removeAllItems();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,"Yes");
            rs = pst.executeQuery();
            
            while (rs.next()) {
                cbo_search.addItem(rs.getString(1));
            }
            
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Item list cannot be loaded");
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
        btn_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cbo_search = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_iSp = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_Update = new javax.swing.JButton();
        btn_Add = new javax.swing.JButton();
        btn_Clear = new javax.swing.JButton();
        btn_Remove1 = new javax.swing.JButton();
        txt_iCp = new javax.swing.JTextField();
        txt_iMinStock = new javax.swing.JTextField();
        txt_iName = new javax.swing.JTextField();
        txt_iId = new javax.swing.JTextField();
        scrollPane_Description = new javax.swing.JScrollPane();
        txt_iDescription = new javax.swing.JTextArea();
        lbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Item details");
        setResizable(false);

        pnl_main.setLayout(null);

        btn_back.setText("Back to main menu");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        pnl_main.add(btn_back);
        btn_back.setBounds(450, 13, 160, 30);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Search item : ");
        pnl_main.add(jLabel1);
        jLabel1.setBounds(40, 20, 102, 23);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("Select the item name :");
        pnl_main.add(jLabel2);
        jLabel2.setBounds(40, 60, 160, 17);

        cbo_search.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbo_search.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item List" }));
        cbo_search.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_searchItemStateChanged(evt);
            }
        });
        cbo_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                cbo_searchMouseReleased(evt);
            }
        });
        cbo_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbo_searchActionPerformed(evt);
            }
        });
        pnl_main.add(cbo_search);
        cbo_search.setBounds(200, 57, 270, 23);

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel3.setText("Item details :");
        pnl_main.add(jLabel3);
        jLabel3.setBounds(40, 130, 110, 23);

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Item Id :");
        pnl_main.add(jLabel4);
        jLabel4.setBounds(50, 180, 90, 17);
        pnl_main.add(txt_iSp);
        txt_iSp.setBounds(150, 330, 220, 30);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Item Name :");
        pnl_main.add(jLabel5);
        jLabel5.setBounds(50, 220, 90, 17);

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel6.setText("Min stock :");
        pnl_main.add(jLabel6);
        jLabel6.setBounds(50, 260, 90, 17);

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel7.setText("Cost price :");
        pnl_main.add(jLabel7);
        jLabel7.setBounds(50, 300, 90, 17);

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Selling price :");
        pnl_main.add(jLabel8);
        jLabel8.setBounds(50, 340, 90, 17);

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel9.setText("Item description :");
        pnl_main.add(jLabel9);
        jLabel9.setBounds(50, 380, 100, 17);

        btn_Update.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_Update.setText("Update item");
        btn_Update.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_UpdateActionPerformed(evt);
            }
        });
        pnl_main.add(btn_Update);
        btn_Update.setBounds(460, 220, 120, 30);

        btn_Add.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_Add.setText("Add item");
        btn_Add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_AddActionPerformed(evt);
            }
        });
        pnl_main.add(btn_Add);
        btn_Add.setBounds(460, 170, 120, 30);

        btn_Clear.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_Clear.setText("Clear");
        btn_Clear.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClearActionPerformed(evt);
            }
        });
        pnl_main.add(btn_Clear);
        btn_Clear.setBounds(460, 320, 120, 30);

        btn_Remove1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_Remove1.setText("Remove item");
        btn_Remove1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Remove1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Remove1ActionPerformed(evt);
            }
        });
        pnl_main.add(btn_Remove1);
        btn_Remove1.setBounds(460, 270, 120, 30);
        pnl_main.add(txt_iCp);
        txt_iCp.setBounds(150, 290, 220, 30);
        pnl_main.add(txt_iMinStock);
        txt_iMinStock.setBounds(150, 250, 220, 30);
        pnl_main.add(txt_iName);
        txt_iName.setBounds(150, 210, 220, 30);

        txt_iId.setEditable(false);
        txt_iId.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        pnl_main.add(txt_iId);
        txt_iId.setBounds(150, 170, 220, 30);

        txt_iDescription.setColumns(20);
        txt_iDescription.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        txt_iDescription.setLineWrap(true);
        txt_iDescription.setRows(5);
        scrollPane_Description.setViewportView(txt_iDescription);

        pnl_main.add(scrollPane_Description);
        scrollPane_Description.setBounds(150, 380, 220, 80);

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.images/Background image.jpeg"))); // NOI18N
        pnl_main.add(lbl_background);
        lbl_background.setBounds(0, 0, 620, 470);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.PREFERRED_SIZE, 620, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 472, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    //Code executed when an item is selected in the combo box
    //It shows the details of the selected items
    private void cbo_searchItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_searchItemStateChanged
        if(listLoaded) {
            String sql = "select * from item where iName=?";
        
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1,cbo_search.getSelectedItem().toString());
                rs = pst.executeQuery();
                rs.next();  //Move resultset to the first pointer

                txt_iId.setText(rs.getString(1));
                txt_iName.setText(rs.getString(2));
                txt_iDescription.setText(rs.getString(3));
                txt_iMinStock.setText(rs.getString(4));
                txt_iCp.setText(rs.getString(5));
                txt_iSp.setText(rs.getString(6));

            }catch(Exception e) {
                JOptionPane.showMessageDialog(null,e);
                //JOptionPane.showMessageDialog(null,"Item details cannot be found");
            }finally {
                try{
                    rs.close();
                    pst.close();
                }catch(Exception e) {}
            }
        }
    }//GEN-LAST:event_cbo_searchItemStateChanged

    //Extra code done by mistake. Cannot be deleted as its done by the gui builder
    private void cbo_searchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbo_searchMouseReleased
    }//GEN-LAST:event_cbo_searchMouseReleased
    
    //Extra code done by mistake. Cannot be deleted as its done by the gui builder
    private void cbo_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbo_searchActionPerformed
    }//GEN-LAST:event_cbo_searchActionPerformed

    
    //Action performed when clear button is clicked
    private void btn_ClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClearActionPerformed
        txt_iId.setText("");
        txt_iName.setText("");
        txt_iDescription.setText("");
        txt_iMinStock.setText("");
        txt_iCp.setText("");
        txt_iSp.setText("");
    }//GEN-LAST:event_btn_ClearActionPerformed

    //Action performed to when remove button is clicked
    private void btn_Remove1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Remove1ActionPerformed
        String sql = "update item set iActive = ? where iId = ?";

        try {
            
            pst = conn.prepareStatement(sql);
            pst.setString(1,"No");
            pst.setInt(2,Integer.parseInt(txt_iId.getText()));
            pst.execute();
            JOptionPane.showMessageDialog(null, "Record Removed");

            //Clear all the fields
            txt_iId.setText("");
            txt_iName.setText("");
            txt_iDescription.setText("");
            txt_iMinStock.setText("");
            txt_iCp.setText("");
            txt_iSp.setText("");
            
            listLoaded = false;     //Variable to tell the combo box action listener that the list values are being updated
            setComboBoxValues();    //Rearrange the combo box values
            listLoaded = true;
            
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Item details cannot be found");
        }finally {
            try{
                rs.close();
                pst.close();
            }catch(Exception e) {}
        }
    }//GEN-LAST:event_btn_Remove1ActionPerformed

    //Action performed when add button is clicked
    private void btn_AddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_AddActionPerformed
        if((txt_iId.getText()).equals("")) {    //Check to see if id is present. If it is not present then its a new item and it has to be added not updated
            String sql ="insert into item " 
                            + "(iName,iDescription,iMinStock,iCp,"
                            + "iSp) values (?,?,?,?,?) ";
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1,txt_iName.getText());
                pst.setString(2,txt_iDescription.getText());
                pst.setInt(3,Integer.parseInt(txt_iMinStock.getText()));
                pst.setInt(4,Integer.parseInt(txt_iCp.getText()));
                pst.setInt(5,Integer.parseInt(txt_iSp.getText()));
                pst.execute();
                JOptionPane.showMessageDialog(null, "Record Added");

                //Clear all the fields
                txt_iId.setText("");
                txt_iName.setText("");
                txt_iDescription.setText("");
                txt_iMinStock.setText("");
                txt_iCp.setText("");
                txt_iSp.setText("");

                listLoaded = false;     //Variable to tell the combo box action listener that the list values are being updated
                setComboBoxValues();    //Rearrange the combo box values
                listLoaded = true;

            }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Item cannot be added. Please fill all the details completely");
            }finally {
                try{
                    rs.close();
                    pst.close();
                }catch(Exception e) {}
            }
        } else {
            JOptionPane.showMessageDialog(null,"Item already present. Please click update to update the item details");
        }
    }//GEN-LAST:event_btn_AddActionPerformed

    //Action performed when update button is clicked
    private void btn_UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_UpdateActionPerformed
        if((txt_iId.getText()).equals("")) {    //Check to see if id is present. If it is then its and old item and it has to be updated not added
            JOptionPane.showMessageDialog(null,"New item. Please click on the add button to add");
        } else {
            String sql ="update item set iName=?, iDescription=?, iMInstock=?, iCp=?, iSp=? where iId=?"; 
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1,txt_iName.getText());
                pst.setString(2,txt_iDescription.getText());
                pst.setInt(3,Integer.parseInt(txt_iMinStock.getText()));
                pst.setInt(4,Integer.parseInt(txt_iCp.getText()));
                pst.setInt(5,Integer.parseInt(txt_iSp.getText()));
                pst.setInt(6,Integer.parseInt(txt_iId.getText()));
                pst.execute();
                JOptionPane.showMessageDialog(null, "Record updated");

                //Clear all the fields
                txt_iId.setText("");
                txt_iName.setText("");
                txt_iDescription.setText("");
                txt_iMinStock.setText("");
                txt_iCp.setText("");
                txt_iSp.setText("");

                listLoaded = false;     //Variable to tell the combo box action listener that the list values are being updated
                setComboBoxValues();    //Rearrange the combo box values
                listLoaded = true;

            }catch(Exception e) {
                //JOptionPane.showMessageDialog(null,"Item cannot be added. Please fill all the details completely");
                JOptionPane.showMessageDialog(null,"Record cannot be updated. Please fill in all the details completely");
            }finally {
                try{
                    rs.close();
                    pst.close();
                }catch(Exception e) {}
            }
        }
    }//GEN-LAST:event_btn_UpdateActionPerformed

    //Code to go back to the main menu
    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        mainMenu mm = new mainMenu();
        mm.setVisible(true);
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
            java.util.logging.Logger.getLogger(itemList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(itemList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(itemList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(itemList.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new itemList().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Add;
    private javax.swing.JButton btn_Clear;
    private javax.swing.JButton btn_Remove1;
    private javax.swing.JButton btn_Update;
    private javax.swing.JButton btn_back;
    private javax.swing.JComboBox<String> cbo_search;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JScrollPane scrollPane_Description;
    private javax.swing.JTextField txt_iCp;
    private javax.swing.JTextArea txt_iDescription;
    private javax.swing.JTextField txt_iId;
    private javax.swing.JTextField txt_iMinStock;
    private javax.swing.JTextField txt_iName;
    private javax.swing.JTextField txt_iSp;
    // End of variables declaration//GEN-END:variables
}

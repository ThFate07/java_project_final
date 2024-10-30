//Class for removing item from the billing summary
package bakery;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;


public class removeItem extends javax.swing.JFrame {

    //Global variables of the class
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    boolean listLoaded = false;
    
    //Constructor for initialist components
    public removeItem() {
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
        String sql = "select bId from billing where bOk=?";
        
        cbo_bId.removeAllItems();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1,"Yes");
            rs = pst.executeQuery();
            
            while (rs.next()) {
                cbo_bId.addItem(rs.getString(1));
            }
            
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Billing list cannot be loaded");
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
        txt_bNumber = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_iName = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txt_bQty = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_iId = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txt_iSp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_bCustName = new javax.swing.JTextField();
        txt_bAmount = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_iCp = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        cbo_bId = new javax.swing.JComboBox<>();
        btn_delete = new javax.swing.JButton();
        txt_bDate = new org.jdesktop.swingx.JXDatePicker();
        btn_clea = new javax.swing.JButton();
        scrollPane_iDescription = new javax.swing.JScrollPane();
        txt_iDescription = new javax.swing.JTextArea();
        lbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Delete item from billing");
        setResizable(false);

        pnl_main.setLayout(null);

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        pnl_main.add(btn_back);
        btn_back.setBounds(670, 10, 100, 30);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Remove item from billing :");
        pnl_main.add(jLabel1);
        jLabel1.setBounds(30, 10, 230, 23);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel2.setText("Bill number : ");
        pnl_main.add(jLabel2);
        jLabel2.setBounds(40, 110, 110, 16);

        txt_bNumber.setEditable(false);
        txt_bNumber.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        pnl_main.add(txt_bNumber);
        txt_bNumber.setBounds(150, 100, 210, 30);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel3.setText("Bill date : ");
        pnl_main.add(jLabel3);
        jLabel3.setBounds(40, 160, 110, 16);

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel4.setText("Customer name : ");
        pnl_main.add(jLabel4);
        jLabel4.setBounds(40, 210, 110, 16);

        txt_iName.setEditable(false);
        txt_iName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        pnl_main.add(txt_iName);
        txt_iName.setBounds(150, 250, 210, 30);

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel5.setText("Item name : ");
        pnl_main.add(jLabel5);
        jLabel5.setBounds(40, 260, 110, 16);

        txt_bQty.setEditable(false);
        txt_bQty.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        pnl_main.add(txt_bQty);
        txt_bQty.setBounds(560, 50, 210, 30);

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel7.setText("Item quantity : ");
        pnl_main.add(jLabel7);
        jLabel7.setBounds(450, 60, 120, 16);

        txt_iId.setEditable(false);
        txt_iId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        pnl_main.add(txt_iId);
        txt_iId.setBounds(150, 300, 210, 30);

        jLabel9.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel9.setText("Selling price : ");
        pnl_main.add(jLabel9);
        jLabel9.setBounds(450, 110, 120, 16);

        txt_iSp.setEditable(false);
        txt_iSp.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        pnl_main.add(txt_iSp);
        txt_iSp.setBounds(560, 100, 210, 30);

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel8.setText("Item Id :");
        pnl_main.add(jLabel8);
        jLabel8.setBounds(40, 310, 120, 16);

        jLabel10.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel10.setText("Item amount : ");
        pnl_main.add(jLabel10);
        jLabel10.setBounds(450, 210, 120, 16);

        txt_bCustName.setEditable(false);
        txt_bCustName.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        pnl_main.add(txt_bCustName);
        txt_bCustName.setBounds(150, 200, 210, 30);

        txt_bAmount.setEditable(false);
        txt_bAmount.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        pnl_main.add(txt_bAmount);
        txt_bAmount.setBounds(560, 200, 210, 30);

        jLabel11.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel11.setText("Cost price : ");
        pnl_main.add(jLabel11);
        jLabel11.setBounds(450, 160, 120, 16);

        txt_iCp.setEditable(false);
        txt_iCp.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        pnl_main.add(txt_iCp);
        txt_iCp.setBounds(560, 150, 210, 30);

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel6.setText("Select Bill id : ");
        pnl_main.add(jLabel6);
        jLabel6.setBounds(40, 60, 110, 16);

        jLabel12.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        jLabel12.setText("Item Description :");
        pnl_main.add(jLabel12);
        jLabel12.setBounds(40, 360, 110, 16);

        cbo_bId.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        cbo_bId.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbo_bIdItemStateChanged(evt);
            }
        });
        pnl_main.add(cbo_bId);
        cbo_bId.setBounds(150, 50, 210, 30);

        btn_delete.setText("Delete item");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        pnl_main.add(btn_delete);
        btn_delete.setBounds(480, 330, 130, 40);

        txt_bDate.setEditable(false);
        pnl_main.add(txt_bDate);
        txt_bDate.setBounds(150, 150, 210, 30);

        btn_clea.setText("Clear");
        btn_clea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cleaActionPerformed(evt);
            }
        });
        pnl_main.add(btn_clea);
        btn_clea.setBounds(620, 330, 130, 40);

        txt_iDescription.setEditable(false);
        txt_iDescription.setColumns(20);
        txt_iDescription.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        txt_iDescription.setLineWrap(true);
        txt_iDescription.setRows(5);
        scrollPane_iDescription.setViewportView(txt_iDescription);

        pnl_main.add(scrollPane_iDescription);
        scrollPane_iDescription.setBounds(150, 350, 210, 130);

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.images/Background image.jpeg"))); // NOI18N
        pnl_main.add(lbl_background);
        lbl_background.setBounds(0, 0, 820, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 819, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
   
    //Action performed to delete the item in the billing list
    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if((txt_bNumber.getText()).equals("")) {    //Check to see if bill number is entered
            JOptionPane.showMessageDialog(null,"Please select the bill id to delete");
        } else {
            String sql ="update billing set bOk=? where bId=?"; 
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1,"No");
                pst.setString(2,cbo_bId.getSelectedItem().toString());
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
        txt_bNumber.setText("");        
        txt_bDate.setDate(null);
        txt_bCustName.setText("");
        txt_iName.setText("");
        txt_iId.setText("");
        txt_iName.setText("");
        txt_iDescription.setText("");
        txt_bQty.setText("");
        txt_iSp.setText("");
        txt_iCp.setText("");
        txt_bAmount.setText("");
    }//GEN-LAST:event_btn_cleaActionPerformed

    //Action performed to show the details of the item of bill when bill id is selected
    private void cbo_bIdItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbo_bIdItemStateChanged
        if(listLoaded) {
            String sql = "select * from billing where bId=?";
        
            try {
                pst = conn.prepareStatement(sql);
                pst.setString(1,cbo_bId.getSelectedItem().toString());
                rs = pst.executeQuery();
                rs.next();  //Move resultset to the first pointer
                
                txt_bNumber.setText(rs.getString(2));        
                txt_bDate.setDate(rs.getDate(3));
                txt_bCustName.setText(rs.getString(4));
                txt_iId.setText(rs.getString(5));
                txt_iName.setText(rs.getString(6));
                txt_iDescription.setText(rs.getString(7));
                txt_bQty.setText(rs.getString(8));
                txt_iSp.setText(rs.getString(9));
                txt_iCp.setText(rs.getString(10));
                txt_bAmount.setText(rs.getString(12));

            }catch(Exception e) {
                JOptionPane.showMessageDialog(null,"Billing details cannot be found");
            }finally {
                try{
                    rs.close();
                    pst.close();
                }catch(Exception e) {}
            }
        }
    }//GEN-LAST:event_cbo_bIdItemStateChanged

    //Code to go back
    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        generateBill gb = new generateBill();
        gb.setVisible(true);
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
            java.util.logging.Logger.getLogger(removeItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(removeItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(removeItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(removeItem.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new removeItem().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_clea;
    private javax.swing.JButton btn_delete;
    private javax.swing.JComboBox<String> cbo_bId;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
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
    private javax.swing.JScrollPane scrollPane_iDescription;
    private javax.swing.JTextField txt_bAmount;
    private javax.swing.JTextField txt_bCustName;
    private org.jdesktop.swingx.JXDatePicker txt_bDate;
    private javax.swing.JTextField txt_bNumber;
    private javax.swing.JTextField txt_bQty;
    private javax.swing.JTextField txt_iCp;
    private javax.swing.JTextArea txt_iDescription;
    private javax.swing.JTextField txt_iId;
    private javax.swing.JTextField txt_iName;
    private javax.swing.JTextField txt_iSp;
    // End of variables declaration//GEN-END:variables
}

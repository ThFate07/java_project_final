//Class for making a new bill
package bakery;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class generateBill extends javax.swing.JFrame {

    //Global variables of the class
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    //Constructor for initialising components
    public generateBill() {
        initComponents();   //Initialise components
        centerFrame();  //Set frame in the center of the screen
        conn = ConnectToDatabase.getConnection();   //Get connection to the database
        generateBillTable();    //Generate table data for bill
    }
    
    //Functin to set frame in the center of the screen
    public void centerFrame() {
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation((size.width/2 - getWidth()/2),(size.height/2 - getHeight()/2));
    }
    
    //Fuction to generate table data for bill
    public void generateBillTable() {
        try {
            //Only those items are shown that have not been removed from the billing list
            String sql ="select bId, bNumber, bDate, bCustName, item_iId, iName, iDescription, bQty, iSp, iCp, bAmount, bProfit, bOk from billing where bOk=?";
            pst=conn.prepareStatement(sql);
            pst.setString(1,"Yes");
            rs=pst.executeQuery();
            tbl_Bill.setModel(DbUtils.resultSetToTableModel(rs));
        } catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }finally {
            try {
                pst.close();
                rs.close();
            } catch(Exception e) {}
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
        btn_backToMainMenu = new javax.swing.JButton();
        btn_addItem = new javax.swing.JButton();
        btn_removeItem = new javax.swing.JButton();
        btn_removeBill = new javax.swing.JButton();
        btn_saveBillInPdf = new javax.swing.JButton();
        jScrollPaneForTable = new javax.swing.JScrollPane();
        tbl_Bill = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        lbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Bill details");
        setResizable(false);

        pnl_main.setLayout(null);

        btn_backToMainMenu.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_backToMainMenu.setText("Back to main menu");
        btn_backToMainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backToMainMenuActionPerformed(evt);
            }
        });
        pnl_main.add(btn_backToMainMenu);
        btn_backToMainMenu.setBounds(890, 10, 200, 30);

        btn_addItem.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_addItem.setText("Add item");
        btn_addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addItemActionPerformed(evt);
            }
        });
        pnl_main.add(btn_addItem);
        btn_addItem.setBounds(370, 430, 90, 30);

        btn_removeItem.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_removeItem.setText("Remove item");
        btn_removeItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeItemActionPerformed(evt);
            }
        });
        pnl_main.add(btn_removeItem);
        btn_removeItem.setBounds(470, 430, 110, 30);

        btn_removeBill.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_removeBill.setText("Remove bill");
        btn_removeBill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeBillActionPerformed(evt);
            }
        });
        pnl_main.add(btn_removeBill);
        btn_removeBill.setBounds(590, 430, 110, 30);

        btn_saveBillInPdf.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btn_saveBillInPdf.setText("Save bill in PDF");
        btn_saveBillInPdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveBillInPdfActionPerformed(evt);
            }
        });
        pnl_main.add(btn_saveBillInPdf);
        btn_saveBillInPdf.setBounds(710, 430, 130, 30);

        tbl_Bill.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        tbl_Bill.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_Bill.setEnabled(false);
        tbl_Bill.setRowSelectionAllowed(false);
        jScrollPaneForTable.setViewportView(tbl_Bill);

        pnl_main.add(jScrollPaneForTable);
        jScrollPaneForTable.setBounds(20, 50, 1070, 370);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jLabel1.setText("Bill details : ");
        pnl_main.add(jLabel1);
        jLabel1.setBounds(20, 20, 120, 23);

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.images/Background image.jpeg"))); // NOI18N
        pnl_main.add(lbl_background);
        lbl_background.setBounds(0, 0, 1110, 470);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 1110, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl_main, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Code to go back to the main menu
    private void btn_backToMainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backToMainMenuActionPerformed
        mainMenu mm = new mainMenu();
        mm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_backToMainMenuActionPerformed

    //Code to add item to billing table
    private void btn_addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addItemActionPerformed
        addItem ai = new addItem();
        ai.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_addItemActionPerformed

    //Code to remove wrongly entered item from billing table
    private void btn_removeItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeItemActionPerformed
        removeItem ri = new removeItem();
        ri.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_removeItemActionPerformed

    //Code to remove all details of bill from billing table
    private void btn_removeBillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeBillActionPerformed
        removeBill rb = new removeBill();
        rb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btn_removeBillActionPerformed

    //Code to save bill in pdf
    private void btn_saveBillInPdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveBillInPdfActionPerformed
       printBill pb = new printBill();
       pb.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_btn_saveBillInPdfActionPerformed

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
            java.util.logging.Logger.getLogger(generateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(generateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(generateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(generateBill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new generateBill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addItem;
    private javax.swing.JButton btn_backToMainMenu;
    private javax.swing.JButton btn_removeBill;
    private javax.swing.JButton btn_removeItem;
    private javax.swing.JButton btn_saveBillInPdf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPaneForTable;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JPanel pnl_main;
    private javax.swing.JTable tbl_Bill;
    // End of variables declaration//GEN-END:variables
}
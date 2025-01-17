//Main login class frame

package bakery;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;


public class login extends javax.swing.JFrame {
    
    //Global variables of the class
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    //Constructor declaration.
    public login() {
        initComponents();   //Initialise all components
        centerFrame();  //Set frame in the center of the screen
        conn = ConnectToDatabase.getConnection();   //Get connection to the database
    }
    
    //Functin to set frame in the center of the screen
    public void centerFrame() {
        Toolkit toolkit = getToolkit();
        Dimension size = toolkit.getScreenSize();
        setLocation((size.width/2 - getWidth()/2),(size.height/2 - getHeight()/2));
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Username = new javax.swing.JTextField();
        txt_Password = new javax.swing.JPasswordField();
        cbo_UserType = new javax.swing.JComboBox<>();
        btn_Login = new javax.swing.JButton();
        lbl_background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login");
        setResizable(false);
        setSize(new java.awt.Dimension(800, 800));

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Welcome to bakery");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(170, 40, 290, 50);

        jLabel2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel2.setText("User type : ");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(140, 250, 80, 17);

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel3.setText("Username : ");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(140, 150, 80, 17);

        jLabel4.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel4.setText("Password : ");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(140, 200, 80, 17);

        txt_Username.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(txt_Username);
        txt_Username.setBounds(220, 143, 250, 30);

        txt_Password.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jPanel1.add(txt_Password);
        txt_Password.setBounds(220, 190, 250, 30);

        cbo_UserType.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        cbo_UserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Admin", "Manager", "Billing Executive" }));
        jPanel1.add(cbo_UserType);
        cbo_UserType.setBounds(220, 240, 250, 30);

        btn_Login.setText("Login");
        btn_Login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LoginActionPerformed(evt);
            }
        });
        jPanel1.add(btn_Login);
        btn_Login.setBounds(280, 320, 90, 30);

        lbl_background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com.images/Background image.jpeg"))); // NOI18N
        jPanel1.add(lbl_background);
        lbl_background.setBounds(0, 0, 640, 450);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 636, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Function to check the login details
    private void btn_LoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LoginActionPerformed
        String sql = "select uId, uName, uPassword, uActive, uType from user where (uName = ? and uPassword = ? and uType = ?)";
        
        try {
            int count = 0; //Counter to check if any valid login credentials is received
            boolean userLoginCredentials = false;
            pst = conn.prepareStatement(sql);
            pst.setString(1,txt_Username.getText());
            pst.setString(2,txt_Password.getText());
            pst.setString(3,cbo_UserType.getSelectedItem().toString());
            
            rs = pst.executeQuery();
            
            while (rs.next()) {
                count = count+1;
                int id = rs.getInt(1);
                //Emp.empname = rs.getString("username");
            }
            
            //If any data is returned from the previous resultset the user credentials are ok
            //the boolean variable userLogin is changed to true
            if(count>0)
                userLoginCredentials = true;
            
            if(userLoginCredentials) {
                String access = cbo_UserType.getSelectedItem().toString();
                
                //Code to show extra tools for admin and manager
                if(access == "Admin") {
                    //Code to show admin tools
                } else if(access == "Manager") {
                    //Code to show manager tools
                }
                
                JOptionPane.showMessageDialog(null, "Login successfull");
                mainMenu j = new mainMenu();
                j.setVisible(true);
                this.dispose();
                
            } else {
                JOptionPane.showMessageDialog(null, "Username and password incorrect");
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Username and password incorrect");
        }finally {
            try {
                rs.close();
                pst.close();
            }catch(Exception e) {}
        }
    }//GEN-LAST:event_btn_LoginActionPerformed

    //Main method
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Login;
    private javax.swing.JComboBox<String> cbo_UserType;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_background;
    private javax.swing.JPasswordField txt_Password;
    private javax.swing.JTextField txt_Username;
    // End of variables declaration//GEN-END:variables
}

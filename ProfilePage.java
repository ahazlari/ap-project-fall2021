


import com.mysql.jdbc.Connection;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
    profile page.
 */

/**
 *
 * @author Ali Rahimi
 */
public class ProfilePage extends javax.swing.JFrame {

    /**
     * Creates new form ProfilePage
     */
    public ProfilePage() {
        
        initComponents();
        labelusername.setText(Login.usernameHelper);
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");             //connect to database from localhost
            Connection connector = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/instagram?autoReconnect=true&useSSL=false", "root", ""); 
            String sqlOrder = "SELECT post.username,post.text,post.date FROM post,follow WHERE post.username = follow.usernameno2 AND follow.usernameno1 = ? ORDER BY post.date DESC";
            PreparedStatement preparedStatement = connector.prepareStatement(sqlOrder);
            preparedStatement.setString(1, Login.usernameHelper); //person page
            ResultSet resultSet = preparedStatement.executeQuery(); 
            
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            
            while(table.getRowCount() > 0){
                model.removeRow(0);  
            }
            while(resultSet.next()){
                model.addRow(new Object[]{resultSet.getString("username"), resultSet.getString("text"), resultSet.getString("date")});
                
            }  
            connector.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error!");
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        labelusername = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        buttondeleteaccount = new javax.swing.JButton();
        buttonfollowers = new javax.swing.JButton();
        buttonfollowing = new javax.swing.JButton();
        buttonmessages = new javax.swing.JButton();
        buttonsearch = new javax.swing.JButton();
        buttonrefresh = new javax.swing.JButton();
        buttonmypost = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Profile Page");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(153, 153, 255));

        labelusername.setText("username");

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Log out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttondeleteaccount.setBackground(new java.awt.Color(255, 255, 255));
        buttondeleteaccount.setText("Delete account");
        buttondeleteaccount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttondeleteaccountActionPerformed(evt);
            }
        });

        buttonfollowers.setBackground(new java.awt.Color(255, 255, 255));
        buttonfollowers.setText("Followers");
        buttonfollowers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonfollowersActionPerformed(evt);
            }
        });

        buttonfollowing.setBackground(new java.awt.Color(255, 255, 255));
        buttonfollowing.setText("Followings");
        buttonfollowing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonfollowingActionPerformed(evt);
            }
        });

        buttonmessages.setBackground(new java.awt.Color(255, 255, 255));
        buttonmessages.setText("Messages");
        buttonmessages.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonmessagesActionPerformed(evt);
            }
        });

        buttonsearch.setBackground(new java.awt.Color(255, 255, 255));
        buttonsearch.setText("Search");
        buttonsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonsearchActionPerformed(evt);
            }
        });

        buttonrefresh.setBackground(new java.awt.Color(255, 255, 255));
        buttonrefresh.setText("Refresh");
        buttonrefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonrefreshActionPerformed(evt);
            }
        });

        buttonmypost.setBackground(new java.awt.Color(255, 255, 255));
        buttonmypost.setText("All my posts");
        buttonmypost.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonmypostActionPerformed(evt);
            }
        });

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "uername", "Caption", "Date"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/50.png"))); // NOI18N

        jLabel1.setText("Bio: ");

        jLabel3.setText("Address: ");

        jLabel4.setText("Email: ");

        jButton2.setText("Information");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(buttonmypost)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonrefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonsearch)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonmessages)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonfollowing)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonfollowers)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(buttondeleteaccount)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel2))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(labelusername, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jButton1))
                        .addGap(0, 112, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(39, 39, 39)
                        .addComponent(labelusername)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel4)))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonmypost)
                    .addComponent(buttonrefresh)
                    .addComponent(buttonsearch)
                    .addComponent(buttonmessages)
                    .addComponent(buttonfollowing)
                    .addComponent(buttonfollowers)
                    .addComponent(buttondeleteaccount)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonrefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonrefreshActionPerformed
        
        ProfilePage profilePage = new ProfilePage();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        profilePage.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        profilePage.show();
        this.hide();
        
    }//GEN-LAST:event_buttonrefreshActionPerformed

    private void buttonmessagesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonmessagesActionPerformed
        Messages messages = new Messages();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        messages.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        messages.show();
        
    }//GEN-LAST:event_buttonmessagesActionPerformed

    private void buttonmypostActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonmypostActionPerformed
        AllMyPost allMyPost = new AllMyPost();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        allMyPost.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        allMyPost.show();
    }//GEN-LAST:event_buttonmypostActionPerformed

    private void buttonsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonsearchActionPerformed
        
        SearchBox searchBox = new SearchBox();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        searchBox.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        searchBox.show();
    }//GEN-LAST:event_buttonsearchActionPerformed

    private void buttonfollowersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonfollowersActionPerformed
        
        FollowerPart followers = new FollowerPart();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        followers.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        followers.show();
    }//GEN-LAST:event_buttonfollowersActionPerformed

    private void buttonfollowingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonfollowingActionPerformed
        FollowingPart follwings = new FollowingPart();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        follwings.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        follwings.show();
    }//GEN-LAST:event_buttonfollowingActionPerformed

    private void buttondeleteaccountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttondeleteaccountActionPerformed
        DeleteAccount deleteAccount = new DeleteAccount();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        deleteAccount.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        deleteAccount.show();
    }//GEN-LAST:event_buttondeleteaccountActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        int selectRow = table.getSelectedRow();
        String username = model.getValueAt(selectRow, 0).toString();
        String post = model.getValueAt(selectRow, 1).toString();
        String date = model.getValueAt(selectRow, 2).toString();
        
        Post postFrame = new Post(username, post, date);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        postFrame.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        postFrame.show();
        
        
        
    }//GEN-LAST:event_tableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Login loginFrame = new Login();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        loginFrame.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        loginFrame.show();
        this.hide();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(ProfilePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProfilePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProfilePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProfilePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfilePage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttondeleteaccount;
    private javax.swing.JButton buttonfollowers;
    private javax.swing.JButton buttonfollowing;
    private javax.swing.JButton buttonmessages;
    private javax.swing.JButton buttonmypost;
    private javax.swing.JButton buttonrefresh;
    private javax.swing.JButton buttonsearch;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelusername;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}

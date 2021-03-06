package JFrame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import jdk.nashorn.internal.scripts.JO;


public class ManageStudents extends javax.swing.JFrame {

    /**
     * Creates new form ManageBook
     */
    
    String studentName, course, branch;
    int studentId;
    DefaultTableModel model;
    
    
    public ManageStudents() {
        initComponents();
        setStudentDetailsToTable();
    }

    
    //to set the book details into the table
    public void setStudentDetailsToTable(){
        try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_ms","root","");
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery("select * from student_details");
             
             while(rs.next()){
                 String StudentId = rs.getString("student_id");
                 String StudentName = rs.getString("name");
                 String course = rs.getString("course");
                 String branch = rs.getString("branch");
                 
                 Object[] obj = {StudentId,StudentName,course,branch};
                 model = (DefaultTableModel)tbl_studentDetails.getModel();
                 model.addRow(obj);
                         
             }
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    //to update Student details
    public boolean updateStudent(){
        boolean isUpdated= false;
        studentId = Integer.parseInt(txt_studentId.getText());
        studentName = txt_studentName.getText();
        course = combo_course.getSelectedItem().toString();
        branch = combo_branch.getSelectedItem().toString();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update student_details set name = ?, course =? ,branch =? where student_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, studentName);
            pst.setString(2, course);
            pst.setString(3, branch);
            pst.setInt(4, studentId);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0){
                isUpdated  = true;
            }else{
                isUpdated = false;
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isUpdated;
    }

    //to delete book detail
    public boolean deleteStudent(){
        boolean isDeleted = false;
        studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "delete from student_details where student_id = ?";
            PreparedStatement pst = con.prepareCall(sql);
            pst.setInt(1, studentId);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0){
                isDeleted = true;
            }else{
                isDeleted = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDeleted; 
    }
    
    //to add student details
    public boolean addStudent(){
        boolean isAdded = false;
        studentId = Integer.parseInt(txt_studentId.getText());
        studentName = txt_studentName.getText();
        course = combo_course.getSelectedItem().toString();
        branch = combo_branch.getSelectedItem().toString();
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into student_details values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, studentId);
            pst.setString(2, studentName);
            pst.setString(3, course);
            pst.setString(4, branch);
            
            int rowCount = pst.executeUpdate();
            if (rowCount > 0 ){
                isAdded = true;
            }else{
                isAdded = false;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    
    
    //clear table
    public void clearTable(){
        DefaultTableModel model = (DefaultTableModel) tbl_studentDetails.getModel();
        model.setRowCount(0);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        jLabel7 = new javax.swing.JLabel();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        txt_studentId = new app.bolivia.swing.JCTextField();
        txt_studentName = new app.bolivia.swing.JCTextField();
        rSMaterialButtonCircle4 = new rojerusan.RSMaterialButtonCircle();
        combo_branch = new javax.swing.JComboBox<>();
        combo_course = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbl_studentDetails = new rojeru_san.complementos.RSTableMetro();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(153, 153, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel1.setText("Back");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 5, -1, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 60));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jLabel2.setText("Enter student Id");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 190, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(51, 0, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons/icons8_Forgot_Password_50px_4.png"))); // NOI18N
        jLabel9.setText("Select Branch");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 190, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 0, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Collaborator_Male_26px.png"))); // NOI18N
        jLabel8.setText("Select course");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, 190, -1));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 153));
        rSMaterialButtonCircle3.setText("Add");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 560, 130, 70));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(51, 0, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/adminIcons/adminIcons/icons8_Books_26px.png"))); // NOI18N
        jLabel7.setText("Student Name");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 210, -1));

        rSMaterialButtonCircle2.setText("delete");
        rSMaterialButtonCircle2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle2MouseClicked(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 560, 130, 70));

        txt_studentId.setBackground(new java.awt.Color(204, 204, 255));
        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_studentId.setPlaceholder("Enter Book Id");
        txt_studentId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentIdFocusLost(evt);
            }
        });
        txt_studentId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentIdActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, -1, -1));

        txt_studentName.setBackground(new java.awt.Color(204, 204, 255));
        txt_studentName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_studentName.setPlaceholder("Enter Book name");
        txt_studentName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentNameActionPerformed(evt);
            }
        });
        jPanel1.add(txt_studentName, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 200, -1, -1));

        rSMaterialButtonCircle4.setText("update");
        rSMaterialButtonCircle4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rSMaterialButtonCircle4MouseClicked(evt);
            }
        });
        jPanel1.add(rSMaterialButtonCircle4, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 560, 130, 70));

        combo_branch.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "CS", "PLAN", "ELECTRONICS", " " }));
        jPanel1.add(combo_branch, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 400, 210, -1));

        combo_course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "BSC", "MSC", "PHD", " " }));
        jPanel1.add(combo_course, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 300, 210, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 760));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 0, 0));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("     X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 40));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 0, 110, 60));

        tbl_studentDetails.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Name", "Course", "Branch"
            }
        ));
        tbl_studentDetails.setColorFilasBackgound2(new java.awt.Color(255, 255, 255));
        tbl_studentDetails.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tbl_studentDetails.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_studentDetailsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbl_studentDetails);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 730, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 0, 1060, 760));

        setSize(new java.awt.Dimension(1724, 758));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        //back to home page
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel1MouseClicked

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
  
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void txt_studentNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentNameActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
     //added
     if (addStudent()== true){
         JOptionPane.showMessageDialog(this,"Book added");
         clearTable();
         setStudentDetailsToTable();
     }else{
         JOptionPane.showMessageDialog(this, "Book addition failed");
     }
     
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    
   
    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void tbl_studentDetailsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_studentDetailsMouseClicked
        // select books
        int rowNo = tbl_studentDetails.getSelectedRow();
        TableModel model = tbl_studentDetails.getModel();
        
        txt_studentId.setText(model.getValueAt(rowNo, 0).toString());
        txt_studentName.setText(model.getValueAt(rowNo,1).toString());
        combo_course.setSelectedItem(model.getValueAt(rowNo,2).toString());
        combo_branch.setSelectedItem(model.getValueAt(rowNo,3).toString());
         
        
    }//GEN-LAST:event_tbl_studentDetailsMouseClicked

    private void rSMaterialButtonCircle4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle4MouseClicked
        // update
       if (updateStudent()== true){
         JOptionPane.showMessageDialog(this,"Student updated");
         clearTable();
         setStudentDetailsToTable();
     }else{
         JOptionPane.showMessageDialog(this, "Student updation failed");
     }
    }//GEN-LAST:event_rSMaterialButtonCircle4MouseClicked

    private void rSMaterialButtonCircle2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2MouseClicked
        // TODO add your handling code here:
    if (deleteStudent()== true){
         JOptionPane.showMessageDialog(this,"Student record deleted");
         clearTable();
         setStudentDetailsToTable();
     }else{
         JOptionPane.showMessageDialog(this, "student recors deletion failed");
     }
    }//GEN-LAST:event_rSMaterialButtonCircle2MouseClicked

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
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManageStudents.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManageStudents().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_branch;
    private javax.swing.JComboBox<String> combo_course;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle4;
    private rojeru_san.complementos.RSTableMetro tbl_studentDetails;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentName;
    // End of variables declaration//GEN-END:variables
}

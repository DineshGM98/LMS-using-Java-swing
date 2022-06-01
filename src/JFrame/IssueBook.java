/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrame;

import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import javax.swing.JOptionPane;


public class IssueBook extends javax.swing.JFrame {

    /**
     * Creates new form IssueBook
     */
    public IssueBook() {
        initComponents();
    }

    
    //to fetch the book details from the database and display it to book details panel
    public void getBookDetails(){
        int bookId = Integer.parseInt(txt_bookId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from book_details where book_id = ?");
            pst.setInt(1, bookId);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                lbl_bookId1.setText(rs.getString("book_id"));
                lbl_bookName1.setText(rs.getString("book_name"));
                lbl_author1.setText(rs.getString("authar"));
                lbl_quantity1.setText(rs.getString("quantity"));
            }else{
                lbl_bookDetailsError1.setText("invalid book id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    
            //to fetch the student details from the database and display it to book details panel
    public void getStudentDetails(){
        int StudentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from student_details where student_id = ?");
            pst.setInt(1, StudentId);
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){
                lbl_studentId2.setText(rs.getString("student_id"));
                lbl_studentName2.setText(rs.getString("name"));
                lbl_course2.setText(rs.getString("course"));
                lbl_branch2.setText(rs.getString("branch"));
            }else{
                lbl_StudentDetailsError.setText("invalid student id");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    //insert issue book details to database
public boolean issueBook(){
	boolean isIssued = false;
	int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        String bookName = lbl_bookName1.getText();
	String studentName = lbl_studentName1.getText();
    
        Date uIssueDate = date_issueDate.getDatoFecha();
        Date uDueDate = date_dueDate.getDatoFecha();
        
        Long l1 = uIssueDate.getTime();
        long l2 = uDueDate.getTime();
        
        java.sql.Date sIssueDate = new java.sql.Date(l1);
         java.sql.Date sDueDate = new java.sql.Date(l2);
        
	
	try{
		Connection con = DBConnection.getConnection();
		String sql = "insert into issue_book_details(book_id,book_name,student_id,student_name,issue_date,due_date,status) values(?,?,?,?,?,?,?)";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1,bookId);
		pst.setString(2,bookName);
		pst.setInt(3,studentId);
		pst.setString(4,studentName);
		pst.setDate(5,sIssueDate);
		pst.setDate(6,sDueDate);
		pst.setString(7,"pending");
		
		int rowCount = pst.executeUpdate();
		if(rowCount > 0){
			isIssued = true;
		}else{
			isIssued = false;
		}
	}catch (Exception e){
		e.printStackTrace();
	}
	return isIssued;
}
    
//updating book count
public void updateBookCOunt(){
    int bookid = Integer.parseInt(txt_bookId.getText());
    try {
        Connection con = DBConnection.getConnection();
        String sql = "update book_details set quantity = quantity -1 where book_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, bookid);
        
        ResultSet rs = pst.executeQuery();
        
        if (rs.next()){
            JOptionPane.showMessageDialog(this, "book count updated");
            int initialCount = Integer.parseInt(lbl_quantity1.getText());
            lbl_quantity1.setText(Integer.toString(initialCount -1));
        }else{
            JOptionPane.showMessageDialog(this,"can't update book count");
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    
}

    //checking whether book already allocated or not
    public boolean isAlreadyIssued(){
        boolean isAlreadyIssued = false;
        int bookId = Integer.parseInt(txt_bookId.getText());
        int studentId = Integer.parseInt(txt_studentId.getText());
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "select * from issue_book_details where book_id = ? and student_id =? and status = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, bookId);
            pst.setInt(2, studentId);
            pst.setString(3, "pending");
            
            int rowCount = pst.executeUpdate();
            
            if(rowCount > 0){
                isAlreadyIssued = true;
            }else{
                isAlreadyIssued = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       return isAlreadyIssued;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel_main = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbl_branch2 = new javax.swing.JLabel();
        lbl_studentId2 = new javax.swing.JLabel();
        lbl_studentName2 = new javax.swing.JLabel();
        lbl_course2 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        lbl_StudentDetailsError = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        txt_bookId = new app.bolivia.swing.JCTextField();
        txt_studentId = new app.bolivia.swing.JCTextField();
        jLabel9 = new javax.swing.JLabel();
        panel_main1 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        lbl_quantity1 = new javax.swing.JLabel();
        lbl_bookId1 = new javax.swing.JLabel();
        lbl_bookName1 = new javax.swing.JLabel();
        lbl_author1 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        lbl_bookDetailsError1 = new javax.swing.JLabel();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lbl_branch1 = new javax.swing.JLabel();
        lbl_studentId1 = new javax.swing.JLabel();
        lbl_studentName1 = new javax.swing.JLabel();
        lbl_course1 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        txt_studentId2 = new app.bolivia.swing.JCTextField();
        jLabel29 = new javax.swing.JLabel();
        txt_studentId3 = new app.bolivia.swing.JCTextField();
        date_issueDate = new rojeru_san.componentes.RSDateChooser();
        jLabel30 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        date_dueDate = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panel_main.setBackground(new java.awt.Color(255, 255, 255));
        panel_main.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(204, 0, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 390, 10));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Branch:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, 120, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Student Id:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 120, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Student name:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 150, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Course:");
        jPanel4.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 120, -1));
        jPanel4.add(lbl_branch2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 600, 210, 40));
        jPanel4.add(lbl_studentId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 210, 40));
        jPanel4.add(lbl_studentName2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 210, 40));
        jPanel4.add(lbl_course2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, 210, 40));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel17.setText("Student Details");
        jPanel4.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 270, 110));

        lbl_StudentDetailsError.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_StudentDetailsError.setForeground(new java.awt.Color(255, 255, 255));
        jPanel4.add(lbl_StudentDetailsError, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 700, 290, 50));

        panel_main.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 470, 800));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 0, 0));
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel12.setText("Issue Book");
        panel_main.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 80, 270, 80));

        jPanel7.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        panel_main.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 160, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 0, 51));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jLabel7.setText("Book Id: ");
        panel_main.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 240, 130, -1));

        txt_bookId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
        txt_bookId.setPlaceholder("Enter Book Id");
        txt_bookId.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_bookIdFocusLost(evt);
            }
        });
        txt_bookId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_bookIdActionPerformed(evt);
            }
        });
        panel_main.add(txt_bookId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 230, -1, -1));

        txt_studentId.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
        txt_studentId.setPlaceholder("Enter Student Id");
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
        panel_main.add(txt_studentId, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 300, -1, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 0, 51));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jLabel9.setText("Student Id:");
        panel_main.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 310, 170, -1));

        panel_main1.setBackground(new java.awt.Color(255, 255, 255));
        panel_main1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setBackground(new java.awt.Color(204, 0, 51));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(255, 0, 0));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel10.setText("Back");
        jLabel10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel10MouseClicked(evt);
            }
        });
        jPanel8.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 5, -1, -1));

        jPanel5.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 60));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Literature_100px_1.png"))); // NOI18N
        jLabel11.setText("Book Details");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 270, 110));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel5.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 390, 10));

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Book Id:");
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 120, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Book name:");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 120, -1));

        jLabel21.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Author:");
        jPanel5.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 510, 120, -1));
        jPanel5.add(lbl_quantity1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 600, 210, 40));
        jPanel5.add(lbl_bookId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 210, 40));
        jPanel5.add(lbl_bookName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 210, 40));
        jPanel5.add(lbl_author1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, 210, 40));

        jLabel31.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(255, 255, 255));
        jLabel31.setText("Quantity:");
        jPanel5.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 120, -1));

        lbl_bookDetailsError1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbl_bookDetailsError1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel5.add(lbl_bookDetailsError1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 710, 260, 50));

        panel_main1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 470, 800));

        jPanel10.setBackground(new java.awt.Color(204, 0, 51));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel10.add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 390, 10));

        jLabel22.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Branch:");
        jPanel10.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 610, 120, -1));

        jLabel23.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Student Id:");
        jPanel10.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 120, -1));

        jLabel24.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Student name:");
        jPanel10.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 150, -1));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Course:");
        jPanel10.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 120, -1));
        jPanel10.add(lbl_branch1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 600, 210, 40));
        jPanel10.add(lbl_studentId1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 210, 40));
        jPanel10.add(lbl_studentName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 210, 40));
        jPanel10.add(lbl_course1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 510, 210, 40));

        jLabel26.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Student_Registration_100px_2.png"))); // NOI18N
        jLabel26.setText("Student Details");
        jPanel10.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 270, 110));

        panel_main1.add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 0, 470, 800));

        jLabel27.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 0, 0));
        jLabel27.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Books_52px_1.png"))); // NOI18N
        jLabel27.setText("Issue Book");
        panel_main1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 80, 270, 80));

        jPanel12.setBackground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        panel_main1.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 160, -1, -1));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 0, 51));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jLabel28.setText("Book Id: ");
        panel_main1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 240, 130, -1));

        txt_studentId2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
        txt_studentId2.setPlaceholder("Enter Book Id");
        txt_studentId2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentId2FocusLost(evt);
            }
        });
        txt_studentId2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentId2ActionPerformed(evt);
            }
        });
        panel_main1.add(txt_studentId2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 230, -1, -1));

        jLabel29.setBackground(new java.awt.Color(255, 255, 255));
        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 0, 51));
        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jLabel29.setText("Issue Date:");
        panel_main1.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 410, 140, -1));

        txt_studentId3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 0, 0)));
        txt_studentId3.setPlaceholder("Enter Student Id");
        txt_studentId3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_studentId3FocusLost(evt);
            }
        });
        txt_studentId3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_studentId3ActionPerformed(evt);
            }
        });
        panel_main1.add(txt_studentId3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1150, 300, -1, -1));

        date_issueDate.setColorBackground(new java.awt.Color(255, 51, 0));
        date_issueDate.setColorForeground(new java.awt.Color(255, 0, 51));
        date_issueDate.setPlaceholder("Select issues date");
        panel_main1.add(date_issueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 400, -1, -1));

        jLabel30.setBackground(new java.awt.Color(255, 255, 255));
        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 0, 51));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jLabel30.setText("Student Id:");
        panel_main1.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 310, 170, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 0, 51));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/AddNewBookIcons/AddNewBookIcons/icons8_Contact_26px.png"))); // NOI18N
        jLabel8.setText("Due Date");
        panel_main1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 520, 140, -1));

        date_dueDate.setColorBackground(new java.awt.Color(255, 51, 0));
        date_dueDate.setColorForeground(new java.awt.Color(255, 0, 51));
        date_dueDate.setPlaceholder("Select Due Date");
        panel_main1.add(date_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 510, -1, -1));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 0, 51));
        rSMaterialButtonCircle3.setText("issue book");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        panel_main1.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1020, 620, 370, 70));

        panel_main.add(panel_main1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 800));

        getContentPane().add(panel_main, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1410, 800));

        setSize(new java.awt.Dimension(1429, 847));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_bookIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_bookIdFocusLost
        if (!txt_bookId.getText().equals("")){
            getBookDetails();
        }
        
        
    }//GEN-LAST:event_txt_bookIdFocusLost

    private void txt_bookIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_bookIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_bookIdActionPerformed

    private void txt_studentIdFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentIdFocusLost
        if (!txt_studentId.getText().equals("")){
            getStudentDetails();
        }
    }//GEN-LAST:event_txt_studentIdFocusLost

    private void txt_studentIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentIdActionPerformed

    private void jLabel10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel10MouseClicked
        // TODO add your handling code here:
        HomePage home = new HomePage();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel10MouseClicked

    private void txt_studentId2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentId2FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentId2FocusLost

    private void txt_studentId2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentId2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentId2ActionPerformed

    private void txt_studentId3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_studentId3FocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentId3FocusLost

    private void txt_studentId3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_studentId3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_studentId3ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if(lbl_quantity1.getText().equals("0")){
            JOptionPane.showMessageDialog(this,"book is not avalable");
        }else{      
            if (isAlreadyIssued() == false){
                if(issueBook() ==  true){
                    JOptionPane.showMessageDialog(this, "book issued successfully");                    
                    updateBookCOunt();
                }else{
                    JOptionPane.showMessageDialog(this, "can't issue the book");
                }
            }else{
                JOptionPane.showMessageDialog(this,"this student already have book");
            }
        }
        
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

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
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueBook.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IssueBook().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojeru_san.componentes.RSDateChooser date_dueDate;
    private rojeru_san.componentes.RSDateChooser date_issueDate;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JLabel lbl_StudentDetailsError;
    private javax.swing.JLabel lbl_author1;
    private javax.swing.JLabel lbl_bookDetailsError1;
    private javax.swing.JLabel lbl_bookId1;
    private javax.swing.JLabel lbl_bookName1;
    private javax.swing.JLabel lbl_branch1;
    private javax.swing.JLabel lbl_branch2;
    private javax.swing.JLabel lbl_course1;
    private javax.swing.JLabel lbl_course2;
    private javax.swing.JLabel lbl_quantity1;
    private javax.swing.JLabel lbl_studentId1;
    private javax.swing.JLabel lbl_studentId2;
    private javax.swing.JLabel lbl_studentName1;
    private javax.swing.JLabel lbl_studentName2;
    private javax.swing.JPanel panel_main;
    private javax.swing.JPanel panel_main1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private app.bolivia.swing.JCTextField txt_bookId;
    private app.bolivia.swing.JCTextField txt_studentId;
    private app.bolivia.swing.JCTextField txt_studentId2;
    private app.bolivia.swing.JCTextField txt_studentId3;
    // End of variables declaration//GEN-END:variables
}

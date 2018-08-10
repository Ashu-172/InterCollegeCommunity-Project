package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ashutosh
 */
import Classes.DB_Connection;
import Classes.Encrypt;
import Classes.MailSender;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Sendmail extends HttpServlet {

    public String alertmsg;
    public String uid=null;
    public void EnterData(HttpServletRequest request, HttpServletResponse response) throws IOException, SQLException {
        final String FirstName = request.getParameter("Fname");
        final String LastName = request.getParameter("Lname");
        final String Gender = request.getParameter("Gender");
        final String CollegeName = request.getParameter("college");
        final String CourseName = request.getParameter("course");
        final String Email = request.getParameter("email");
        final String Pass = request.getParameter("password");
        final String PPurl=request.getParameter("PPurl");
        final String Password;
        PrintWriter out=response.getWriter();
        Password = Encrypt.crypt(Pass);
        out.println("pass : "+Password);
        String Collegeid=null;
        String Courseid=null;
        out.println("college "+CollegeName);
        out.println("course "+CourseName);
        DB_Connection dbc = new DB_Connection();
        Connection conn = dbc.getConnection();
        if (CollegeName.equals("Select College")) {
            alertmsg = "Please Select College";
            boolean flag = true;
            request.setAttribute("flag", flag);
            request.setAttribute("message", alertmsg);
            try {
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(Sendmail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (CollegeName.equals("Select Courses")) {
            alertmsg = "Please Select Course..";
            boolean flag = true;
            request.setAttribute("flag", flag);
            request.setAttribute("message", alertmsg);
            try {
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(Sendmail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        PreparedStatement stmt=conn.prepareStatement("SELECT COUNT(1) FROM user_registration WHERE email = '"+Email+"'");
        ResultSet Check=stmt.executeQuery();
        int ExistingCount=0;
        while(Check.next()){
            ExistingCount=Check.getInt(1);
        }   
        out.println("Existance "+ExistingCount);
        if(ExistingCount==0){
        PreparedStatement clgname = conn.prepareStatement("select College_id from colleges where College_Name = '" + CollegeName+"'");
        ResultSet RScollegeid = clgname.executeQuery();
        PreparedStatement coursename = conn.prepareStatement("select Course_id from courses where Course_Name = '" + CourseName+"'");
        ResultSet RScourseid = coursename.executeQuery();
        while(RScollegeid.next()){
        Collegeid = RScollegeid.getString(1);}
        while(RScourseid.next()){
        Courseid = RScourseid.getString(1);}
            LocalDate localDate = LocalDate.now();
        String date=DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
            out.println(date);
        out.println("college id= "+Integer.parseInt(Collegeid)+" , Course id = "+Integer.parseInt(Courseid)+" , Profile Picture : "+PPurl);
        PreparedStatement Insertdata = conn.prepareStatement("insert into user_registration(First_Name,Last_Name,Gender,College_id,Course_Id,Email,Password,isEmail_Varified,isAdmin,Profile_Picture,Reg_Date) values ('" + FirstName + "','" + LastName + "','" + Gender + "'," + Collegeid + "," + Courseid + ",'" + Email + "','" + Password + "',"+0+","+0+",'"+PPurl+"','"+ date +"')");
        int i = Insertdata.executeUpdate();
        out.println(i + "Data Inserted");
        PreparedStatement Idstmt=conn.prepareStatement("SELECT Reg_id FROM user_registration WHERE email = '"+Email+"'");
        ResultSet uidset=stmt.executeQuery();
        String uid=null;
        while(uidset.next())
            uid=uidset.getString(1);
        }else{
            alertmsg = "Email Already Registered...Please Signin";
            boolean flag = true;
            request.setAttribute("flag", flag);
            request.setAttribute("message", alertmsg);
            try {
                request.getRequestDispatcher("Register.jsp").forward(request, response);
            } catch (ServletException ex) {
                Logger.getLogger(Sendmail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            EnterData(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Sendmail.class.getName()).log(Level.SEVERE, null, ex);
        }
        String Subject="Confirmation";
        boolean verification=true;
        String message="confirmation successed   http://localhost:8080/InterCollegeCommunity/Login.jsp?isVarified="+verification+"&no="+uid;
        String mailid= request.getParameter("email");
        MailSender mailsender=new MailSender();
        mailsender.sendEmail(mailid,Subject,message);
        boolean flag = true;
            alertmsg = "An Email Verification Link Has Been Sent To Your Email Address.Please Check..!";
            request.setAttribute("flag", flag);
            request.setAttribute("message", alertmsg);
            request.getRequestDispatcher("Register.jsp").forward(request, response);

    }
}

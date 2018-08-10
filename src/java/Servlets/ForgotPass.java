/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.DB_Connection;
import Classes.Encrypt;
import Classes.MailSender;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForgotPass extends HttpServlet {

    public String getid(String email) throws SQLException {
        String userid = null;
        DB_Connection dbc = new DB_Connection();
        Connection conn = dbc.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select Reg_id from user_registration where Email = '" + email + "'");
        ResultSet reg_id = stmt.executeQuery();
        while (reg_id.next()) {
            userid = reg_id.getString(1);
        }
        return userid;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean flag = true;
        String Alertmsg;
        request.setAttribute("flag", flag);
        String Subject = "forget password";
        String uid = null;
        String mailid = request.getParameter("Email");
        try {
            uid = getid(mailid);
            } catch (SQLException ex) {
            Logger.getLogger(ForgotPass.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (uid != null) {
            String Encrypted_uid=Encrypt.crypt(uid);
            String message = "click on link below /r/n  http://localhost:8080/InterCollegeCommunity/ResetPassword.jsp?id=" + Encrypted_uid+"&di="+uid;
            MailSender mailsender = new MailSender();
            mailsender.sendEmail(mailid, Subject, message);
            Alertmsg = "An Email has been sent to your Email Address please Check..";
            request.setAttribute("alert", Alertmsg);
        } else {
            Alertmsg = "Please Enter Your Registered Email Address..!";
            request.setAttribute("alert", Alertmsg);
        }
        request.getRequestDispatcher("ForgotPassword_Form.jsp").forward(request, response);
    }

}

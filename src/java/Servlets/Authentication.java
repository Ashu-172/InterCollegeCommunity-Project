package Servlets;

import Classes.DB_Connection;
import Classes.Encrypt;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Authentication extends HttpServlet {

    public ResultSet Authenticate(Connection conn, String mail) throws SQLException {
        String DBpassword = null;
        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user_registration WHERE Email = '" + mail + "'");
        ResultSet RSdata = stmt.executeQuery();
        return RSdata;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DB_Connection dbc = new DB_Connection();
        Connection conn = dbc.getConnection();
        PrintWriter out = response.getWriter();
        String Email = request.getParameter("Email");
        System.out.println("email " + Email);
        String Password = request.getParameter("Password");
        Boolean flag = true;
        String loginPassword = Encrypt.crypt(Password);
        String DBPassword = null;
        String mail_id = null;
        int uid = 0;
        String FName = null;
        String PPURL = null;
        ResultSet DBdata = null;
        try {
            DBdata = Authenticate(conn, Email);
            if (DBdata == null) {
                request.setAttribute("flag", flag);
                request.setAttribute("alert", "Your Email Address is not Registered..");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
            System.out.println("DBPassword: " + DBdata);
        } catch (SQLException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (DBdata.next()) {
                uid = DBdata.getInt("Reg_id");
                FName = DBdata.getString("First_Name");
                DBPassword = DBdata.getString("Password");
                PPURL = DBdata.getString("Profile_Picture");
                out.println(PPURL);
                mail_id = DBdata.getString("Email");
            }
            out.println("id : " + uid + "Fname : " + FName + " DBpassword : " + DBPassword + "Login Password : "+loginPassword+"Profile picture : " + PPURL + "Email : " + mail_id);
        } catch (SQLException ex) {
            Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (loginPassword.equals(DBPassword)) {
            HttpSession Session = request.getSession(true);
            Session.setAttribute("User_id", uid);
            Session.setAttribute("Fname", FName);
            Session.setAttribute("Profile_Picture", PPURL);
            Session.setAttribute("mail_id", mail_id);
            Cookie cookie = new Cookie("JSESSIONID", Session.getId());
            cookie.setMaxAge(Integer.MAX_VALUE);
            response.addCookie(cookie);
            request.getRequestDispatcher("RedirectServlet").forward(request, response);
        } else {
            request.setAttribute("flag", flag);
            request.setAttribute("alert", "Incorrect Password..");
            out.println("login password " + loginPassword);
            out.println("DB password " + DBPassword);

            request.getRequestDispatcher("Login.jsp").forward(request, response);
        }
    }

}

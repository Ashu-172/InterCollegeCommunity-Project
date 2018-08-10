package Servlets;

import Classes.DB_Connection;
import Classes.Encrypt;
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

/**
 *
 * @author Ashutosh
 */
public class Password_Update extends HttpServlet {
    private void Update(String uid,String password) throws SQLException{
        DB_Connection dbc = new DB_Connection();
            Connection conn = dbc.getConnection();
            PreparedStatement stmt = conn.prepareStatement("UPDATE user_registration SET Password = '"+password+"' WHERE Reg_id = '"+uid+"'");
            int i=stmt.executeUpdate();
        
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userid=request.getParameter("userid");
        String pass=request.getParameter("password");
        String MD5pass=Encrypt.crypt(pass);
        try {
            Update(userid,MD5pass);
        } catch (SQLException ex) {
            Logger.getLogger(Password_Update.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    
    }
}

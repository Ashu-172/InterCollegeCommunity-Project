package Classes;


import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ashutosh
 */

public class DB_Connection {
   /* public void doGet(HttpServletRequest request,HttpServletResponse response){
        Connection conn=getConnection();
        String Fname=request.getParameter("Fname");
        String Lname=request.getParameter("Lname");
        String College=request.getParameter("college");
        String Course=request.getParameter("course");
        String Email=request.getParameter("email");
        String Password=request.getParameter("password");
    }*/
     public  Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con= (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/intercollege-communitydb","root","1234567890");
        
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DB_Connection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}

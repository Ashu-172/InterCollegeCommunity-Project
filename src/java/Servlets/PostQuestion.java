/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Classes.DB_Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PostQuestion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        PrintWriter out=response.getWriter();
        DB_Connection dbc = new DB_Connection();
        Connection conn = dbc.getConnection();
        HttpSession session = request.getSession(false);
        String Userid = session.getAttribute("User_id").toString();
        String Question=request.getParameter("question");
        LocalDate localDate = LocalDate.now();
        String date=DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
        out.println("Reg_id : "+Userid+", Question : "+Question+", Date : "+date);
        PreparedStatement postQuestion=conn.prepareStatement("insert into questions (Reg_id,Question_Text,Create_Date,LikeCounts) values('"+Userid+"','"+Question+"','"+date+"',0)");                       
        int i=postQuestion.executeUpdate();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PostQuestion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

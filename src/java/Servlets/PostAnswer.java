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
public class PostAnswer extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        PrintWriter out=response.getWriter();
        DB_Connection dbc = new DB_Connection();
        Connection conn = dbc.getConnection();
        HttpSession session = request.getSession(false);
        String Userid = session.getAttribute("User_id").toString();
        String Answer=request.getParameter("answer");
        int Qid=Integer.parseInt(request.getParameter("Qid"));
        out.println("Qid : "+Qid);
        LocalDate localDate = LocalDate.now();
        String date=DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate);
        out.println("Reg_id : "+Userid+", Answer : "+Answer+", Date : "+date);
        PreparedStatement postAnswer=conn.prepareStatement("insert into answers (Que_id,Reg_id,Answer_text,Create_date) values("+Qid+",'"+Userid+"','"+Answer+"','"+date+"')");                       
        int i=postAnswer.executeUpdate();
        PreparedStatement Acountstmt=conn.prepareStatement("update questions set AnswerCounts = AnswerCounts+1 where Q_id="+Qid);
            int j=Acountstmt.executeUpdate();
    }
   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(PostAnswer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

package Servlets;

import Classes.DB_Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LikeBookmark_dataEntry extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException {
        PrintWriter out=response.getWriter();
        String task = request.getParameter("val3");
        int Q_id = Integer.parseInt(request.getParameter("val1"));
        int U_id = Integer.parseInt(request.getParameter("val2"));
        DB_Connection dbc = new DB_Connection();
        Connection conn = dbc.getConnection();
        if (task.equals("Like")) {
            PreparedStatement Likestmt = conn.prepareStatement("insert into likes  values (0,"+Q_id+","+U_id+")");
            int i = Likestmt.executeUpdate();
            out.write("Liked");
            PreparedStatement Lcountstmt=conn.prepareStatement("update questions set LikeCounts = LikeCounts+1 where Q_id="+Q_id);
            int j=Lcountstmt.executeUpdate();
        } else if (task.equals("Bookmark")) {
            PreparedStatement BMstmt = conn.prepareStatement("insert into bookmarks values (0,"+U_id+","+Q_id+")");
            int i = BMstmt.executeUpdate();
            out.write("1234");
        }
      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LikeBookmark_dataEntry.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
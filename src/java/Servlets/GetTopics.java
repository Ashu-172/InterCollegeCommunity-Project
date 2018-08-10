package Servlets;

import Classes.DB_Connection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetTopics extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        int totalTopics;
        String search = request.getParameter("search");
        response.setContentType("text/html");
        if (!((search.trim()).equals(""))) {
            String searchstring = getSearchResult(search);
            response.getWriter().write(searchstring);
        } else {
            response.getWriter().write("");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(GetTopics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(GetTopics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private String getSearchResult(String search) throws SQLException {
        String finalSearch = "";
        DB_Connection dbc = new DB_Connection();
        Connection conn = dbc.getConnection();
        PreparedStatement stmt = conn.prepareStatement("select Topic_text from topics where Topic_text like '"+search+"%' order by Topic_text");
        ResultSet alltopics = stmt.executeQuery();
        while (alltopics.next()) {
            String un = alltopics.getString(1);
            finalSearch += un + "\n";
        }
        return finalSearch;
    }
}

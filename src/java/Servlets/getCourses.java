package Servlets;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Classes.DB_Connection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class getCourses extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String id = null;
        try (PrintWriter out = response.getWriter()) {
            String valajax = request.getParameter("valajax");
            DB_Connection dbc = new DB_Connection();
            Connection conn = dbc.getConnection();
            ArrayList<String> Courses = new ArrayList<String>();
            PreparedStatement colg = conn.prepareStatement("select College_id from colleges where College_Name = '" + valajax + "'");
            //System.out.println("Check 1"+colg);
            ResultSet collegeid = colg.executeQuery();
            while (collegeid.next()) {
                id = collegeid.getString(1);
            }
            PreparedStatement cours = conn.prepareStatement("select Course_id from college_course where College_id = " + id);
            //System.out.println("Check 2"+cours);
            ResultSet courseid = cours.executeQuery();
            while (courseid.next()) {
                int crsid = Integer.parseInt(courseid.getString(1));
                //System.out.println("Check 3 "+crsid);
                PreparedStatement Course_Names = conn.prepareStatement("select Course_name from courses where Course_id = " + crsid);
                ResultSet Corsname = Course_Names.executeQuery();
                if (Corsname.next()) {
                    String str = Corsname.getString(1);
                    //System.out.println("course name : "+str);
                    Courses.add(str);
                }
                System.out.println("Courses : " + Corsname.getString(1));
            }
            out.write("<select class=\"form-control select2\" id=\"select_course\" name=\"course\"  style=\"width: 100%; border-radius: 0px; \" >");
            out.write("<option>Select Course</option>");
            for (String Course : Courses) {
                out.write("<option>" + Course + "</option>");
            }
            out.write("</select>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(getCourses.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

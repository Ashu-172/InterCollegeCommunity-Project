package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import Classes.DB_Connection;

public final class UserProfile_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <title>AdminLTE 2 | User Profile</title>\n");
      out.write("        <!-- Tell the browser to be responsive to screen width -->\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n");
      out.write("        <!-- Bootstrap 3.3.7 -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"Admin/bower_components/bootstrap/dist/css/bootstrap.min.css\">\n");
      out.write("        <!-- Font Awesome -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"Admin/bower_components/font-awesome/css/font-awesome.min.css\">\n");
      out.write("        <!-- Ionicons -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"Admin/bower_components/Ionicons/css/ionicons.min.css\">\n");
      out.write("        <!-- Theme style -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"Admin/dist/css/AdminLTE.min.css\">\n");
      out.write("        <!-- AdminLTE Skins. Choose a skin from the css/skins\n");
      out.write("             folder instead of downloading all of them to reduce the load. -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"Admin/dist/css/skins/_all-skins.min.css\">\n");
      out.write("\n");
      out.write("        <!-- Google Font -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic\">\n");
      out.write("    </head>\n");
      out.write("    <body class=\"hold-transition skin-blue layout-top-nav\">\n");
      out.write("        ");
  String Userid = null, Fname = null, Profile_Picture = null, Mail_id = null;
            try {
                Userid = session.getAttribute("User_id").toString();
                Fname = session.getAttribute("Fname").toString();
                Profile_Picture = session.getAttribute("Profile_Picture").toString();
                Mail_id = session.getAttribute("mail_id").toString();
            } catch (Exception e) {
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
            String Lname=null,CollegeName=null,CourseName=null,Email=null,Reg_Date=null;
            int colgid=0,courseid=0;
            DB_Connection dbc = new DB_Connection();
            Connection conn = dbc.getConnection();
            PreparedStatement UserProfileStmt = conn.prepareStatement("select * from user_registration where Reg_id="+Userid);
            ResultSet userProfileRS = UserProfileStmt.executeQuery();
            while(userProfileRS.next()){
                Lname=userProfileRS.getString("Last_Name");
                colgid=userProfileRS.getInt("College_id");
                courseid=userProfileRS.getInt("Course_Id");
                Email=userProfileRS.getString("Email");
                Reg_Date=userProfileRS.getDate("Reg_Date").toString();
            }
        PreparedStatement UserColgStmt = conn.prepareStatement("select College_Name from colleges where College_id="+colgid);
            ResultSet userColgRS = UserColgStmt.executeQuery();
            while(userColgRS.next()){
                CollegeName=userColgRS.getString("College_Name");
            }
            PreparedStatement UserCourseStmt = conn.prepareStatement("select Course_name from courses where Course_id="+courseid);
            ResultSet userCourseRS = UserCourseStmt.executeQuery();
            while(userCourseRS.next()){
                CourseName=userCourseRS.getString("Course_name");
            }
        
      out.write("\n");
      out.write("        <div class=\"wrapper\">\n");
      out.write("\n");
      out.write("            <header class=\"main-header\">\n");
      out.write("                <nav class=\"navbar navbar-static-top\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"navbar-header\">\n");
      out.write("                            <a href=\"../../index2.html\" class=\"navbar-brand\"><b>InterCollege</b>Community</a>\n");
      out.write("                            <button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#navbar-collapse\">\n");
      out.write("                                <i class=\"fa fa-bars\"></i>\n");
      out.write("                            </button>\n");
      out.write("                        </div>\n");
      out.write("\n");
      out.write("                        <!-- Collect the nav links, forms, and other content for toggling -->\n");
      out.write("                        <div class=\"collapse navbar-collapse pull-left\" id=\"navbar-collapse\">\n");
      out.write("                            <ul class=\"nav navbar-nav\">\n");
      out.write("                                <li><a href=\"index.jsp\">Home</a></li>\n");
      out.write("                                <li class=\"active\"><a href=\"AskQuestion.jsp\">Ask Question <span class=\"sr-only\">(current)</span></a></li>\n");
      out.write("                                <li><a href=\"TopStories.jsp\">Top Stories</a></li>\n");
      out.write("                                <li><a href=\"QuestionsforAnswer.jsp\">Answer</a></li>\n");
      out.write("                                <li><a href=\"Bookmarks.jsp\">Bookmarks</a></li>\n");
      out.write("                            </ul>\n");
      out.write("                            <form class=\"navbar-form navbar-left\" role=\"search\">\n");
      out.write("                                <div class=\"form-group\">\n");
      out.write("                                    <input type=\"text\" class=\"form-control\" id=\"navbar-search-input\" placeholder=\"Search\">\n");
      out.write("                                </div>\n");
      out.write("                            </form>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.navbar-collapse -->\n");
      out.write("                        <!-- Navbar Right Menu -->\n");
      out.write("                        <div class=\"navbar-custom-menu\">\n");
      out.write("                            <ul class=\"nav navbar-nav\">                                                              \n");
      out.write("                                <!-- User Account Menu -->\n");
      out.write("                                <li class=\"dropdown user user-menu\">\n");
      out.write("                                    <!-- Menu Toggle Button -->\n");
      out.write("                                    <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">\n");
      out.write("                                        <!-- The user image in the navbar-->\n");
      out.write("                                        <img src=\"");
      out.print(Profile_Picture);
      out.write("\" class=\"user-image\" alt=\"User Image\">\n");
      out.write("                                        <!-- hidden-xs hides the username on small devices so only the image appears. -->\n");
      out.write("                                        <span class=\"hidden-xs\">");
      out.print(Fname);
      out.write("</span>\n");
      out.write("                                    </a>\n");
      out.write("                                    <ul class=\"dropdown-menu\">\n");
      out.write("                                        <!-- The user image in the menu -->\n");
      out.write("                                        <li class=\"user-header\">\n");
      out.write("                                            <img src=\"");
      out.print(Profile_Picture);
      out.write("\" class=\"img-circle\" alt=\"User Image\">\n");
      out.write("\n");
      out.write("                                            <p>\n");
      out.write("                                                ");
      out.print(Fname);
      out.write("\n");
      out.write("                                                <small>Member since Nov. 2012</small>\n");
      out.write("                                            </p>\n");
      out.write("                                        </li>\n");
      out.write("                                        <!-- Menu Body -->\n");
      out.write("                                        <li class=\"user-body\">\n");
      out.write("                                            <div class=\"row\">\n");
      out.write("                                                <div class=\"col-xs-6 text-center\">\n");
      out.write("                                                    <a href=\"#\">Questions</a>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"col-xs-6 text-center\" >\n");
      out.write("                                                    <a href=\"#\">Answers</a>\n");
      out.write("                                                </div>\n");
      out.write("                                            </div>\n");
      out.write("                                            <!-- /.row -->\n");
      out.write("                                        </li>\n");
      out.write("                                        <!-- Menu Footer-->\n");
      out.write("                                        <li class=\"user-footer\">\n");
      out.write("                                            <div class=\"pull-left\">\n");
      out.write("                                                <a href=\"#\" class=\"btn btn-default btn-flat\">Profile</a>\n");
      out.write("                                            </div>\n");
      out.write("                                            <div class=\"pull-right\">\n");
      out.write("                                                <a href=\"#\" class=\"btn btn-default btn-flat\">Sign out</a>\n");
      out.write("                                            </div>\n");
      out.write("                                        </li>\n");
      out.write("                                    </ul>\n");
      out.write("                                </li>\n");
      out.write("                            </ul>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.navbar-custom-menu -->\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.container-fluid -->\n");
      out.write("                </nav>\n");
      out.write("            </header>\n");
      out.write("            <!-- Full Width Column -->\n");
      out.write("            <div class=\"content-wrapper\">\n");
      out.write("                <div class=\"container\">\n");
      out.write("                    <!-- Content Header (Page header) -->\n");
      out.write("                    <section class=\"content-header\">\n");
      out.write("                        <h1>\n");
      out.write("                            Top Navigation\n");
      out.write("                            <small>Example 2.0</small>\n");
      out.write("                        </h1>\n");
      out.write("                        <ol class=\"breadcrumb\">\n");
      out.write("                            <li><a href=\"#\"><i class=\"fa fa-dashboard\"></i> Home</a></li>\n");
      out.write("                            <li><a href=\"#\">Layout</a></li>\n");
      out.write("                            <li class=\"active\">Top Navigation</li>\n");
      out.write("                        </ol>\n");
      out.write("                    </section>\n");
      out.write("\n");
      out.write("                    <!-- Main content -->\n");
      out.write("                    <section class=\"content\">\n");
      out.write("\n");
      out.write("                        <div class=\"row\">\n");
      out.write("                            <div class=\"col-md-3\">\n");
      out.write("\n");
      out.write("                                <!-- Profile Image -->\n");
      out.write("                                <div class=\"box box-primary\">\n");
      out.write("                                    <div class=\"box-body box-profile\">\n");
      out.write("                                        <img class=\"profile-user-img img-responsive img-circle\" src=\"");
      out.print(Profile_Picture);
      out.write("\" alt=\"User profile picture\">\n");
      out.write("\n");
      out.write("                                        <h3 class=\"profile-username text-center\">");
      out.print(Fname);
      out.write("</h3>\n");
      out.write("\n");
      out.write("                                        <p class=\"text-muted text-center\">Software Engineer</p>\n");
      out.write("\n");
      out.write("                                        <ul class=\"list-group list-group-unbordered\">\n");
      out.write("                                            <li class=\"list-group-item\">\n");
      out.write("                                                <b>Questions</b> <a class=\"pull-right\">1,322</a>\n");
      out.write("                                            </li>\n");
      out.write("                                            <li class=\"list-group-item\">\n");
      out.write("                                                <b>Answers</b> <a class=\"pull-right\">543</a>\n");
      out.write("                                            </li>\n");
      out.write("\n");
      out.write("                                        </ul>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- /.box-body -->\n");
      out.write("                                </div>\n");
      out.write("                                <!-- /.box -->\n");
      out.write("\n");
      out.write("\n");
      out.write("                                <!-- /.box -->\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.col -->\n");
      out.write("                            <div class=\"col-md-9\">\n");
      out.write("                                <!-- About Me Box -->\n");
      out.write("                                <div class=\"box box-primary\">\n");
      out.write("                                    <div class=\"box-header with-border\">\n");
      out.write("                                        <h3 class=\"box-title\">About Me</h3>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- /.box-header -->\n");
      out.write("                                    <div class=\"box-body\">\n");
      out.write("                                        <strong><i class=\"fa fa-user-circle margin-r-5\"></i>First Name</strong>\n");
      out.write("\n");
      out.write("                                        <p class=\"text-muted\" id=\"new\" onclick=\"Fnamechange();\">\n");
      out.write("                                            ");
      out.print(Fname);
      out.write("\n");
      out.write("                                        </p>\n");
      out.write("\n");
      out.write("                                        <hr>\n");
      out.write("\n");
      out.write("                                        <strong><i class=\"fa fa-user-circle-o margin-r-5\"></i> Last Name</strong>\n");
      out.write("\n");
      out.write("                                        <p class=\"text-muted\" id=\"new\" onclick=\"Lnamechange();\">\n");
      out.write("                                            ");
      out.print(Lname);
      out.write("\n");
      out.write("                                        </p>\n");
      out.write("\n");
      out.write("                                        <hr>\n");
      out.write("\n");
      out.write("                                        <strong><i class=\"fa fa-university margin-r-5\"></i> College</strong>\n");
      out.write("\n");
      out.write("                                        <p class=\"text-muted\" id=\"new\" onclick=\"Collegechange();\">\n");
      out.write("                                            ");
      out.print(CollegeName);
      out.write("\n");
      out.write("                                        </p>\n");
      out.write("\n");
      out.write("                                        <hr>\n");
      out.write("\n");
      out.write("                                        <strong><i class=\"fa fa-book margin-r-5\"></i> Course</strong>\n");
      out.write("\n");
      out.write("                                        <p class=\"text-muted\" id=\"new\" onclick=\"Coursechange();\">\n");
      out.write("                                            ");
      out.print(CourseName);
      out.write("\n");
      out.write("                                        </p>\n");
      out.write("\n");
      out.write("                                        <hr>\n");
      out.write("\n");
      out.write("                                        <strong><i class=\"fa fa-mail-forward margin-r-5\"></i> E-mail Address</strong>\n");
      out.write("\n");
      out.write("                                        <p class=\"text-muted\" id=\"new\" >\n");
      out.write("                                            ");
      out.print(Email);
      out.write("\n");
      out.write("                                        </p>\n");
      out.write("\n");
      out.write("                                        <hr>\n");
      out.write("\n");
      out.write("                                        <strong><i class=\"fa fa-check-circle margin-r-5\"></i> Registration Date</strong>\n");
      out.write("\n");
      out.write("                                        <p class=\"text-muted\" id=\"new\">\n");
      out.write("                                            ");
      out.print(Reg_Date);
      out.write("\n");
      out.write("                                        </p>\n");
      out.write("\n");
      out.write("                                        <hr>\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- /.box-body -->\n");
      out.write("                                </div>\n");
      out.write("                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                            <!-- /.col -->\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.row -->\n");
      out.write("\n");
      out.write("                    </section>\n");
      out.write("                    <!-- /.content -->\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            function change() {\n");
      out.write("                document.getElementById('new').innerHTML = '<input type=\"text\"  name=\"\"';\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

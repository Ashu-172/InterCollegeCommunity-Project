package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import Classes.DB_Connection;
import Classes.MailSender;
import Servlets.Sendmail;

public final class Login_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <title>InterCollege Community</title>\n");
      out.write("        <!-- Tell the browser to be responsive to screen width -->\n");
      out.write("        <meta content=\"width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no\" name=\"viewport\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"Admin/bower_components/bootstrap/dist/css/bootstrap.min.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"Admin/bower_components/font-awesome/css/font-awesome.min.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"Admin/bower_components/Ionicons/css/ionicons.min.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"Admin/dist/css/AdminLTE.min.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"Admin/plugins/iCheck/square/blue.css\">\n");
      out.write("\n");
      out.write("        <!-- Google Font -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic\">\n");
      out.write("        <script src=\"https://www.google.com/recaptcha/api.js\" async defer></script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"hold-transition login-page\">\n");
      out.write("        <div class=\"login-box\">\n");
      out.write("            <div class=\"login-logo\">\n");
      out.write("                <a href=\"../../index2.html\"><b>InterCollege</b>Community</a>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.login-logo -->\n");
      out.write("            <div class=\"login-box-body\" style=\"background: transparent\">\n");
      out.write("\n");
      out.write("                <div class=\"login-box-body\" style=\"background: transparent\">\n");
      out.write("                    ");
String isVarified = request.getParameter("isVarified");
                        DB_Connection dbc = new DB_Connection();
                        Connection conn = dbc.getConnection();
                        PreparedStatement stmt = conn.prepareStatement("select college_name from colleges");
                        ResultSet colleges = stmt.executeQuery();
                        boolean flag = false;
                        try {
                            flag = (boolean) request.getAttribute("flag");
                            if (flag == true) {
      out.write("\n");
      out.write("\n");
      out.write("                    <div class=\"callout callout-warning\">\n");
      out.write("                        <h4>Alert : </h4>\n");
      out.write("\n");
      out.write("                        <p>");
      out.print(request.getAttribute("alert"));
      out.write("</p>\n");
      out.write("                    </div>\n");
      out.write("                    ");
}
                        } catch (NullPointerException e) {
                            System.out.println("Stacktrace");
                        }
      out.write("\n");
      out.write("                    <p class=\"login-box-msg\" id=\"title\">Sign in to start your session</p>\n");
      out.write("                    <form action=\"Authentication\" id=\"login_form\" method=\"post\">\n");
      out.write("                        <div class=\"form-group has-feedback\">\n");
      out.write("                            <input type=\"email\" name=\"Email\" id=\"logEmail\" class=\"form-control\" placeholder=\"Email\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-envelope form-control-feedback\"></span>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group has-feedback\">\n");
      out.write("                            <input type=\"password\" name=\"Password\" id=\"logpassword\" class=\"form-control\" placeholder=\"Password\">\n");
      out.write("                            <span class=\"glyphicon glyphicon-lock form-control-feedback\"></span>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"row\"> \n");
      out.write("                            <!-- /.col -->\n");
      out.write("                            <div style=\"text-align: -webkit-center\" class=\"g-recaptcha \" data-sitekey=\"6LdYHTcUAAAAACF7KauukYRQo6fslHepNkHt3TqA\"></div>\n");
      out.write("                            <span id=\"CapchaMsg\"></span>\n");
      out.write("                            <div style=\"margin-top: 10px\" class=\"col-xs-4\">\n");
      out.write("                                <button type=\"submit\" class=\"btn btn-primary btn-block btn-flat\">Sign In</button>\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.col -->\n");
      out.write("                        </div>\n");
      out.write("                    </form>\n");
      out.write("                    <a href=\"ForgotPassword_Form.jsp\"  id=\"resetpass\"><b>I forgot my password</b></a><br>\n");
      out.write("                    <a href=\"Register.jsp\" class=\"text-center\"><b>Register a new membership</b></a> \n");
      out.write("                </div>\n");
      out.write("                <!-- /.login-box-body -->\n");
      out.write("            </div>\n");
      out.write("            <!-- /.login-box -->\n");
      out.write("\n");
      out.write("            <!-- jQuery 3 -->\n");
      out.write("            <script src=\"Admin/bower_components/jquery/dist/jquery.min.js\"></script>\n");
      out.write("            <!-- Bootstrap 3.3.7 -->\n");
      out.write("            <script src=\"Admin/bower_components/bootstrap/dist/js/bootstrap.min.js\"></script>\n");
      out.write("            <!-- iCheck -->\n");
      out.write("            <script src=\"Admin/plugins/iCheck/icheck.min.js\"></script>\n");
      out.write("            <script>\n");
      out.write("                $('#login_form').submit(function (e) {\n");
      out.write("                    $(\".error\").hide();\n");
      out.write("                    var emailReg = /^([\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4})?$/;\n");
      out.write("                    var hasError = false;\n");
      out.write("\n");
      out.write("                    var emailaddressVal = $(\"#logEmail\").val();\n");
      out.write("                    var passwordVal = $(\"#logpassword\").val();\n");
      out.write("                    if (emailaddressVal === '') {\n");
      out.write("                        $(\"#logEmail\").addClass('errorClass');\n");
      out.write("                        $(\"#logEmail\").after('<span class=\"error\" style=\"color: #D32F2F\">  Please enter your email address.</span>');\n");
      out.write("                        hasError = true;\n");
      out.write("                    } else if (!emailReg.test(emailaddressVal)) {\n");
      out.write("                        $(\"#logEmail\").addClass('errorClass');\n");
      out.write("                        $(\"#logEmail\").after('<span class=\"error\" style=\"color: #D32F2F\">  Enter a valid email address.</span>');\n");
      out.write("                        hasError = true;\n");
      out.write("                    }\n");
      out.write("                    if (passwordVal === '') {\n");
      out.write("                        $(\"#logpassword\").addClass('errorClass');\n");
      out.write("                        $(\"#logpassword\").after('<span class=\"error\" style=\"color: #D32F2F\">  Please enter your Password.</span>');\n");
      out.write("                        hasError = true;\n");
      out.write("                    }\n");
      out.write("                    if (hasError === true) {\n");
      out.write("                        e.preventDefault();\n");
      out.write("                        return false;\n");
      out.write("                    }\n");
      out.write("                    var captchResponse = $('#g-recaptcha-response').val();\n");
      out.write("                    if (captchResponse.length === 0)\n");
      out.write("                    { //user has not yet checked the 'I am not a robot' checkbox\n");
      out.write("                        $('#CapchaMsg').html('Are you a Robot..?').css('color', '#D32F2F');\n");
      out.write("                        e.preventDefault();\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            </script>\n");
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

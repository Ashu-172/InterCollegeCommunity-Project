package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ResetPassword_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write('\n');
      out.write('\n');
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <title>AdminLTE 2 | Log in</title>\n");
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
      out.write("    </head>\n");
      out.write("    <body class=\"hold-transition ForgotPassword-page\">\n");
      out.write("        ");
String id=request.getParameter("id");
        out.write(" "+id);
      out.write("\n");
      out.write("        \n");
      out.write("        <div class=\"login-box\">\n");
      out.write("            <div class=\"login-logo\">\n");
      out.write("                <a href=\"../../index2.html\"><b>Admin</b>LTE </a>\n");
      out.write("            </div>\n");
      out.write("            <!-- /.login-logo -->\n");
      out.write("            <div class=\"login-box-body\" style=\"background: transparent\">\n");
      out.write("                <form action=\"#\" id=\"login_form\" method=\"post\">\n");
      out.write("                    <div class=\"form-group has-feedback\">\n");
      out.write("                        <input type=\"password\" id=\"password\" class=\"form-control\"  placeholder=\"Password\" required>\n");
      out.write("                        <span class=\"glyphicon glyphicon-lock form-control-feedback\"></span>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group has-feedback\">\n");
      out.write("                        <input type=\"password\" id=\"confirm_password\" class=\"form-control\" name=\"password\" placeholder=\"Retype password\">\n");
      out.write("                        <span class=\"glyphicon glyphicon-log-in form-control-feedback\"></span>\n");
      out.write("                        <span id=\"messagepass\"></span>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"row\">\n");
      out.write("                    <div class=\"col-xs-4\">\n");
      out.write("                        <button type=\"submit\" class=\"btn btn-primary btn-block btn-flat\">Submit</button>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.col -->\n");
      out.write("                    </div>\n");
      out.write("                </form>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        <!-- /.login-box-body -->\n");
      out.write("    </div>\n");
      out.write("    <!-- /.login-box -->\n");
      out.write("\n");
      out.write("    <!-- jQuery 3 -->\n");
      out.write("    <script src=\"Admin/bower_components/jquery/dist/jquery.min.js\"></script>\n");
      out.write("    <!-- Bootstrap 3.3.7 -->\n");
      out.write("    <script src=\"Admin/bower_components/bootstrap/dist/js/bootstrap.min.js\"></script>\n");
      out.write("    <!-- iCheck -->\n");
      out.write("    <script src=\"Admin/plugins/iCheck/icheck.min.js\"></script>\n");
      out.write("    <script>\n");
      out.write("        //password check\n");
      out.write("                            $('#password, #confirm_password').on('keyup', function () {\n");
      out.write("                                if ($('#password').val() === $('#confirm_password').val()) {\n");
      out.write("                                    $('#confirm_password').css('color', 'green');\n");
      out.write("                                } else\n");
      out.write("                                    $('#confirm_password').css('color', 'red');\n");
      out.write("                            });\n");
      out.write("        \n");
      out.write("        $('#login_form').submit(function (e) {\n");
      out.write("            $(\".error\").hide();\n");
      out.write("            var hasError = false;\n");
      out.write("\n");
      out.write("            if ($('#password').val() !== $('#confirm_password').val())\n");
      out.write("                                {\n");
      out.write("                                    $('#messagepass').html('Check Password.').css('color', '#D32F2F');\n");
      out.write("                                    e.preventDefault();\n");
      out.write("                                }\n");
      out.write("                                });\n");
      out.write("    </script>\n");
      out.write("</body>\n");
      out.write("</html>\n");
      out.write("\n");
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

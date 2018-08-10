package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Servlets.*;
import Classes.DB_Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;

public final class Register_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>Registration Page</title>\n");
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
      out.write("        <!-- iCheck -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"Admin/plugins/iCheck/square/blue.css\">\n");
      out.write("        <link href=\"https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.4/css/select2.min.css\" rel=\"stylesheet\" />\n");
      out.write("        <style>\n");
      out.write("            .select2-container--default .select2-selection--single {\n");
      out.write("                background-color: #fff;\n");
      out.write("                border: 1px solid #d2d6de;\n");
      out.write("                border-radius: 0px !important;\n");
      out.write("                height : 34px;\n");
      out.write("                padding-left: 5px;\n");
      out.write("            }\n");
      out.write("        </style>\n");
      out.write("        <script>\n");
      out.write("            function change() {\n");
      out.write("                var val = document.getElementById('colleges').value;\n");
      out.write("                var xhttp = new XMLHttpRequest();\n");
      out.write("                xhttp.onreadystatechange = function () {\n");
      out.write("                    if (xhttp.readyState === 4 && xhttp.status === 200) {\n");
      out.write("                        document.getElementById('courses').innerHTML = xhttp.responseText;\n");
      out.write("                    }\n");
      out.write("                };\n");
      out.write("\n");
      out.write("                xhttp.open(\"POST\", \"getCourses?valajax=\" + val, true);\n");
      out.write("                xhttp.send();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic\">\n");
      out.write("        <script src = \"https://plus.google.com/js/client:platform.js\" async defer></script>\n");
      out.write("        <script src=\"https://www.google.com/recaptcha/api.js\" async defer></script>\n");
      out.write("    </head>\n");
      out.write("    <body class=\"hold-transition register-page\">\n");
      out.write("        ");
DB_Connection dbc = new DB_Connection();
            Connection conn = dbc.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select college_name from colleges");
            ResultSet colleges = stmt.executeQuery();
            boolean flag = false;
        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"register-box\">\n");
      out.write("            <div class=\"register-logo\">\n");
      out.write("                <a href=\"../../index2.html\"><b>InterCollege<span style=\"color: #D32F2F\">Community</span></b></a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <div class=\"register-box-body\">\n");
      out.write("                <div class=\" margin-bottom-ten no-print\">\n");
      out.write("                    ");
try {
                            flag = (boolean) request.getAttribute("flag");
                            if (flag == true) {
      out.write("\n");
      out.write("                    <div class=\"callout callout-info\" style=\"margin-bottom: 0!important;\">\n");
      out.write("                        <h4><i class=\"fa fa-info\"></i> Note : </h4>\n");
      out.write("                        ");
      out.print(request.getAttribute("message"));
      out.write("\n");
      out.write("                    </div>\n");
      out.write("                    ");
}
                        } catch (NullPointerException e) {
                            System.out.println("Stacktrace");
                        }
      out.write("\n");
      out.write("                </div>\n");
      out.write("                <p class=\"login-box-msg\">Register a new membership</p>\n");
      out.write("\n");
      out.write("                <form id=\"register_form\" action=\"Sendmail\" method=\"post\">\n");
      out.write("                    <div class=\"form-group has-feedback\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"Fname\" id=\"First_name\" placeholder=\"First name\" required>\n");
      out.write("                        <span class=\"glyphicon glyphicon-user form-control-feedback\"></span>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group has-feedback\">\n");
      out.write("                        <input type=\"text\" class=\"form-control\" name=\"Lname\" id=\"Last_name\" placeholder=\"Last name\">\n");
      out.write("                        <span class=\"glyphicon glyphicon-user form-control-feedback\"></span>\n");
      out.write("                    </div>\n");
      out.write("                    <!-- radio -->\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <b style=\"float: left; margin:10px 20px;\">Gender :</b>\n");
      out.write("                        <div style=\"float: left; position: relative;display: block; margin:10px 20px;\">\n");
      out.write("                            <label>\n");
      out.write("                                <input type=\"radio\" name=\"Gender\" id=\"optionsRadios1\" value=\"Male\" checked>\n");
      out.write("                                Male</label>\n");
      out.write("                        </div>\n");
      out.write("                        <div style=\"float: left; position: relative;display: block; margin:10px 20px;\">\n");
      out.write("                            <label>\n");
      out.write("                                <input type=\"radio\" name=\"Gender\" id=\"optionsRadios2\" value=\"Female\">\n");
      out.write("                                Female\n");
      out.write("                            </label>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\">\n");
      out.write("                        <select class=\"form-control select2\" name=\"college\" id=\"colleges\" onchange=\"change()\" style=\"width: 100%; border-radius: 0px;\" required>\n");
      out.write("                            <option>Select College</option>\n");
      out.write("                            ");
while (colleges.next()) {
      out.write("\n");
      out.write("                            <option>");
      out.print(colleges.getString(1));
      out.write("</option>\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </select>\n");
      out.write("                        <span id='messagecolg'></span>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group\" id=\"courses\">\n");
      out.write("                        <select class=\"form-control select2\" id=\"select_course\" name=\"course\"  style=\"width: 100%; border-radius: 0px; \" required >\n");
      out.write("                            <option> Select Course</option>\n");
      out.write("                        </select>\n");
      out.write("                        <span id='messagecors'></span>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group has-feedback\">\n");
      out.write("                        <input type=\"email\" class=\"form-control\" name=\"email\" id=\"Email\" placeholder=\"Email\" required>\n");
      out.write("                        <span class=\"glyphicon glyphicon-envelope form-control-feedback\"></span>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group has-feedback\">\n");
      out.write("                        <input type=\"password\" id=\"password\" class=\"form-control\"  placeholder=\"Password\" required>\n");
      out.write("                        <span class=\"glyphicon glyphicon-lock form-control-feedback\"></span>\n");
      out.write("                    </div>\n");
      out.write("                    <div class=\"form-group has-feedback\">\n");
      out.write("                        <input type=\"password\" id=\"confirm_password\" class=\"form-control\" name=\"password\" placeholder=\"Retype password\">\n");
      out.write("                        <span class=\"glyphicon glyphicon-log-in form-control-feedback\"></span>\n");
      out.write("                        <span id=\"messagepass\"></span>\n");
      out.write("                    </div>\n");
      out.write("                        \n");
      out.write("                    <div class=\"row\">\n");
      out.write("                        <div class=\"col-xs-8\">\n");
      out.write("                            <div class=\"checkbox icheck\">\n");
      out.write("                                <label>\n");
      out.write("                                    <input type=\"checkbox\" required> I agree to the <a href=\"#\">terms</a>\n");
      out.write("                                </label>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                        ");
String Appid = "119086718765082";
      out.write("\n");
      out.write("                        <input id=\"id\" type=\"hidden\" value=\"");
      out.print(Appid);
      out.write("\">\n");
      out.write("                        <input id=\"PP\" type=\"hidden\" name=\"PPurl\">\n");
      out.write("                        <!-- /.col -->\n");
      out.write("                        <div class=\"col-xs-4\">\n");
      out.write("                            <button  type=\"submit\" id=\"submit\" class=\"btn btn-primary btn-block btn-flat\">Register</button>\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.col -->\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                <div class=\"social-auth-links text-center\">\n");
      out.write("                    <p>- OR -</p>\n");
      out.write("                    <div id=\"fb-root\">\n");
      out.write("                        <a id=\"facebookSignUp\" class=\"btn btn-block btn-social btn-facebook btn-flat\" onclick=\"Login();\"><i class=\"fa fa-facebook\"></i> Sign up using\n");
      out.write("                            Facebook</a>\n");
      out.write("                    </div>\n");
      out.write("                    <br>\n");
      out.write("                    <div id=\"gConnect\" class=\"button\">\n");
      out.write("                        <button onclick=\"\" id=\"googleSignUp\" class=\"btn btn-block btn-social btn-google btn-flat g-signin\"\n");
      out.write("                                data-scope=\"email\"\n");
      out.write("                                data-clientid=\"262198385760-tm7gv8pdpll16m4ci805c5n0q92c5mbf.apps.googleusercontent.com\"\n");
      out.write("                                data-callback=\"onSignInCallback\"\n");
      out.write("                                data-theme=\"dark\"\n");
      out.write("                                data-cookiepolicy=\"single_host_origin\"><i class=\"fa fa-google-plus\"></i> Sign up using\n");
      out.write("                            Google+</button>\n");
      out.write("                    </div>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <a href=\"Login.jsp\" class=\"text-center\">I already have a membership</a>\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("            <!-- /.form-box -->\n");
      out.write("        </div>\n");
      out.write("        <!-- /.register-box -->\n");
      out.write("\n");
      out.write("        <!-- jQuery 3 -->\n");
      out.write("        <script src=\"Admin/bower_components/jquery/dist/jquery.min.js\"></script>\n");
      out.write("        <!-- Bootstrap 3.3.7 -->\n");
      out.write("        <script src=\"Admin/bower_components/bootstrap/dist/js/bootstrap.min.js\"></script>\n");
      out.write("        <!-- iCheck -->\n");
      out.write("        <script src=\"Admin/plugins/iCheck/icheck.min.js\"></script>\n");
      out.write("        <script src=\"https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.4/js/select2.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("                            $(function () {\n");
      out.write("                                $('input').iCheck({\n");
      out.write("                                    checkboxClass: 'icheckbox_square-blue',\n");
      out.write("                                    radioClass: 'iradio_square-blue',\n");
      out.write("                                    increaseArea: '20%' // optional\n");
      out.write("                                });\n");
      out.write("                            });\n");
      out.write("\n");
      out.write("                            //password check\n");
      out.write("                            $('#password, #confirm_password').on('keyup', function () {\n");
      out.write("                                if ($('#password').val() === $('#confirm_password').val()) {\n");
      out.write("                                    $('#confirm_password').css('color', 'green');\n");
      out.write("                                } else\n");
      out.write("                                    $('#confirm_password').css('color', 'red');\n");
      out.write("                            });\n");
      out.write("\n");
      out.write("                            //email validation and form validation\n");
      out.write("                            $(document).ready(function () {\n");
      out.write("                                $('#register_form').submit(function (e) {\n");
      out.write("                                    $(\".error\").hide();\n");
      out.write("                                    var hasError = false;\n");
      out.write("                                    var emailReg = /^([\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4})?$/;\n");
      out.write("\n");
      out.write("                                    var emailaddressVal = $(\"#Email\").val();\n");
      out.write("                                    if (emailaddressVal === '') {\n");
      out.write("                                        $(\"#Email\").addClass('errorClass');\n");
      out.write("                                        $(\"#Email\").after('<span class=\"error\" style=\"color: #D32F2F\">  Please enter your email address.</span>');\n");
      out.write("                                        hasError = true;\n");
      out.write("                                    } else if (!emailReg.test(emailaddressVal)) {\n");
      out.write("                                        $(\"#Email\").addClass('errorClass');\n");
      out.write("                                        $(\"#Email\").after('<span class=\"error\" style=\"color: #D32F2F\">  Enter a valid email address.</span>');\n");
      out.write("                                        hasError = true;\n");
      out.write("                                    }\n");
      out.write("                                    if (hasError === true) {\n");
      out.write("                                        e.preventDefault();\n");
      out.write("                                        return false;\n");
      out.write("                                    }\n");
      out.write("                                    if ($('#colleges').val() === \"Select College\")\n");
      out.write("                                    {\n");
      out.write("                                        $('#messagecolg').html('Select College..').css('color', '#D32F2F');\n");
      out.write("                                        e.preventDefault();\n");
      out.write("                                    } else if ($('#select_course').val() === \"Select Course\")\n");
      out.write("                                    {\n");
      out.write("                                        $('#messagecors').html('Select Course..').css('color', '#D32F2F');\n");
      out.write("                                        e.preventDefault();\n");
      out.write("                                    }\n");
      out.write("                                    if ($('#password').val() !== $('#confirm_password').val())\n");
      out.write("                                    {\n");
      out.write("                                        $('#messagepass').html('Check Password.').css('color', '#D32F2F');\n");
      out.write("                                        e.preventDefault();\n");
      out.write("                                    }\n");
      out.write("                                    var captchResponse = $('#g-recaptcha-response').val();\n");
      out.write("                                    if (captchResponse.length === 0)\n");
      out.write("                                        //user has not yet checked the 'I am not a robot' checkbox\n");
      out.write("                                        $('#messagepass').html('Check Password.').css('color', '#D32F2F');\n");
      out.write("                                        e.preventDefault();\n");
      out.write("                                    else\n");
      out.write("                                        //user is a verified human and you are good to submit your form now\n");
      out.write("                                });\n");
      out.write("                            });\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("        <script src=\"Signup.js\" ></script>\n");
      out.write("    </body>\n");
      out.write("</html>");
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

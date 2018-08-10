package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import Classes.DB_Connection;

public final class QuestionsforAnswer_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"utf-8\">\n");
      out.write("        <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n");
      out.write("        <title>AdminLTE 2 | Top Navigation</title>\n");
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
      out.write("        <!-- bootstrap wysihtml5 - text editor -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"Admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css\">\n");
      out.write("\n");
      out.write("        <link rel=\"stylesheet\" href=\"Admin/dist/css/skins/_all-skins.min.css\">\n");
      out.write("\n");
      out.write("        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->\n");
      out.write("        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->\n");
      out.write("        <!--[if lt IE 9]>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js\"></script>\n");
      out.write("        <script src=\"https://oss.maxcdn.com/respond/1.4.2/respond.min.js\"></script>\n");
      out.write("        <![endif]-->\n");
      out.write("\n");
      out.write("        <!-- Google Font -->\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic\">\n");
      out.write("        <style>.cke{visibility:hidden;}</style>\n");
      out.write("        <script type=\"text/javascript\" src=\"https://adminlte.io/themes/AdminLTE/bower_components/ckeditor/config.js?t=H5SE\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://adminlte.io/themes/AdminLTE/bower_components/ckeditor/skins/moono-lisa/editor.css?t=H5SE\">\n");
      out.write("        <script type=\"text/javascript\" src=\"https://adminlte.io/themes/AdminLTE/bower_components/ckeditor/lang/en.js?t=H5SE\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"https://adminlte.io/themes/AdminLTE/bower_components/ckeditor/styles.js?t=H5SE\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://adminlte.io/themes/AdminLTE/bower_components/ckeditor/plugins/scayt/skins/moono-lisa/scayt.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://adminlte.io/themes/AdminLTE/bower_components/ckeditor/plugins/scayt/dialogs/dialog.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://adminlte.io/themes/AdminLTE/bower_components/ckeditor/plugins/tableselection//styles/tableselection.css\">\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"https://adminlte.io/themes/AdminLTE/bower_components/ckeditor/plugins/wsc/skins/moono-lisa/wsc.css\">\n");
      out.write("        <!--script language=\"javascript\">\n");
      out.write("    </head>\n");
      out.write("        <!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->\n");
      out.write("    <body class=\"hold-transition skin-blue layout-top-nav\">\n");
      out.write("        ");
  String Userid = null, Fname = null, Profile_Picture = null, Mail_id = null;
            //int qid = 0,likecount=0;
            try {
                Userid = session.getAttribute("User_id").toString();
                Fname = session.getAttribute("Fname").toString();
                Profile_Picture = session.getAttribute("Profile_Picture").toString();
                Mail_id = session.getAttribute("mail_id").toString();
                //qid = Integer.parseInt(request.getParameter("Qid"));
            } catch (Exception e) {
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
            //out.println("PP"+Profile_Picture);
            //out.println("mail"+Mail_id);
            int que_id, QUid,likcounts=0;
            String que, QPdate;
            DB_Connection dbc = new DB_Connection();
            Connection conn = dbc.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from questions where AnswerCounts=0 or 1");
            ResultSet question_idrs = stmt.executeQuery();
            List<Integer> Qids = new ArrayList<Integer>();
            List<Integer> Likes = new ArrayList<Integer>();
            List<String> Questions = new ArrayList<String>();
            List<Integer> QUserids = new ArrayList<Integer>();
            List<String> QPostDate = new ArrayList<String>();
            while (question_idrs.next()) {
                que_id = question_idrs.getInt("Q_id");
                //out.println("###"+que_id);
                Qids.add(que_id);
                que = question_idrs.getString("Question_Text");
                //out.write(que);
                Questions.add(que);
                QUid = question_idrs.getInt("Reg_id");
                //out.println("###"+QUid);
                QUserids.add(QUid);
                QPdate = question_idrs.getDate("Create_Date").toString();
                //out.println("###"+QPdate);
                QPostDate.add(QPdate);
                likcounts=question_idrs.getInt("LikeCounts");
                Likes.add(likcounts);
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
      out.write("                                <li class=\"active\"><a href=\"index.jsp\">Home <span class=\"sr-only\">(current)</span></a></li>\n");
      out.write("                                <li><a href=\"AskQuestion.jsp\">Ask Question</a></li>\n");
      out.write("                                <li><a href=\"#\">Top Stories</a></li>\n");
      out.write("                                <li><a href=\"#\">Answer</a></li>\n");
      out.write("                                <li><a href=\"#\">Bookmarks</a></li>\n");
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
      out.write("                                                    <a href=\"#\">Followers</a>\n");
      out.write("                                                </div>\n");
      out.write("                                                <div class=\"col-xs-6 text-center\" >\n");
      out.write("                                                    <a href=\"#\">Following</a>\n");
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
      out.write("                            <li><a href=\"index.jsp\"><i class=\"fa fa-dashboard\"></i> Home</a></li>\n");
      out.write("                            <li><a href=\"#\">Post Answer</a></li>\n");
      out.write("                        </ol>\n");
      out.write("                    </section>\n");
      out.write("                    ");

                        for (int i = 0; i < Qids.size(); i++) {
                           
                            //out.println("###+++"+Qids.size());
                            String QueUserName = null, QueUserimg = null;
                            int qid = Qids.get(i);
                            //out.println("###"+qid);
                            String Question = Questions.get(i);
                            int Qu_id = QUserids.get(i);
                            int likecount=Likes.get(i);
                            //out.println("###"+Qu_id);
                            String QuePostDate = QPostDate.get(i);
                            //user data for question
                            PreparedStatement stmtQueUserdata = conn.prepareStatement("select * from user_registration where Reg_id=" + Qu_id);
                            ResultSet rsQueUserData = stmtQueUserdata.executeQuery();
                            while (rsQueUserData.next()) {
                                QueUserName = rsQueUserData.getString("First_Name") + " " + rsQueUserData.getString("Last_Name");
                                QueUserimg = rsQueUserData.getString("Profile_Picture");
                            }
                            //Check like and bookmark
                            PreparedStatement checkLikestmt=conn.prepareStatement("SELECT Like_id FROM likes WHERE Q_id="+qid+" and U_id="+Userid);
                            ResultSet checkLikeRS=checkLikestmt.executeQuery();
                            boolean likechk=checkLikeRS.isBeforeFirst();
                            //out.println("check liked "+likechk);
                            PreparedStatement checkBMstmt=conn.prepareStatement("SELECT Bookmark_id FROM bookmarks WHERE Q_id="+qid+" and U_id="+Userid);
                            ResultSet checkBMRS=checkBMstmt.executeQuery();
                            boolean BMchk=checkBMRS.isBeforeFirst();
                            //out.println("check Bookmarked "+BMchk);
                           
                                            //answer count
                                            //out.println("Q_id"+qid);
                                            PreparedStatement stmtAnscount=conn.prepareStatement("select count(A_id) from answers where Que_id="+qid);
                                            ResultSet AnscountRS=stmtAnscount.executeQuery();
                                            int Anscount=0;
                                            while(AnscountRS.next()){
                                                Anscount=AnscountRS.getInt(1);
                                                //out.println(Anscount+",");
                                            }
                                            //out.println(Anscount);
                            
                    
      out.write("\n");
      out.write("                    <!-- Main content -->\n");
      out.write("                    <section class=\"content\">\n");
      out.write("\n");
      out.write("                        <div class=\"col-md-9\">\n");
      out.write("                            <!-- Box Comment -->\n");
      out.write("                            <div class=\"box box-widget\">\n");
      out.write("                                <div class=\"box-header with-border\">\n");
      out.write("                                    <div class=\"user-block\">\n");
      out.write("                                        <img class=\"img-circle\" src=\"");
      out.print(QueUserimg);
      out.write("\" alt=\"User Image\">\n");
      out.write("                                        <span class=\"username\"><a href=\"#\">");
      out.print(QueUserName);
      out.write("</a></span>\n");
      out.write("                                        <span class=\"description\">Shared publicly - ");
      out.print(QuePostDate);
      out.write("</span>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- /.user-block -->\n");
      out.write("                                    <div class=\"box-tools\">\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"collapse\"><i class=\"fa fa-minus\"></i>\n");
      out.write("                                        </button>\n");
      out.write("                                        <button type=\"button\" class=\"btn btn-box-tool\" data-widget=\"remove\"><i class=\"fa fa-times\"></i></button>\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- /.box-tools -->\n");
      out.write("                                </div>\n");
      out.write("                                <!-- /.box-header -->\n");
      out.write("                                <div class=\"box-body\">\n");
      out.write("                                    <p>");
      out.print(Question);
      out.write("</p>\n");
      out.write("                                    <!--button type=\"submit\" data-que-id=\"");
      out.print(qid);
      out.write("\" data-user-id=\"");
      out.print(Userid);
      out.write("\" task=\"Share\" class=\"btn btn-default btn-xs task-button fa fa-share\" onclick=\"alertName();\"> Share</button-->\n");
      out.write("                                    <button type=\"submit\" data-que-id=\"");
      out.print(qid);
      out.write("\" data-user-id=\"");
      out.print(Userid);
      out.write("\" task=\"Like\" clicked=\"");
      out.print(likechk);
      out.write("\" class=\"btn btn-default btn-xs task-button fa fa-thumbs-o-up\"> ");
if (likechk) {
      out.write("Liked");
} else {
      out.write("Like");
}
      out.write("</button>\n");
      out.write("                                    <button type=\"submit\" data-que-id=\"");
      out.print(qid);
      out.write("\" data-user-id=\"");
      out.print(Userid);
      out.write("\" task=\"Bookmark\" clicked=\"");
      out.print(BMchk);
      out.write("\" class=\"btn btn-default btn-xs task-button fa fa-bookmark\"> ");
if (BMchk) {
      out.write("Bookmarked");
} else {
      out.write("Bookmark");
}
      out.write("</button>\n");
      out.write("                                    <span class=\"pull-right text-muted\">");
      out.print(likecount);
      out.write(" likes - ");
      out.print(Anscount);
      out.write(" Answers</span>\n");
      out.write("                                </div>\n");
      out.write("                                <!-- /.box-body -->\n");
      out.write("                                <!-- /.box-footer -->\n");
      out.write("\n");
      out.write("                            </div>\n");
      out.write("                            <!-- /.box -->\n");
      out.write("                            <!-- /.AnswerBox -->\n");
      out.write("                            <!-- Main content -->\n");
      out.write("                            \n");
      out.write("                                        <!-- /.content -->\n");
      out.write("\n");
      out.write("                                    </div>\n");
      out.write("                                    <!-- /.col -->\n");
      out.write("                                    <!-- /.box -->\n");
      out.write("                            </section>\n");
      out.write("                            <!-- /.content -->\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("                        </div>\n");
      out.write("                        <!-- /.container -->\n");
      out.write("                </div>\n");
      out.write("                <!-- /.content-wrapper -->\n");
      out.write("                <footer class=\"main-footer\">\n");
      out.write("                    <div class=\"container\">\n");
      out.write("                        <div class=\"pull-right hidden-xs\">\n");
      out.write("                            <b>Version</b> 2.4.0\n");
      out.write("                        </div>\n");
      out.write("                        <strong>Copyright &copy; 2014-2016 <a href=\"https://adminlte.io\">Almsaeed Studio</a>.</strong> All rights\n");
      out.write("                        reserved.\n");
      out.write("                    </div>\n");
      out.write("                    <!-- /.container -->\n");
      out.write("                </footer>\n");
      out.write("            </div>\n");
      out.write("            <!-- ./wrapper -->\n");
      out.write("\n");
      out.write("            <!-- jQuery 3 -->\n");
      out.write("\n");
      out.write("            <!-- ./wrapper -->\n");
      out.write("            <script async=\"\" src=\"//www.google-analytics.com/analytics.js\"></script>        \n");
      out.write("            <script src=\"Admin/bower_components/jquery/dist/jquery.min.js\"></script>\n");
      out.write("            <!-- Bootstrap 3.3.7 -->\n");
      out.write("            <script src=\"Admin/bower_components/bootstrap/dist/js/bootstrap.min.js\"></script>\n");
      out.write("            <!-- SlimScroll -->\n");
      out.write("            <script src=\"Admin/bower_components/jquery-slimscroll/jquery.slimscroll.min.js\"></script>\n");
      out.write("            <!-- FastClick -->\n");
      out.write("            <script src=\"Admin/bower_components/fastclick/lib/fastclick.js\"></script>\n");
      out.write("            <!-- AdminLTE App -->\n");
      out.write("            <script src=\"Admin/dist/js/adminlte.min.js\"></script>\n");
      out.write("            <!-- AdminLTE for demo purposes -->\n");
      out.write("            <script src=\"Admin/dist/js/demo.js\"></script>\n");
      out.write("            <!-- CK Editor -->\n");
      out.write("            <script src=\"Admin/bower_components/ckeditor/ckeditor.js\"></script>\n");
      out.write("            <!-- Bootstrap WYSIHTML5 -->\n");
      out.write("            <script src=\"Admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js\"></script>\n");
      out.write("            \n");
      out.write("            <script type=\"text/javascript\">\n");
      out.write("                $(\".task-button\").click(function () {\n");
      out.write("                    var Q_id = $(this).attr(\"data-que-id\");\n");
      out.write("                    var U_id = $(this).attr(\"data-user-id\");\n");
      out.write("                    var Task = $(this).attr(\"task\");\n");
      out.write("                    var chkclicked = $(this).attr(\"clicked\");\n");
      out.write("                    //alert(\"Question id \"+Q_id+\" , User id \"+U_id+\" , Task \"+Task+\" , Already clicked \"+chkclicked);\n");
      out.write("                    if (chkclicked === \"false\") {\n");
      out.write("                        var xhttp = new XMLHttpRequest();\n");
      out.write("                        xhttp.onreadystatechange = function () {\n");
      out.write("                            if (xhttp.readyState === 4 && xhttp.status === 200) {\n");
      out.write("                                //alert(xhttp.responseText);\n");
      out.write("                            }\n");
      out.write("                        };\n");
      out.write("                        var url = \"LikeBookmark_dataEntry?val1=\" + Q_id + \"&val2=\" + U_id + \"&val3=\" + Task;\n");
      out.write("                        xhttp.open(\"POST\", url, true);\n");
      out.write("                        xhttp.send();\n");
      out.write("                    }\n");
      out.write("                    if (Task === \"Like\") {\n");
      out.write("                        $(this).html(\" Liked\");\n");
      out.write("                    } else if (Task === \"Bookmark\") {\n");
      out.write("                        $(this).html(\" Bookmarked\");\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("            </script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
      out.write("\n");
      out.write("\n");
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

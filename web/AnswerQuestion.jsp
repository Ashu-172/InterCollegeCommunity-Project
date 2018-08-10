<%-- 
    Document   : AnswerQuestion
    Created on : Oct 31, 2017, 7:25:43 PM
    Author     : Ashutosh
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Classes.DB_Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>AdminLTE 2 | Top Navigation</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
        <!-- Bootstrap 3.3.7 -->
        <link rel="stylesheet" href="Admin/bower_components/bootstrap/dist/css/bootstrap.min.css">
        <!-- Font Awesome -->
        <link rel="stylesheet" href="Admin/bower_components/font-awesome/css/font-awesome.min.css">
        <!-- Ionicons -->
        <link rel="stylesheet" href="Admin/bower_components/Ionicons/css/ionicons.min.css">
        <!-- Theme style -->
        <link rel="stylesheet" href="Admin/dist/css/AdminLTE.min.css">
        <!-- AdminLTE Skins. Choose a skin from the css/skins
             folder instead of downloading all of them to reduce the load. -->
        <!-- bootstrap wysihtml5 - text editor -->
        <link rel="stylesheet" href="Admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">

        <link rel="stylesheet" href="Admin/dist/css/skins/_all-skins.min.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Google Font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
        <style>.cke{visibility:hidden;}</style>
        <script type="text/javascript" src="https://adminlte.io/themes/AdminLTE/bower_components/ckeditor/config.js?t=H5SE"></script>
        <link rel="stylesheet" type="text/css" href="https://adminlte.io/themes/AdminLTE/bower_components/ckeditor/skins/moono-lisa/editor.css?t=H5SE">
        <script type="text/javascript" src="https://adminlte.io/themes/AdminLTE/bower_components/ckeditor/lang/en.js?t=H5SE"></script>
        <script type="text/javascript" src="https://adminlte.io/themes/AdminLTE/bower_components/ckeditor/styles.js?t=H5SE"></script>
        <link rel="stylesheet" type="text/css" href="https://adminlte.io/themes/AdminLTE/bower_components/ckeditor/plugins/scayt/skins/moono-lisa/scayt.css">
        <link rel="stylesheet" type="text/css" href="https://adminlte.io/themes/AdminLTE/bower_components/ckeditor/plugins/scayt/dialogs/dialog.css">
        <link rel="stylesheet" type="text/css" href="https://adminlte.io/themes/AdminLTE/bower_components/ckeditor/plugins/tableselection//styles/tableselection.css">
        <link rel="stylesheet" type="text/css" href="https://adminlte.io/themes/AdminLTE/bower_components/ckeditor/plugins/wsc/skins/moono-lisa/wsc.css">
        <!--script language="javascript">
    </head>
        <!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
    <body class="hold-transition skin-blue layout-top-nav">
        <%  String Userid = null, Fname = null, Profile_Picture = null, Mail_id = null;
            int qid = 0,likecount=0,Anscount=0;
            try {
                Userid = session.getAttribute("User_id").toString();
                Fname = session.getAttribute("Fname").toString();
                Profile_Picture = session.getAttribute("Profile_Picture").toString();
                Mail_id = session.getAttribute("mail_id").toString();
                qid = Integer.parseInt(request.getParameter("Qid"));
            } catch (Exception e) {
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }
            //out.println("PP"+Profile_Picture);
            //out.println("mail"+Mail_id);
            int Qu_id = 0;

            String Question = null, QuePostDate = null;
            DB_Connection dbc = new DB_Connection();
            Connection conn = dbc.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select * from questions where Q_id=" + qid);
            ResultSet question_idrs = stmt.executeQuery();
            //List<Integer> Qids = new ArrayList<Integer>();
            //List<String> Questions = new ArrayList<String>();
            //List<Integer> QUserids = new ArrayList<Integer>();
            //List<String> QPostDate = new ArrayList<String>();
            while (question_idrs.next()) {
                qid = question_idrs.getInt("Q_id");
                //out.println("###"+que_id);
                //Qids.add(que_id);
                Question = question_idrs.getString("Question_Text");
                //out.write(que);
                //Questions.add(que);
                Qu_id = question_idrs.getInt("Reg_id");
                //out.println("###"+QUid);
                //QUserids.add(QUid);
                QuePostDate = question_idrs.getDate("Create_Date").toString();
                //out.println("###"+QPdate);
                //QPostDate.add(QPdate);
                likecount=question_idrs.getInt("LikeCounts");
                Anscount=question_idrs.getInt("AnswerCounts");
            }
        %>
        <div class="wrapper">

            <header class="main-header">
                <nav class="navbar navbar-static-top">
                    <div class="container">
                        <div class="navbar-header">
                            <a href="../../index2.html" class="navbar-brand"><b>InterCollege</b>Community</a>
                            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
                                <i class="fa fa-bars"></i>
                            </button>
                        </div>

                        <!-- Collect the nav links, forms, and other content for toggling -->
                        <div class="collapse navbar-collapse pull-left" id="navbar-collapse">
                            <ul class="nav navbar-nav">
                                <li class="active"><a href="index.jsp">Home </a></li>
                                <li><a href="AskQuestion.jsp">Ask Question</a></li>
                                <li><a href="TopStories.jsp">Top Stories</a></li>
                                <li><a href="QuestionsforAnswer.jsp">Answer</a></li>
                                <li><a href="#">Bookmarks</a></li>
                            </ul>
                            <form class="navbar-form navbar-left" role="search">
                                <div class="form-group">
                                    <input type="text" class="form-control" id="navbar-search-input" placeholder="Search">
                                </div>
                            </form>
                        </div>
                        <!-- /.navbar-collapse -->
                        <!-- Navbar Right Menu -->
                        <div class="navbar-custom-menu">
                            <ul class="nav navbar-nav">                                                              
                                <!-- User Account Menu -->
                                <li class="dropdown user user-menu">
                                    <!-- Menu Toggle Button -->
                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                        <!-- The user image in the navbar-->
                                        <img src="<%=Profile_Picture%>" class="user-image" alt="User Image">
                                        <!-- hidden-xs hides the username on small devices so only the image appears. -->
                                        <span class="hidden-xs"><%=Fname%></span>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <!-- The user image in the menu -->
                                        <li class="user-header">
                                            <img src="<%=Profile_Picture%>" class="img-circle" alt="User Image">

                                            <p>
                                                <%=Fname%>
                                                <small>Member since Nov. 2012</small>
                                            </p>
                                        </li>
                                        <!-- Menu Footer-->
                                        <li class="user-footer">
                                            <div class="pull-left">
                                                <a href="UserProfile.jsp" class="btn btn-default btn-flat">Profile</a>
                                            </div>
                                            <div class="pull-right">
                                                <a href="#" class="btn btn-default btn-flat">Sign out</a>
                                            </div>
                                        </li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                        <!-- /.navbar-custom-menu -->
                    </div>
                    <!-- /.container-fluid -->
                </nav>
            </header>
            <!-- Full Width Column -->
            <div class="content-wrapper">
                <div class="container">
                    <!-- Content Header (Page header) -->
                    <section class="content-header">
                        
                        <ol class="breadcrumb">
                            <li><a href="index.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
                            <li><a href="AnswerQuestion.jsp">Post Answer</a></li>
                        </ol>
                    </section>
                    <%

                        //List<Integer> Aids = new ArrayList<Integer>();
                        //out.println("###+++"+Qids.size());
                        String QueUserName = null, QueUserimg = null;
                        //int qid = Qids.get(i);
                        //out.println("###"+qid);
                        //String Question = Questions.get(i);
                        //int Qu_id = QUserids.get(i);
                        //out.println("###"+Qu_id);
                        //String QuePostDate = QPostDate.get(i);
                        //PreparedStatement stmtans = conn.prepareStatement("select A_id from answers where Que_id=" + qid);
                        //ResultSet rsA_id = stmtans.executeQuery();
                        //while (rsA_id.next()) {
                         //   int answerid = rsA_id.getInt(1);
                           // Aids.add(rsA_id.getInt(1));
                            //out.println("AnsId "+rsA_id.getInt(1));
                        //}
                        //user data for question
                        PreparedStatement stmtQueUserdata = conn.prepareStatement("select * from user_registration where Reg_id=" + Qu_id);
                        ResultSet rsQueUserData = stmtQueUserdata.executeQuery();
                        while (rsQueUserData.next()) {
                            QueUserName = rsQueUserData.getString("First_Name") + " " + rsQueUserData.getString("Last_Name");
                            QueUserimg = rsQueUserData.getString("Profile_Picture");
                        }
                        //Check like and bookmark
                        PreparedStatement checkLikestmt = conn.prepareStatement("SELECT Like_id FROM likes WHERE Q_id=" + qid + " and U_id=" + Userid);
                        ResultSet checkLikeRS = checkLikestmt.executeQuery();
                        boolean likechk = checkLikeRS.isBeforeFirst();
                        //out.println("check liked "+likechk);
                        PreparedStatement checkBMstmt = conn.prepareStatement("SELECT Bookmark_id FROM bookmarks WHERE Q_id=" + qid + " and U_id=" + Userid);
                        ResultSet checkBMRS = checkBMstmt.executeQuery();
                        boolean BMchk = checkBMRS.isBeforeFirst();
                        //out.println("check Bookmarked "+BMchk);
                        //answer count
                        //out.println("Q_id"+qid);
                        
                        //out.println(Anscount);

                    %>
                    <!-- Main content -->
                    <section class="content">

                        <div class="col-md-9">
                            <!-- Box Comment -->
                            <div class="box box-widget">
                                <div class="box-header with-border">
                                    <div class="user-block">
                                        <img class="img-circle" src="<%=QueUserimg%>" alt="User Image">
                                        <span class="username"><a href="#"><%=QueUserName%></a></span>
                                        <span class="description">Shared publicly - <%=QuePostDate%></span>
                                    </div>
                                    <!-- /.user-block -->
                                    <div class="box-tools">
                                        <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i>
                                        </button>
                                        <button type="button" class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                                    </div>
                                    <!-- /.box-tools -->
                                </div>
                                <!-- /.box-header -->
                                <div class="box-body">
                                    <p><%=Question%></p>
                                    <!--button type="submit" data-que-id="<%=qid%>" data-user-id="<%=Userid%>" task="Share" class="btn btn-default btn-xs task-button fa fa-share" onclick="alertName();"> Share</button-->
                                    <button type="submit" data-que-id="<%=qid%>" data-user-id="<%=Userid%>" task="Like" clicked="<%=likechk%>" class="btn btn-default btn-xs task-button fa fa-thumbs-o-up"> <%if (likechk) {%>Liked<%} else {%>Like<%}%></button>
                                    <button type="submit" data-que-id="<%=qid%>" data-user-id="<%=Userid%>" task="Bookmark" clicked="<%=BMchk%>" class="btn btn-default btn-xs task-button fa fa-bookmark"> <%if (BMchk) {%>Bookmarked<%} else {%>Bookmark<%}%></button>
                                    <span class="pull-right text-muted"><%=likecount%> likes - <%=Anscount%> Answers</span>
                                </div>
                                <!-- /.box-body -->
                                <!-- /.box-footer -->

                            </div>
                            <!-- /.box -->
                            <!-- /.AnswerBox -->
                            <!-- Main content -->
                            <section class="content">

                                <div class="box box-info">

                                    <div class="box-body pad">
                                        <form action="PostAnswer" method="post">
                                            <textarea id="editor1" name="answer" rows="15" cols="80" style="display: none;" placeholder="Type your Question Here">
                                            </textarea>

                                            <div class="box-footer clearfix">
                                                <input type="hidden" name="Qid" value="<%=qid%>">
                                                <div class="collapse navbar-collapse ">
                                                    <input type="submit" class="btn btn-sm btn-info btn-flat pull-right" value="Post Answer">
                                                </div>
                                            </div>
                                        </form>
                                        </section>
                                        <!-- /.content -->

                                    </div>
                                    <!-- /.col -->
                                    <!-- /.box -->
                            </section>
                            <!-- /.content -->

                        </div>
                        <!-- /.container -->
                </div>
                <!-- /.content-wrapper -->
                <footer class="main-footer">
                    <div class="container">
                        <div class="pull-right hidden-xs">
                            <b>Version</b> 2.4.0
                        </div>
                        <strong>Copyright &copy; 2014-2016 <a href="https://adminlte.io">Almsaeed Studio</a>.</strong> All rights
                        reserved.
                    </div>
                    <!-- /.container -->
                </footer>
            </div>
            <!-- ./wrapper -->

            <!-- jQuery 3 -->

            <!-- ./wrapper -->
            <script async="" src="//www.google-analytics.com/analytics.js"></script>        
            <script src="Admin/bower_components/jquery/dist/jquery.min.js"></script>
            <!-- Bootstrap 3.3.7 -->
            <script src="Admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
            <!-- SlimScroll -->
            <script src="Admin/bower_components/jquery-slimscroll/jquery.slimscroll.min.js"></script>
            <!-- FastClick -->
            <script src="Admin/bower_components/fastclick/lib/fastclick.js"></script>
            <!-- AdminLTE App -->
            <script src="Admin/dist/js/adminlte.min.js"></script>
            <!-- AdminLTE for demo purposes -->
            <script src="Admin/dist/js/demo.js"></script>
            <!-- CK Editor -->
            <script src="Admin/bower_components/ckeditor/ckeditor.js"></script>
            <!-- Bootstrap WYSIHTML5 -->
            <script src="Admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.all.min.js"></script>
            <script>
                $(function () {
                    // Replace the <textarea id="editor1"> with a CKEditor
                    // instance, using default configuration.
                    CKEDITOR.replace('editor1');
                    //bootstrap WYSIHTML5 - text editor
                    //$('.textarea').wysihtml5();
                });
            </script>
            <script type="text/javascript">
                $(".task-button").click(function () {
                    var Q_id = $(this).attr("data-que-id");
                    var U_id = $(this).attr("data-user-id");
                    var Task = $(this).attr("task");
                    var chkclicked = $(this).attr("clicked");
                    //alert("Question id "+Q_id+" , User id "+U_id+" , Task "+Task+" , Already clicked "+chkclicked);
                    if (chkclicked === "false") {
                        var xhttp = new XMLHttpRequest();
                        xhttp.onreadystatechange = function () {
                            if (xhttp.readyState === 4 && xhttp.status === 200) {
                                //alert(xhttp.responseText);
                            }
                        };
                        var url = "LikeBookmark_dataEntry?val1=" + Q_id + "&val2=" + U_id + "&val3=" + Task;
                        xhttp.open("POST", url, true);
                        xhttp.send();
                    }
                    if (Task === "Like") {
                        $(this).html(" Liked");
                    } else if (Task === "Bookmark") {
                        $(this).html(" Bookmarked");
                    }
                });
            </script>
    </body>
</html>


</html>

<%-- 
    Document   : AskQuestion
    Created on : Oct 17, 2017, 8:39:19 AM
    Author     : Ashutosh
--%>



<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Classes.DB_Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <link rel="stylesheet" href="Admin/dist/css/skins/_all-skins.min.css">
        <!-- bootstrap wysihtml5 - text editor -->
        <link rel="stylesheet" href="Admin/plugins/bootstrap-wysihtml5/bootstrap3-wysihtml5.min.css">
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
var req;
function searchText() {
var search = document.getElementById("search").value;
if(window.xmlHttpRequest){
req = new xmlHttpRequest();
}
else if(window.ActiveXObject){
req = new ActiveXObject("Microsoft.XMLHttp");
}
var url = "GetTopics?search="+search;
req.open("get",url,true);
req.onreadystatechange = callback;
req.send(null);
}
function callback() {
if( req.readyState===4 ){
var result = document.getElementById('result');
result.innerHTML = '';
var respText = req.responseText;
alert(respText);
if((respText.length)!==0){
document.getElementById('result').style.display =
'block';
var str = req.responseText.split("\n");
var items;
for(i=0; i < str.length - 1; i++) {
items = '<div onclick="setText(this.innerHTML);" ';
items += '>'+ str[i] + '</div>';
result.innerHTML += items;
}
}
else
{
document.getElementById('result').style.display ='none';
}
}
}
function focusIn(){
document.getElementById("search").focus( );
}
function setText(value) {
document.getElementById('search').value = value;
document.getElementById('result').style.display = 'none';
document.getElementById('result').innerHTML = '';
}
</script-->
    </head>
    <!-- ADD THE CLASS layout-top-nav TO REMOVE THE SIDEBAR. -->
    <body class="hold-transition skin-blue layout-top-nav">
        <%  String Userid = session.getAttribute("User_id").toString();
            String Fname = session.getAttribute("Fname").toString();
            String Profile_Picture = session.getAttribute("Profile_Picture").toString();
            String Mail_id = session.getAttribute("mail_id").toString();
            //out.println("PP"+Profile_Picture);
            //out.println("mail"+Mail_id);
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
                                <li><a href="index.jsp">Home</a></li>
                                <li class="active"><a href="AskQuestion.jsp">Ask Question <span class="sr-only">(current)</span></a></li>
                                <li><a href="TopStories.jsp">Top Stories</a></li>
                                <li><a href="QuestionsforAnswer.jsp">Answer</a></li>
                                <li><a href="Bookmarks.jsp">Bookmarks</a></li>
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
                            <li><a href="AskQuestion.jsp"><i class="fa fa-dashboard"></i> Ask Question</a></li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">

                        <div class="box box-info">

                            <div class="box-body pad">
                                <form action="PostQuestion" method="post">
                                    <textarea id="editor1" name="question" rows="15" cols="80" style="visibility: hidden; display: none;" placeholder="Type your Question Here">
                                    </textarea>

                                    <div class="box-footer clearfix">
                                        <div class="collapse navbar-collapse ">
                                            <input type="submit" class="btn btn-sm btn-info btn-flat pull-right" value="Post Question">
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
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
                <script async="" src="//www.google-analytics.com/analytics.js"></script>
                <!-- jQuery 3 -->
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
                
                </body>
                </html>



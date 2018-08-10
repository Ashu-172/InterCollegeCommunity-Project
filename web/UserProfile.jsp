<%-- 
    Document   : UserProfile
    Created on : Nov 5, 2017, 3:31:47 PM
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
        <title>AdminLTE 2 | User Profile</title>
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

        <!-- Google Font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    </head>
    <body class="hold-transition skin-blue layout-top-nav">
        <%  String Userid = null, Fname = null, Profile_Picture = null, Mail_id = null;
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
                        <h1>
                            Top Navigation
                            <small>Example 2.0</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li><a href="index.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
                            <li><a href="UserProfile.jsp">Profile</a></li>
                        </ol>
                    </section>

                    <!-- Main content -->
                    <section class="content">

                        <div class="row">
                            <div class="col-md-3">

                                <!-- Profile Image -->
                                <div class="box box-primary">
                                    <div class="box-body box-profile">
                                        <img class="profile-user-img img-responsive img-circle" src="<%=Profile_Picture%>" alt="User profile picture">

                                        <h3 class="profile-username text-center"><%=Fname%></h3>

                                        <p class="text-muted text-center">Software Engineer</p>

                                        <ul class="list-group list-group-unbordered">
                                            <li class="list-group-item">
                                                <b>Questions</b> <a class="pull-right">1,322</a>
                                            </li>
                                            <li class="list-group-item">
                                                <b>Answers</b> <a class="pull-right">543</a>
                                            </li>

                                        </ul>


                                    </div>
                                    <!-- /.box-body -->
                                </div>
                                <!-- /.box -->


                                <!-- /.box -->
                            </div>
                            <!-- /.col -->
                            <div class="col-md-9">
                                <!-- About Me Box -->
                                <div class="box box-primary">
                                    <div class="box-header with-border">
                                        <h3 class="box-title">About Me</h3>
                                    </div>
                                    <!-- /.box-header -->
                                    <div class="box-body">
                                        <strong><i class="fa fa-user-circle margin-r-5"></i>First Name</strong>

                                        <p class="text-muted" id="new" onclick="Fnamechange();">
                                            <%=Fname%>
                                        </p>

                                        <hr>

                                        <strong><i class="fa fa-user-circle-o margin-r-5"></i> Last Name</strong>

                                        <p class="text-muted" id="new" onclick="Lnamechange();">
                                            <%=Lname%>
                                        </p>

                                        <hr>

                                        <strong><i class="fa fa-university margin-r-5"></i> College</strong>

                                        <p class="text-muted" id="new" onclick="Collegechange();">
                                            <%=CollegeName%>
                                        </p>

                                        <hr>

                                        <strong><i class="fa fa-book margin-r-5"></i> Course</strong>

                                        <p class="text-muted" id="new" onclick="Coursechange();">
                                            <%=CourseName%>
                                        </p>

                                        <hr>

                                        <strong><i class="fa fa-mail-forward margin-r-5"></i> E-mail Address</strong>

                                        <p class="text-muted" id="new" >
                                            <%=Email%>
                                        </p>

                                        <hr>

                                        <strong><i class="fa fa-check-circle margin-r-5"></i> Registration Date</strong>

                                        <p class="text-muted" id="new">
                                            <%=Reg_Date%>
                                        </p>

                                        <hr>

                                    </div>
                                    <!-- /.box-body -->
                                </div>
                            </div>


                            <!-- /.col -->
                        </div>
                        <!-- /.row -->

                    </section>
                    <!-- /.content -->
                </div>
            </div>
        </div>
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
        <script type="text/javascript">
            function change() {
                document.getElementById('new').innerHTML = '<input type="text"  name=""';
            }
        </script>
    </body>
</html>

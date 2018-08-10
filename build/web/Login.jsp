<%-- 
    Document   : Login
    Created on : Oct 7, 2017, 9:57:27 AM
    Author     : Ashutosh
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="Classes.DB_Connection"%>
<%@page import="Classes.MailSender"%>
<%@page import="Servlets.Sendmail"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>InterCollege Community</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

        <link rel="stylesheet" href="Admin/bower_components/bootstrap/dist/css/bootstrap.min.css">

        <link rel="stylesheet" href="Admin/bower_components/font-awesome/css/font-awesome.min.css">

        <link rel="stylesheet" href="Admin/bower_components/Ionicons/css/ionicons.min.css">

        <link rel="stylesheet" href="Admin/dist/css/AdminLTE.min.css">

        <link rel="stylesheet" href="Admin/plugins/iCheck/square/blue.css">

        <!-- Google Font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
        <script src="https://www.google.com/recaptcha/api.js" async defer></script>
    </head>
    <body class="hold-transition login-page">
        <div class="login-box">
            <div class="login-logo">
                <a href="../../index2.html"><b>InterCollege</b>Community</a>
            </div>
            <!-- /.login-logo -->
            <div class="login-box-body" style="background: transparent">

                <div class="login-box-body" style="background: transparent">
                    <%String isVarified = request.getParameter("isVarified");
                        DB_Connection dbc = new DB_Connection();
                        Connection conn = dbc.getConnection();
                        PreparedStatement stmt = conn.prepareStatement("select college_name from colleges");
                        ResultSet colleges = stmt.executeQuery();
                        boolean flag = false;
                        try {
                            flag = (boolean) request.getAttribute("flag");
                            if (flag == true) {%>

                    <div class="callout callout-warning">
                        <h4>Alert : </h4>

                        <p><%=request.getAttribute("alert")%></p>
                    </div>
                    <%}
                        } catch (NullPointerException e) {
                            System.out.println("Stacktrace");
                        }%>
                    <p class="login-box-msg" id="title">Sign in to start your session</p>
                    <form action="Authentication" id="login_form" method="post">
                        <div class="form-group has-feedback">
                            <input type="email" name="Email" id="logEmail" class="form-control" placeholder="Email">
                            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                        </div>
                        <div class="form-group has-feedback">
                            <input type="password" name="Password" id="logpassword" class="form-control" placeholder="Password">
                            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                        </div>
                        <div class="row"> 
                            <!-- /.col -->
                            <div style="text-align: -webkit-center" class="g-recaptcha " data-sitekey="6LdYHTcUAAAAACF7KauukYRQo6fslHepNkHt3TqA"></div>
                            <span id="CapchaMsg"></span>
                            <div style="margin-top: 10px" class="col-xs-4">
                                <button type="submit" class="btn btn-primary btn-block btn-flat">Sign In</button>
                            </div>
                            <!-- /.col -->
                        </div>
                    </form>
                    <a href="ForgotPassword_Form.jsp"  id="resetpass"><b>I forgot my password</b></a><br>
                    <a href="Register.jsp" class="text-center"><b>Register a new membership</b></a> 
                </div>
                <!-- /.login-box-body -->
            </div>
            <!-- /.login-box -->

            <!-- jQuery 3 -->
            <script src="Admin/bower_components/jquery/dist/jquery.min.js"></script>
            <!-- Bootstrap 3.3.7 -->
            <script src="Admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
            <!-- iCheck -->
            <script src="Admin/plugins/iCheck/icheck.min.js"></script>
            <script>
                $('#login_form').submit(function (e) {
                    $(".error").hide();
                    var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;
                    var hasError = false;

                    var emailaddressVal = $("#logEmail").val();
                    var passwordVal = $("#logpassword").val();
                    if (emailaddressVal === '') {
                        $("#logEmail").addClass('errorClass');
                        $("#logEmail").after('<span class="error" style="color: #D32F2F">  Please enter your email address.</span>');
                        hasError = true;
                    } else if (!emailReg.test(emailaddressVal)) {
                        $("#logEmail").addClass('errorClass');
                        $("#logEmail").after('<span class="error" style="color: #D32F2F">  Enter a valid email address.</span>');
                        hasError = true;
                    }
                    if (passwordVal === '') {
                        $("#logpassword").addClass('errorClass');
                        $("#logpassword").after('<span class="error" style="color: #D32F2F">  Please enter your Password.</span>');
                        hasError = true;
                    }
                    if (hasError === true) {
                        e.preventDefault();
                        return false;
                    }
                    var captchResponse = $('#g-recaptcha-response').val();
                    if (captchResponse.length === 0)
                    { //user has not yet checked the 'I am not a robot' checkbox
                        $('#CapchaMsg').html('Are you a Robot..?').css('color', '#D32F2F');
                        e.preventDefault();
                    }
                });
            </script>
    </body>
</html>

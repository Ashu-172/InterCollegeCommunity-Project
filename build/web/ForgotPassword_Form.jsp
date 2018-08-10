<%-- 
    Document   : ForgotPassword_Form
    Created on : Oct 8, 2017, 11:38:15 AM
    Author     : Ashutosh
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>AdminLTE 2 | Log in</title>
        <!-- Tell the browser to be responsive to screen width -->
        <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">

        <link rel="stylesheet" href="Admin/bower_components/bootstrap/dist/css/bootstrap.min.css">

        <link rel="stylesheet" href="Admin/bower_components/font-awesome/css/font-awesome.min.css">

        <link rel="stylesheet" href="Admin/bower_components/Ionicons/css/ionicons.min.css">

        <link rel="stylesheet" href="Admin/dist/css/AdminLTE.min.css">

        <link rel="stylesheet" href="Admin/plugins/iCheck/square/blue.css">

        <!-- Google Font -->
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    </head>
    <body class="hold-transition ForgotPassword-page">
        <div class="login-box">
            <div class="login-logo">
                <a href="../../index2.html"><b>Admin</b>LTE</a>
            </div>
            <!-- /.login-logo -->
            <div class="login-box-body" style="background: transparent">
                <%  boolean flag = false;
                    try {
                            flag = (boolean) request.getAttribute("flag");
                            if (flag == true) {%>
                    
                    <div class="callout callout-warning">
                <h4>Note:</h4>

                <p><%=request.getAttribute("alert")%></p>
              </div>
                    <%}
                        } catch (NullPointerException e) {
                            System.out.println("Stacktrace");
                        }%>
                <form action="ForgotPass" id="login_form" method="post">
                    <div class="form-group has-feedback">
                        <input type="email" name="Email" id="logEmail" class="form-control" placeholder="Email">
                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                    </div>
                    
                    <div class="row"> 
                        <!-- /.col -->
                        <div class="col-xs-4">
                            <button type="submit" class="btn btn-primary btn-block btn-flat">Submit</button>
                        </div>
                        <!-- /.col -->
                    </div>
                </form>
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
            });
            </script>
    </body>
</html>


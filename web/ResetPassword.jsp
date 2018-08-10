<%-- 
    Document   : ResetPassword
    Created on : Oct 8, 2017, 8:35:23 AM
    Author     : Ashutosh
--%>

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
        <%String id=request.getParameter("di");
        out.write(" "+id);%>
        
        <div class="login-box">
            <div class="login-logo">
                <a href="../../index2.html"><b>Admin</b>LTE </a>
            </div>
            <!-- /.login-logo -->
            <div class="login-box-body" style="background: transparent">
                <form action="Password_Update" id="login_form" method="post">
                    <div class="form-group has-feedback">
                        <input type="password" id="password" class="form-control"  placeholder="Password" required>
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" id="confirm_password" class="form-control" name="password" placeholder="Retype password">
                        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                        <span id="messagepass"></span>
                    </div>
                    <input type="hidden" name="userid" value="<%=id%>">
                    <div class="row">
                    <div class="col-xs-4">
                        <button type="submit" class="btn btn-primary btn-block btn-flat">Submit</button>
                    </div>
                    <!-- /.col -->
                    </div>
                </form>
            </div>
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
        //password check
                            $('#password, #confirm_password').on('keyup', function () {
                                if ($('#password').val() === $('#confirm_password').val()) {
                                    $('#confirm_password').css('color', 'green');
                                } else
                                    $('#confirm_password').css('color', 'red');
                            });
        
        $('#login_form').submit(function (e) {
            $(".error").hide();
            var hasError = false;

            if ($('#password').val() !== $('#confirm_password').val())
                                {
                                    $('#messagepass').html('Check Password.').css('color', '#D32F2F');
                                    e.preventDefault();
                                }
                                });
    </script>
</body>
</html>


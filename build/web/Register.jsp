<%-- 
    Document   : Register
    Created on : Sep 25, 2017, 11:40:37 AM
    Author     : Ashutosh
--%>
<%@page import="Servlets.*"%>
<%@page import="Classes.DB_Connection" %>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Registration Page</title>
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
        <!-- iCheck -->
        <link rel="stylesheet" href="Admin/plugins/iCheck/square/blue.css">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.4/css/select2.min.css" rel="stylesheet" />
        <style>
            .select2-container--default .select2-selection--single {
                background-color: #fff;
                border: 1px solid #d2d6de;
                border-radius: 0px !important;
                height : 34px;
                padding-left: 5px;
            }
        </style>
        <script>
            function change() {
                var val = document.getElementById('colleges').value;
                var xhttp = new XMLHttpRequest();
                xhttp.onreadystatechange = function () {
                    if (xhttp.readyState === 4 && xhttp.status === 200) {
                        document.getElementById('courses').innerHTML = xhttp.responseText;
                    }
                };

                xhttp.open("POST", "getCourses?valajax=" + val, true);
                xhttp.send();
            }
        </script>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
        <script src = "https://plus.google.com/js/client:platform.js" async defer></script>
        
    </head>
    <body class="hold-transition register-page">
        <%DB_Connection dbc = new DB_Connection();
            Connection conn = dbc.getConnection();
            PreparedStatement stmt = conn.prepareStatement("select college_name from colleges");
            ResultSet colleges = stmt.executeQuery();
            boolean flag = false;
        %>




        <div class="register-box">
            <div class="register-logo">
                <a href="../../index2.html"><b>InterCollege<span style="color: #D32F2F">Community</span></b></a>
            </div>

            <div class="register-box-body">
                <div class=" margin-bottom-ten no-print">
                    <%try {
                            flag = (boolean) request.getAttribute("flag");
                            if (flag == true) {%>
                    <div class="callout callout-info" style="margin-bottom: 0!important;">
                        <h4><i class="fa fa-info"></i> Note : </h4>
                        <%=request.getAttribute("message")%>
                    </div>
                    <%}
                        } catch (NullPointerException e) {
                            System.out.println("Stacktrace");
                        }%>
                </div>
                <p class="login-box-msg">Register a new membership</p>

                <form id="register_form" action="Sendmail" method="post">
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="Fname" id="First_name" placeholder="First name" required>
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="text" class="form-control" name="Lname" id="Last_name" placeholder="Last name">
                        <span class="glyphicon glyphicon-user form-control-feedback"></span>
                    </div>
                    <!-- radio -->
                    <div class="form-group">
                        <b style="float: left; margin:10px 20px;">Gender :</b>
                        <div style="float: left; position: relative;display: block; margin:10px 20px;">
                            <label>
                                <input type="radio" name="Gender" id="optionsRadios1" value="Male" checked>
                                Male</label>
                        </div>
                        <div style="float: left; position: relative;display: block; margin:10px 20px;">
                            <label>
                                <input type="radio" name="Gender" id="optionsRadios2" value="Female">
                                Female
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <select class="form-control select2" name="college" id="colleges" onchange="change()" style="width: 100%; border-radius: 0px;" required>
                            <option>Select College</option>
                            <%while (colleges.next()) {%>
                            <option><%=colleges.getString(1)%></option>
                            <%}%>
                        </select>
                        <span id='messagecolg'></span>
                    </div>
                    <div class="form-group" id="courses">
                        <select class="form-control select2" id="select_course" name="course"  style="width: 100%; border-radius: 0px; " required >
                            <option> Select Course</option>
                        </select>
                        <span id='messagecors'></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="email" class="form-control" name="email" id="Email" placeholder="Email" required>
                        <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" id="password" class="form-control"  placeholder="Password" required>
                        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
                    </div>
                    <div class="form-group has-feedback">
                        <input type="password" id="confirm_password" class="form-control" name="password" placeholder="Retype password">
                        <span class="glyphicon glyphicon-log-in form-control-feedback"></span>
                        <span id="messagepass"></span>
                    </div>
                    <div class="row">
                        <div class="col-xs-8">
                            <div class="checkbox icheck">
                                <label>
                                    <input type="checkbox" required> I agree to the <a href="#">terms</a>
                                </label>
                            </div>
                        </div>
                        <%String Appid = "119086718765082";%>
                        <input id="id" type="hidden" value="<%=Appid%>">
                        <input id="PP" type="hidden" name="PPurl">
                        <!-- /.col -->
                        <div class="col-xs-4">
                            <button  type="submit" id="submit" class="btn btn-primary btn-block btn-flat">Register</button>
                        </div>
                        <!-- /.col -->
                    </div>

                </form>

                <div class="social-auth-links text-center">
                    <p>- OR -</p>
                    <div id="fb-root">
                        <a id="facebookSignUp" class="btn btn-block btn-social btn-facebook btn-flat" onclick="Login();"><i class="fa fa-facebook"></i> Sign up using
                            Facebook</a>
                    </div>
                    <br>
                    <div id="gConnect" class="button">
                        <button onclick="" id="googleSignUp" class="btn btn-block btn-social btn-google btn-flat g-signin"
                                data-scope="email"
                                data-clientid="262198385760-tm7gv8pdpll16m4ci805c5n0q92c5mbf.apps.googleusercontent.com"
                                data-callback="onSignInCallback"
                                data-theme="dark"
                                data-cookiepolicy="single_host_origin"><i class="fa fa-google-plus"></i> Sign up using
                            Google+</button>
                    </div>
                </div>

                <a href="Login.jsp" class="text-center">I already have a membership</a>
            </div>

            <!-- /.form-box -->
        </div>
        <!-- /.register-box -->

        <!-- jQuery 3 -->
        <script src="Admin/bower_components/jquery/dist/jquery.min.js"></script>
        <!-- Bootstrap 3.3.7 -->
        <script src="Admin/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <!-- iCheck -->
        <script src="Admin/plugins/iCheck/icheck.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.4/js/select2.min.js"></script>
        <script>
                            $(function () {
                                $('input').iCheck({
                                    checkboxClass: 'icheckbox_square-blue',
                                    radioClass: 'iradio_square-blue',
                                    increaseArea: '20%' // optional
                                });
                            });

                            //password check
                            $('#password, #confirm_password').on('keyup', function () {
                                if ($('#password').val() === $('#confirm_password').val()) {
                                    $('#confirm_password').css('color', 'green');
                                } else
                                    $('#confirm_password').css('color', 'red');
                            });

                            //email validation and form validation
                            $(document).ready(function () {
                                $('#register_form').submit(function (e) {
                                    $(".error").hide();
                                    var hasError = false;
                                    var emailReg = /^([\w-\.]+@([\w-]+\.)+[\w-]{2,4})?$/;

                                    var emailaddressVal = $("#Email").val();
                                    if (emailaddressVal === '') {
                                        $("#Email").addClass('errorClass');
                                        $("#Email").after('<span class="error" style="color: #D32F2F">  Please enter your email address.</span>');
                                        hasError = true;
                                    } else if (!emailReg.test(emailaddressVal)) {
                                        $("#Email").addClass('errorClass');
                                        $("#Email").after('<span class="error" style="color: #D32F2F">  Enter a valid email address.</span>');
                                        hasError = true;
                                    }
                                    if (hasError === true) {
                                        e.preventDefault();
                                        return false;
                                    }
                                    if ($('#colleges').val() === "Select College")
                                    {
                                        $('#messagecolg').html('Select College..').css('color', '#D32F2F');
                                        e.preventDefault();
                                    } else if ($('#select_course').val() === "Select Course")
                                    {
                                        $('#messagecors').html('Select Course..').css('color', '#D32F2F');
                                        e.preventDefault();
                                    }
                                    if ($('#password').val() !== $('#confirm_password').val())
                                    {
                                        $('#messagepass').html('Check Password.').css('color', '#D32F2F');
                                        e.preventDefault();
                                    }
                                    
                                });
                            });

        </script>
        <script src="Signup.js" ></script>
    </body>
</html>
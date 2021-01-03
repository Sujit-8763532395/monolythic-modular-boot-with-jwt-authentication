<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!doctype html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Single Window Portal WCD</title>
    <meta name="keywords" content="Single Window Portal WCD" />
    <meta name="description" content="Single Window Portal WCD">
    <meta name="author" content="Aashdit Technologies">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <link rel="shortcut icon" href="static/assets/images/logo.png">
    <link rel="stylesheet" href="static/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="static/assets/vendor/font-awesome/css/font-awesome.css" />
    <link rel="stylesheet" href="static/loginPage/css/login.css">
    <style>
    .sub_headings h4:after {
    content: "";
    position: absolute;
    left: 0;
    z-index: 100;
    top: 30px;
    width: 100%;
    height: 1px;
    background: #aaaba7ab;
    z-index: 1;
}</style>
</head>
<body class="login_bg">
  <section class="login_content">
      <div class="container">
          <div class="TextContainer lc_left">
              <div class="col-md-12 row">
                  <div class="col-md-3">
                      <img src="static/loginPage/img/logo.png">
                  </div>
                  <div class="col-md-9" style="margin-bottom: 60px;">
                     <h3 class="icds_title2">Department Of Women & Child Development, Odisha</h3>
                  </div>
              </div>
              <div class="col-md-12" style="margin-top: 23px;padding: 0px;">
                <h1>Single Window Portal</h1>
                <h1>WCD Department, Odisha</h1>
              </div>             
          </div>
      </div>
  </section>
 <script src="static/loginPage/js/jquery-2.2.4.min.js"></script>
 <script src="static/assets/vendor/bootstrap/js/bootstrap.min.js"></script>
      <script type="text/javascript">        
      function getAction(){
          var username = $("#username").val();
              var password = $("#password").val();

              if (username == "" && password == "") 
                {
                  alert("Username/Password Can't be empty");
                }
              else if (username == "supervisor" && password == "123456") 
                    {
                      document.getElementById('login-window').action = "supervisor_dashboard.html";
                    }
                  else if (username == "cdpo" && password == "123456") 
                    {
                      document.getElementById('login-window').action = "cpdo_dashboard.html";
                    }
                    else if (username == "ddo" && password == "123456") 
                    {
                      document.getElementById('login-window').action = "ddo_dashboard.html";
                    }
                    else if (username == "dswo" && password == "123456") 
                    {
                      document.getElementById('login-window').action = "dswo_dashboard.html";
                    }
                    else if (username == "director" && password == "123456") 
                    {
                      document.getElementById('login-window').action = "director_dashboard.html";
                    }
                    else if (username == "admin" && password == "123456") 
                    {
                      document.getElementById('login-window').action = "admin_dashboard.html";
                    }
                     else if (username == "hod" && password == "123456") 
                    {
                      document.getElementById('login-window').action = "hod_dashboard.html";
                    }
                };
    </script>
    <link href="static/assets/vendor/jquery_datepicker/jquery.datepick.css" rel="stylesheet">
    <script src="static/assets/vendor/jquery_datepicker/jquery.plugin.js"></script>
    <script src="static/assets/vendor/jquery_datepicker/jquery.datepick.js"></script>
    <script>
      $(function() {
        $('.datepicker_con>input').datepick({onShow: $.datepick.monthOnly, dateFormat: 'dd/mm/yyyy',yearRange: 'c-100:c+5', showOnFocus: true,
      showTrigger: '<button type="button" class="trigger">' +
      '<i class="fa fa-calendar"></i></button>'});
      });
    </script>
</body>
</html>
	
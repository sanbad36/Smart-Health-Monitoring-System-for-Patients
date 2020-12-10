<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<head>
<title>Smart ICU</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Colored Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- bootstrap-css -->
<link rel="stylesheet" href="css/bootstrap.css">
<!-- //bootstrap-css -->
<!-- Custom CSS -->
<link href="css/style.css" rel='stylesheet' type='text/css' />
<!-- font CSS -->
<link href='//fonts.googleapis.com/css?family=Roboto:400,100,100italic,300,300italic,400italic,500,500italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<!-- font-awesome icons -->
<link rel="stylesheet" href="css/font.css" type="text/css"/>
<link href="css/font-awesome.css" rel="stylesheet"> 
<!-- //font-awesome icons -->
</head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<<style>
body {
background-image: url(images/icu.jpg);
background-repeat: no-repeat;
background-size: cover;
height:820px;
font-family: 'Times New Roman', Times, serif;
}
p{
color:white;
font-size:25px;
}
.un{
color:white;
}
.login-page {
width: 360px;
padding: 8% 0 0;
margin: auto;
}
.form {
position: relative;
z-index: 1;
/* background: #FFFFFF; */
max-width: 360px;
margin: 50px auto 70px;
padding: 45px;
text-align: center;
color:#18638E;

background: rgb(0, 151, 19); 
                text-align:justify;  
                 /*setting alpha = 0.1*/ 
                background: rgba(0, 151, 19, 0.2); 
/* box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24); */
}
.form input {
font-family: "Roboto", sans-serif;
outline: 0;
/* background: #f2f2f2; */
width: 100%;
border: 0;
margin: 0 0 15px;
padding: 15px;
box-sizing: border-box;
font-size: 14px;
background-color:transparent;
border-bottom: 1px solid white;
color:white;
}
::placeholder{
      color:gray;
}
.form button {
font-family: "Roboto", sans-serif;
text-transform: uppercase;
outline: 0;
background: #79C6F2;
width: 100%;
border: 0;
padding: 15px;
color: #FFFFFF;
font-size: 14px;
-webkit-transition: all 0.3 ease;
transition: all 0.3 ease;
cursor: pointer;
}
.form button:hover,.form button:active,.form button:focus {
background: rgb(241, 95, 85);
}
.form .message {
margin: 15px 0 0;
color: black;
font-size: 12px;
}
.form .message a {
color: #4CAF50;
text-decoration: none;
}
.form .register-form {
display: none;
transform: translate(-25%,-25%);
background: rgba(0, 0, 0, 0.5);
}
div.first {
color:#18638E;
margin-left:500px;
margin-right:500px;
background: rgb(0, 151, 19); 
                text-align:justify;  
                 /*setting alpha = 0.1*/ 
                background: rgba(200, 151, 19, 0.2); 
}

</style>
</head>
<body style="background-image: url(images/doctorLogin.jpg);
background-repeat: no-repeat;height:820px;">

<div class="login-page">
  <div class="form">
    <p>Doctor Login</p>
    <form class="login-form" action="DoctorLogin" method="post">
      <input type="text" name="email" placeholder="username"/>
      <input type="password" name="password" placeholder="password"/>
      <button>login</button>
      <p class="message">Home Page? <a href="index.jsp">Click Here</a><br><br>
     
      </p>
    </form>
  </div>
</div>
<!-- <app-create></app-create> -->
<!-- <app-forget></app-forget> -->
<router-outlet></router-outlet>
		
	<script src="js/proton.js"></script>
</body>
</html>
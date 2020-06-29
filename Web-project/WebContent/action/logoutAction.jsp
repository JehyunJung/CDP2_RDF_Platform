<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="utils.DatabaseConnection" %>
<%@ page import="account.AccountDAO" %>
<jsp:useBean id="account" class="account.AccountDTO" scope="page"/>
<jsp:setProperty name="account" property="ID"/>
<jsp:setProperty name="account" property="PASSWORD"/>
<jsp:setProperty name="account" property="NAME"/>
<jsp:setProperty name="account" property="ADMIN_FLAG"/>


<!DOCTYPE html>
<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>RDF Hybrid Storage System</title>
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<style>
		html,body{
			height:100%;
			background:url("../image/login_background.jpg");
			background-position:center;
		}
		.page-wrapper{
			min-height:100%;
		}
		.jumbotron{
			padding-top:50px;
			padding-bottom:60px;
			margin: 150px auto;
			max-width: 500px;
			border-radius:10px;
		}	
	</style>
</head>
<body>
	<%
		//session.invalidate();
	%>
</body>
	<script>
		location.href='../view/main.jsp';
	</script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
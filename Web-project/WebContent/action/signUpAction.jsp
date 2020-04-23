<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="utils.DatabaseConnection" %>
<%@ page import="Account.AccountDAO" %>
<jsp:useBean id="account" class="Account.Account" scope="page"/>
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
	if(account.getID() == null || account.getPASSWORD() == null || account.getNAME() == null)
	{
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('입력이 안 된 사항이 있습니다.')");
		script.println("history.back()");
		script.println("</script>"); 
	}
	else
	{
		String ID = null;
		if(session.getAttribute("ID") != null)
		{
			ID = (String)session.getAttribute("ID");
		}	
		if(ID != null)
		{
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('이미 로그인이 되어있습니다.')");
			script.println("location.href = '../view/main.jsp'");
			script.println("</script>");
		}
		AccountDAO accountDAO = new AccountDAO();
		int result = accountDAO.join(account);
		
		if(result == -1){	
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('중복된 아이디입니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		else{	
			session.setAttribute("ID", account.getID());
			session.setAttribute("ADMIN_FLAG", account.getADMIN_FLAG());
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = '../view/main.jsp'");
			script.println("</script>");
		}
	}
		
	%>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
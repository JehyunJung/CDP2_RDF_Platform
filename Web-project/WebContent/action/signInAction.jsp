<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="Account.AccountDAO" %>
<%@ page import="utils.DatabaseConnection" %>
<%@ page import="java.io.PrintWriter" %>
<jsp:useBean id="account" class="Account.Account" scope="page"/>
<jsp:setProperty name="account" property="ID"/>
<jsp:setProperty name="account" property="PASSWORD"/>
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
		int result = accountDAO.login(account.getID(), account.getPASSWORD());
		if(result == 1){
			session.setAttribute("ID", account.getID());
			session.setAttribute("ADMIN_FLAG", account.getADMIN_FLAG());
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("location.href = '../view/main.jsp'");
			script.println("</script>");
		}
		else if(result == 0){	
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('비밀번호가 틀립니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		else if(result == -1){	
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('존재하지 않는 아이디입니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
		else if(result == -2){	
			PrintWriter script = response.getWriter();
			script.println("<script>");
			script.println("alert('데이터베이스 오류가 발생했습니다.')");
			script.println("history.back()");
			script.println("</script>");
		}
	%>
</body>
</html>
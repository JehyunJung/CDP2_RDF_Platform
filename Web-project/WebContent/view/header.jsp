<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.login_button{
		background-color:white;
		font-size:15px;
	}
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	  <a class="navbar-brand" href="main.jsp">RDF_HSS</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	    <ul class="navbar-nav mr-auto">   
	      <li class="nav-item dropdown">
	        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	          Manage Menu
	        </a>
	        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
	          <a class="dropdown-item" href="manageView.jsp">upload/delete</a>
	          <div class="dropdown-divider"></div>
	        </div>
	    </ul>	  
		<%
			String userID = null;
			if(session.getAttribute("ID")!=null){
				userID=(String)session.getAttribute("ID");
			}
		%>
		<%
			if(userID == null){
		%>
			<button class="btn login_button" type="button" onclick="location.href='signInView.jsp'">Sign In</button>
	
		<%
			}else{
		%>	
	  		<button class="btn login_button" type="button" onclick="location.href='../action/logoutAction.jsp'">Sign Out</button>
  		<%
			}
		%>
	    
	  </div>
	</nav>
</body>
</html>
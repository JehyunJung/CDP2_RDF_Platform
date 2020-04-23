<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<header>
		<jsp:include page="header.jsp" flush="false"/>
	</header>
	 <div class="page-wrapper">
		<section class="container">
			   <div class="jumbotron">
				   <form method="post" action="../action/signUpAction.jsp">
				    <h3 style="text-align: center;padding-bottom:10px"> Sign Up </h3>
				    <div class="form-group">
				     <input type="text" class="form-control" placeholder="Enter Name" name="NAME" required maxlength="20">
				    </div>
				    <div class="form-group">
				     <input type="text" class="form-control" placeholder="Enter ID" name="ID" required maxlength="20">
				    </div>
				    <div class="form-group">
				     <input type="password" class="form-control" placeholder="Enter Password" required name="PASSWORD" maxlength="20">
				    </div>
				    <input type="submit" class="btn btn-success form-control" value="Sign Up" style="font:20px;">
				   </form>
				  </div>
		</section>
	</div>
	<footer>
		<jsp:include page="footer.jsp" flush="false"/>
	</footer>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
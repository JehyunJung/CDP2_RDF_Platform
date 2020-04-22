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
			min-width:500px;
		}
		.page-wrapper{
			min-height:100%;
		}
		.jumbotron{
			padding-left:20px;
		}
	</style>
</head>
<body>
	<header>
		<jsp:include page="header.jsp" flush="false"/>
	</header>
	<div class="page-wrapper">
		<section>
			<div class="jumbotron jumbotron-fluid">
	    			<h1>Welcome To RDF_HSS</h1>
	    			<p>Hybrid Storage System for RDF Data</p>
	  			</div>
		</section>
		<section>
			<img src="../image/background.jpg" title="background image" style="width:100%; height:100%"></img>
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
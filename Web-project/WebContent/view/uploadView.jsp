<%@ page import="jena.FileUpload"%>
<!DOCTYPE html>
<html>
<head>
	
	<meta charset="EUC-KR">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>RDF Hybrid Storage System</title>
	<link href="../css/bootstrap.min.css" rel="stylesheet">
	<style>
		html,body{
			height:100%;
		}
		.page-wrapper{
			min-height:100%;
		}
	</style>
</head>
<body>
	<header>
		<jsp:include page="header.jsp" flush="false"/>
	</header>
	<div class="page-wrapper">
	   <div class="jumbotron">
	   		<h2>Upload Data Files</h2>
		</div>
	</div>
	<footer>
		<jsp:include page="footer.jsp" flush="false"/>
	</footer>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
</body>
</html>
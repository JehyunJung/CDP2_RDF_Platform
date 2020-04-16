<!DOCTYPE html>
<html>
<head>
	<meta charset="EUC-KR">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
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
		<jsp:include page="view/header.jsp" flush="false"/>
	</header>
	<div class="page-wrapper">
		<section>
			<div class="jumbotron jumbotron-fluid">
	  			<div class="container">
	    			<h1>Bootstrap Tutorial</h1>
	    			<p>Bootstrap is the most popular HTML, CSS...</p>
	  			</div>
			</div>
		</section>
		<section>
			<img src="image/background.jpg" title="background image" style="width:100%; height:100%"></img>
		</section>
	</div>
	<footer>
		<jsp:include page="view/footer.jsp" flush="false"/>
	</footer>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="jena.FileUpload"%>
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
		}
		.page-wrapper{
			min-height:100%;
		}
		.upload_form{
			max_width:400px;
		}
	</style>
</head>
<body>
	<header>
		<jsp:include page="header.jsp" flush="false"/>
	</header>
	<div class="page-wrapper">
		<section>
	   		<div class="jumbotron">
	   			<form action="../action/uploadAction.jsp" method="post" enctype="multipart/form-data">
				    <h3 style="text-align: left;padding-bottom:10px">Upload DataFile</h3>
				    <div class="form-group upload_form">
				     <input type="file" id="fileinput" name="file"> <br/>
				     <input type="submit" class="btn btn-success form-control" value="Upload" style="font:20px;">
				    </div>
	   			</form>
			</div>
		</section>
		<section>
	   		<div class="jumbotron">
	   			<h2>Delete Data Files</h2>
			</div>
		</section>
	</div>
	<footer>
		<jsp:include page="footer.jsp" flush="false"/>
	</footer>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-filestyle/2.1.0/bootstrap-filestyle.min.js"></script>
	<script src="../js/bootstrap.min.js"></script>
	<script>
		$('#fileinput').filestyle({
			buttonName:'btn-success',
			buttonText:'Choose File'
		})
	</script>
</body>
</html>
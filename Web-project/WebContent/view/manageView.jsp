<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File"%>
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
		h3{
			text-align: left;
			padding-bottom:10px
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
	   		<h3>Upload DataFile</h3>
	   			<div class="container">
	   			<form action="../action/uploadAction.jsp" method="post" enctype="multipart/form-data">
				    <div class="form-group upload_form">
				     <input type="file" id="fileinput" name="file"> <br/>
				     <input type="submit" class="btn btn-success form-control" value="Upload" style="font:20px;">
				    </div>
	   			</form>
	   			</div>
			</div>
		</section>
		<section>
	   		<div class="jumbotron">
	   			<h3>Delete Data Files</h3>
	   			<div class="container">
					<div class="row">
						<table class="table table-striped" id="fileList"
							style="text-align: center; border: 1px solid #dddddd">
							<thead>
								<tr>
									<th style="background-color: #eeeeee; text-align: center;">File Name</th>
									<th style="background-color: #eeeeee; text-align: center;">Delete</th>
								</tr>
							</thead>
							<tbody>
								<%
					   				String directory=application.getRealPath("/upload/");
					   				String files[]= new File(directory).list();
					   				if(files.length==0){
					   					%>
					   					<td colspan=2>No Files Currently</td>
									<%
					   				}
					   				for(String file: files){
					   			%>
								<tr>
									<td><%=file%></td>
									<td><a href="../action/deleteAction.jsp?filename=<%=file %>">Delete</a></td>
								</tr>
								<%
									}
								%>
							</tbody>
						</table>
					</div>
				</div>
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
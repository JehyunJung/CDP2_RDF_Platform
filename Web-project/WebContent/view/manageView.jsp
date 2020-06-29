<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.File"%>
<%@ page import="dataset.DatasetDAO"%>
<%@ page import="dataset.DatasetDTO"%>
<%@ page import="java.util.ArrayList" %>

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
		.upload_form{
			max_width:400px;
		}
		h2,h3{
			text-align: center;
			padding-bottom:10px
		}
		.link_item{
			padding:2px 10px;
			border-radius:3px;
		}
		.link_item:hover{
			color:black;
		}
		.delete_btn{
			color:white;
			background:red;
		}
		.add_btn{
			color:white;
			background:green;
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
			   
	   			<div class="container">
				<h2>Manage DataFiles</h2>
	   			<form action="../action/uploadAction.jsp" method="post" enctype="multipart/form-data">
				    <div class="form-group upload_form">
				     <input type="file" id="fileinput" name="file" required> <br/>
				     <input type="submit" class="btn btn-success form-control" value="Upload" style="font:20px;">
				    </div>
	   			</form>
	   			</div>
	   			
	   			<div class="container">
				   <h3>Current Data Files</h3>
					<div class="row">
						<table class="table table-striped" id="fileList"
							style="text-align: center; border: 1px solid #dddddd">
							<thead>
								<tr>
									<th style="background-color: #eeeeee; text-align: center;">Index</th>
									<th style="background-color: #eeeeee; text-align: center;">File Name</th>
									<th style="background-color: #eeeeee; text-align: center;"></th>
									<th style="background-color: #eeeeee; text-align: center;"></th>
									<th colspan=3 style="background-color: #eeeeee; text-align: center;">Actions</th>
									<th style="background-color: #eeeeee; text-align: center;">Location</th>
								</tr>
							</thead>
							<tbody>
								<%
									
									DatasetDAO datasetDAO=new DatasetDAO();
									ArrayList<DatasetDTO> datas=datasetDAO.getDataList();
									long memorySize=0;
									long diskSize=0;
					   				if(datas.isEmpty()){
					   					out.write("<td colspan=7>No Files Currently</td>");
					   				}
									int count=0;
					   				for(DatasetDTO data: datas){
										count+=1;
					   					String fileName=data.getTitle();
					   					System.out.println(data.getDataset());
					   					
					   			%>
								<tr>
									<td><%=count%></td>
									<td><%=data.getTitle()%></td>
									<td></td>
									<td></td>
									<%
										if(data.getDataset()==null){
											%>
											<td style="padding-left:30px;"><a class="link_item add_btn" href="../action/addtoDatasetAction.jsp?filename=<%=fileName%>&datasetType=mem&datasetExists=False">Add to Memory</a></td>
											<td><a class="link_item add_btn" href="../action/addtoDatasetAction.jsp?filename=<%=fileName%>&datasetType=tdb&datasetExists=False">Add to Disk</a></td>
											<td ><a class="link_item delete_btn" href="../action/deleteAction.jsp?filename=<%=fileName%>&datasetExists=False">Delete</a></td>
											<td>Not in Dataset</td>
									<%
										}
										else{
											if(data.getDataset().contentEquals("M")){
												%>
												<td colspan=2 style="padding-left:30px;padding-right:5px;"><a class="link_item add_btn" href="../action/addtoDatasetAction.jsp?filename=<%=fileName%>&datasetType=tdb&datasetExists=True">Add to Disk</a></td>
												<td><a class="link_item delete_btn" href="../action/deleteAction.jsp?filename=<%=fileName%>&datasetExists=True">Delete</a></td>
												<td><strong>In-Memory</strong></td>
												<%
												File file=new File(data.getStorage_path());
												memorySize+=file.length();
											}
											else{
												%>
												<td colspan=2 style="padding-left:30px;padding-right:5px;"><a class="link_item add_btn" href="../action/addtoDatasetAction.jsp?filename=<%=fileName%>&datasetType=mem&datasetExists=True">Add to Memory</a></td>
												<td><a class="link_item delete_btn" href="../action/deleteAction.jsp?filename=<%=fileName%>&datasetExists=True">Delete</a></td>
												<td><strong>Disk</strong></td>
												<%
												File file=new File(data.getStorage_path());
												diskSize+=file.length();
											}
										}
										
										
									%>									
								</tr>
								<%
								} %>
							</tbody>
						</table>
						<p>
							Memory Size: <%=memorySize %>
							Disk Size: <%=diskSize %>
						</p>
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
	
	<script src="../js/manageDataset.js"></script>
	<script>
		$('#fileinput').filestyle({
			buttonName:'btn-success',
			buttonText:'Choose File'
		})
	</script>
</body>
</html>
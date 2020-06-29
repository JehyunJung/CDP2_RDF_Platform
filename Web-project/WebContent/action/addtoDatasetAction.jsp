<%@ page import="dataset.DatasetDAO" %>
<%@ page import="jena.JenaAPI" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

</head>
<body>
	<%
		String fileName=request.getParameter("filename");
		String datasetType=request.getParameter("datasetType");
		boolean datasetExists=Boolean.parseBoolean(request.getParameter("datasetExists"));
		
		String directory=application.getRealPath("/DataFiles/");
		String filePath=directory+fileName;
		String datasetName=fileName.replaceAll("(\\.\\w+)", "");
		DatasetDAO datasetDAO=new DatasetDAO();
		boolean status1=datasetDAO.addtoDataset(fileName, datasetName,datasetType,datasetExists);	
		
		boolean status2=JenaAPI.addData(filePath,datasetName);
		
		System.out.println("status1: " +status1+" status2: "+status2);
		if(status1 && status2){
			out.write("<script>");
			if(datasetType.contentEquals("mem"))
				out.println("alert('파일이 정상적으로  메모리에 추가되었습니다.')");
			else
				out.println("alert('파일이 정상적으로  디스크에 추가되었습니다.')");
			out.write("</script>");
		}
		else{
			out.write("<script>");
			out.println("alert('파일이 추가 되지 않았습니다.')");
			out.write("</script>");
		}
	%>
	<script>
		location.href="../view/manageView.jsp";
	</script>
	
</body>
</html>
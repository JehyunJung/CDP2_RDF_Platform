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
		String filename=request.getParameter("filename");
		String dataset=request.getParameter("dataset");
		
		String directory=application.getRealPath("/DataFiles/");
		String filePath=directory+filename;
		
		boolean status1=JenaAPI.addtoDataset(filePath, dataset);
		
		DatasetDAO datasetDAO=new DatasetDAO();
		boolean status2=datasetDAO.addToDataset(filename,dataset);
		
		if(status1 && status2){
			out.write("<script>");
			if(dataset.contentEquals("M"))
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
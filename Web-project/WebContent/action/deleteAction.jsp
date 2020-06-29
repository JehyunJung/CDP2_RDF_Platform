<%@ page import="dataset.DatasetDAO" %>
<%@ page import="file.FileManage" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		String directory=application.getRealPath("/DataFiles/");
		String fileName=request.getParameter("filename");
		boolean datasetExists=Boolean.parseBoolean(request.getParameter("datasetExists"));
		
		String filePath=directory+fileName;
		String datasetName=fileName.replaceAll("(\\.\\w+)", "");
		
		boolean status=FileManage.deleteFile(filePath);
		
		if(status){
			DatasetDAO dataDAO = new DatasetDAO();
			dataDAO.delete(fileName,datasetName,datasetExists);
			out.write("<script>");
			out.println("alert('"+fileName+" 파일이 제거되었습니다.')");
			out.write("</script>");
		}
		else{
			out.write("<script>");
			out.println("alert('"+fileName+" 파일이 제거 되지 않았습니다.')");
			out.write("</script>");
		}
	%>
	<script>
		location.href="../view/manageView.jsp";
	</script>

</body>
</html>
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
		String filePath=directory+fileName;
		System.out.println(fileName);
		FileManage.deleteFile(filePath);
		
		DatasetDAO dataDAO = new DatasetDAO();
		dataDAO.delete(fileName);
		
	%>
	<script>
		location.href="../view/manageView.jsp";
	</script>

</body>
</html>
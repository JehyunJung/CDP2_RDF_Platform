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
		String directory=application.getRealPath("/upload/");
		String fileName=request.getParameter("filename");
		String filePath=directory+fileName;
		boolean status=FileManage.deleteFile(filePath);
		
		if(status){
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
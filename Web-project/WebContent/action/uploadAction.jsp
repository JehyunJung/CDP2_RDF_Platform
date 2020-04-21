<%@ page import="dataset.DatasetDAO" %>
<%@ page import="file.FileManage"%>
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
		String directory=application.getRealPath("/DataFiles/"); //실제 upload 폴더의 경로를 출력
		int maxSize=1024*1024*100; //100MB
		String encoding="UTF-8";
		
		MultipartRequest multipartRequest=new MultipartRequest(request,directory,maxSize,encoding,
				new DefaultFileRenamePolicy());
		
		String fileName=multipartRequest.getOriginalFileName("file"); //업로드되 파일 이름
		String realName=multipartRequest.getFilesystemName("file"); //서버에 저장되는 실제 이름
		
		if(!fileName.endsWith(".rdf") && !fileName.endsWith(".ttl") && !fileName.endsWith(".nt")){
			FileManage.deleteFile(directory+realName);
			out.write("<script>");
			out.write("alert('"+fileName+"은 업로드 할 수 없는 확장자입니다.')");
			out.write("</script>");
		}
		else{
			out.write("<script>");
			out.write("alert('"+fileName+" 파일을 성공적으로 저장하였습니다.')");
			out.write("</script>");
		}
	%>
	<script>
		location.href="../view/manageView.jsp";
	</script>

</body>
</html>
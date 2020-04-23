<%@ page import="dataset.DatasetDAO" %>
<%@ page import="jena.FileUpload" %>
<%@ page import="jena.StorageType" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>
<%@ page import="com.oreilly.servlet.MultipartRequest" %>
<%@ page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<%
		//등록자. 아이디없거나 관리자 아니면 등록 못하게.
	/*	String registrant=null;
		int admin_flag=0;
		if(session.getAttribute("ID")!=null && session.getAttribute("ADMIN_FLAG")!=null){
			registrant = (String)session.getAttribute("ID");
			admin_flag = (int)session.getAttribute("ADMIN_FLAG");
		}
		
		if(registrant == null){
			PrintWriter script= response.getWriter();
			script.println("<script>");
			script.println("alert('로그인을 하세요.')");
			script.println("location.href = '../view/signInView.jsp'");
			script.println("</script>");
		}
		else if(admin_flag==0){
			PrintWriter script= response.getWriter();
			script.println("<script>");
			script.println("alert('관리자가 아닙니다.')");
			script.println("location.href = '../view/main.jsp'");
			script.println("</script>");
		}else{
			
		}*/
		
		String registrant=null;
		if(session.getAttribute("ID")!=null){
			registrant = (String)session.getAttribute("ID");
		}
		
		String directory=application.getRealPath("/DataFiles/"); //실제 upload 폴더의 경로를 출력
		int maxSize=1024*1024*100; //100MB
		String encoding="UTF-8";
		
		MultipartRequest multipartRequest=new MultipartRequest(request,directory,maxSize,encoding,
				new DefaultFileRenamePolicy());
		
		String fileName=multipartRequest.getOriginalFileName("file"); //업로드되 파일 이름
		String realName=multipartRequest.getFilesystemName("file"); //서버에 저장되는 실제 이름
		
		//파일이름.확장자에서 확장자만 뽑아서 저장
		String data_type=realName.substring(realName.lastIndexOf(".")+1);
		
		//저장경로. 타입 만들어서 다시 수행.
		//String storage_path= multipartRequest.getParameter("path");
		
		//new DatasetDAO().upload(realName, data_type, registrant, storage_path);
		
		
	%>
	<script>
		location.href="../view/manageView.jsp";
	</script>

</body>
</html>
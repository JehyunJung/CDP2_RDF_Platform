import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * fileSizeThreshold	서버로 파일을 저장할 때 파일의 임시 저장 사이즈
 * maxFileSize			1개 파일에 대한 최대 사이즈
 * maxRequestSize		서버로 전송되는 request의 최대 사이즈
 * @author  "SeokRae (kslbsh@gmail.com)"
 * https://www.journaldev.com/2122/servlet-3-file-upload-multipartconfig-part
 * for the whole code, look up https://seokr.tistory.com/610
 */
@WebServlet("/UploadService")
@MultipartConfig(fileSizeThreshold=1024*1024*10, 	// 10 MB 
					maxFileSize=1024*1024*50,      	// 50 MB
					maxRequestSize=1024*1024*100)   // 100 MB
public class FileUpload extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4793303100936264213L;

	private static final String UPLOAD_DIR = "filefolder";
	
	public FileUpload() {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 서버의 실제 경로
		String applicationPath = request.getServletContext().getRealPath("");
		String uploadFilePath = applicationPath + UPLOAD_DIR;
		
		System.out.println(" LOG :: [서버 루트 경로] :: " + applicationPath);
		System.out.println(" LOG :: [파일 저장 경로] :: " + uploadFilePath);
		
		// creates the save directory if it does not exists
		File fileSaveDir = new File(uploadFilePath);
		
		// 파일 경로 없으면 생성
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
		}

        String fileName = null;
        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
        	getPartConfig(part);
            fileName = getFileName(part);
            System.out.println(" LOG :: [ 업로드 파일 경로 ] :: " + uploadFilePath + File.separator + fileName);
            part.write(uploadFilePath + File.separator + fileName);
        }
        registerDB(fileName, type, author);
        request.setAttribute("fileName", fileName);
        getServletContext().getRequestDispatcher("/response.jsp").forward(request, response);
	}
	
	/**
	 * https://docs.oracle.com/javaee/6/api/javax/servlet/http/Part.html
	 * 
	 * multipart/form-data 사용시 HttpServletRequest의 멤버 변수 중 Part의 형태로 전달됨
	 * 
	 * @param part
	 */
	private void getPartConfig(Part part) {
		System.out.println("------------------------------------------------------------");
		System.out.println(" LOG :: [HTML태그의 폼태그 이름] :: " + part.getName());
		System.out.println(" LOG :: [ 파일 사이즈 ] :: " + part.getSize());
		for(String name : part.getHeaderNames()) {
			System.out.println(" LOG :: HeaderName :: " + name + ", HeaderValue :: " + part.getHeader(name) + "\n");
		}
		System.out.println("------------------------------------------------------------");
	}
	
    /**
     * Utility method to get file name from HTTP header content-disposition
     */
    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        System.out.println(" LOG :: content-disposition 헤더 :: = "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
            	System.out.println(" LOG :: 파일 이름 :: " + token);
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
    
    private void registerDB(String fileName, StorageType type, String  v) {
    	
    }
}
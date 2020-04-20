package jena;
import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
		
		// �꽌踰꾩쓽 �떎�젣 寃쎈줈
		String applicationPath = request.getServletContext().getRealPath("");
		String uploadFilePath = applicationPath + UPLOAD_DIR;
		
		System.out.println(" LOG :: [�꽌踰� 猷⑦듃 寃쎈줈] :: " + applicationPath);
		System.out.println(" LOG :: [�뙆�씪 ���옣 寃쎈줈] :: " + uploadFilePath);
		
		// creates the save directory if it does not exists
		File fileSaveDir = new File(uploadFilePath);
		
		// �뙆�씪 寃쎈줈 �뾾�쑝硫� �깮�꽦
		if (!fileSaveDir.exists()) {
			fileSaveDir.mkdirs();
		}

        String fileName = null;
        //Get all the parts from request and write it to the file on server
        for (Part part : request.getParts()) {
        	getPartConfig(part);
            fileName = getFileName(part);
            System.out.println(" LOG :: [ �뾽濡쒕뱶 �뙆�씪 寃쎈줈 ] :: " + uploadFilePath + File.separator + fileName);
            part.write(uploadFilePath + File.separator + fileName);
        }
        //registerDB(fileName, type, author);
        request.setAttribute("fileName", fileName);
        getServletContext().getRequestDispatcher("/response.jsp").forward(request, response);
	}
	
	/**
	 * https://docs.oracle.com/javaee/6/api/javax/servlet/http/Part.html
	 * 
	 * multipart/form-data �궗�슜�떆 HttpServletRequest�쓽 硫ㅻ쾭 蹂��닔 以� Part�쓽 �삎�깭濡� �쟾�떖�맖
	 * 
	 * @param part
	 */
	private void getPartConfig(Part part) {
		System.out.println("------------------------------------------------------------");
		System.out.println(" LOG :: [HTML�깭洹몄쓽 �뤌�깭洹� �씠由�] :: " + part.getName());
		System.out.println(" LOG :: [ �뙆�씪 �궗�씠利� ] :: " + part.getSize());
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
        System.out.println(" LOG :: content-disposition �뿤�뜑 :: = "+contentDisp);
        String[] tokens = contentDisp.split(";");
        for (String token : tokens) {
            if (token.trim().startsWith("filename")) {
            	System.out.println(" LOG :: �뙆�씪 �씠由� :: " + token);
                return token.substring(token.indexOf("=") + 2, token.length()-1);
            }
        }
        return "";
    }
    
    private void registerDB(String fileName, StorageType type, String  v) {
    	
    }
}
package file;

import java.io.File;

public class FileManage {
	public static boolean deleteFile(String inputFileName) {
		File file = new File(inputFileName);
		if( file.exists() ){
    		if(file.delete()){
    			System.out.println("Delete the file successfully");
    			return true;
    		}else{
    			System.out.println("Failed to delete the file");
    			return false;
    		}
    	}else{
    		System.out.println("The file does not exist");
    		return false;
    	}
	}
}

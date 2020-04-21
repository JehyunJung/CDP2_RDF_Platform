package file;

import java.io.File;

public class FileManage {
	public static void deleteFile(String inputFileName) {
		File file = new File(inputFileName);
		if( file.exists() ){
    		if(file.delete()){
    			System.out.println("Delete the file successfully");
    		}else{
    			System.out.println("Failed to delete the file");
    		}
    	}else{
    		System.out.println("The file does not exist");
    	}
	}
}

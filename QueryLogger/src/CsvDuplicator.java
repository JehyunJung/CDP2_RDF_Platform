import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CsvDuplicator {
	public static void duplicateCsv(String sourceFile,String destFile) {
		BufferedReader br = null;
		BufferedWriter bufWriter = null;
		String FilePath = "C:\\Users\\jhyun\\Desktop";
		String queryFileName = destFile;
		List<List<String>> allQuery = new ArrayList<List<String>>();
		int count=0;
		try {
			// query 파일에서 query 전체 읽어 allQuery 리스트에 저장
			br = new BufferedReader(new InputStreamReader(new FileInputStream(FilePath+"\\"+sourceFile+".csv")));
			String line = "";
			while((line = br.readLine()) != null){
	                //CSV 1행을 저장하는 리스트
	                List<String> tmpList = new ArrayList<String>();
	                String temp[] = line.split(",");
	                String query=temp[1];
	                //query에 comma가 있는 경우 처리
	                for(int i=2;i<temp.length;i++) 
	                	query+=","+temp[i];
	                
	                //double quote 처리
	                if(query.charAt(0)=='"')
	                	query=query.substring(1, query.length()-1);   
	                String array[]= {temp[0],query};
	                //배열에서 리스트 반환
	                tmpList = Arrays.asList(array);
	                allQuery.add(tmpList);
	                allQuery.add(tmpList);
				}
			} catch(FileNotFoundException e) {
				e.printStackTrace();
			} catch(IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (br != null) {
						br.close();
					}
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
		try {
			bufWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FilePath+"\\"+queryFileName+".csv")));
			for(List<String> query : allQuery) {
					bufWriter.write(query.get(0)+","+query.get(1));
					bufWriter.newLine();
				}
		} catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try{
                if(bufWriter != null){
                    bufWriter.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
	}

}


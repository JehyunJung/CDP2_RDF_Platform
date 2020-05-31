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

public class Logger {

	public static void main(String[] args) {
		// FilePath/queryFileName.csv 파일에서 쿼리를 읽어 fuseki에 쿼리 후 FilePath/logFileName.csv에 로그 저장함
		// 쿼리 및 로그 변수
		BufferedReader br = null;
		BufferedWriter bufWriter = null;
		String FilePath = "";
		String queryFileName = "queryset";
		String logFileName = "log";
		List<List<String>> allQuery = new ArrayList<List<String>>();
		
		
		try {
			// query 파일에서 query 전체 읽어 allQuery 리스트에 저장
			br = new BufferedReader(new InputStreamReader(new FileInputStream(FilePath+"\\"+queryFileName+".csv")));
			
			String line = "";
			while((line = br.readLine()) != null){
                //CSV 1행을 저장하는 리스트
                List<String> tmpList = new ArrayList<String>();
                String array[] = line.split(",");
                //배열에서 리스트 반환
                tmpList = Arrays.asList(array);
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
			bufWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FilePath+"\\"+logFileName+".csv")));
			for (List<String> newLine : allQuery) {
				List<String> list = newLine;	// csv에서 dataset, query문 순으로 쓰여있다고 가정
				// 쿼리 후 로그 저장
				bufWriter.write(Query.fuseki_query(list.get(0), list.get(1))+","+ManagerIdExtract.log(list.get(0)));
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

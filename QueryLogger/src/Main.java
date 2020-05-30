import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// logFilePath/logFileName.csv 파일에서 쿼리를 읽어 fuseki에 쿼리 후 logFilePath/logFileName.csv에 로그 저장함
		// 쿼리 및 로그 변수
		BufferedReader br = null;
		BufferedWriter bufWriter = null;
		String queryFilePath = null;
		String queryFileName = "queryset";
		String logFilePath = null;
		String logFileName = "log";
		String datasetAddr = null; // "http://49.60.166.240:3030/"
		List<List<String>> allQuery = new ArrayList<List<String>>();
		
		// DB 변수
		String serverIp= "155.230.36.61";
		String strSID="orcl";
		String portNum="1521";
		String user="s2017110115";
		String pass="qaz123wsx456";
		Connection conn = null;
		Statement st = null;
		
		try {
			// query 파일에서 query 전체 읽어 allQuery 리스트에 저장
			br = Files.newBufferedReader(Paths.get(queryFilePath+"/"+queryFileName+".csv"));
			//Charset.forName("UTF-8");
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
			// DB 접속
			conn = DatabaseConnection.getConnection(serverIp, strSID, portNum, user, pass);
			st = conn.createStatement();
		} catch (SQLException e) {
			System.out.println("Failed to connect DB");
			e.printStackTrace();
		}
		
		try {
			bufWriter = Files.newBufferedWriter(Paths.get(logFilePath+"/"+logFileName+".csv"),Charset.forName("UTF-8"));
			for (List<String> newLine : allQuery) {
				List<String> list = newLine;	// csv에서 dataset, query문 순으로 쓰여있다고 가정
				// 쿼리 후 로그 저장
				bufWriter.write(Query.fuseki_query(conn, st, datasetAddr, list.get(0), list.get(1)));
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

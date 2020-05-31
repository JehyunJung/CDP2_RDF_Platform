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
		// queryFilePath/queryFileName.csv ���Ͽ��� ������ �о� fuseki�� ���� �� logFilePath/logFileName.csv�� �α� ������
		// ���� �� �α� ����
		BufferedReader br = null;
		BufferedWriter bufWriter = null;
		String queryFilePath = "";
		String queryFileName = "queryset";
		String logFilePath = "";
		String logFileName = "log";
		List<List<String>> allQuery = new ArrayList<List<String>>();
		
		
		try {
			// query ���Ͽ��� query ��ü �о� allQuery ����Ʈ�� ����
			br = new BufferedReader(new InputStreamReader(new FileInputStream(queryFilePath+"\\"+queryFileName+".csv")));
			
			String line = "";
			while((line = br.readLine()) != null){
                //CSV 1���� �����ϴ� ����Ʈ
                List<String> tmpList = new ArrayList<String>();
                String array[] = line.split(",");
                //�迭���� ����Ʈ ��ȯ
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
			bufWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(logFilePath+"\\"+logFileName+".csv")));
			for (List<String> newLine : allQuery) {
				List<String> list = newLine;	// csv���� dataset, query�� ������ �����ִٰ� ����
				// ���� �� �α� ����
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

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
import java.util.Collections;
import java.util.List;
import java.util.Random;
public class Logger {

	public static void main(String[] args) {
		// FilePath/queryFileName.csv ���Ͽ��� ������ �о� fuseki�� ���� �� FilePath/logFileName.csv�� �α� ������
		// ���� �� �α� ����
		BufferedReader br = null;
		BufferedWriter bufWriter = null;
		String FilePath = "C:\\Users\\jhyun\\Desktop";
		String queryFileName = "queryset_final";
		String logFileName = "log2";
		List<List<String>> allQuery = new ArrayList<List<String>>();
		int count=0;
		try {
			// query ���Ͽ��� query ��ü �о� allQuery ����Ʈ�� ����
			br = new BufferedReader(new InputStreamReader(new FileInputStream(FilePath+"\\"+queryFileName+".csv")));
			
			String line = "";
			while((line = br.readLine()) != null){
                //CSV 1���� �����ϴ� ����Ʈ
                List<String> tmpList = new ArrayList<String>();
                String temp[] = line.split(",");
                String query=temp[1];
                //query�� comma�� �ִ� ��� ó��
                for(int i=2;i<temp.length;i++) 
                	query+=","+temp[i];
                
                //double quote ó��
                if(query.charAt(0)=='"')
                	query=query.substring(1, query.length()-1);   
                String array[]= {temp[0],query};
                //�迭���� ����Ʈ ��ȯ
                tmpList = Arrays.asList(array);
                allQuery.add(tmpList);
                count+=1;
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
		System.out.println("Num Queries: " + count);
		try {
			count=1;
			bufWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FilePath+"\\"+logFileName+".csv")));
			for (List<String> newLine : allQuery) {
				List<String> list = newLine;	// csv���� dataset, query�� ������ �����ִٰ� ����
				// ���� �� �α� ����
				bufWriter.write(Query.fuseki_query(list.get(0), list.get(1))+","+ManagerIdExtract.log(list.get(0)));
				bufWriter.newLine();
				System.out.println(count);
				count+=1;
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

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

public class CsvMerge {
	public static void mergeCsv(ArrayList<String> sourceFiles,String destFile) {
		BufferedReader br = null;
		BufferedWriter bufWriter = null;
		String FilePath = "C:\\Users\\jhyun\\Desktop";
		String queryFileName = "queryset_final";
		ArrayList<List<List<String>>> allQueries = new ArrayList<>();
		int sum=0;
		for(int index=0;index<4;index++) {
			String sourceFile=sourceFiles.get(index);
			List<List<String>> allQuery = new ArrayList<List<String>>();
			int count=0;
			try {
				// query ���Ͽ��� query ��ü �о� allQuery ����Ʈ�� ����
				br = new BufferedReader(new InputStreamReader(new FileInputStream(FilePath+"\\"+sourceFile+".csv")));
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
	                count++;
	            }
				sum+=count;
				allQueries.add(allQuery);
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
		}
		System.out.println("Total Queries: " + sum);
		try {
			bufWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FilePath+"\\"+queryFileName+".csv")));
			int[] start_indexes= {0,0,0,0};
			int[] next_indexes= {1,2,3,0};
			int count=0;
			int index=0;
			while(count<sum) {
				List<String> list=allQueries.get(index).get(start_indexes[index]);
				if(list!=null) {
					bufWriter.write(list.get(0)+","+list.get(1));
					bufWriter.newLine();
					start_indexes[index]++;
					count++;
				}
				index=next_indexes[index];
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


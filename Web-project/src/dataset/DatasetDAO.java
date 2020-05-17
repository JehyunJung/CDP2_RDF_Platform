package dataset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import utils.DatabaseConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DatasetDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public DatasetDAO() {
		conn=DatabaseConnection.get_DatabaseConnection();
	}
	
	public String getDate() {
		String SQL="SELECT NOW()";
		try {
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public ArrayList<DatasetDTO> getDataList() {
		String SQL="SELECT * FROM DATA";
		ArrayList<DatasetDTO> datas=new ArrayList<>();
		try {
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			while(rs.next()){
				datas.add(new DatasetDTO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8)));
			}
		}
		catch(SQLException e) {
			e.printStackTrace();
			return null;
		}
		return datas;
	}
	
	public int getNext() {
		String SQL="SELECT serial_Num FROM DATA ORDER BY serial_Num DESC";
		try {
			pstmt=conn.prepareStatement(SQL);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1)+1;
			}
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public boolean upload(String Title, String data_type, String manager, String storage_path) {
		String SQL="INSERT INTO DATA VALUES (?, ?, ?, ?, ?, ?, NULL,NULL)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			
			pstmt.setInt(1, getNext());
			pstmt.setString(2, Title);
			pstmt.setString(3, data_type);
			pstmt.setString(4, manager);
			pstmt.setString(5, getDate());
			pstmt.setString(6, storage_path);
			
			pstmt.executeUpdate();
			return true;
		}catch(Exception e){
			e.printStackTrace();
		}
		return false;
	}
	public boolean createDataset(String datasetName,String datasetType) {
		String ip=DatabaseConnection.getIP();
		String request ="http://"+ip+":3030/$/datasets";
		URL url;
		HttpURLConnection connection;
		try {
			url = new URL(request);
			connection = (HttpURLConnection) url.openConnection(); 
			connection.setDoInput(true);
			connection.setInstanceFollowRedirects(false); 
			connection.setRequestMethod("POST"); 
			connection.setUseCaches (false);
			connection.setDoOutput(true);
			connection.setRequestProperty("content-type", "application/x-www-form-urlencoded");
			String body = "dbName="+datasetName+"&dbType="+datasetType;
			OutputStream os = connection.getOutputStream();
		    os.write(body.getBytes());
		    int responseStatus=connection.getResponseCode();
			connection.disconnect();
			if(responseStatus==200) 
				return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;
	}
	public boolean deleteDataset(String datasetName) {
		String ip=DatabaseConnection.getIP();
		String request ="http://"+ip+"/$/datasets/"+datasetName;
		URL url;
		HttpURLConnection connection;
		try {
			url = new URL(request);
			connection= (HttpURLConnection) url.openConnection(); 
			connection.setRequestMethod("DELETE"); 
			int responseStatus=connection.getResponseCode();
			connection.disconnect();
			if(responseStatus==200) 
				return true;

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return false;

	}
	public boolean addtoDataset(String Title,String datasetName,String datasetType,boolean datasetExists) {
		String ip=DatabaseConnection.getIP();
		String port=DatabaseConnection.getPort();
		String SQL="UPDATE DATA SET URL= ?, DATASET=? WHERE Title = ?";
		boolean status;
		if(datasetExists) {
			status=deleteDataset(datasetName);
			System.out.println("Performed delete: "+status);
		}
		status=createDataset(datasetName,datasetType);
		System.out.println("Performed Create: "+status);
		if(!status)
			return status;
		  try {
	         pstmt=conn.prepareStatement(SQL);
	         if(dataset.contentEquals("M"))
	            pstmt.setString(1,"http://"+ip+":3030/"+datasetName+"/sparql");
	         else
	            pstmt.setString(1,"http://"+ip+":3030/"+datasetName+"/sparql");         
	         pstmt.setString(2, dataset);
	         pstmt.setString(3, Title);
	         pstmt.executeUpdate();
	         return true;
	      }catch(Exception e) {
	         e.printStackTrace();
	      }
	      return false;
	}
		
	public int delete (String Title) {
		String SQL = "DELETE FROM DATA WHERE Title = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);   
			pstmt.setString(1, Title);
			pstmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
}

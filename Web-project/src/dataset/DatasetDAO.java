package dataset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jena.StorageType;
import utils.DatabaseConnection;

public class DatasetDAO {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	
	public DatasetDAO() {
		String db_name="CDP2";
		conn=DatabaseConnection.get_DatabaseConnection(db_name);
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
	
	public int getNext() {
		String SQL="SELECT serial_Num FROM data ORDER BY serial_Num DESC";
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
	
	public int upload(String Title, String data_type, String manager, String storage_path) {
		String SQL="INSERT INTO data VALUES (?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pstmt=conn.prepareStatement(SQL);
			
			pstmt.setInt(1, getNext());
			pstmt.setString(2, Title);
			pstmt.setString(3, data_type);
			pstmt.setString(4, manager);
			pstmt.setString(5, getDate());
			pstmt.setString(6, storage_path);
			return pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}
		return -1;
	}
	
	
	public int delete (String Title) {
		String SQL = "DELETE FROM data WHERE Title = ?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(SQL);   
			pstmt.setString(1, Title);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
}

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ManagerIdExtract {
	public static String log(String dataset) {
		Connection conn=DatabaseConnection.get_DatabaseConnection();
		String managerId=null;
		try {
			// �����ͼ� �̸����� managerId ã��
			String sql = "SELECT manager FROM DATA WHERE Title in (?,?,?) ";
			PreparedStatement psmt=conn.prepareStatement(sql);

			psmt.setString(1, dataset+".rdf");
			psmt.setString(2, dataset+".ttl");
			psmt.setString(3, dataset+".nt");
			
			ResultSet resultset = psmt.executeQuery();
			if(resultset.next())
				managerId = resultset.getString(1);
			// DB�� �α� ���
//			loggedLine = dataset + "," + date + "," + estimatedTime + "," + 
			resultset.close();
			psmt.close();
			return managerId;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed to log");
			return null;
		}
		finally {
				try {
					if(conn!=null)
						conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}
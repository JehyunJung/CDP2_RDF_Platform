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
			// 데이터셋 이름으로 managerId 찾기
			String sql = "SELECT manager FROM DATA WHERE Title = ?";
			PreparedStatement psmt=conn.prepareStatement(sql);

			psmt.setString(1, dataset);
			ResultSet resultset = psmt.executeQuery();
			if(resultset.next())
				managerId = resultset.getString(1);
			// DB에 로그 기록
//			loggedLine = dataset + "," + date + "," + estimatedTime + "," + 
			return managerId;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Failed to log");
			return null;
		}
		
	}
}
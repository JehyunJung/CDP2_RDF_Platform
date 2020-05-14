
import java.sql.Date;
import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Logger {
	public static void log(String dataset, long estimatedTime) {
		long time;
		int result = -1;
		time = System.currentTimeMillis();
		Date date = new Date(time);
		try {
			// DB 접속
			Connection conn = DatabaseConnection.getConnection();
			Statement st = conn.createStatement();
			PreparedStatement ps;
			// 데이터셋 이름으로 managerId 찾기
			String sql = "SELECT REGISTRANT FROM DATASET WHERE DATASET = " + dataset;
			ResultSet resultset = st.executeQuery(sql);
			String managerId = resultset.getString(1);
			// DB에 로그 기록
			sql = "INSERT INTO LOG VALUES(?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, dataset);
			ps.setDate(2, date);
			ps.setLong(3, estimatedTime);
			ps.setString(4, managerId);
			result = ps.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			System.out.println("Failed to log");
		}
	}
}


import java.sql.Date;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Logger {
	public static String log(Connection conn, Statement st, String dataset, long estimatedTime) {
		long time = System.currentTimeMillis();
		Date date = new Date(time);
		String loggedLine = null;
		try {
			// 데이터셋 이름으로 managerId 찾기
			String sql = "SELECT REGISTRANT FROM DATASET WHERE DATASET = " + dataset;
			ResultSet resultset = st.executeQuery(sql);
			String managerId = resultset.getString(1);
			// DB에 로그 기록
			loggedLine = dataset + "," + date + "," + estimatedTime + "," + managerId;
		} catch (SQLException e) {
			System.out.println("Failed to log");
		}
		return loggedLine;
	}
}

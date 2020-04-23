package utils;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	static String url = "jdbc:mysql://";
	static String ip="49.50.166.240";
	static String port="5050";
	static String userID="root";
	static String userPW="qaz123wsx456!@#";

	public static Connection get_DatabaseConnection(String db_name) {
		Connection conn = null;
		// Driver Loading
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db = url + ip + ":" + port + "/" + db_name+ "?serverTimezone=UTC";
			conn = DriverManager.getConnection(db, userID, userPW);
			return conn;
		}
		
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}

}

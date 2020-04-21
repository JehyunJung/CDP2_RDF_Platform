package utils;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	static String url = "jdbc:mysql://";
	static String ip;
	static String port;
	static String userID;
	static String userPW;

	public static Connection get_DatabaseConnection(String db_name) {
		Connection conn = null;
		// Driver Loading
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String db = url + ip + ":" + port + "/" + db_name;
			conn = DriverManager.getConnection(db, userID, userPW);
			return conn;
		}
		
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}

}

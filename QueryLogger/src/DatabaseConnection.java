import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
	static String url = "jdbc:mysql://";
	static String ip="";
	static String DBport="";
	static String userID="";
	static String userPW="";
	static String dbName="";
	static String fusekiPort="";

	public static Connection get_DatabaseConnection() {
		Connection conn = null;
		// Driver Loading
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db = url + ip + ":" + DBport + "/" + dbName+ "?serverTimezone=UTC";
			conn = DriverManager.getConnection(db, userID, userPW);
			return conn;
		}
		
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		} 
	}
	public static String getIP() {
		return ip;
	}
	public static String getPort() {
		return DBport;
	}
	public static String getfusekiPort() {
		return fusekiPort;
	}

}

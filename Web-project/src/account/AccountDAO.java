package account;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import utils.DatabaseConnection;


public class AccountDAO {
	
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public AccountDAO() {
		try {
			conn = DatabaseConnection.getDatabaseConnection();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public int login(String ID, String Password)
	{
		String SQL = "SELECT PASSWORD FROM ACCOUNT where ID = ?";
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, ID);
			rs = pstmt.executeQuery();
			if(rs.next()){
				if(rs.getString(1).contentEquals(Password)) {
					return 1;
				}
				else
					return 0;
			}
			return -1; 
		} catch(Exception e){
			e.printStackTrace();
		}
		return -2;
	}
	
	public boolean join(AccountDTO account) {
		String SQL = "INSERT INTO ACCOUNT VALUES(?,?,?,0)";
		try{
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, account.getID());
			pstmt.setString(2, account.getPASSWORD());
			pstmt.setString(3, account.getNAME());
			pstmt.executeUpdate();
			return true;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
	}

}

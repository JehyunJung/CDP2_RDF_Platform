package Account;

public class Account {
	
	private String ID;
	private String PASSWORD;
	private String NAME;
	private int ADMIN_FLAG;
	
	public int getADMIN_FLAG() {
		return ADMIN_FLAG;
	}
	public void setADMIN_FLAG(int aDMIN_FLAG) {
		ADMIN_FLAG = aDMIN_FLAG;
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getPASSWORD() {
		return PASSWORD;
	}
	public void setPASSWORD(String password) {
		PASSWORD = password;
	}
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String name) {
		NAME = name;
	}

}

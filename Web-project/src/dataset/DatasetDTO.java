package dataset;

public class DatasetDTO {
	String serial_num;
	String contents;
	String data_type;
	String registrant;
	String modification_time;
	String storage_path;
	
	
	public DatasetDTO(String serial_num, String contents, String data_type, String registrant, String modification_time,
			String storage_path) {
		super();
		this.serial_num = serial_num;
		this.contents = contents;
		this.data_type = data_type;
		this.registrant = registrant;
		this.modification_time = modification_time;
		this.storage_path = storage_path;
	}
	
	public String getSerial_num() {
		return serial_num;
	}
	public void setSerial_num(String serial_num) {
		this.serial_num = serial_num;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}
	public String getRegistrant() {
		return registrant;
	}
	public void setRegistrant(String registrant) {
		this.registrant = registrant;
	}
	public String getModification_time() {
		return modification_time;
	}
	public void setModification_time(String modification_time) {
		this.modification_time = modification_time;
	}
	public String getStorage_path() {
		return storage_path;
	}
	public void setStorage_path(String storage_path) {
		this.storage_path = storage_path;
	}
	
}

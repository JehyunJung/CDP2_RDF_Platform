package dataset;

public class DatasetDTO {
	int serial_Num;
	String Title;
	String data_type;
	String manager;
	String modification_time;
	String storage_path;
	String url;
	String dataset;
	
	public DatasetDTO(int serial_Num, String title, String data_type, String manager, String modification_time,
			String storage_path,String url,String dataset) {
		super();
		this.serial_Num = serial_Num;
		this.Title = title;
		this.data_type = data_type;
		this.manager = manager;
		this.modification_time = modification_time;
		this.storage_path = storage_path;
		this.url=url;
		this.dataset=dataset;
	}
	

	public int getSerial_num() {
		return serial_Num;
	}
	public void setSerial_num(int serial_Num) {
		this.serial_Num = serial_Num;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		this.Title = title;
	}
	public String getData_type() {
		return data_type;
	}
	public void setData_type(String data_type) {
		this.data_type = data_type;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
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
	public String getURL() {
		return url;
	}

	public void setURL(String uRL) {
		url = uRL;
	}

	public String getDataset() {
		return dataset;
	}

	public void setDataset(String dataset) {
		this.dataset = dataset;
	}

	
}

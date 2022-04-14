package Model;

public class ModelStudent {
	private String StuID;
	private String name;
	private String address;
	
	public ModelStudent(String stuID, String name, String address) {
		StuID = stuID;
		this.name = name;
		this.address = address;
	}

	public ModelStudent() {
	}

	public String getStuID() {
		return StuID;
	}

	public void setStuID(String stuID) {
		StuID = stuID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}

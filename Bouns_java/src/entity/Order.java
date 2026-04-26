package entity;

public class Order {
	private String idnumber;
	private String idparty;
	private String crditnumber;
	private String age;
	public Order(String idnumber, String idparty, String crditnumber, String age) {
		super();
		this.idnumber = idnumber;
		this.idparty = idparty;
		this.crditnumber = crditnumber;
		this.age = age;
	}
	public String getIdnumber() {
		return idnumber;
	}
	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}
	public String getIdparty() {
		return idparty;
	}
	public void setIdparty(String idparty) {
		this.idparty = idparty;
	}
	public String getCrditnumber() {
		return crditnumber;
	}
	public void setCrditnumber(String crditnumber) {
		this.crditnumber = crditnumber;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
}

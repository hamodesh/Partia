package entity;

public class NewOrder {
	private String idNumber;
	private String PartyNumber;
	private String Crditcart;
	private String age;
	public NewOrder(String idNumber, String partyNumber, String crditcart, String age) {
		super();
		this.idNumber = idNumber;
		PartyNumber = partyNumber;
		Crditcart = crditcart;
		this.age = age;
	}
	public String getIdNumber() {
		return idNumber;
	}
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}
	public String getPartyNumber() {
		return PartyNumber;
	}
	public void setPartyNumber(String partyNumber) {
		PartyNumber = partyNumber;
	}
	public String getCrditcart() {
		return Crditcart;
	}
	public void setCrditcart(String crditcart) {
		Crditcart = crditcart;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	
	
	
}

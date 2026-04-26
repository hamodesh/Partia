package entity;

public class CustomerinParty {

	private Integer phonenumber;
	private Integer partynumber;
	private Integer Adress;

	public static final int MAX_ADDRESS = 60;
	public static final int MAX_CITY = 15;
	public static final int MAX_COUNTRY = 15;

	public CustomerinParty(Integer phonenumber, Integer partynumber, Integer adress) {
		super();
		this.phonenumber = phonenumber;
		this.partynumber = partynumber;
		Adress = adress;
	}

	public Integer getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(Integer phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Integer getPartynumber() {
		return partynumber;
	}

	public void setPartynumber(Integer partynumber) {
		this.partynumber = partynumber;
	}

	public Integer getAdress() {
		return Adress;
	}

	public void setAdress(Integer adress) {
		Adress = adress;
	}

	public static int getMaxAddress() {
		return MAX_ADDRESS;
	}

	public static int getMaxCity() {
		return MAX_CITY;
	}

	public static int getMaxCountry() {
		return MAX_COUNTRY;
	}

	@Override
	public String toString() {
		return "CustomerinParty [phonenumber=" + phonenumber + ", partynumber=" + partynumber + ", Adress=" + Adress
				+ "]";
	}

}

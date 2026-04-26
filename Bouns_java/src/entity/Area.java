package entity;

public class Area {

	private String Partyname;
	private String crditprice;
	private String size;
	private String maixcrdit;
	private String maixprictes;
	private String partynumber;

	public static final int MAX_ADDRESS = 60;
	public static final int MAX_CITY = 15;
	public static final int MAX_COUNTRY = 15;

	public Area(String partyname, String crditprice, String size, String maixcrdit, String maixprictes,
			String partynumber) {
		super();
		Partyname = partyname;
		this.crditprice = crditprice;
		this.size = size;
		this.maixcrdit = maixcrdit;
		this.maixprictes = maixprictes;
		this.partynumber = partynumber;
	}

	public String getPartyname() {
		return Partyname;
	}

	public void setPartyname(String partyname) {
		Partyname = partyname;
	}

	public String getCrditprice() {
		return crditprice;
	}

	public void setCrditprice(String crditprice) {
		this.crditprice = crditprice;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getMaixcrdit() {
		return maixcrdit;
	}

	public void setMaixcrdit(String maixcrdit) {
		this.maixcrdit = maixcrdit;
	}

	public String getMaixprictes() {
		return maixprictes;
	}

	public void setMaixprictes(String maixprictes) {
		this.maixprictes = maixprictes;
	}

	public String getPartynumber() {
		return partynumber;
	}

	public void setPartynumber(String partynumber) {
		this.partynumber = partynumber;
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
		return "Area [Partyname=" + Partyname + ", crditprice=" + crditprice + ", size=" + size + ", maixcrdit="
				+ maixcrdit + ", maixprictes=" + maixprictes + ", partynumber=" + partynumber + "]";
	}

}

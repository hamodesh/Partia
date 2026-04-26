package entity;

public class concertsquare {

	private String nameArtist;
	private String Date;
	private String starthour;
	private String endhour;
	private String numbercon;
	private String Areanumber;

	public static final int MAX_ADDRESS = 60;
	public static final int MAX_CITY = 15;
	public static final int MAX_COUNTRY = 15;

	public concertsquare(String nameArtist, String date, String starthour, String endhour, String numbercon,
			String areanumber) {
		super();
		this.nameArtist = nameArtist;
		Date = date;
		this.starthour = starthour;
		this.endhour = endhour;
		this.numbercon = numbercon;
		Areanumber = areanumber;
	}

	public String getNameArtist() {
		return nameArtist;
	}

	public void setNameArtist(String nameArtist) {
		this.nameArtist = nameArtist;
	}

	public String getDate() {
		return Date;
	}

	public void setDate(String date) {
		Date = date;
	}

	public String getStarthour() {
		return starthour;
	}

	public void setStarthour(String starthour) {
		this.starthour = starthour;
	}

	public String getEndhour() {
		return endhour;
	}

	public void setEndhour(String endhour) {
		this.endhour = endhour;
	}

	public String getNumbercon() {
		return numbercon;
	}

	public void setNumbercon(String numbercon) {
		this.numbercon = numbercon;
	}

	public String getAreanumber() {
		return Areanumber;
	}

	public void setAreanumber(String areanumber) {
		Areanumber = areanumber;
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
		return "concertsquare [nameArtist=" + nameArtist + ", Date=" + Date + ", starthour=" + starthour + ", endhour="
				+ endhour + ", numbercon=" + numbercon + ", Areanumber=" + Areanumber + "]";
	}

}

package entity;

public class Artist {

	private String artistid;
	private String name;
	private String grade;

	public static final int MAX_ADDRESS = 60;
	public static final int MAX_CITY = 15;
	public static final int MAX_COUNTRY = 15;
	public Artist(String artistid, String name, String grade) {
		super();
		this.artistid = artistid;
		this.name = name;
		this.grade = grade;
	}
	public String getArtistid() {
		return artistid;
	}
	public void setArtistid(String artistid) {
		this.artistid = artistid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
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
		return "Artist [artistid=" + artistid + ", name=" + name + ", grade=" + grade + "]";
	}
	
	
}

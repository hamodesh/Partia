package entity;

public class Location {
	private String phonenumber;
	private String date;
	private String hour;
	private String Area;
	public Location(String phonenumber, String date, String hour, String area) {
		super();
		this.phonenumber = phonenumber;
		this.date = date;
		this.hour = hour;
		Area = area;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getHour() {
		return hour;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	
	
}

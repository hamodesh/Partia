package entity;

import java.util.Date;

public class Party {

	private Integer Partyid;
	private String Partyname;
	private Integer buildingnumber;
	private String City;	
	private String  namearea;
	private String Startdate;
	private String Enddate;
	private Integer Adress;

	
	public static final int MAX_ADDRESS = 60;
	public static final int MAX_CITY = 15;
	public static final int MAX_COUNTRY = 15;
	public Party(Integer partyid, String partyname, Integer buildingnumber, String city, String namearea,
			String startdate, String enddate, Integer adress) {
		super();
		Partyid = partyid;
		Partyname = partyname;
		this.buildingnumber = buildingnumber;
		City = city;
		this.namearea = namearea;
		Startdate = startdate;
		Enddate = enddate;
		Adress = adress;
	}
	public Integer getPartyid() {
		return Partyid;
	}
	public void setPartyid(Integer partyid) {
		Partyid = partyid;
	}
	public String getPartyname() {
		return Partyname;
	}
	public void setPartyname(String partyname) {
		Partyname = partyname;
	}
	public Integer getBuildingnumber() {
		return buildingnumber;
	}
	public void setBuildingnumber(Integer buildingnumber) {
		this.buildingnumber = buildingnumber;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getNamearea() {
		return namearea;
	}
	public void setNamearea(String namearea) {
		this.namearea = namearea;
	}
	public String getStartdate() {
		return Startdate;
	}
	public void setStartdate(String startdate) {
		Startdate = startdate;
	}
	public String getEnddate() {
		return Enddate;
	}
	public void setEnddate(String enddate) {
		Enddate = enddate;
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
		return "Party [Partyid=" + Partyid + ", Partyname=" + Partyname + ", buildingnumber=" + buildingnumber
				+ ", City=" + City + ", namearea=" + namearea + ", Startdate=" + Startdate + ", Enddate=" + Enddate
				+ ", Adress=" + Adress + "]";
	}
	
	
}

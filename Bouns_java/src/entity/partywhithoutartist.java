package entity;

public class partywhithoutartist {
	private String Partid;
	private String numberartist;
	private String partyname;
	private String Area;
	private String date;
	public partywhithoutartist(String partid, String numberartist, String partyname, String area, String date) {
		super();
		Partid = partid;
		this.numberartist = numberartist;
		this.partyname = partyname;
		Area = area;
		this.date = date;
	}
	public String getPartid() {
		return Partid;
	}
	public void setPartid(String partid) {
		Partid = partid;
	}
	public String getNumberartist() {
		return numberartist;
	}
	public void setNumberartist(String numberartist) {
		this.numberartist = numberartist;
	}
	public String getPartyname() {
		return partyname;
	}
	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	
	
}

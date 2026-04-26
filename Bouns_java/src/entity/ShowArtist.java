package entity;

public class ShowArtist {
	private String Date;
	private String startdate;
	private String enddate;
	private String location;
	private String proift;
	private Integer idArtist;
	private String idPraty;
	public ShowArtist(String date, String startdate, String enddate, String location, String proift, Integer idArtist,
			String idPraty) {
		super();
		Date = date;
		this.startdate = startdate;
		this.enddate = enddate;
		this.location = location;
		this.proift = proift;
		this.idArtist = idArtist;
		this.idPraty = idPraty;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getStartdate() {
		return startdate;
	}
	public void setStartdate(String startdate) {
		this.startdate = startdate;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProift() {
		return proift;
	}
	public void setProift(String proift) {
		this.proift = proift;
	}
	public Integer getIdArtist() {
		return idArtist;
	}
	public void setIdArtist(Integer idArtist) {
		this.idArtist = idArtist;
	}
	public String getIdPraty() {
		return idPraty;
	}
	public void setIdPraty(String idPraty) {
		this.idPraty = idPraty;
	}
	
	
	

}

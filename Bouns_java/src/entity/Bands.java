package entity;

public class Bands {
	private String name;
	private String Typemusic;
	private String bandsnumber;
	private String idparty;
	public Bands(String name, String typemusic, String bandsnumber, String idparty) {
		super();
		this.name = name;
		Typemusic = typemusic;
		this.bandsnumber = bandsnumber;
		this.idparty = idparty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTypemusic() {
		return Typemusic;
	}
	public void setTypemusic(String typemusic) {
		Typemusic = typemusic;
	}
	public String getBandsnumber() {
		return bandsnumber;
	}
	public void setBandsnumber(String bandsnumber) {
		this.bandsnumber = bandsnumber;
	}
	public String getIdparty() {
		return idparty;
	}
	public void setIdparty(String idparty) {
		this.idparty = idparty;
	}
	
	
}

package entity;

public class NewParty {

	private String partyname;
	private String Mounth;
	private String Adress;
	private String MusicType;	
	private String  NumberArtist;
	private String Area;
	public NewParty(String partyname, String mounth, String adress, String musicType, String numberArtist,
			String area) {
		super();
		this.partyname = partyname;
		Mounth = mounth;
		Adress = adress;
		MusicType = musicType;
		NumberArtist = numberArtist;
		Area = area;
	}
	public String getPartyname() {
		return partyname;
	}
	public void setPartyname(String partyname) {
		this.partyname = partyname;
	}
	public String getMounth() {
		return Mounth;
	}
	public void setMounth(String mounth) {
		Mounth = mounth;
	}
	
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public String getMusicType() {
		return MusicType;
	}
	public void setMusicType(String musicType) {
		MusicType = musicType;
	}
	public String getNumberArtist() {
		return NumberArtist;
	}
	public void setNumberArtist(String numberArtist) {
		NumberArtist = numberArtist;
	}
	public String getArea() {
		return Area;
	}
	public void setArea(String area) {
		Area = area;
	}
	
	
	
}

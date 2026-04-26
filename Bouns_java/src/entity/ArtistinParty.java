package entity;

public class ArtistinParty {
	private String idArtist;
	private String partynumber ;
	private String nameArtist;
	private String gendr;
	private String typemusic;
	private String grade;
	public ArtistinParty(String idArtist, String partynumber, String nameArtist, String gendr, String typemusic,
			String grade) {
		super();
		this.idArtist = idArtist;
		this.partynumber = partynumber;
		this.nameArtist = nameArtist;
		this.gendr = gendr;
		this.typemusic = typemusic;
		this.grade = grade;
	}
	public String getIdArtist() {
		return idArtist;
	}
	public void setIdArtist(String idArtist) {
		this.idArtist = idArtist;
	}
	public String getPartynumber() {
		return partynumber;
	}
	public void setPartynumber(String partynumber) {
		this.partynumber = partynumber;
	}
	public String getNameArtist() {
		return nameArtist;
	}
	public void setNameArtist(String nameArtist) {
		this.nameArtist = nameArtist;
	}
	public String getGendr() {
		return gendr;
	}
	public void setGendr(String gendr) {
		this.gendr = gendr;
	}
	public String getTypemusic() {
		return typemusic;
	}
	public void setTypemusic(String typemusic) {
		this.typemusic = typemusic;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	
	
	
}

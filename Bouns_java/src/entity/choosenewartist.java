package entity;

public class choosenewartist {
	private String name;
	private String gendr;
	private String typemusic;
	private String idparty;
	public choosenewartist(String name, String gendr, String typemusic, String idparty) {
		super();
		this.name = name;
		this.gendr = gendr;
		this.typemusic = typemusic;
		this.idparty = idparty;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getIdparty() {
		return idparty;
	}
	public void setIdparty(String idparty) {
		this.idparty = idparty;
	}
	
	
}

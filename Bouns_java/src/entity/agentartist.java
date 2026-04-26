package entity;

public class agentartist {
	private String artistid;
	private String agent;
	public agentartist(String artistid, String agent) {
		super();
		this.artistid = artistid;
		this.agent = agent;
	}
	public String getArtistid() {
		return artistid;
	}
	public void setArtistid(String artistid) {
		this.artistid = artistid;
	}
	public String getAgent() {
		return agent;
	}
	public void setAgent(String agent) {
		this.agent = agent;
	}
	@Override
	public String toString() {
		return "agentartist [artistid=" + artistid + ", agent=" + agent + "]";
	}
	
	
	
	
}

	
package control;

import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import java.sql.ResultSet;

import entity.Agent;
import entity.Area;
import entity.Artist;
import entity.ArtistinParty;
import entity.Bands;
import entity.Consts;
import entity.CustomerinParty;
import entity.Friends;
import entity.NewParty;
import entity.Order;
import entity.Party;
import entity.ShowArtist;
import entity.agentartist;
import entity.choosenewartist;
import entity.concertsquare;
import entity.partywhithoutartist;


public class FriendLogic {
	private static FriendLogic instance;
	
	private FriendLogic() {}
	
	public static FriendLogic getInstance() {
		if (instance == null)
			
			instance = new FriendLogic();
		return instance;
	}

public ArrayList<CustomerinParty> getCustomerinParty() {
	ArrayList<CustomerinParty> results = new ArrayList<CustomerinParty>();
	try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				PreparedStatement stmt = conn.prepareStatement(Consts.SELECT_ALL_CUSTOMERSINPARTY );
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int i = 1;
				results.add(new CustomerinParty(rs.getInt(i++),
						rs.getInt(i++), rs.getInt(i++)));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return results;
}

public ArrayList<Friends> getFreinds() {
	ArrayList<Friends> results = new ArrayList<Friends>();
	try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				PreparedStatement stmt = conn.prepareStatement(Consts.SELECT_ALL_FRIENDS);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int i = 1;
				results.add(new Friends(rs.getInt(i++),
						(rs.getInt(i++)), (rs.getInt(i++))));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return results;
}

public boolean removeEmployee(Integer phonenumber) {
	try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				CallableStatement stmt = conn.prepareCall(Consts.DELETE_FRIEND)) {
			
			stmt.setInt(1, phonenumber);
			stmt.executeUpdate();
			
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return false;
}


public ArrayList<Party> getParty() {
	ArrayList<Party> results = new ArrayList<Party>();
	try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				PreparedStatement stmt = conn.prepareStatement(Consts.SELECT_ALL_PARTYS);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int i = 1;
				results.add(new Party(rs.getInt(i++),
						(rs.getString(i++)), (rs.getInt(i++)),(rs.getString(i++)),(rs.getString(i++)),(rs.getString(i++)),(rs.getString(i++)),(rs.getInt(i++))));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return results;
}

public ArrayList<NewParty> getNewParty() {
	ArrayList<NewParty> results = new ArrayList<NewParty>();
	try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				PreparedStatement stmt = conn.prepareStatement(Consts.SELECT_ALL_NEWPARTYS);
				//PreparedStatement stmt2 = conn.prepareStatement(Consts.New_PARTY);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int i = 1;
				results.add(new NewParty(
						(rs.getString(i++)), (rs.getString(i++)),(rs.getString(i++)),(rs.getString(i++)),(rs.getString(i++)),(rs.getString(i++))));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return results;
}
public ArrayList<Order> getOrder() {
	ArrayList<Order> results = new ArrayList<Order>();
	try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				PreparedStatement stmt = conn.prepareStatement(Consts. SELECT_ALL_ORDER );
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int i = 1;
				results.add(new Order(rs.getString(i++),
						rs.getString(i++), rs.getString(i++),rs.getString(i++)));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return results;
}
public ArrayList<partywhithoutartist> getpartywhitoutartist() {
	ArrayList<partywhithoutartist> results = new ArrayList<partywhithoutartist>();
	try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				PreparedStatement stmt = conn.prepareStatement(Consts. SELECT_ALL_partywithoutArtist );
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int i = 1;
				results.add(new partywhithoutartist(rs.getString(i++),
						rs.getString(i++), rs.getString(i++),rs.getString(i++),rs.getString(i++)));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return results;
}

public ArrayList<choosenewartist> getchooseartisttartist() {
	ArrayList<choosenewartist> results = new ArrayList<choosenewartist>();
	try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				PreparedStatement stmt = conn.prepareStatement(Consts. SELECT_ALL_chooseArtist );
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int i = 1;
				results.add(new choosenewartist(rs.getString(i++),
						rs.getString(i++), rs.getString(i++),rs.getString(i++)));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return results;
}
public ArrayList<Bands> getbands() {
	ArrayList<Bands> results = new ArrayList<Bands>();
	try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				PreparedStatement stmt = conn.prepareStatement(Consts. SELECT_ALL_Bands  );
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int i = 1;
				results.add(new Bands(rs.getString(i++),
						rs.getString(i++), rs.getString(i++),rs.getString(i++)));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return results;
}


public ArrayList<ArtistinParty> getgradeartist() {
	ArrayList<ArtistinParty> results = new ArrayList<ArtistinParty>();
	try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				PreparedStatement stmt = conn.prepareStatement(Consts. SELECT_ALL_gradeartist   );
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int i = 1;
				results.add(new ArtistinParty(rs.getString(i++),
						rs.getString(i++), rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++)));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return results;
}

public ArrayList<Artist> getArtist() {
	ArrayList<Artist> results = new ArrayList<Artist>();
	try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				PreparedStatement stmt = conn.prepareStatement(Consts. SELECT_ALL_Artist  );
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int i = 1;
				results.add(new Artist(rs.getString(i++),
						rs.getString(i++), rs.getString(i++)));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return results;
}
public ArrayList<Agent> getAgent() {
	ArrayList<Agent> results = new ArrayList<Agent>();
	try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				PreparedStatement stmt = conn.prepareStatement(Consts. SELECT_ALL_Agent  );
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int i = 1;
				results.add(new Agent(rs.getString(i++),
						rs.getString(i++)));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return results;
}
public ArrayList<Area> getArea() {
	ArrayList<Area> results = new ArrayList<Area>();
	try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				PreparedStatement stmt = conn.prepareStatement(Consts. SELECT_ALL_AREA  );
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int i = 1;
				results.add(new Area(rs.getString(i++),
						rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++)));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return results;
}
public ArrayList<concertsquare> getconcertsquare() {
	ArrayList<concertsquare> results = new ArrayList<concertsquare>();
	try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				PreparedStatement stmt = conn.prepareStatement(Consts. SELECT_ALL_concertsquare  );
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int i = 1;
				results.add(new concertsquare(rs.getString(i++),
						rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getString(i++)));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return results;
}

public ArrayList<agentartist> getagentartist() {
	ArrayList<agentartist> results = new ArrayList<agentartist>();
	try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				PreparedStatement stmt = conn.prepareStatement(Consts. SELECT_ALL_AgentArtist  );
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int i = 1;
				results.add(new agentartist(rs.getString(i++),
						rs.getString(i++)));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return results;
}
public ArrayList<ShowArtist> getShowArtist() {
	ArrayList<ShowArtist> results = new ArrayList<ShowArtist>();
	try {
		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
		try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
				PreparedStatement stmt = conn.prepareStatement(Consts. SELECT_ALL_Rpt );
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				int i = 1;
				results.add(new ShowArtist(rs.getString(i++),
						rs.getString(i++), rs.getString(i++),rs.getString(i++),rs.getString(i++),rs.getInt(i++),rs.getString(i++)));
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	return results;
}
}
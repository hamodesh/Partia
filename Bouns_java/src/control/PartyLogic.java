package control;

import java.io.File;




import java.io.FileReader;
import java.sql.CallableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;

import entity.Area;
import entity.Artist;
import entity.ArtistinParty;
import entity.Consts;

import entity.Consts.Manipulation;
import entity.Consts.Manipulation2;
import entity.Consts.Manipulation3;
import entity.Consts.Manipulation4;

import entity.Party;
import entity.concertsquare;
import entity.Location;

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

public class PartyLogic {
	private static PartyLogic _instance;

	private PartyLogic() {
	}

	public static PartyLogic getInstance() {
		if (_instance == null)
			_instance = new PartyLogic();
		return _instance;
	}
	///////////////////// All////////////////////////////////////

	public void importPartysJSON(String path) {
		try (FileReader reader = new FileReader(new File(path))) {
			JsonObject doc = (JsonObject) Jsoner.deserialize(reader);
			JsonArray partyArray = (JsonArray) doc.get("Partys_info");

			int errors = 0;
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			Iterator<Object> iterator = partyArray.iterator();
			while (iterator.hasNext()) {
				JsonObject partyObj = (JsonObject) iterator.next();
				Party party = new Party(Integer.parseInt((String) partyObj.get("Partyid")),
						(String) partyObj.get("Partyname"), Integer.parseInt((String) partyObj.get("buildingnumber")),
						(String) partyObj.get("City"), (String) partyObj.get("namearea"),
						(String) partyObj.get("Startdate"), (String) partyObj.get("Enddate"),
						Integer.parseInt((String) partyObj.get("Adress")));

				if (!manipulateParry(party, Manipulation.INSERT) && !manipulateParry(party, Manipulation.UPDATE))
					errors++;

				JsonObject areaObj = (JsonObject) partyObj.get("Area");
				Area area = new Area((String) areaObj.get("partynumber"), (String) areaObj.get("Partyname"),
						(String) areaObj.get("crditprice"), (String) areaObj.get("size"),
						(String) areaObj.get("maixcrdit"), (String) areaObj.get("maixprictes"));

				if (!manipulateParry2(area, Manipulation2.INSERT) && !manipulateParry2(area, Manipulation2.UPDATE))
					errors++;

				JsonObject concertSquareObj = (JsonObject) areaObj.get("concertsquare");
				concertsquare concertSquare = new concertsquare((String) concertSquareObj.get("nameArtist"),
						(String) concertSquareObj.get("Date"), (String) concertSquareObj.get("starthour"),
						(String) concertSquareObj.get("endhour"), (String) concertSquareObj.get("numbercon"),
						(String) concertSquareObj.get("Areanumber"));

				if (!manipulateParry3(concertSquare, Manipulation3.INSERT)
						&& !manipulateParry3(concertSquare, Manipulation3.UPDATE))
					errors++;

				
			  JsonObject ArtistObj = (JsonObject) concertSquareObj.get("Artist"); 
				  Artist artist = new Artist(
						  (String) ArtistObj.get("artistid")
						   ,(String) ArtistObj.get("name")
						   ,(String) ArtistObj.get("grade")
						   );
				  
				  if (!manipulateParry4(artist, Manipulation4.INSERT) &&
				  !manipulateParry4(artist, Manipulation4.UPDATE)) errors++;
				
			}

			System.out.println((errors == 0) ? "Partys data imported successfully!"
					: String.format("Partys data imported with %d errors!", errors));
		} catch (IOException | DeserializationException e) {
			e.printStackTrace();
		}
	}

	public boolean manipulateParry(Party c, Manipulation manipulation) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall((manipulation.equals(Manipulation.UPDATE))
							? Consts.UPDATE_PARTY
							: (manipulation.equals(Manipulation.INSERT)) ? Consts.INSERT_PARTY : Consts.DELETE_PARTY)) {
				allocatePartyParams(stmt, c, manipulation);
				stmt.executeUpdate();
				return true;
			} catch (SQLException e) {
				// e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		}

		return false;
	}

	///////// Party//////////////

	private void allocatePartyParams(CallableStatement stmt, Party party, Manipulation manipulation)
			throws SQLException {
		int i = 1;

		if (!manipulation.equals(Manipulation.UPDATE)) {
			stmt.setInt(i++, party.getPartyid());

			if (manipulation.equals(Manipulation.DELETE))
				return;
		}

		if (party.getPartyname() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setString(i++, party.getPartyname());

		if (party.getBuildingnumber() == null)
			stmt.setNull(i++, java.sql.Types.INTEGER);
		else
			stmt.setInt(i++, party.getBuildingnumber());

		if (party.getCity() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setString(i++, party.getCity());

		if (party.getNamearea() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setString(i++, party.getNamearea());

		if (party.getStartdate() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setString(i++, party.getStartdate());

		if (party.getEnddate() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setString(i++, party.getEnddate());

		if (party.getAdress() == null)
			stmt.setNull(i++, java.sql.Types.INTEGER);
		else
			stmt.setInt(i++, party.getAdress());

		if (manipulation.equals(Manipulation.UPDATE))
			stmt.setInt(i, party.getPartyid());
	}

////////////////Area//////////////////
	public boolean manipulateParry2(Area c, Manipulation2 manipulation) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn.prepareCall((manipulation.equals(Manipulation2.UPDATE))
							? Consts.UPDATE_AREA
							: (manipulation.equals(Manipulation2.INSERT)) ? Consts.INSERT_AREA : Consts.DELETE_AREA)) {
				allocatePartyParams2(stmt, c, manipulation);
				stmt.executeUpdate();
				return true;
			} catch (SQLException e) {
				// e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// e.printStackTrace();
		}

		return false;
	}

	private void allocatePartyParams2(CallableStatement stmt, Area party, Manipulation2 manipulation)
			throws SQLException {
		int i = 1;

		if (!manipulation.equals(Manipulation2.UPDATE)) {
			stmt.setString(i++, party.getPartynumber());

			if (manipulation.equals(Manipulation2.DELETE))
				return;
		}

		if (party.getPartyname() == null)
			stmt.setNull(i++, java.sql.Types.INTEGER);
		else
			stmt.setString(i++, party.getPartyname());

		if (party.getCrditprice() == null)
			stmt.setNull(i++, java.sql.Types.INTEGER);
		else
			stmt.setString(i++, party.getCrditprice());

		if (party.getSize() == null)
			stmt.setNull(i++, java.sql.Types.INTEGER);
		else
			stmt.setString(i++, party.getSize());

		if (party.getMaixcrdit() == null)
			stmt.setNull(i++, java.sql.Types.INTEGER);
		else
			stmt.setString(i++, party.getMaixcrdit());

		if (party.getMaixprictes() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setString(i++, party.getMaixprictes());
		if (manipulation.equals(Manipulation2.UPDATE))
			stmt.setString(i, party.getPartynumber());

	}

	//////////////// ConcertSquare/////////////////////

	public boolean manipulateParry3(concertsquare c, Manipulation3 manipulation) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn
							.prepareCall((manipulation.equals(Manipulation3.UPDATE)) ? Consts.UPDATE_concertsquare
									: (manipulation.equals(Manipulation3.INSERT)) ? Consts.INSERT_concertsquare
											: Consts.DELETE_concertsquare)) {
				allocatePartyParams3(stmt, c, manipulation);
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

	private void allocatePartyParams3(CallableStatement stmt, concertsquare party, Manipulation3 manipulation)
			throws SQLException {
		int i = 1;

		if (!manipulation.equals(Manipulation3.UPDATE)) {
			stmt.setString(i++, party.getNumbercon());
			if (manipulation.equals(Manipulation3.DELETE))
				return;

		}

		if (party.getNameArtist() == null)
			stmt.setNull(i++, java.sql.Types.INTEGER);
		else
			stmt.setString(i++, party.getNameArtist());

		if (party.getDate() == null)
			stmt.setNull(i++, java.sql.Types.INTEGER);
		else
			stmt.setString(i++, party.getDate());

		if (party.getStarthour() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setString(i++, party.getStarthour());
		if (party.getEndhour() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setString(i++, party.getEndhour());

		if (party.getAreanumber() == null)
			stmt.setNull(i++, java.sql.Types.VARCHAR);
		else
			stmt.setString(i++, party.getAreanumber());
		if (manipulation.equals(Manipulation3.UPDATE))
			stmt.setString(i, party.getNumbercon());

	}

	////////////// Artist/////////////
	public boolean manipulateParry4(Artist c, Manipulation4 manipulation) {

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn
							.prepareCall((manipulation.equals(Manipulation4.UPDATE)) ? Consts.UPDATE_Artist
									: (manipulation.equals(Manipulation4.INSERT)) ? Consts.INSERT_Artist
											: Consts.DELETE_Artist)) {
				allocatePartyParams4(stmt, c, manipulation);
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

	private void allocatePartyParams4(CallableStatement stmt, Artist party, Manipulation4 manipulation)
			throws SQLException {

		int i = 1;

		if (!manipulation.equals(Manipulation3.UPDATE)) {
			stmt.setString(i++, party.getArtistid());
			if (manipulation.equals(Manipulation3.DELETE))
				return;

		}

		if (party.getName() == null)
			stmt.setNull(i++, java.sql.Types.INTEGER);
		else
			stmt.setString(i++, party.getName());

		if (party.getGrade() == null)
			stmt.setNull(i++, java.sql.Types.INTEGER);
		else
			stmt.setString(i++, party.getGrade());

		if (manipulation.equals(Manipulation3.UPDATE))
			stmt.setString(i, party.getArtistid());

	}
	
	//////grade Artist//////////
	
	public void importgradeArtistJSON(String path) {
		try (FileReader reader = new FileReader(new File(path))) {
			JsonObject doc = (JsonObject) Jsoner.deserialize(reader);
			JsonArray partyArray = (JsonArray) doc.get("Artist_info");

			int errors = 0;
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

			Iterator<Object> iterator = partyArray.iterator();
			while (iterator.hasNext()) {
				JsonObject partyObj = (JsonObject) iterator.next();
				ArtistinParty party = new ArtistinParty((String) partyObj.get("idArtist"),
						(String) partyObj.get("partynumber"), (String) partyObj.get("nameArtist"),
						(String) partyObj.get("gendr"), (String) partyObj.get("typemusic"),
						 (String) partyObj.get("grade")
						);

				if (!manipulateParry5(party, Manipulation4.INSERT) && !manipulateParry5(party, Manipulation4.UPDATE))
					errors++;

				
				
			 
				
			}

			System.out.println((errors == 0) ? "Artist data imported successfully!"
					: String.format("Artist data imported with %d errors!", errors));
		} catch (IOException | DeserializationException e) {
			e.printStackTrace();
		}
	}

	
	
	
	
	public boolean manipulateParry5(ArtistinParty c, Manipulation4 manipulation) {

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					CallableStatement stmt = conn
							.prepareCall((manipulation.equals(Manipulation4.UPDATE)) ? Consts. UPDATE_gradeartist
									: (manipulation.equals(Manipulation4.INSERT)) ? Consts.INSERT_gradeartist
											: Consts.DELETE_gradeartist )) {
				allocatePartyParams4(stmt, c, manipulation);
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

	private void allocatePartyParams4(CallableStatement stmt, ArtistinParty party, Manipulation4 manipulation)
			throws SQLException {

		int i = 1;

		if (!manipulation.equals(Manipulation4.UPDATE)) {
			stmt.setString(i++, party.getIdArtist());
			if (manipulation.equals(Manipulation4.DELETE))
				return;

		}

		if (party.getPartynumber() == null)
			stmt.setNull(i++, java.sql.Types.INTEGER);
		else
			stmt.setString(i++, party.getPartynumber());

		if (party.getNameArtist() == null)
			stmt.setNull(i++, java.sql.Types.INTEGER);
		else
			stmt.setString(i++, party.getNameArtist());
		
		
		if (party.getGendr() == null)
			stmt.setNull(i++, java.sql.Types.INTEGER);
		else
			stmt.setString(i++, party.getGendr());
		if (party.getTypemusic() == null)
			stmt.setNull(i++, java.sql.Types.INTEGER);
		else
			stmt.setString(i++, party.getTypemusic());
		if (party.getGrade() == null)
			stmt.setNull(i++, java.sql.Types.INTEGER);
		else
			stmt.setString(i++, party.getGrade());

		if (manipulation.equals(Manipulation4.UPDATE))
			stmt.setString(i, party.getIdArtist());

	}
	

	/////////Export json party////////
	
	
	/*public void exportCustomersToJSON() {
 	   try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
                    PreparedStatement stmt = conn.prepareStatement(
                            Consts.SELECT_ALL_PARTYS );
                    ResultSet rs = stmt.executeQuery()) {
         	   JsonArray customers = new JsonArray();
                while (rs.next()) {
             	   JsonObject customer = new JsonObject();
             	   
             	   for (int i = 1; i < rs.getMetaData().getColumnCount(); i++)
             		   customer.put(rs.getMetaData().getColumnName(i), rs.getString(i));
             	   
             	   customers.add(customer);
                }
                
         	   JsonObject doc = new JsonObject();
         	   doc.put("Partys_info", customers);
                
                File file = new File("json/ExportPartys.json");
                file.getParentFile().mkdir();
                
                try (FileWriter writer = new FileWriter(file)) {
             	   writer.write(Jsoner.prettyPrint(doc.toJson()));
             	   writer.flush();
                    System.out.println("Partys data exported successfully!");
                } catch (IOException e) {
             	   e.printStackTrace();
                }
            } catch (SQLException | NullPointerException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }	
 }*/
	
	
	public void exportPartytsToJSON() {
 	   try {
 		   
             ArrayList<Party> flights = FriendLogic.getInstance().getParty();
             JsonArray data = new JsonArray();
             for(int i=0; i<flights.size(); i++) {
             	JsonObject flight = new JsonObject();
             	flight.put("Partyid", flights.get(i).getPartyid()); 
             	flight.put("Partyname", flights.get(i).getPartyname());    
             	flight.put("buildingnumber", flights.get(i).getBuildingnumber()); 
             	flight.put("City", flights.get(i).getCity());  
             	flight.put("namearea", flights.get(i).getNamearea());  
             	flight.put("Startdate", flights.get(i).getStartdate());  
             	flight.put("Enddate", flights.get(i).getEnddate());
 				flight.put("Adress", flights.get(i).getAdress());
 			
 				
             	JsonArray seats = new JsonArray();
             	ArrayList<Area> seatList =FriendLogic.getInstance().getArea();
             	for(int j=0; j<seatList.size(); j++) {
             		
             		JsonObject seat = new JsonObject();
             		seat.put("partynumber", seatList.get(j).getPartynumber());
             		seat.put("Partyname", seatList.get(j).getPartyname());
             		seat.put("crditprice", seatList.get(j).getCrditprice());
             		seat.put("size", seatList.get(j).getSize());
             		seat.put("maixcrdit", seatList.get(j).getMaixcrdit());
             		seat.put("maixprictes", seatList.get(j).getMaixprictes());
             		seats.add(seat);
             		
             	}
             	
             	
             	JsonArray seats22 = new JsonArray();
             	ArrayList<concertsquare> seatList2 =FriendLogic.getInstance().getconcertsquare();
             	for(int j=0; j<seatList2.size(); j++) {
             		
             		JsonObject seat2 = new JsonObject();
             		seat2.put("nameArtist", seatList2.get(j).getNameArtist());
             		seat2.put("Date", seatList2.get(j).getDate());
             		seat2.put("starthour", seatList2.get(j).getStarthour());
             		seat2.put("Endhour", seatList2.get(j).getEndhour());
             		seat2.put("numbercon", seatList2.get(j).getNumbercon());
             		seat2.put("Areanumber", seatList2.get(j).getAreanumber());
             		seats22.add(seat2);
             		
             	}
             	
             	JsonArray seats33 = new JsonArray();
             	ArrayList<Artist> seatList3 =FriendLogic.getInstance().getArtist();
             	for(int j=0; j<seatList3.size(); j++) {
             		
             		
             		JsonObject seat3 = new JsonObject();
             		seat3.put("artistid", seatList3.get(j).getArtistid());
             		seat3.put("name", seatList3.get(j).getName());
             		seat3.put("grade", seatList3.get(j).getGrade());
             		seats33.add(seat3);
             		
             	}
             	
           
            	data.add(flight);
             	seats22.add(seats33);
             	seats.add(seats22);
             	
            	
                    	
             	flight.put("Area", seats);
             	
             	data.add(flight);
             	
              }
             
         	 JsonObject doc = new JsonObject();
 		   	 doc.put("flights", data);
 		   	 
              File file = new File("json/ExportPartys.json");
              file.getParentFile().mkdir();
                
              try (FileWriter writer = new FileWriter(file)) {
             	  writer.write(Jsoner.prettyPrint(doc.toJson()));
             	  writer.flush();
             	 System.out.println("Partys data Export successfully!");  
              } catch (IOException e) {
             	   e.printStackTrace();
              }
        } catch (Exception e) {
            e.printStackTrace();
        }	
 }
	
	

}

package entity;

import java.net.URLDecoder;

// http://www.javapractices.com/topic/TopicAction.do?Id=2
public final class Consts {

	private Consts() {
		throw new AssertionError();
	}

	//public static final String CONN_STR = "jdbc:ucanaccess://src/entity/DataBasebouns.accdb;COLUMNORDER=DISPLAY";
	protected static final String DB_FILEPATH = getDBPath();

	public static final String CONN_STR = "jdbc:ucanaccess://" + DB_FILEPATH + ";COLUMNORDER=DISPLAY";
	public static final String JDBC_STR = "net.ucanaccess.jdbc.UcanaccessDriver";
	public enum Manipulation {
		UPDATE, INSERT, DELETE;
	}

	public enum Manipulation2 {
		UPDATE, INSERT, DELETE;
	}

	public enum Manipulation3 {
		UPDATE, INSERT, DELETE;
	}
	public enum Manipulation4 {
		UPDATE, INSERT, DELETE;
	}
	/*----------------------------------------- Partys QUERIES -----------------------------------------*/

	public static final String SELECT_ALL_PARTYS = "SELECT * FROM TblPartys";
	public static final String SELECT_ALL_NEWPARTYS = "SELECT * FROM NewParty";
	public static final String INSERT_PARTY = "{ call AddParty(?,?,?,?,?,?,?,?); }";
	public static final String UPDATE_PARTY = "{ call updateparty(?,?,?,?,?,?,?,?); }";
	public static final String DELETE_PARTY = "{ call DeleteParty(?); }";
	public static final String New_PARTY = "{ call ReportNewParty(?,?,?,?,?,?); }";
	
	public static final String SELECT_ALL_AREA = "SELECT * FROM Areas";
	public static final String UPDATE_AREA = "{ call updatArea(?,?,?,?,?,?); }";
	public static final String INSERT_AREA = "{ call AddArea(?,?,?,?,?,?); }";
	public static final String DELETE_AREA = "{ call DeleteArea(?); }";

	public static final String UPDATE_concertsquare = "{ call updatconcertsquare(?,?,?,?,?,?); }";
	public static final String INSERT_concertsquare = "{ call Addconcertsquare(?,?,?,?,?,?); }";
	public static final String DELETE_concertsquare = "{ call Deleteconcertsquare(?); }";
	public static final String SELECT_ALL_concertsquare = "SELECT * FROM concertsquare";

	public static final String UPDATE_Artist = "{ call updaArtist(?,?,?); }";
	public static final String INSERT_Artist= "{ call AddArtist(?,?,?); }";
	public static final String DELETE_Artist = "{ call DeleteArtist(?); }";
	public static final String SELECT_ALL_Artist = "SELECT * FROM Artist";
	
	
	public static final String UPDATE_LOCATION = "{ call updatLocation(?,?,?,?); }";
	public static final String INSERT_LOCATION= "{ call AddLocation(?,?,?,?); }";
	
	public static final String INSERT_ORDER= "{ call Addorder(?,?,?,?); }";
	public static final String SELECT_ALL_ORDER = "SELECT * FROM Tblorder";
	
	public static final String SELECT_ALL_partywithoutArtist = "SELECT * FROM partywithoutArtist";
	
	public static final String INSERT_chooseArtist = "{ call AddNewArtist(?,?,?,?,?,?,?); }";
	public static final String SELECT_ALL_chooseArtist = "SELECT * FROM chooseArtist";
	public static final String DELETE_choosenartist= "DELETE FROM TblReportShowjsper WHERE idparty  = ? ";

	public static final String INSERT_Bands = "{ call AddBands(?,?,?,?); }";
	public static final String SELECT_ALL_Bands = "SELECT * FROM Bands";
	
	public static final String INSERT_gradeartist = "{ call AddGradeArtist(?,?,?,?,?,?); }";
	public static final String UPDATE_gradeartist = "{ call updatGradeArtist(?,?,?,?,?,?); }";
	public static final String DELETE_gradeartist = "{ call DeleteGradeArtist(?); }";
	
	public static final String SELECT_ALL_gradeartist = "SELECT * FROM ArtistinParty";
	public static final String SELECT_ALL_Agent = "SELECT * FROM Agent";
	public static final String SELECT_ALL_AgentArtist = "SELECT * FROM AgentArtist";
	
	
	public static final String UPDATE_agentartist = "{ call Addagentartist(?,?); }";
	public static final String DELETE_agentartist= "DELETE FROM AgentArtist WHERE artistid = ? ";
	
	
	
	public static final String UPDATE_NEWORDER = "{ call UpdatNewOrder(?,?,?,?); }";
	public static final String INSERT_NEWORDER = "{ call AddNeworder(?,?,?,?); }";
	
	public static final String SELECT_ALL_Rpt = "SELECT * FROM TblReportShowjsper";

	/*----------------------------------------- Friends QUERIES -----------------------------------------*/

	public static final String SELECT_ALL_CUSTOMERSINPARTY = "SELECT * FROM TblCustomerinParty";
	public static final String SELECT_ALL_FRIENDS = "SELECT * FROM TblFreinds";
	public static final String INSERT_FRIEND = "{ call AddFreinds(?,?,?); }";
	public static final String DELETE_FRIEND = "DELETE FROM TblFreinds WHERE phonenumber = ?";

	private static String getDBPath() {
		try {
			String path = Consts.class.getProtectionDomain().getCodeSource().getLocation().getPath();
			String decoded = URLDecoder.decode(path, "UTF-8");
			// System.out.println(decoded) - Can help to check the returned path
			if (decoded.contains(".jar")) {
				decoded = decoded.substring(0, decoded.lastIndexOf('/'));
				return decoded + "/boundary/DataBasebouns.accdb";
			} else {
				decoded = decoded.substring(0, decoded.lastIndexOf("bin/"));
				System.out.println(decoded);
				return decoded + "/src/entity/DataBasebouns.accdb";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

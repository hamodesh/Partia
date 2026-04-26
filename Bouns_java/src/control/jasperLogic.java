package control;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import javax.swing.JFrame;
import entity.Consts;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;

/**
 * Customer Orders Report controller.
 */
public class jasperLogic {
	/** Singleton instance. */
	private static jasperLogic instance;

	/**
	 * private constructor for singleton purposes.
	 */
	private jasperLogic() {
	}

	/**
	 * Singleton getter.
	 * 
	 * @return instance of this.
	 */
	public static jasperLogic getInstance() {
		if (instance == null)
			instance = new jasperLogic();
		return instance;
	}

	public JFrame compileProductOrdersByCountryReport(int productID, String productName) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR)) {
				HashMap<String, Object> params = new HashMap<>();
				params.put("p1", productID);

				params.put("productName", productName);

				JasperPrint print = JasperFillManager
						.fillReport(getClass().getResourceAsStream("/boundary/RptArtistShow.jasper"), params, conn);
				JFrame frame = new JFrame("Product " + productName + "'s Orders By Country");
				frame.getContentPane().add(new JRViewer(print));
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.pack();
				return frame;
			} catch (SQLException | JRException | NullPointerException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	public JFrame rptPartMounth(String productID) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR)) {
				HashMap<String, Object> params = new HashMap<>();
				params.put("p1", productID);

				JasperPrint print = JasperFillManager
						.fillReport(getClass().getResourceAsStream("/boundary/RptPartyMonuth.jasper"), params, conn);
				JFrame frame = new JFrame("Party Mounth Report");
				frame.getContentPane().add(new JRViewer(print));
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.pack();
				return frame;
			} catch (SQLException | JRException | NullPointerException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	
	public JFrame rptPartMounth2(String agentname,String productName) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR)) {
				
				HashMap<String, Object> params = new HashMap<>();
				params.put("p1", agentname);

				params.put("p2", productName);

				JasperPrint print = JasperFillManager
						.fillReport(getClass().getResourceAsStream("/boundary/RptAgent.jasper"), params, conn);
				JFrame frame = new JFrame("Product " + productName + "'s Orders By Country");
				frame.getContentPane().add(new JRViewer(print));
				frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
				frame.pack();
				return frame;
				
			
			} catch (SQLException | JRException | NullPointerException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return null;
	}

	
}

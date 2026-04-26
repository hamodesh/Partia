package control;

import java.io.File;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.soap.Node;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import entity.Consts;
import entity.Location;
import entity.NewOrder;
import entity.Consts.Manipulation;


public class XmlLogic {
	
	private static XmlLogic _instance;

	private XmlLogic() {
	}

	public static XmlLogic getInstance() {
		if (_instance == null)
			_instance = new XmlLogic();
		return _instance;
	}
	
	 public void exportCustomersToXML() {
	        try {
	            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	            try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
	                    PreparedStatement stmt = conn.prepareStatement(
	                            Consts.SELECT_ALL_ORDER);
	                    ResultSet rs = stmt.executeQuery()) {
	                
	                // create document object.
	                Document doc = DocumentBuilderFactory.newInstance()
	                        .newDocumentBuilder().newDocument();
	                
	                // push root element into document object.
	                Element rootElement = doc.createElement("Customers_info");
	                rootElement.setAttribute("exportDate", LocalDateTime.now().toString());
	                doc.appendChild(rootElement);
	                
	                while (rs.next()) {     // run on all customer records..
	                    // create customer element.
	                    Element customer = doc.createElement("Customer");
	                    
	                    // assign key to customer.
	                    Attr attr = doc.createAttribute("ID");
	                    attr.setValue(rs.getString(1));
	                    customer.setAttributeNode(attr);
	                    
	                    // push elements to customer.
	                    for (int i = 2; i <= rs.getMetaData().getColumnCount(); i++) {
	                        Element element = doc.createElement(
	                                rs.getMetaData().getColumnName(i)); // push element to doc.
	                        rs.getObject(i); // for wasNull() check..
	                        element.appendChild(doc.createTextNode(
	                                rs.wasNull() ? "" : rs.getString(i)));  // set element value.
	                        customer.appendChild(element);  // push element to customer.
	                    }
	                    
	                    // push customer to document's root element.
	                    rootElement.appendChild(customer);
	                }
	                
	                // write the content into xml file
	                
	                DOMSource source = new DOMSource(doc);
	                File file = new File("xml/customers2.xml");
	                file.getParentFile().mkdir(); // create xml folder if doesn't exist.
	                StreamResult result = new StreamResult(file);
	                TransformerFactory factory = TransformerFactory.newInstance();
	                
	                // IF CAUSES ISSUES, COMMENT THIS LINE.
	                //factory.setAttribute("indent-number", 2);
	                //
	                
	                Transformer transformer = factory.newTransformer();
	                
	                // IF CAUSES ISSUES, COMMENT THESE 2 LINES.
	                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
	                transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
	                //
	                
	                transformer.transform(source, result);
	                
	                System.out.println("Order data exported successfully!");
	            } catch (SQLException | NullPointerException | ParserConfigurationException
	                    | TransformerException e) {
	                e.printStackTrace();
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
	    }
	
	 public  void importCustomersFromXML(String path) {
	    	try {
				Document doc = DocumentBuilderFactory.newInstance()
									.newDocumentBuilder().parse(new File(path));
				doc.getDocumentElement().normalize();
				NodeList nl = doc.getElementsByTagName("Customers_info");
				
				int errors = 0;
				for (int i = 0; i < nl.getLength(); i++) {
					if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {			
						Element el = (Element) nl.item(i);
						Location c = new Location( 
								el.getElementsByTagName("Phonenumber").item(0).getTextContent(),
								el.getElementsByTagName("Date").item(0).getTextContent(),
								el.getElementsByTagName("hour").item(0).getTextContent(),
								el.getElementsByTagName("AreaParty").item(0).getTextContent());
						if (!manipulateCustomer(c, Manipulation.INSERT) && !manipulateCustomer(c, Manipulation.UPDATE))
							errors++;
					}}
				
				
				System.out.println((errors == 0) ? "Location data imported successfully!" : 
					String.format("Location data imported with %d errors!", errors));
				
			} catch (SAXException | IOException | ParserConfigurationException e) {
				e.printStackTrace();
			}
	    }
	 
	 public  boolean manipulateCustomer(Location c, Manipulation manipulation) {
	    	try {
	    		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	    		try (Connection conn = DriverManager.getConnection(entity.Consts.CONN_STR);
	    				CallableStatement stmt = conn.prepareCall(
	    						(manipulation.equals(Manipulation.UPDATE)) ? 
	    								Consts.UPDATE_LOCATION : 
	    									(manipulation.equals(Manipulation.INSERT)) ? 
	    											Consts.INSERT_LOCATION  : 
	    												Consts.DELETE_AREA)) {
	    			allocateCustomerParams(stmt, c, manipulation);
	    			stmt.executeUpdate();
	    			return true;
	    		} catch (SQLException e) {
//	    			e.printStackTrace();
	    		}
	    	} catch (ClassNotFoundException e) {
//	    		e.printStackTrace();
	    	}
	    	
	    	return false;
	    }
	    
	    /**
	     * fills statement's placeholders with customer's field values.
	     * @param stmt statement object.
	     * @param c customer.
	     * @param m manipulation type.
	     * @throws SQLException
	     */
	    private  void allocateCustomerParams(CallableStatement stmt, Location c, Manipulation m) throws SQLException {
	    	int i = 1;
	    	
	    	if (!m.equals(Manipulation.UPDATE)) {
	    		stmt.setString(i++, c.getPhonenumber());
	    		
	    		if (m.equals(Manipulation.DELETE))
	    			return;
	    	}
	    	
	    	
	    	
	    	if (c.getDate() == null)
	    		stmt.setNull(i++, java.sql.Types.VARCHAR);
	    	else
	    		stmt.setString(i++, c.getDate());
	    	
	    	if (c.getHour() == null)
	    		stmt.setNull(i++, java.sql.Types.VARCHAR);
	    	else
	    		stmt.setString(i++, c.getHour());
	    	
	    	if (c.getArea() == null)
	    		stmt.setNull(i++, java.sql.Types.VARCHAR);
	    	else
	    		stmt.setString(i++, c.getArea());
	    	
	    	
	    	if (m.equals(Manipulation.UPDATE))
	    		stmt.setString(i, c.getPhonenumber());
	    }
	    
	    
	    
	    
	    
	    
	    public  void importCustomersFromXML1(String path) {
	    	try {
				Document doc = DocumentBuilderFactory.newInstance()
									.newDocumentBuilder().parse(new File(path));
				doc.getDocumentElement().normalize();
				NodeList nl = doc.getElementsByTagName("Customers_info");
				
				int errors = 0;
				for (int i = 0; i < nl.getLength(); i++) {
					if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {			
						Element el = (Element) nl.item(i);
						NewOrder c1 = new NewOrder( 
								el.getElementsByTagName("Customer").item(0).getTextContent(),
								el.getElementsByTagName("idparty").item(0).getTextContent(),
								el.getElementsByTagName("crditnumber").item(0).getTextContent(),
								el.getElementsByTagName("age").item(0).getTextContent());
						if (!manipulateCustomer1(c1, Manipulation.INSERT) && !manipulateCustomer1(c1, Manipulation.UPDATE))
							errors++;
					}}
				
				
				System.out.println((errors == 0) ? "New Order data imported successfully!" : 
					String.format("New Order data imported with %d errors!", errors));
				
			} catch (SAXException | IOException | ParserConfigurationException e) {
				e.printStackTrace();
			}
	    }
	 
	 public  boolean manipulateCustomer1(NewOrder c, Manipulation manipulation) {
	    	try {
	    		Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
	    		try (Connection conn = DriverManager.getConnection(entity.Consts.CONN_STR);
	    				CallableStatement stmt = conn.prepareCall(
	    						(manipulation.equals(Manipulation.UPDATE)) ? 
	    								Consts.UPDATE_NEWORDER: 
	    									(manipulation.equals(Manipulation.INSERT)) ? 
	    											Consts.INSERT_NEWORDER : 
	    												Consts.DELETE_AREA)) {
	    			allocateCustomerParams1(stmt, c, manipulation);
	    			stmt.executeUpdate();
	    			return true;
	    		} catch (SQLException e) {
//	    			e.printStackTrace();
	    		}
	    	} catch (ClassNotFoundException e) {
//	    		e.printStackTrace();
	    	}
	    	
	    	return false;
	    }
	    
	    /**
	     * fills statement's placeholders with customer's field values.
	     * @param stmt statement object.
	     * @param c customer.
	     * @param m manipulation type.
	     * @throws SQLException
	     */
	    private  void allocateCustomerParams1(CallableStatement stmt, NewOrder c, Manipulation m) throws SQLException {
	    	int i = 1;
	    	
	    	if (!m.equals(Manipulation.UPDATE)) {
	    		stmt.setString(i++, c.getIdNumber());
	    		
	    		if (m.equals(Manipulation.DELETE))
	    			return;
	    	}
	    	
	    	
	    	
	    	if (c.getPartyNumber() == null)
	    		stmt.setNull(i++, java.sql.Types.VARCHAR);
	    	else
	    		stmt.setString(i++, c.getPartyNumber());
	    	
	    	if (c.getCrditcart() == null)
	    		stmt.setNull(i++, java.sql.Types.VARCHAR);
	    	else
	    		stmt.setString(i++, c.getCrditcart() );
	    	
	    	if (c.getAge() == null)
	    		stmt.setNull(i++, java.sql.Types.VARCHAR);
	    	else
	    		stmt.setString(i++, c.getAge());
	    	
	    	
	    	if (m.equals(Manipulation.UPDATE))
	    		stmt.setString(i, c.getIdNumber());
	    }
}

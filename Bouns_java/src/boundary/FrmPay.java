package boundary;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import com.toedter.calendar.JDateChooser;

import control.FriendLogic;
import control.PartyLogic;
import control.XmlLogic;
import entity.Consts;
import entity.CustomerinParty;

import entity.Friends;
import entity.Party;
import entity.Consts.Manipulation;
import entity.Consts.Manipulation2;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.List;
import java.awt.Scrollbar;
import java.awt.Color;
import javax.swing.JComboBox;

import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;
import javax.swing.JTextArea;
import javax.swing.JProgressBar;

public class FrmPay {

	JFrame frame;
	private JTextField txtYouCanPay;
	private JTextField txtEachCustomer;
	private JTextField txtPaymentIsMade;
	private JTextField textField;
	public JTextField txtUsername;
	private JTextField txtPartyNumber;
	private JTextField textField_1;
	private JTextField txtCreditCard;
	private JTextField textField_2;
	private JTextField txtAge;
	private JTextField textField_3;
	public static ArrayList<String> resultss = new ArrayList<String>();
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPay window = new FrmPay();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmPay() {
		initialize();
		fetchAndRefresh();
	}

	private void fetchAndRefresh() {
		// TODO Auto-generated method stub

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setAutoRequestFocus(false);
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/test/Desktop/images.jpeg"));
		frame.setBounds(100, 100, 835, 583);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuItem backtochoose1;
		JMenuItem backtochoose2;
		JMenuItem backtochoose3;
		JMenuItem backtochoose4;
		JButton B = null;

		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(new Color(30, 144, 255));
		panel.setLayout(null);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
	
		JList list_1 = new JList();
		Image img2=new ImageIcon(this.getClass().getResource("/visa2.png")).getImage();
		JTextField txtAllTheCustomer = new JTextField();
		txtAllTheCustomer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtAllTheCustomer.setText("Pay credit:");
		txtAllTheCustomer.setBounds(27, 50, 85, 34);
		panel.add(txtAllTheCustomer);
		txtAllTheCustomer.setBackground(new Color(248, 248, 255));
		txtAllTheCustomer.setForeground(new Color(0, 0, 0));
		txtAllTheCustomer.setColumns(10);

		txtYouCanPay = new JTextField();
		txtYouCanPay.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtYouCanPay.setText("*you can pay credit only before 48 hours ");
		txtYouCanPay.setForeground(new Color(255, 0, 0));
		txtYouCanPay.setColumns(10);
		txtYouCanPay.setBackground(new Color(245, 255, 250));
		txtYouCanPay.setBounds(27, 95, 465, 34);
		panel.add(txtYouCanPay);

		txtEachCustomer = new JTextField();
		txtEachCustomer.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtEachCustomer.setText(
				"*\nEach customer will be able to order one ticket only for him to different areas of his choice");
		txtEachCustomer.setForeground(new Color(255, 0, 0));
		txtEachCustomer.setColumns(10);
		txtEachCustomer.setBackground(new Color(245, 255, 250));
		txtEachCustomer.setBounds(27, 154, 470, 34);
		panel.add(txtEachCustomer);

		txtPaymentIsMade = new JTextField();
		txtPaymentIsMade.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtPaymentIsMade.setText("*Payment is made by credit card using the \"Mala\" company's API");
		txtPaymentIsMade.setForeground(new Color(255, 0, 0));
		txtPaymentIsMade.setColumns(10);
		txtPaymentIsMade.setBackground(new Color(240, 255, 255));
		txtPaymentIsMade.setBounds(27, 119, 468, 34);
		panel.add(txtPaymentIsMade);

		textField = new JTextField();
		textField.setBounds(121, 233, 140, 34);
		panel.add(textField);
		textField.setColumns(10);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(96, 326, -61, 21);
		panel.add(textArea);

		JTextArea txtrUsername = new JTextArea();
		txtrUsername.setText("username");
		txtrUsername.setBounds(83, 326, -78, 21);
		panel.add(txtrUsername);

		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtUsername.setText("id number:");
		txtUsername.setForeground(Color.BLACK);
		txtUsername.setColumns(10);
		txtUsername.setBackground(new Color(245, 255, 250));
		txtUsername.setBounds(14, 233, 85, 34);
		panel.add(txtUsername);

		txtPartyNumber = new JTextField();
		txtPartyNumber.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtPartyNumber.setText("party number:");
		txtPartyNumber.setForeground(Color.BLACK);
		txtPartyNumber.setColumns(10);
		txtPartyNumber.setBackground(new Color(240, 255, 255));
		txtPartyNumber.setBounds(14, 281, 89, 34);
		panel.add(txtPartyNumber);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(121, 278, 140, 34);

		resultss.add(textField_1.getText());
		System.out.println(textField_1.getText());
		panel.add(textField_1);

		txtCreditCard = new JTextField();
		txtCreditCard.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtCreditCard.setText("credit card:");
		txtCreditCard.setForeground(new Color(0, 0, 0));
		txtCreditCard.setColumns(10);
		txtCreditCard.setBackground(new Color(245, 255, 250));
		txtCreditCard.setBounds(354, 233, 96, 34);
		panel.add(txtCreditCard);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(460, 231, 161, 40);
		panel.add(textField_2);

		txtAge = new JTextField();
		txtAge.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		txtAge.setText("age:");
		txtAge.setForeground(Color.BLACK);
		txtAge.setColumns(10);
		txtAge.setBackground(new Color(245, 255, 250));
		txtAge.setBounds(354, 281, 96, 34);
		panel.add(txtAge);
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(245, 255, 250));
		panel_2.setForeground(SystemColor.activeCaptionText);
		panel_2.setBounds(0, 0, 1019, 29);
		panel.add(panel_2);

		JButton btnNewButton_1 = new JButton("friendship");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FrmimportXmlAndLogin window1 = new FrmimportXmlAndLogin();
				window1.frame.setVisible(true);
				frame.setVisible(false);

			}
		});

		JButton btnNewButton_2 = new JButton("pay crdiet");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FrmPay window1 = new FrmPay();
				window1.frame.setVisible(true);
				frame.setVisible(false);

			}
		});

		JButton btnNewButton_4 = new JButton("report party this mounth ");

		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				FrmRepoet window1 = new FrmRepoet();
				window1.setVisible(true);
				frame.setVisible(false);

			}
		});

		JButton btnNewButton_5 = new JButton("import from jason  ");

		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Frmimportjson window1 = new Frmimportjson();
				window1.frame.setVisible(true);
				frame.setVisible(false);

			}
		});

		btnNewButton = new JButton("Schedule of Party");

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Frmsch window1 = new Frmsch();
				window1.setVisible(true);
				frame.setVisible(false);

			}
		});
		
		JButton btnNewButton_10 = new JButton("My order");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Frmorder window1 = new Frmorder();
				window1.frame.setVisible(true);
				frame.setVisible(false); 
				

			}
		});	

		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 186, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_5, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_10)
					.addContainerGap(261, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_5)
						.addComponent(btnNewButton_10)
						.addComponent(btnNewButton_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(460, 278, 161, 40);
		panel.add(textField_3);

		JButton btnNewButton_11 = new JButton("pay");
		btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		btnNewButton_11.setBackground(new Color(245, 255, 250));
		btnNewButton_11.setForeground(SystemColor.infoText);
		btnNewButton_11.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(textField_3.getText().equals("")||textField.getText().equals("")||textField_1.getText().equals("")||textField_2.getText().equals(""))
				{
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "please fill in all fields!!");
				
					
				}
				else
				{
					Frmsendorded window1 = new Frmsendorded();
					window1.frame.setVisible(true);
					frame.setVisible(false);
					btnAddOnClick(e);
				}
				
			}
		});
		btnNewButton_11.setBounds(254, 337, 117, 29);
		panel.add(btnNewButton_11);
		
		JLabel lblExportThePartys = new JLabel("Export the Partys in 22:00PM\r\n");
		lblExportThePartys.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblExportThePartys.setBounds(14, 403, 235, 35);
		panel.add(lblExportThePartys);
		
		JButton btnNewButton_1_1 = new JButton("Export");
		btnNewButton_1_1.setBounds(293, 411, 89, 23);
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XmlLogic.getInstance().exportCustomersToXML();
				FrmExporetToXml window1 = new FrmExporetToXml();
				window1.frame.setVisible(true);
				frame.setVisible(false); 
				

			}
		});	
		
		
		JLabel im_2_3 = new JLabel("");
		im_2_3.setBounds(0, 0, 821, 546);
		panel.add(im_2_3);
		Image img1=new ImageIcon(this.getClass().getResource("/cover3.jpeg")).getImage();
		im_2_3.setIcon(new ImageIcon(img1));
	}
	public boolean AddFriendByPhone() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.INSERT_ORDER)) {

				ArrayList<CustomerinParty> results = FriendLogic.getInstance().getCustomerinParty();
				String id = textField.getText();
				String partynumber = textField_1.getText();
				String Crdit = textField_2.getText();
				String age = textField_3.getText();

				

				stmt.setString(1, id);
				stmt.setString(2, partynumber);
				stmt.setString(3, Crdit);
				stmt.setString(4, age);
				int rowsAffected = stmt.executeUpdate();

				if (rowsAffected > 0) {
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return false;
	}

	private void btnAddOnClick(java.awt.event.ActionEvent evt) {
		
				AddFriendByPhone();
			
	}
	
}

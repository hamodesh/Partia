package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import com.toedter.calendar.JDateChooser;

import control.FriendLogic;
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
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.BoxLayout;

public class FrmFriendShip {

	JFrame frame;
	private JTextField shhade;
	private JTextField textField_1;
	private JComboBox c1;
	private JComboBox c2;
	private JComboBox c3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmFriendShip window = new FrmFriendShip();
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
	public FrmFriendShip() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/test/Desktop/images.jpeg"));
		frame.setBounds(100, 100, 982, 616);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuItem backtochoose1;
		JMenuItem backtochoose2;
		JMenuItem backtochoose3;
		JMenuItem backtochoose4;

		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setBackground(SystemColor.infoText);
		panel.setLayout(null);
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		Image img2=new ImageIcon(this.getClass().getResource("/bigfriend.jpeg")).getImage();
		
		JLabel im_2_3 = new JLabel("");
		im_2_3.setBounds(68, 289, 346, 382);
		panel.add(im_2_3);
		Image img1=new ImageIcon(this.getClass().getResource("/frindsp.jpeg")).getImage();
		im_2_3.setIcon(new ImageIcon(img1));
	
		JLabel lblFreindshio = new JLabel("Friend Ship");
		lblFreindshio.setForeground(new Color(218, 165, 32));
		lblFreindshio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFreindshio.setBounds(142, 0, 176, 40);
		panel.add(lblFreindshio);

		JPanel pnlEmpDetails = new JPanel();
		pnlEmpDetails.setBackground(Color.DARK_GRAY);
		pnlEmpDetails.setBorder(null);
		pnlEmpDetails.setBounds(0, 79, 394, 127);
		panel.add(pnlEmpDetails);

		JLabel lblHireDate_1_1 = new JLabel("End Date:");

		JDateChooser dtcBirthDate_1 = new JDateChooser();

		JButton Delet = new JButton("Delete");
		Delet.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblDeletFriend = new JLabel("Delet Friend:");
		lblDeletFriend.setForeground(new Color(218, 165, 32));
		lblDeletFriend.setFont(new Font("Tahoma", Font.BOLD, 15));

		shhade = new JTextField();
		shhade.setBackground(Color.GRAY);
		shhade.setText((String) null);
		shhade.setColumns(10);

		JButton Add = new JButton("Add");
		Add.setForeground(new Color(218, 165, 32));
		Add.setHorizontalAlignment(SwingConstants.LEFT);

		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = shhade.getText();

				ArrayList<CustomerinParty> resultss = new ArrayList<CustomerinParty>();
				resultss = FriendLogic.getInstance().getCustomerinParty();

				for (int i = 0; i < resultss.size(); i++) {
					int num2 = Integer.parseInt(num);
					if (num2 == resultss.get(i).getPhonenumber()) {
						CustomerinParty c1 = resultss.get(i);
						c3.removeItem(resultss.get(i).getPhonenumber());
						c2.addItem(resultss.get(i).getPhonenumber());
						shhade.setText("");
						AddFriendByPhone(resultss.get(i).getPhonenumber());

						btnAddOnClick(e);

					}

				}

			}
		});

		textField_1 = new JTextField();
		textField_1.setBackground(Color.GRAY);
		textField_1.setText((String) null);
		textField_1.setColumns(10);

		JButton Delete2 = new JButton("Delete");
		Delete2.setForeground(new Color(218, 165, 32));
		Delete2.setHorizontalAlignment(SwingConstants.LEFT);

		Delete2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String num = textField_1.getText();

				ArrayList<CustomerinParty> resultss = new ArrayList<CustomerinParty>();
				resultss = FriendLogic.getInstance().getCustomerinParty();

				for (int i = 0; i < resultss.size(); i++) {
					int num2 = Integer.parseInt(num);
					if (num2 == resultss.get(i).getPhonenumber()) {
						CustomerinParty c1 = resultss.get(i);
						c2.removeItem(resultss.get(i).getPhonenumber());
						textField_1.setText("");
						FriendLogic.getInstance().removeEmployee(resultss.get(i).getPhonenumber());

						btnRemoveOnClick(e);

					}

				}
			}
		});

		JLabel lblIdFriend = new JLabel("Phone Friend:");
		lblIdFriend.setForeground(new Color(218, 165, 32));

		JLabel lblIdNumber = new JLabel("Phone Number:");
		lblIdNumber.setForeground(new Color(218, 165, 32));
		GroupLayout gl_pnlEmpDetails = new GroupLayout(pnlEmpDetails);
		gl_pnlEmpDetails.setHorizontalGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlEmpDetails.createSequentialGroup().addContainerGap().addGroup(gl_pnlEmpDetails
						.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDeletFriend, GroupLayout.PREFERRED_SIZE, 109, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlEmpDetails.createSequentialGroup().addGroup(gl_pnlEmpDetails
								.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_pnlEmpDetails.createSequentialGroup().addComponent(lblHireDate_1_1)
										.addGap(9))
								.addGroup(gl_pnlEmpDetails.createSequentialGroup().addGroup(gl_pnlEmpDetails
										.createParallelGroup(Alignment.TRAILING, false)
										.addGroup(gl_pnlEmpDetails.createSequentialGroup().addComponent(lblIdNumber)
												.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE,
														Short.MAX_VALUE)
												.addComponent(shhade, GroupLayout.PREFERRED_SIZE, 160,
														GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_pnlEmpDetails.createSequentialGroup()
												.addComponent(lblIdFriend, GroupLayout.PREFERRED_SIZE, 96,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(textField_1,
														GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)))
										.addGap(18)))
								.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
										.addComponent(Delete2, GroupLayout.PREFERRED_SIZE, 75,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(Add, GroupLayout.PREFERRED_SIZE, 75,
												GroupLayout.PREFERRED_SIZE))))
						.addGap(53)
						.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlEmpDetails.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED).addComponent(dtcBirthDate_1,
												GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_pnlEmpDetails.createSequentialGroup().addGap(29).addComponent(Delet,
										GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)))));
		gl_pnlEmpDetails.setVerticalGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlEmpDetails.createSequentialGroup().addGap(17)
						.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.BASELINE).addComponent(Add)
								.addComponent(shhade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblIdNumber))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(lblDeletFriend, GroupLayout.PREFERRED_SIZE, 35, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_pnlEmpDetails.createSequentialGroup().addGap(45).addComponent(Delet)
										.addGap(110)
										.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
												.addComponent(dtcBirthDate_1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblHireDate_1_1)))
								.addGroup(gl_pnlEmpDetails.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.BASELINE)
												.addComponent(Delete2)
												.addComponent(textField_1, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(lblIdFriend))))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
		pnlEmpDetails.setLayout(gl_pnlEmpDetails);

		JLabel lblAccpet = new JLabel("my Friends:");
		lblAccpet.setForeground(new Color(218, 165, 32));
		lblAccpet.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAccpet.setBounds(406, 166, 114, 40);
		panel.add(lblAccpet);

		JLabel lblAddFriends = new JLabel("Add Friends:");
		lblAddFriends.setForeground(new Color(218, 165, 32));
		lblAddFriends.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddFriends.setBounds(10, 51, 114, 40);
		panel.add(lblAddFriends);

		JLabel lblListNewfriends = new JLabel("customer in party:");
		lblListNewfriends.setForeground(new Color(218, 165, 32));
		lblListNewfriends.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblListNewfriends.setBounds(406, 79, 140, 40);
		panel.add(lblListNewfriends);

		JButton Delete22 = new JButton("Delete");
		Delete22.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		Delete22.setForeground(new Color(218, 165, 32));
		Delete22.setBounds(206, 306, 75, 23);
		panel.add(Delete22);
		Delete22.setHorizontalAlignment(SwingConstants.LEFT);
		Delete22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Integer selectedValue = (Integer) c1.getSelectedItem();
				c1.removeItem(selectedValue);

			}
		});

		JButton btnAccept = new JButton("Accept");
		btnAccept.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		btnAccept.setForeground(new Color(218, 165, 32));
		btnAccept.setBounds(320, 306, 82, 23);
		panel.add(btnAccept);
		btnAccept.setHorizontalAlignment(SwingConstants.LEFT);
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<Friends> results = new ArrayList<Friends>();
				results = FriendLogic.getInstance().getFreinds();
				Integer selectedValue = (Integer) c1.getSelectedItem();
				c1.removeItem(selectedValue);
				c2.addItem(selectedValue);
				c3.removeItem(selectedValue);
				AddFriendByPhone(selectedValue);

			}
		});

		JLabel lblRequesetFriends = new JLabel("Requeset Friends");
		lblRequesetFriends.setForeground(new Color(218, 165, 32));
		lblRequesetFriends.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblRequesetFriends.setBounds(10, 225, 160, 40);
		panel.add(lblRequesetFriends);

		ArrayList<Friends> results = new ArrayList<Friends>();
		results = FriendLogic.getInstance().getFreinds();

		ArrayList<CustomerinParty> results2 = new ArrayList<CustomerinParty>();
		results2 = FriendLogic.getInstance().getCustomerinParty();

		c1 = new JComboBox();
		c1.setForeground(new Color(218, 165, 32));
		c1.setBounds(206, 237, 179, 20);
		panel.add(c1);
		c1.addItem(results2.get(0).getPhonenumber());
		c1.addItem(results2.get(1).getPhonenumber());

		c2 = new JComboBox();
		c2.setForeground(new Color(218, 165, 32));
		c2.setBounds(575, 178, 179, 20);
		panel.add(c2);
		for (int i = 0; i < results.size(); i++) {
			c2.addItem(results.get(i).getPhonenumber());
		}

		c3 = new JComboBox();
		c3.setForeground(new Color(218, 165, 32));
		c3.setBounds(575, 91, 179, 20);
		panel.add(c3);

		JButton btnNewButton = new JButton("<-");
		btnNewButton.setBounds(0, 0, 89, 23);
		panel.add(btnNewButton);

		panel.add(btnNewButton);
		JLabel im_2_3_1_1 = new JLabel("");
		im_2_3_1_1.setBounds(397, 0, 915, 588);
		im_2_3_1_1.setIcon(new ImageIcon(img2));
		panel.add(im_2_3_1_1);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				manuepartya window1 = new manuepartya();
				window1.frame.setVisible(true);
				frame.setVisible(false);

			}
		});
		for (int i = 3; i < results2.size(); i++) {

			c3.addItem(results2.get(i).getPhonenumber());

		}

	}

	public boolean AddFriendByPhone(Integer phoneNumber) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.INSERT_FRIEND)) {

				ArrayList<CustomerinParty> results = FriendLogic.getInstance().getCustomerinParty();
				int partynumber = 0;
				int address = 0;
				int newnum = phoneNumber;

				for (CustomerinParty result : results) {
					if (result.getPhonenumber() == newnum) {
						partynumber = result.getPartynumber();
						address = result.getAdress();
						break;
					}
				}

				stmt.setInt(1, newnum);
				stmt.setInt(2, partynumber);
				stmt.setInt(3, address);
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

	ArrayList<CustomerinParty> results = FriendLogic.getInstance().getCustomerinParty();

	private void btnAddOnClick(java.awt.event.ActionEvent evt) {
		for (int i = 0; i < results.size(); i++) {
			String phone = String.valueOf(results.get(i).getPhonenumber());

			if (shhade.getText().equals(phone)) {
				AddFriendByPhone(results.get(i).getPhonenumber());
			}
		}

	}

	public boolean deleteFriendByPhone(int phoneNumber) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.DELETE_FRIEND)) {

				stmt.setLong(1, phoneNumber);
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

	private ArrayList<Friends> empArray = FriendLogic.getInstance().getFreinds();

	private void btnRemoveOnClick(java.awt.event.ActionEvent evt) {

		for (int i = 0; i < empArray.size(); i++) {
			String phone = String.valueOf(empArray.get(i).getPhonenumber());

			if (textField_1.getText().equals(phone)) {
				
				deleteFriendByPhone(empArray.get(i).getPhonenumber());
			}
		}
	}
}

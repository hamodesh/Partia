package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import control.FriendLogic;
import entity.Agent;
import entity.Artist;
import entity.Consts;
import entity.CustomerinParty;
import entity.Friends;
import entity.NewParty;
import entity.Party;
import entity.choosenewartist;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;

public class changeS extends JFrame {

	private JPanel contentPane;
	protected Object frame;
	JComboBox c1 = new JComboBox();
	JComboBox c1_1 = new JComboBox();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changeS frame = new changeS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public changeS() {
		setTitle("");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(418, 38, 212, 14);
		contentPane.add(lblError);

		JLabel lblClikTheParty = new JLabel("\nSwitch agent  to:");
		lblClikTheParty.setForeground(new Color(0, 0, 0));
		lblClikTheParty.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblClikTheParty.setBounds(10, 215, 217, 40);
		contentPane.add(lblClikTheParty);
		// Image img1 = new
		// ImageIcon(this.getClass().getResource("/cover3.jpeg")).getImage();
		JLabel im_2_3 = new JLabel("");
		contentPane.add(im_2_3);
		im_2_3.setBounds(-445, 398, 786, 40);

		JLabel lblName = new JLabel("i am the artist ");
		lblName.setBackground(new Color(240, 255, 255));
		lblName.setForeground(new Color(0, 0, 0));
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblName.setBounds(21, 138, 168, 40);
		contentPane.add(lblName);

		JButton btnNewButton = new JButton("Change");
		btnNewButton.setForeground(new Color(199, 21, 133));
		btnNewButton.setBounds(517, 288, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "the agent swithched✅");

				btnRemoveOnClick(e);
				btnAddOnClick(e);

			}
		});

		c1.setForeground(new Color(199, 21, 133));
		c1.setBounds(162, 150, 179, 20);
		contentPane.add(c1);

		ArrayList<Artist> results2 = new ArrayList<Artist>();
		results2 = FriendLogic.getInstance().getArtist();

		for (int i = 0; i < results2.size(); i++) {
			c1.addItem(results2.get(i).getName());
		}

		c1_1.setForeground(new Color(199, 21, 133));
		c1_1.setBounds(162, 227, 179, 20);
		contentPane.add(c1_1);

		ArrayList<Agent> results22 = new ArrayList<Agent>();
		results22 = FriendLogic.getInstance().getAgent();

		for (int i = 0; i < results22.size(); i++) {
			c1_1.addItem(results22.get(i).getName());
		}

		JLabel lblIdParty = new JLabel("switch agent for artist");
		lblIdParty.setForeground(new Color(0, 0, 0));
		lblIdParty.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblIdParty.setBounds(21, 38, 192, 40);
		contentPane.add(lblIdParty);
		
		JButton btnNewButton_2 = new JButton("<-");
		btnNewButton_2.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_2);
		Image img=new ImageIcon(this.getClass().getResource("/artistcover.jpeg")).getImage();
		JLabel im_4 = new JLabel("");
		contentPane.add(im_4);
		im_4.setForeground(new Color(240, 128, 128));
		im_4.setBackground(new Color(216, 191, 216));
		im_4.setBounds(-756, -37, 1490, 462);
		im_4.setIcon(new ImageIcon(img));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ManueArtist window1 = new ManueArtist();
				window1.frame1.setVisible(true);
				setVisible(false);

			}
		});

	}

	public boolean deleteFriendByPhone(int id) {
	
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.DELETE_agentartist)) {

				stmt.setInt(1, id);
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
	private ArrayList<Artist> empArray = FriendLogic.getInstance().getArtist();
	private void btnRemoveOnClick(java.awt.event.ActionEvent evt) {
		
		String m = (String) c1.getSelectedItem();
		
		
		for (int i = 0; i < empArray.size(); i++) {
			

			if (m.equals(empArray.get(i).getName())) {
			
				int c2=Integer.parseInt(empArray.get(i).getArtistid());
				deleteFriendByPhone(c2);
				
			}
		}
		
		
		
		
	}
	
	
	
	
	public boolean AddFriendByPhone(int phoneNumber) {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.UPDATE_agentartist)) {

				ArrayList<Artist> empArray2 = FriendLogic.getInstance().getArtist();
				int idartist = 0;
				String agent = null;
				

				for (Artist result : empArray2) {
					int n =Integer.parseInt(result.getArtistid());
					if (n == phoneNumber) {
						idartist = phoneNumber;
						agent = (String) c1_1.getSelectedItem();
						break;
					}
				}

				stmt.setInt(1, idartist);
				stmt.setString(2, agent);
				
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
         String m = (String) c1.getSelectedItem();
		
		
		for (int i = 0; i < empArray.size(); i++) {
			String c =empArray.get(i).getName();

			if (m.equals(c)) {
				int c2=Integer.parseInt(empArray.get(i).getArtistid());
				AddFriendByPhone(c2);
				
			}
		}

	}


}

package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import control.FriendLogic;
import control.PartyLogic;
import entity.ArtistinParty;
import entity.Consts;
import entity.CustomerinParty;
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

public class AddArtist extends JFrame {

	private JPanel contentPane;
	protected Object frame;
	private JTextField textField_1;
	private JTextField textField4;
	private JTextField textField5;
	private JTextField textField3;
	private JTextField textField6;
	private JTextField textField_2;
	private JTextField textField7;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddArtist frame = new AddArtist();
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
	public AddArtist() {
		setTitle("");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 418);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(418, 38, 212, 14);
		contentPane.add(lblError);

		JLabel lblClikTheParty = new JLabel("Add Artist:");
		lblClikTheParty.setForeground(Color.BLACK);
		lblClikTheParty.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblClikTheParty.setBounds(10, 186, 217, 40);
		contentPane.add(lblClikTheParty);
		
		JLabel lblName_1 = new JLabel("Starthour:");
		lblName_1.setForeground(Color.BLACK);
		lblName_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblName_1.setBounds(10, 280, 102, 40);
		contentPane.add(lblName_1);
		
		JLabel lblName_1_1 = new JLabel("endhour:");
		lblName_1_1.setForeground(Color.BLACK);
		lblName_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblName_1_1.setBounds(266, 280, 102, 40);
		contentPane.add(lblName_1_1);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(367, 331, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Send Requset to Artist sucssfully✅");
				btnAddOnClick(e);
			}
		});
		
		JLabel Date = new JLabel("Date");
		Date.setForeground(Color.BLACK);
		Date.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		Date.setBounds(277, 237, 102, 40);
		contentPane.add(Date);
		
		textField_1 = new JTextField();
		textField_1.setText((String) null);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.GRAY);
		textField_1.setBounds(328, 249, 160, 20);
		contentPane.add(textField_1);
		
		JLabel lblImportJsonArtist = new JLabel("import json Artist:");
		lblImportJsonArtist.setForeground(Color.BLACK);
		lblImportJsonArtist.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblImportJsonArtist.setBounds(10, 26, 217, 40);
		contentPane.add(lblImportJsonArtist);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(315, 63, 465, 112);
		contentPane.add(panel);
		
		JButton btnNewButton_1 = new JButton("import");
		btnNewButton_1.setBounds(39, 61, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PartyLogic.getInstance().importgradeArtistJSON("json/Artist.json");
				
				try {
					lblError.setText("");
					
					ArrayList<ArtistinParty> results2 = new ArrayList<ArtistinParty>();
					results2 = FriendLogic.getInstance().getgradeartist();

					if (results2.size() == 0) {
						// remove all components in panel.
						panel.removeAll();
						// refresh the panel.
						panel.updateUI();
						lblError.setText("Delete From Acsses");
					} else {
						String[] column = new String[6];
						column[0] = "id Artist";
						column[1] = "party Number";
						column[2] = "name Artist";
						column[3] = "gendr";
						column[4] = "type music";
						column[5] = "grade";
						

						// table body = 2d array (rows=persons, columns=fName,lName)
						String data[][] = new String[results2.size()][6];
						for (int i = 0; i < results2.size(); i++) {
							
								
								data[i][0] = "" + results2.get(i).getIdArtist();
								data[i][1] = results2.get(i).getPartynumber();
								data[i][2] = results2.get(i).getNameArtist();
								data[i][3] = results2.get(i).getGendr();
								data[i][4] = results2.get(i).getTypemusic();
								data[i][5] = results2.get(i).getGrade();
							
						}
						JTable jtable = new JTable(data, column);
						JScrollPane sp = new JScrollPane(jtable);
						// remove all components in panel.
						panel.removeAll();
						// refresh the panel.
						panel.updateUI();

						panel.add(sp);
						getContentPane().add(panel, BorderLayout.SOUTH);
						revalidate(); // called on a container once new components are added (refresh the page)
					}

				} catch (Exception e1) {
					lblError.setText("Invalid Input");
				}
				
			}
		});
		
		
		
		//Image img1 = new ImageIcon(this.getClass().getResource("/cover3.jpeg")).getImage();
		JLabel im_2_3 = new JLabel("");
		panel.add(im_2_3);
		
		JLabel lblArtistDetails = new JLabel("  Artist Details :");
		lblArtistDetails.setForeground(Color.BLACK);
		lblArtistDetails.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblArtistDetails.setBounds(413, 12, 217, 40);
		contentPane.add(lblArtistDetails);
		
		JButton btnNewButton_2 = new JButton("<-");
		btnNewButton_2.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_2);
		Image img=new ImageIcon(this.getClass().getResource("/cover3.jpeg")).getImage();
		/*im_4.setIcon(new ImageIcon(img));*/
		
		JLabel lblIdParty_1 = new JLabel("Location:");
		lblIdParty_1.setForeground(Color.BLACK);
		lblIdParty_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblIdParty_1.setBounds(518, 237, 102, 40);
		contentPane.add(lblIdParty_1);
		
		textField4 = new JTextField();
		textField4.setText((String) null);
		textField4.setColumns(10);
		textField4.setBackground(Color.GRAY);
		textField4.setBounds(95, 292, 160, 20);
		contentPane.add(textField4);
		
		textField5 = new JTextField();
		textField5.setText((String) null);
		textField5.setColumns(10);
		textField5.setBackground(Color.GRAY);
		textField5.setBounds(341, 292, 160, 20);
		contentPane.add(textField5);
		
		textField3 = new JTextField();
		textField3.setText((String) null);
		textField3.setColumns(10);
		textField3.setBackground(Color.GRAY);
		textField3.setBounds(599, 249, 160, 20);
		contentPane.add(textField3);
		
		JLabel lblIdParty_1_1 = new JLabel("Profit:");
		lblIdParty_1_1.setForeground(Color.BLACK);
		lblIdParty_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblIdParty_1_1.setBounds(528, 280, 102, 40);
		contentPane.add(lblIdParty_1_1);
		
		textField6 = new JTextField();
		textField6.setText((String) null);
		textField6.setColumns(10);
		textField6.setBackground(Color.GRAY);
		textField6.setBounds(599, 292, 160, 20);
		contentPane.add(textField6);
		
		JLabel lblIdArtist = new JLabel("id Artist:");
		lblIdArtist.setForeground(Color.BLACK);
		lblIdArtist.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblIdArtist.setBounds(10, 237, 102, 40);
		contentPane.add(lblIdArtist);
		
		textField_2 = new JTextField();
		textField_2.setText((String) null);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.GRAY);
		textField_2.setBounds(95, 249, 160, 20);
		contentPane.add(textField_2);
		
		JLabel lblIdParty = new JLabel("id Party:");
		lblIdParty.setForeground(Color.BLACK);
		lblIdParty.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblIdParty.setBounds(10, 323, 102, 40);
		contentPane.add(lblIdParty);
		
		textField7 = new JTextField();
		textField7.setText((String) null);
		textField7.setColumns(10);
		textField7.setBackground(Color.GRAY);
		textField7.setBounds(95, 332, 160, 20);
		contentPane.add(textField7);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ManueAgent window1 = new ManueAgent();
				window1.frame1.setVisible(true);
				setVisible(false);

			}
		});
	}
	
	public boolean AddArtist() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.INSERT_chooseArtist)) {

				
				String date  = textField_1.getText() ;
				String startdate= textField4.getText() ;
				String enddate = textField5.getText();
				String location = textField3.getText() ;
				String proft =  textField6.getText() ;
				String id =  textField_2.getText() ;
				String idP =  textField7.getText() ;

				

		
				stmt.setString(1, date);
				stmt.setString(2, startdate);
				stmt.setString(3, enddate);
				stmt.setString(4, location);
				stmt.setString(5, proft);
				stmt.setString(6, id);
				stmt.setString(7, idP);
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
		AddArtist();

	}
}

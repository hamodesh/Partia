package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import control.FriendLogic;
import entity.Artist;
import entity.ArtistinParty;
import entity.Consts;
import entity.CustomerinParty;
import entity.NewParty;
import entity.Party;
import entity.ShowArtist;
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
import java.awt.Frame;
import java.awt.SystemColor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;

public class Aceeptartist extends JFrame {

	private JPanel contentPane;
	protected Object frame;
	JComboBox c1_1 = new JComboBox();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aceeptartist frame = new Aceeptartist();
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
	public Aceeptartist() {
		setTitle("");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 734, 424);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(418, 38, 212, 14);
		contentPane.add(lblError);

		JLabel lblClikTheParty = new JLabel("the party that request the artist ");
		lblClikTheParty.setForeground(Color.BLACK);
		lblClikTheParty.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblClikTheParty.setBounds(6, 148, 265, 40);
		contentPane.add(lblClikTheParty);
		// Image img1 = new
		// ImageIcon(this.getClass().getResource("/cover3.jpeg")).getImage();
		JLabel im_2_3 = new JLabel("");
		contentPane.add(im_2_3);
		im_2_3.setBounds(-445, 398, 786, 40);

		JLabel lblName = new JLabel("choose artist ");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblName.setBounds(6, 84, 168, 40);
		contentPane.add(lblName);

		JButton btnNewButton = new JButton("accept");
		btnNewButton.setBounds(308, 325, 89, 23);

		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame frame = new JFrame();
				JOptionPane.showMessageDialog(frame,"Accsept Party");
			}
		});

		ArrayList<Artist> results2 = new ArrayList<Artist>();
		results2 = FriendLogic.getInstance().getArtist();

		c1_1.setForeground(new Color(218, 165, 32));
		c1_1.setBounds(184, 96, 179, 20);
		contentPane.add(c1_1);
		for (int i = 0; i < results2.size(); i++) {
			c1_1.addItem(results2.get(i).getArtistid());
		}

		JLabel lblIdParty = new JLabel("request party");
		lblIdParty.setForeground(Color.BLACK);
		lblIdParty.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblIdParty.setBounds(254, 26, 133, 40);
		contentPane.add(lblIdParty);

		JLabel lblIdParty_1 = new JLabel("party number");
		lblIdParty_1.setForeground(Color.BLACK);
		lblIdParty_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblIdParty_1.setBounds(26, 314, 133, 40);
		contentPane.add(lblIdParty_1);

		textField = new JTextField();
		textField.setBounds(158, 322, 130, 26);
		contentPane.add(textField);
		textField.setColumns(10);

		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(6, 181, 465, 112);

		JButton btnNewButton_1 = new JButton("Delet");
		btnNewButton_1.setBounds(423, 325, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnRemoveOnClick(e);

			}
		});

		JButton btnSelect = new JButton("Select");
		btnSelect.setBounds(404, 95, 89, 23);
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					lblError.setText("");

					String m = (String) c1_1.getSelectedItem();

					ArrayList<ShowArtist> results = FriendLogic.getInstance().getShowArtist();

					if (results.size() == 0) {
						// remove all components in panel.
						panel.removeAll();
						// refresh the panel.
						panel.updateUI();
						lblError.setText("No New Party ");
					} else {

						String[] column = new String[7];
						column[0] = "Date";
						column[1] = "Starthour";
						column[2] = "Endhour";
						column[3] = "Location";
						column[4] = "Proift";
						column[5] = "Id Artist";
						column[6] = "Id Party";

						// table body = 2d array (rows=persons, columns=fName,lName)
						String data[][] = new String[results.size()][7];
						for (int i = 0; i < results.size(); i++) {
							String id = String.valueOf(results.get(i).getIdArtist());
							;

							if (m.equalsIgnoreCase(id)) {
								data[i][0] = "" + results.get(i).getDate();
								data[i][1] = "" + results.get(i).getStartdate();
								data[i][2] = results.get(i).getEnddate();
								data[i][3] = results.get(i).getLocation();
								data[i][4] = results.get(i).getProift();
								data[i][5] = id;
								data[i][6] = results.get(i).getIdPraty();

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
					}
				} catch (Exception e1) {
					lblError.setText("Invalid Input");
				}

			}
		});

		contentPane.add(panel);

		contentPane.add(btnSelect);

		JButton btnNewButton_2 = new JButton("<-");
		btnNewButton_2.setBounds(0, 0, 89, 23);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ManueArtist window1 = new ManueArtist();
				window1.frame1.setVisible(true);
				setVisible(false);

			}
		});

		contentPane.add(btnNewButton_2);
		Image img = new ImageIcon(this.getClass().getResource("/cover3.jpeg")).getImage();
		JLabel im_4 = new JLabel("");
		contentPane.add(im_4);
		im_4.setForeground(new Color(240, 128, 128));
		im_4.setBackground(new Color(216, 191, 216));
		im_4.setBounds(-6, -66, 734, 462);
		im_4.setIcon(new ImageIcon(img));

		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Frame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Send message to Manger that is not appropriate for me");

			}
		});

	}

	public boolean deleteFriendByPhone(int id) {

		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.DELETE_choosenartist)) {

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

	ArrayList<choosenewartist> results = FriendLogic.getInstance().getchooseartisttartist();

	private void btnRemoveOnClick(java.awt.event.ActionEvent evt) {

		int c2 = Integer.parseInt(textField.getText());
		deleteFriendByPhone(c2);

	}
}

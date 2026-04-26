package boundary;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import control.FriendLogic;
import entity.Bands;
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

public class AddBands extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	protected Object frame;
	JComboBox c1_1 = new JComboBox();
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBands frame = new AddBands();
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
	public AddBands() {
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

		JLabel lblClikTheParty = new JLabel("Add Bands:");
		lblClikTheParty.setForeground(Color.BLACK);
		lblClikTheParty.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblClikTheParty.setBounds(10, 38, 217, 40);
		contentPane.add(lblClikTheParty);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setForeground(Color.BLACK);
		lblName.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblName.setBounds(10, 104, 102, 40);
		contentPane.add(lblName);
		
		JLabel lblName_1 = new JLabel("Bands Number:");
		lblName_1.setForeground(Color.BLACK);
		lblName_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblName_1.setBounds(384, 155, 147, 40);
		contentPane.add(lblName_1);
		
		JLabel lblName_1_1 = new JLabel("Type Music:");
		lblName_1_1.setForeground(Color.BLACK);
		lblName_1_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblName_1_1.setBounds(10, 155, 102, 40);
		contentPane.add(lblName_1_1);
		
		textField = new JTextField();
		textField.setText((String) null);
		textField.setColumns(10);
		textField.setBackground(Color.GRAY);
		textField.setBounds(98, 116, 160, 20);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBounds(308, 230, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frame = new JFrame();
				JOptionPane.showMessageDialog(frame, "Send Requset to Bands sucssfully✅");
			
				btnAddOnClick(e);
			}
		});
		
		
		c1_1.setForeground(new Color(218, 165, 32));
		c1_1.setBounds(111, 167, 179, 20);
		contentPane.add(c1_1);
		c1_1.addItem("rock");
		c1_1.addItem("pop");
		c1_1.addItem("east");
		c1_1.addItem("country");
		c1_1.addItem("other");
		
		textField_1 = new JTextField();
		textField_1.setText((String) null);
		textField_1.setColumns(10);
		textField_1.setBackground(Color.GRAY);
		textField_1.setBounds(541, 167, 160, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setText((String) null);
		textField_2.setColumns(10);
		textField_2.setBackground(Color.GRAY);
		textField_2.setBounds(541, 116, 160, 20);
		contentPane.add(textField_2);
		
		JLabel lblName_1_2 = new JLabel("Party id:");
		lblName_1_2.setForeground(Color.BLACK);
		lblName_1_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblName_1_2.setBounds(384, 104, 147, 40);
		contentPane.add(lblName_1_2);
		
		JButton btnNewButton_2 = new JButton("<-");
		btnNewButton_2.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_2);
		Image img=new ImageIcon(this.getClass().getResource("/cover3.jpeg")).getImage();
		JLabel im_4 = new JLabel("");
		contentPane.add(im_4);
		im_4.setForeground(new Color(240, 128, 128));
		im_4.setBackground(new Color(216, 191, 216));
		im_4.setBounds(0, -78, 820, 468);
		im_4.setIcon(new ImageIcon(img));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ManueAgent window1 = new ManueAgent();
				window1.frame1.setVisible(true);
				setVisible(false);

			}
		});

	}
	
	public boolean AddBands() {
		try {
			Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
			try (Connection conn = DriverManager.getConnection(Consts.CONN_STR);
					PreparedStatement stmt = conn.prepareStatement(Consts.INSERT_Bands)) {

				ArrayList<Bands> results = FriendLogic.getInstance().getbands();
				String name = textField.getText()  ;
				String typemusic=  ((String) (c1_1.getSelectedItem()));
				String bandsnumber  =  textField_1.getText();
				String idparty  =  textField_2.getText();
				

				

				stmt.setString(1, name);
				stmt.setString(2, typemusic);
				stmt.setString(3, bandsnumber);
				stmt.setString(4, idparty);
				
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
		AddBands();

	}
}

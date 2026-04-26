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
import control.PartyLogic;
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

public class Frmimportjson {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmimportjson window = new Frmimportjson();
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
	public Frmimportjson() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/test/Desktop/images.jpeg"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setForeground(new Color(65, 105, 225));
		panel.setBackground(SystemColor.activeCaption);
		panel.setLayout(null);
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblFreindshio = new JLabel("Partya");
		lblFreindshio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblFreindshio.setBounds(29, 28, 176, 40);
		panel.add(lblFreindshio);

		JPanel pnlEmpDetails = new JPanel();
		pnlEmpDetails.setBackground(Color.WHITE);
		pnlEmpDetails.setForeground(Color.WHITE);
		pnlEmpDetails.setBorder(null);
		pnlEmpDetails.setBounds(-6, 79, 333, 75);
		panel.add(pnlEmpDetails);

		JLabel lblHireDate_1_1 = new JLabel("End Date:");

		JDateChooser dtcBirthDate_1 = new JDateChooser();

		JButton Add = new JButton("Import");
		Add.setForeground(new Color(0, 0, 205));
		Add.setHorizontalAlignment(SwingConstants.LEFT);

		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PartyLogic.getInstance().importPartysJSON("json/Partys.json");
				Importjsonsucsses f = new Importjsonsucsses();
				f.frame.setVisible(true);
				frame.setVisible(false);
				
		}}

		);
		
		
				JLabel lblAddFriends = new JLabel("Import jason file");
				lblAddFriends.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		GroupLayout gl_pnlEmpDetails = new GroupLayout(pnlEmpDetails);
		gl_pnlEmpDetails.setHorizontalGroup(
			gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlEmpDetails.createSequentialGroup()
					.addGap(48)
					.addComponent(lblAddFriends, GroupLayout.PREFERRED_SIZE, 160, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlEmpDetails.createSequentialGroup()
							.addComponent(lblHireDate_1_1)
							.addGap(189)
							.addComponent(dtcBirthDate_1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
						.addComponent(Add, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(204, Short.MAX_VALUE))
		);
		gl_pnlEmpDetails.setVerticalGroup(
			gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlEmpDetails.createSequentialGroup()
					.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlEmpDetails.createSequentialGroup()
							.addGap(253)
							.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
								.addComponent(dtcBirthDate_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblHireDate_1_1)))
						.addGroup(gl_pnlEmpDetails.createSequentialGroup()
							.addGap(24)
							.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.BASELINE)
								.addComponent(Add)
								.addComponent(lblAddFriends, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnlEmpDetails.setLayout(gl_pnlEmpDetails);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.setBounds(0, 0, 89, 23);
		Image img = new ImageIcon(this.getClass().getResource("/cover3.jpeg")).getImage();
		JLabel im_4 = new JLabel("");
		im_4.setForeground(new Color(240, 128, 128));
		im_4.setBackground(new Color(216, 191, 216));
		panel.add(im_4);
		im_4.setBounds(-6, -11, 456, 283);
		im_4.setIcon(new ImageIcon(img));
		panel.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				manuepartya window1 = new manuepartya();
				window1.frame.setVisible(true);
				frame.setVisible(false); 
				

			}
		});	

	}
}

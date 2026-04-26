package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import com.toedter.calendar.JDateChooser;

import control.FriendLogic;
import entity.CustomerinParty;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Color;
import javax.swing.border.EmptyBorder;

public class MFrmLogin {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MFrmLogin window = new MFrmLogin();
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
	public MFrmLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 814, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setLayout(null);
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		JLabel lblFreindshio = new JLabel("welcome to party system");
		lblFreindshio.setForeground(new Color(255, 255, 255));
		lblFreindshio.setBackground(SystemColor.activeCaption);
		lblFreindshio.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFreindshio.setBounds(327, 0, 225, 40);
		panel.add(lblFreindshio);

		JPanel pnlEmpDetails = new JPanel();
		pnlEmpDetails.setBackground(new Color(255, 255, 255));
		pnlEmpDetails.setBorder(null);
		pnlEmpDetails.setBounds(101, 186, 132, 25);
		panel.add(pnlEmpDetails);

		JLabel lblHireDate_1_1 = new JLabel("End Date:");

		JDateChooser dtcBirthDate_1 = new JDateChooser();
		
		JTextArea passwordarea = new JTextArea();
		GroupLayout gl_pnlEmpDetails = new GroupLayout(pnlEmpDetails);
		gl_pnlEmpDetails.setHorizontalGroup(
			gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlEmpDetails.createSequentialGroup()
					.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_pnlEmpDetails.createSequentialGroup()
							.addGap(188)
							.addComponent(lblHireDate_1_1)
							.addGap(18)
							.addComponent(dtcBirthDate_1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE))
						.addComponent(passwordarea, GroupLayout.PREFERRED_SIZE, 132, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_pnlEmpDetails.setVerticalGroup(
			gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlEmpDetails.createSequentialGroup()
					.addComponent(passwordarea, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE)
					.addGap(185)
					.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
						.addComponent(dtcBirthDate_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblHireDate_1_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		pnlEmpDetails.setLayout(gl_pnlEmpDetails);

		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(44, 227, 87, 32);
		panel.add(panel_3);
		
				JButton btnLogIn = new JButton("Log in");
				panel_3 .add(btnLogIn);
				btnLogIn.setForeground(new Color(0, 0, 0));
				btnLogIn.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
				btnLogIn.setBackground(new Color(255, 255, 255));
				Image img1 = new ImageIcon(this.getClass().getResource("/login222.jpeg")).getImage();
				
				
						btnLogIn.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent e) {
				
								if (passwordarea.getText().equals("partya")) {
									manuepartya f1 = new manuepartya();
									f1.frame.setVisible(true);
									frame.setVisible(false);
				
								}
								
								
								else if (passwordarea.getText().equals("mangeparty")) {
									Manumangeparty1 f1 = new Manumangeparty1();
									f1.frame1.setVisible(true);
									frame.setVisible(false);
				
								} else {
									JFrame frame2 = new JFrame();
									JOptionPane.showMessageDialog(frame2, "please enter you system you want tp login!! try again ");
				
								}
								
								
							}
				
						}
				
						);
						
						JLabel lblFreindshio_1 = new JLabel("My System :");
						lblFreindshio_1.setForeground(Color.WHITE);
						lblFreindshio_1.setFont(new Font("Tahoma", Font.BOLD, 15));
						lblFreindshio_1.setBackground(Color.WHITE);
						lblFreindshio_1.setBounds(6, 175, 167, 40);
						panel.add(lblFreindshio_1);
						
								btnLogIn.setHorizontalAlignment(SwingConstants.LEFT);
								
		JLabel im_2_3 = new JLabel("");
		im_2_3.setBounds(-177, -151, 990, 623);
		panel.add(im_2_3);
		im_2_3.setIcon(new ImageIcon(img1));
	
	}
}

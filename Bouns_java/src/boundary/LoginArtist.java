
	package boundary;

	import java.awt.EventQueue;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import java.awt.BorderLayout;
	import java.awt.Container;
	import java.awt.Font;
	import java.awt.Image;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
	import java.util.ArrayList;
	import java.awt.image.*;
	import javax.swing.JPanel;
	import javax.swing.JTextArea;
	import javax.swing.GroupLayout;
	import javax.swing.GroupLayout.Alignment;
	import javax.swing.JTextField;
	import com.toedter.calendar.JDateChooser;
	import javax.swing.ImageIcon;
	import control.FriendLogic;
	import entity.CustomerinParty;

	import javax.swing.LayoutStyle.ComponentPlacement;
	import javax.swing.JButton;
	import javax.swing.SwingConstants;
	import java.awt.SystemColor;
import java.awt.Window;

import javax.swing.JPasswordField;

	public class LoginArtist {

		JFrame frame;
		private JTextField login;
		JTextArea resultArea = new JTextArea(3,50);
		private JPasswordField passwordField;
		

		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						LoginArtist window = new LoginArtist();
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
		public LoginArtist() {
			initialize();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initialize() {
			frame = new JFrame();
			frame.setBounds(100, 100, 609, 482);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel panel = new JPanel();
			panel.setBackground(SystemColor.activeCaption);
			panel.setForeground(SystemColor.activeCaption);
			panel.setLayout(null);
			frame.getContentPane().add(panel, BorderLayout.CENTER);

			JPanel pnlEmpDetails = new JPanel();
			pnlEmpDetails.setBackground(SystemColor.activeCaption);
			pnlEmpDetails.setBorder(null);
			pnlEmpDetails.setBounds(103, 297, 392, 89);
			panel.add(pnlEmpDetails);

			JLabel lblHireDate_1_1 = new JLabel("End Date:");

			JLabel lblPhoneNumber = new JLabel("Username");

			JDateChooser dtcBirthDate_1 = new JDateChooser();
			
           JLabel lblPassword = new JLabel("Password");
			
			passwordField = new JPasswordField();

			login = new JTextField();
			login.setText((String) null);
			login.setColumns(10);

			JButton btnLogIn = new JButton("Log in");

			btnLogIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<CustomerinParty> results = new ArrayList<CustomerinParty>();
					results = FriendLogic.getInstance().getCustomerinParty();
					int phone;
					for (int i = 0; i < results.size(); i++) {
						phone = results.get(i).getPhonenumber();

						String num = String.valueOf(phone);
						if (login.getText().equals("Artist") &&passwordField.getText().equals("Artist") ) {
							ManueArtist f1 = new ManueArtist();
							f1.frame1.setVisible(true);
							resultArea.setText("");
						    resultArea.setText("Success Log in");
							resultArea.setFont(new Font("Courier New", Font.BOLD, 12));
							login.setText("");
							  frame.setVisible(false);

						} else {
							resultArea.setText("");
							resultArea.setText("failed, please try again!");
							resultArea.setFont(new Font("Courier New", Font.BOLD, 12));
							login.setText("");
							
						}		
					}
					
				  
				

				}
			}

			);

			btnLogIn.setHorizontalAlignment(SwingConstants.LEFT);
			
			
			GroupLayout gl_pnlEmpDetails = new GroupLayout(pnlEmpDetails);
			gl_pnlEmpDetails.setHorizontalGroup(
				gl_pnlEmpDetails.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnlEmpDetails.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_pnlEmpDetails.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblHireDate_1_1)
								.addGap(18))
							.addGroup(gl_pnlEmpDetails.createSequentialGroup()
								.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblPhoneNumber))
								.addPreferredGap(ComponentPlacement.UNRELATED)))
						.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnlEmpDetails.createSequentialGroup()
								.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
									.addComponent(dtcBirthDate_1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
									.addComponent(login, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE))
								.addContainerGap(110, Short.MAX_VALUE))
							.addGroup(Alignment.TRAILING, gl_pnlEmpDetails.createSequentialGroup()
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)
								.addGap(68)
								.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
								.addGap(24))))
			);
			gl_pnlEmpDetails.setVerticalGroup(
				gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlEmpDetails.createSequentialGroup()
						.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnlEmpDetails.createSequentialGroup()
								.addContainerGap()
								.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.BASELINE)
									.addComponent(login, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblPhoneNumber))
								.addGap(7)
								.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.BASELINE)
									.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblPassword))
								.addGap(116)
								.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
									.addComponent(dtcBirthDate_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblHireDate_1_1)))
							.addGroup(gl_pnlEmpDetails.createSequentialGroup()
								.addGap(59)
								.addComponent(btnLogIn)))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			pnlEmpDetails.setLayout(gl_pnlEmpDetails);

			JLabel lblLogIn = new JLabel("Log in to Artist system:");
			lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblLogIn.setBounds(187, 0, 216, 40);
			panel.add(lblLogIn);
			
			JButton btnNewButton = new JButton("<-");
			btnNewButton.setBounds(0, 0, 89, 23);
			panel.add(btnNewButton);
		
			
			JLabel im = new JLabel("");
			im.setBounds(152, 39, 326, 246);
			panel.add(im);
			Image img=new ImageIcon(this.getClass().getResource("/login.png")).getImage();
			im.setIcon(new ImageIcon(img));
			resultArea.setBounds(6, 389, 600, 48);
			panel.add(resultArea);
			resultArea.setBackground(SystemColor.text);
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					Manumangeparty1 window1 = new Manumangeparty1();
					 window1.frame1.setVisible(true);
					frame.setVisible(false); 
					

				}
			});	
		}
	}



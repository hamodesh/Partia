

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
import javax.swing.JPasswordField;

import boundary.ManueAgent;

	public class LoginAgent {

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
						LoginAgent window = new LoginAgent();
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
		public LoginAgent() {
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
			pnlEmpDetails.setBounds(93, 277, 392, 91);
			panel.add(pnlEmpDetails);

			JLabel lblHireDate_1_1 = new JLabel("End Date:");

			JLabel lblPhoneNumber = new JLabel("Username");

			JDateChooser dtcBirthDate_1 = new JDateChooser();

			login = new JTextField();
			login.setText((String) null);
			login.setColumns(10);

			JButton btnLogIn = new JButton("Log in");
			
        JLabel lblPassword = new JLabel("Password");
			
			passwordField = new JPasswordField();
			passwordField.setText((String) null);
			passwordField.setColumns(10);

			btnLogIn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<CustomerinParty> results = new ArrayList<CustomerinParty>();
					results = FriendLogic.getInstance().getCustomerinParty();
					int phone;
					
						

						
						if (login.getText().equals("Agent") && passwordField.getText().equals("Agent"))  {
							System.out.println("asd");
							ManueAgent window1 = new ManueAgent();
							window1.frame1.setVisible(true);
							
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

			);

			btnLogIn.setHorizontalAlignment(SwingConstants.LEFT);
			
			
			GroupLayout gl_pnlEmpDetails = new GroupLayout(pnlEmpDetails);
			gl_pnlEmpDetails.setHorizontalGroup(
				gl_pnlEmpDetails.createParallelGroup(Alignment.TRAILING)
					.addGroup(gl_pnlEmpDetails.createSequentialGroup()
						.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_pnlEmpDetails.createSequentialGroup()
								.addContainerGap()
								.addComponent(lblHireDate_1_1)
								.addGap(10))
							.addGroup(Alignment.TRAILING, gl_pnlEmpDetails.createSequentialGroup()
								.addContainerGap(54, Short.MAX_VALUE)
								.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
									.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
									.addComponent(lblPhoneNumber))
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
							.addComponent(dtcBirthDate_1, GroupLayout.PREFERRED_SIZE, 179, GroupLayout.PREFERRED_SIZE)
							.addGroup(gl_pnlEmpDetails.createSequentialGroup()
								.addGap(18)
								.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(passwordField, Alignment.LEADING)
									.addComponent(login, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE))))
						.addContainerGap(91, Short.MAX_VALUE))
					.addGroup(gl_pnlEmpDetails.createSequentialGroup()
						.addContainerGap(299, Short.MAX_VALUE)
						.addComponent(btnLogIn, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addGap(18))
			);
			gl_pnlEmpDetails.setVerticalGroup(
				gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_pnlEmpDetails.createSequentialGroup()
						.addContainerGap()
						.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPhoneNumber)
							.addComponent(login, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.BASELINE)
							.addComponent(lblPassword)
							.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(btnLogIn)
						.addGap(108)
						.addGroup(gl_pnlEmpDetails.createParallelGroup(Alignment.LEADING)
							.addComponent(dtcBirthDate_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(lblHireDate_1_1))
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
			);
			pnlEmpDetails.setLayout(gl_pnlEmpDetails);

			JLabel lblLogIn = new JLabel("Log in to Agent system:");
			lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblLogIn.setBounds(192, 0, 226, 40);
			panel.add(lblLogIn);
			
			JButton btnNewButton = new JButton("<-");
			btnNewButton.setBounds(0, 0, 89, 23);
			panel.add(btnNewButton);
		
			
			JLabel im = new JLabel("");
			im.setBounds(162, 39, 326, 246);
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





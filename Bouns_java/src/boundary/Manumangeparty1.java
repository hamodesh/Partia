


	package boundary;

	import java.awt.event.KeyAdapter;

	import java.awt.event.KeyEvent;
	import java.sql.CallableStatement;
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.util.ArrayList;
	import java.util.Date;

	import javax.swing.GroupLayout.Alignment;
	import com.toedter.calendar.JDateChooser;

	import control.PartyLogic;
	import control.XmlLogic;
	import entity.Consts;
	import entity.Party;

	import javax.swing.LayoutStyle.ComponentPlacement;

	import java.awt.*;

	import javax.swing.*;

	import javax.swing.border.EmptyBorder;
	import javax.swing.GroupLayout.Alignment;
	import javax.swing.LayoutStyle.ComponentPlacement;

	import com.toedter.calendar.JDateChooser;
	import java.awt.event.ActionListener;
	import java.util.ArrayList;
	import java.awt.event.ActionEvent;

	import javax.swing.border.TitledBorder;

	import java.awt.event.KeyAdapter;
	import java.awt.event.KeyEvent;
	import java.awt.event.FocusAdapter;
	import java.awt.event.FocusEvent;

	
		public class Manumangeparty1 {

			JFrame frame1;
			private JTextField txtWelcomeToPartya;

			/**
			 * Launch the application.
			 */
			public static void main1(String[] args) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Manumangeparty1 window = new Manumangeparty1();
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
			public Manumangeparty1() {
				initialize1();
			}

			/**
			 * Initialize the contents of the frame.
			 */
			private void initialize1() {
				frame1 = new JFrame();
				frame1.setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/test/Desktop/images.jpeg"));
				frame1.setBounds(100, 100, 824, 621);
				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				JMenuItem backtochoose1;
				JMenuItem backtochoose2;
				JMenuItem backtochoose3;
				JMenuItem backtochoose4;
				
				JPanel panel = new JPanel();
				panel.setForeground(new Color(100, 149, 237));
				panel.setBackground(new Color(0, 0, 0));
				panel.setLayout(null);
				frame1.getContentPane().add(panel, BorderLayout.CENTER);

				
				
				JPanel panel_2 = new JPanel();
				panel_2.setBackground(new Color(51, 102, 204));
				panel_2.setForeground(SystemColor.activeCaptionText);
				panel_2.setBounds(0, 0, 1019, 29);
				panel.add(panel_2);
				
				JButton btnNewButton_1 = new JButton("i am artist ");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						LoginArtist window1 = new  LoginArtist	();
						window1.frame.setVisible(true);
						frame1.setVisible(false); 
						

					}
				});
				
				JButton btnNewButton_31 = new JButton("i am agent &Admin");
				btnNewButton_31.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						LoginAgent window1 = new LoginAgent();
						window1.frame.setVisible(true);
						frame1.setVisible(false); 
						

					}
				});
				
				JButton btnNewButton_31_1 = new JButton("Export  the partys to json file ");
				btnNewButton_31_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						exportpartyafromjson window1 = new exportpartyafromjson();
						window1.frame.setVisible(true);
						frame1.setVisible(false); 
						

					}
				});
				JButton btnNewButton_31_1_1 = new JButton("import   the order from  xml file ");
				btnNewButton_31_1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						importpayXmIL window1 = new importpayXmIL();
						window1.frame.setVisible(true);
						frame1.setVisible(false); 
						

					}
				});
				
				JButton btnNewButton_1_1 = new JButton("Log Out");
				btnNewButton_1_1.setForeground(Color.RED);
				btnNewButton_1_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						MFrmLogin window1 = new MFrmLogin();
						window1.frame.setVisible(true);
						frame1.setVisible(false); 
						

					}
				});
				
				
				
					

				
				
				GroupLayout gl_panel_2 = new GroupLayout(panel_2);
				gl_panel_2.setHorizontalGroup(
					gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnNewButton_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_31, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_31_1, GroupLayout.PREFERRED_SIZE, 206, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_31_1_1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnNewButton_1_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(253, Short.MAX_VALUE))
				);
				gl_panel_2.setVerticalGroup(
					gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnNewButton_31)
								.addComponent(btnNewButton_31_1)
								.addComponent(btnNewButton_31_1_1)
								.addComponent(btnNewButton_1_1)
								.addComponent(btnNewButton_1))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
				panel_2.setLayout(gl_panel_2);
				
				txtWelcomeToPartya = new JTextField();
				txtWelcomeToPartya.setBackground(new Color(75, 0, 130));
				txtWelcomeToPartya.setForeground(SystemColor.textHighlight);
				txtWelcomeToPartya.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
				txtWelcomeToPartya.setHorizontalAlignment(SwingConstants.LEFT);
				txtWelcomeToPartya.setText("  welcome to MangeParty");
				txtWelcomeToPartya.setBounds(292, 43, 259, 58);
				panel.add(txtWelcomeToPartya);
				txtWelcomeToPartya.setColumns(10);
				
				JLabel im= new JLabel("");
				im.setForeground(Color.WHITE);
				im.setBounds(0, 307, 282, 285);
				panel.add(im);
				Image img=new ImageIcon(this.getClass().getResource("/gggg.jpeg")).getImage();
				im.setIcon(new ImageIcon(img));
				
				JLabel im_2 = new JLabel("");
				im_2.setBounds(0, 28, 282, 290);
				panel.add(im_2);
				im_2.setIcon(new ImageIcon(img));
				
				JLabel im_3 = new JLabel("");
				im_3.setBounds(283, 293, 295, 310);
				panel.add(im_3);
				im_3.setIcon(new ImageIcon(img));
				
				JLabel im_2_2 = new JLabel("");
				im_2_2.setBounds(0, 28, 282, 267);
				panel.add(im_2_2);
				im_2_2.setIcon(new ImageIcon(img));
				
				JLabel im_2_3 = new JLabel("");
				im_2_3.setBounds(283, 28, 282, 278);
				panel.add(im_2_3);
				im_2_3.setIcon(new ImageIcon(img));
				
				JLabel im_2_4 = new JLabel("");
				im_2_4.setBounds(551, 307, 282, 278);
				panel.add(im_2_4);
				im_2_4.setIcon(new ImageIcon(img));
				
				JLabel im_2_5 = new JLabel("");
				im_2_5.setBounds(566, 28, 282, 278);
				panel.add(im_2_5);
				im_2_5.setIcon(new ImageIcon(img));
			}

			
		
		public JFrame frame;
		private JDateChooser startDate = new JDateChooser();
		private JDateChooser endDate = new JDateChooser();

	
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						Manumangeparty1 window = new Manumangeparty1();
						window.frame1.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}


		public void Manumangeparty() {
			initialize1();
		
		}

		
		private void initialize() {
			frame1 = new JFrame();
			frame1.setBounds(100, 100, 760, 506);
			frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			frame1.getContentPane().add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			JLabel lblCreatParty = new JLabel("import new orders from XmIL :    \r\n");
			lblCreatParty.setForeground(new Color(0, 0, 0));
			lblCreatParty.setFont(new Font("Tahoma", Font.BOLD, 15));
			lblCreatParty.setBounds(20, 39, 358, 91);
			panel.add(lblCreatParty);
			
			JDesktopPane desktopPane = new JDesktopPane();
			desktopPane.setBounds(231, 133, 1, 1);
			panel.add(desktopPane);
			
			JButton btnNewButton = new JButton("<-");
			btnNewButton.setBounds(20, 17, 89, 23);
			panel.add(btnNewButton);
			
			
			JButton btnNewButton_1 = new JButton("import");
			btnNewButton_1.setBounds(57, 144, 89, 23);
			panel.add(btnNewButton_1);
			
			
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					JFrame frame = new JFrame();
					JOptionPane.showMessageDialog(frame, "The new Order are importet sucssfully✅");
					
					//XmlLogic.getInstance().importCustomersFromXML2("xml/customers2.xml");
					

				}
			});	
			JLabel im_4 = new JLabel("");
			im_4.setForeground(Color.WHITE);
			im_4.setBackground(Color.WHITE);
			panel.add(im_4);
			im_4.setBounds(-287, 0, 1072, 478);
			
			Image img = new ImageIcon(this.getClass().getResource("/cover3.jpeg")).getImage();

			im_4.setIcon(new ImageIcon(img));
		}
}

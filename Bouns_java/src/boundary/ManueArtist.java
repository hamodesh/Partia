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

	
		public class ManueArtist {

			JFrame frame1;
			private JTextField txtWelcomeToPartya;

			public ManueArtist() {
				initialize1();
			}

			/**
			 * Initialize the contents of the frame.
			 */
			private void initialize1() {
				frame1 = new JFrame();
				frame1.setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/test/Desktop/images.jpeg"));
				frame1.setBounds(100, 100, 803, 527);
				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
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
				
				JButton btnNewButton_1 = new JButton("change agent ");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						changeS window1 = new  changeS	();
						window1.setVisible(true);
						frame1.setVisible(false); 
						

					}
				});
				
				JButton btnNewButton_31 = new JButton("request party ");
				btnNewButton_31.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Aceeptartist window1 = new Aceeptartist();
						window1.setVisible(true);
						frame1.setVisible(false); 
						

					}
				});
				
				JButton btnLogOut = new JButton("Log Out\r\n");
				btnLogOut.setForeground(Color.RED);
				btnLogOut.setBackground(Color.WHITE);
				btnLogOut.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						MFrmLogin window1 = new MFrmLogin();
						window1.frame.setVisible(true);
						frame1.setVisible(false); 
						

					}
				});
				
				JButton btnNewButton44 = new JButton("Report New party");
				
				btnNewButton44.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						ArtistRpt2 window1 = new ArtistRpt2();
						window1.setVisible(true);
						frame1.setVisible(false); 
						

					}
				});
				
				
				
				
				
					

				
				
				GroupLayout gl_panel_2 = new GroupLayout(panel_2);
				gl_panel_2.setHorizontalGroup(
					gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(28)
							.addComponent(btnNewButton_1)
							.addGap(18)
							.addComponent(btnNewButton_31, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
							.addGap(26)
							.addComponent(btnNewButton44, GroupLayout.PREFERRED_SIZE, 137, GroupLayout.PREFERRED_SIZE)
							.addGap(166)
							.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(263, Short.MAX_VALUE))
				);
				gl_panel_2.setVerticalGroup(
					gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLogOut)
								.addComponent(btnNewButton_1)
								.addComponent(btnNewButton_31)
								.addComponent(btnNewButton44))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
				panel_2.setLayout(gl_panel_2);
				
				txtWelcomeToPartya = new JTextField();
				txtWelcomeToPartya.setBackground(new Color(255, 255, 255));
				txtWelcomeToPartya.setForeground(new Color(102, 153, 255));
				txtWelcomeToPartya.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
				txtWelcomeToPartya.setHorizontalAlignment(SwingConstants.LEFT);
				txtWelcomeToPartya.setText("  welcome Artist ");
				txtWelcomeToPartya.setBounds(317, 49, 166, 61);
				panel.add(txtWelcomeToPartya);
				txtWelcomeToPartya.setColumns(10);
				
				JLabel im= new JLabel("");
				im.setForeground(Color.WHITE);
				im.setBounds(-260, 6, 1074, 517);
				panel.add(im);
				Image img=new ImageIcon(this.getClass().getResource("/artistcover.jpeg")).getImage();
				im.setIcon(new ImageIcon(img));
			}

			
		
		protected void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}



		public JFrame frame;
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ManueArtist window = new ManueArtist();
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

		
		
}



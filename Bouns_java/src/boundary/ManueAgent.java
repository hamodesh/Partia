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
	import javax.swing.JFrame;
	
	
	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.JScrollPane;
	import javax.swing.JTable;
	import javax.swing.border.EmptyBorder;

	import control.FriendLogic;
	import entity.CustomerinParty;
	import entity.NewParty;
	import entity.Party;

	import javax.swing.JLabel;
	import javax.swing.JTextField;
	import javax.swing.JButton;
	import java.awt.event.ActionListener;
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
	
		public class ManueAgent {

			JFrame frame1;
			private JTextField txtWelcomeToPartya;

			public ManueAgent() {
				initialize1();
			}

			/**
			 * Initialize the contents of the frame.
			 */
			private void initialize1() {
				frame1 = new JFrame();
				frame1.setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/test/Desktop/images.jpeg"));
				frame1.setBounds(100, 100, 804, 621);
				frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
				
				JPanel panel = new JPanel();
				panel.setForeground(new Color(100, 149, 237));
				panel.setBackground(new Color(0, 0, 0));
				panel.setLayout(null);
				frame1.getContentPane().add(panel, BorderLayout.CENTER);

				
				
				JPanel panel_2 = new JPanel();
				panel_2.setBackground(new Color(0, 0, 0));
				panel_2.setForeground(SystemColor.activeCaptionText);
				panel_2.setBounds(0, 0, 1019, 29);
				panel.add(panel_2);
				
				JButton btnNewButton_31 = new JButton("Setting up the shows");
				btnNewButton_31.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Manueaddbandsartist window1 = new Manueaddbandsartist();
						window1.setVisible(true);
						frame1.setVisible(false); 
						

					}
				});
				
				JButton btnReportPartyAgent = new JButton("Report Agent party");
				btnReportPartyAgent.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					FrmReportAgent window1 = new FrmReportAgent();
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
				
				
				
				
				
				
					

				
				
				GroupLayout gl_panel_2 = new GroupLayout(panel_2);
				gl_panel_2.setHorizontalGroup(
					gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGap(33)
							.addComponent(btnNewButton_31, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
							.addGap(33)
							.addComponent(btnReportPartyAgent, GroupLayout.PREFERRED_SIZE, 195, GroupLayout.PREFERRED_SIZE)
							.addGap(233)
							.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(247, Short.MAX_VALUE))
				);
				gl_panel_2.setVerticalGroup(
					gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnLogOut)
								.addComponent(btnNewButton_31)
								.addComponent(btnReportPartyAgent))
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);
				panel_2.setLayout(gl_panel_2);
				
				txtWelcomeToPartya = new JTextField();
				txtWelcomeToPartya.setBackground(new Color(0, 0, 0));
				txtWelcomeToPartya.setForeground(new Color(205, 133, 63));
				txtWelcomeToPartya.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
				txtWelcomeToPartya.setHorizontalAlignment(SwingConstants.LEFT);
				txtWelcomeToPartya.setText("  welcome agent ");
				txtWelcomeToPartya.setBounds(306, 62, 184, 58);
				panel.add(txtWelcomeToPartya);
				txtWelcomeToPartya.setColumns(10);
				
				JLabel im= new JLabel("");
				im.setForeground(Color.WHITE);
				im.setBounds(0, 307, 275, 285);
				panel.add(im);
				Image img=new ImageIcon(this.getClass().getResource("/agents2.jpeg")).getImage();
				im.setIcon(new ImageIcon(img));
				
				JLabel im_3 = new JLabel("");
				im_3.setBounds(287, 292, 292, 316);
				panel.add(im_3);
				im_3.setIcon(new ImageIcon(img));
				
				JLabel im_2_2 = new JLabel("");
				im_2_2.setBounds(0, 28, 282, 250);
				panel.add(im_2_2);
				im_2_2.setIcon(new ImageIcon(img));
				
				JLabel im_2_3 = new JLabel("");
				im_2_3.setBounds(283, 17, 282, 278);
				panel.add(im_2_3);
				im_2_3.setIcon(new ImageIcon(img));
				
				JLabel im_2_4 = new JLabel("");
				im_2_4.setBounds(572, 314, 275, 278);
				panel.add(im_2_4);
				im_2_4.setIcon(new ImageIcon(img));
				
				JLabel im_2_5 = new JLabel("");
				im_2_5.setBounds(562, 17, 282, 278);
				panel.add(im_2_5);
				im_2_5.setIcon(new ImageIcon(img));
			}

			
		
		protected void setVisible(boolean b) {
				// TODO Auto-generated method stub
				
			}



		public JFrame frame;
		
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						ManueAgent window = new ManueAgent();
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



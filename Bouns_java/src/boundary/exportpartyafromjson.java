


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

		public class exportpartyafromjson {

			public JFrame frame;
			private JDateChooser startDate = new JDateChooser();
			private JDateChooser endDate = new JDateChooser();

			private static final long serialVersionUID = 1;
			private ArrayList<entity.Party> PartyArray;
			private Integer currentParty;
			private boolean inAddMode;

			private JButton btnFirst = new JButton("|<");
			private JButton btnPrev = new JButton("<<");
			private final JButton x = new JButton("Save");
			private JButton btnNext = new JButton(">>");
			private JButton btnLast = new JButton(">|");

			public static void main(String[] args) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							exportpartyafromjson window = new exportpartyafromjson();
							window.frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}


			public exportpartyafromjson() {
				initialize();
			
			}

			
			private void initialize() {
				frame = new JFrame();
				frame.setBounds(100, 100, 760, 506);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				JPanel panel = new JPanel();
				panel.setBackground(Color.WHITE);
				frame.getContentPane().add(panel, BorderLayout.CENTER);
				panel.setLayout(null);
				JLabel lblCreatParty = new JLabel("export new orders from json :    \r\n");
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
				
				
				JButton btnNewButton_1 = new JButton("export");
				btnNewButton_1.setBounds(57, 144, 89, 23);
				panel.add(btnNewButton_1);
				
				
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						PartyLogic.getInstance().exportPartytsToJSON();
						
						JFrame frame = new JFrame();
						JOptionPane.showMessageDialog(frame, "The partys are export  sucssfully✅");
						
						//XmlLogic.getInstance().importCustomersFromXML2("xml/customers2.xml");
						

					}
				});	
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						Manumangeparty1 window1 = new Manumangeparty1();
						 window1.frame1.setVisible(true);
						frame.setVisible(false); 
						
						
						
						

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




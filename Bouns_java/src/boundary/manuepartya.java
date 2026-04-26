package boundary;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import com.toedter.calendar.JDateChooser;

import control.FriendLogic;
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
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

public class manuepartya {

	JFrame frame;
	private JTextField txtWelcomeToPartya;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					manuepartya window = new manuepartya();
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
	public manuepartya() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/test/Desktop/images.jpeg"));
		frame.setBounds(100, 100, 910, 621);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuItem backtochoose1;
		JMenuItem backtochoose2;
		JMenuItem backtochoose3;
		JMenuItem backtochoose4;
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(100, 149, 237));
		panel.setBackground(new Color(0, 0, 0));
		panel.setLayout(null);
		frame.getContentPane().add(panel, BorderLayout.CENTER);

		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(51, 102, 204));
		panel_2.setForeground(SystemColor.activeCaptionText);
		panel_2.setBounds(0, 0, 1019, 29);
		panel.add(panel_2);
		
		JButton btnNewButton_1 = new JButton("friendship");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FrmimportXmlAndLogin window1 = new  FrmimportXmlAndLogin	();
				window1.frame.setVisible(true);
				frame.setVisible(false); 
				

			}
		});
		
		JButton btnNewButton_2 = new JButton("pay crdiet");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FrmPay window1 = new FrmPay();
				window1.frame.setVisible(true);
				frame.setVisible(false); 
				

			}
		});
		
		JButton btnNewButton_31 = new JButton("Schedule of Party");
		btnNewButton_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Frmsch window1 = new Frmsch();
				window1.setVisible(true);
				frame.setVisible(false); 
				

			}
		});
		
		JButton btnNewButton_4 = new JButton("report party this mounth ");
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FrmRepoet window1 = new FrmRepoet();
				window1.setVisible(true);
				frame.setVisible(false); 
				

			}
		});

JButton btnNewButton_5 = new JButton("import from jason  ");
		
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Frmimportjson window1 = new Frmimportjson();
				window1.frame.setVisible(true);
				frame.setVisible(false); 
				

			}
		});	
		
		JButton btnNewButton_10 = new JButton("My order");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Frmorder window1 = new Frmorder();
				window1.frame.setVisible(true);
				frame.setVisible(false); 
				

			}
		});	
		
		JButton btnLogOut = new JButton("Log Out\r\n");
		btnLogOut.setForeground(Color.RED);
		btnLogOut.setBackground(Color.WHITE);
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MFrmLogin window1 = new MFrmLogin();
				window1.frame.setVisible(true);
				frame.setVisible(false); 
				

			}
		});
		
		
		
		
			

		
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_31, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_5, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_10, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnLogOut, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(149, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_31)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_5)
						.addComponent(btnNewButton_10)
						.addComponent(btnLogOut)
						.addComponent(btnNewButton_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_2.setLayout(gl_panel_2);
		
		txtWelcomeToPartya = new JTextField();
		txtWelcomeToPartya.setBackground(new Color(75, 0, 130));
		txtWelcomeToPartya.setForeground(SystemColor.textHighlight);
		txtWelcomeToPartya.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		txtWelcomeToPartya.setHorizontalAlignment(SwingConstants.LEFT);
		txtWelcomeToPartya.setText("  welcome to Partya");
		txtWelcomeToPartya.setBounds(331, 56, 199, 58);
		panel.add(txtWelcomeToPartya);
		txtWelcomeToPartya.setColumns(10);
		
		JLabel im= new JLabel("");
		im.setForeground(Color.WHITE);
		im.setBounds(0, 321, 282, 285);
		panel.add(im);
		Image img=new ImageIcon(this.getClass().getResource("/gggg.jpeg")).getImage();
		im.setIcon(new ImageIcon(img));
		
		JLabel im_2 = new JLabel("");
		im_2.setBounds(10, 24, 295, 290);
		panel.add(im_2);
		im_2.setIcon(new ImageIcon(img));
		
		JLabel im_3 = new JLabel("");
		im_3.setBounds(293, 310, 295, 296);
		panel.add(im_3);
		im_3.setIcon(new ImageIcon(img));
		
		JLabel im_2_3 = new JLabel("");
		im_2_3.setBounds(306, 17, 282, 278);
		panel.add(im_2_3);
		im_2_3.setIcon(new ImageIcon(img));
		
		JLabel im_2_4 = new JLabel("");
		im_2_4.setBounds(598, 317, 308, 268);
		panel.add(im_2_4);
		im_2_4.setIcon(new ImageIcon(img));
		
		JLabel im_2_5 = new JLabel("");
		im_2_5.setBounds(599, 23, 308, 278);
		panel.add(im_2_5);
		im_2_5.setIcon(new ImageIcon(img));
	}

	
}

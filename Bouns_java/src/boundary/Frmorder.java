package boundary;



import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.GroupLayout.Alignment;
import com.toedter.calendar.JDateChooser;

import control.FriendLogic;
import control.PartyLogic;
import control.XmlLogic;
import entity.Consts;
import entity.CustomerinParty;
import entity.Order;
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

public class Frmorder {

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
	private JTextField txtSendingNoticeTo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmorder window = new Frmorder();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Frmorder() {
		initialize();
	
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 946, 472);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JComboBox c3 = new JComboBox();
		c3.setBackground(Color.BLUE);
		c3.setForeground(SystemColor.controlHighlight);
		c3.setBounds(238, 75, 179, 20);
		ArrayList<Order> resultss = new ArrayList<Order>();
		resultss = FriendLogic.getInstance().getOrder();
		ArrayList<Party> resultss2 = new ArrayList<Party>();
		resultss2 = FriendLogic.getInstance().getParty();
		for (int i = 0; i < resultss.size(); i++) {
			int num=Integer.parseInt((String)  resultss.get(i).getIdparty());
			 
			if( num==resultss2.get(i).getPartyid())
			{
				c3.addItem("id party:"+resultss.get(i).getIdparty()+ "    "+"name Prty:"+resultss2.get(i).getPartyname() );
			}
			
		}
		panel.add(c3);
		
		
		
		JLabel lblTheScheduleOf = new JLabel("The schedule of partys:");
		lblTheScheduleOf.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTheScheduleOf.setBounds(22, 66, 214, 35);
		panel.add(lblTheScheduleOf);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.setBounds(0, 0, 89, 23);
		panel.add(btnNewButton);
		Image img = new ImageIcon(this.getClass().getResource("/cover3.jpeg")).getImage();
		JLabel im_4 = new JLabel("");
		im_4.setForeground(new Color(240, 128, 128));
		im_4.setBackground(new Color(216, 191, 216));
		panel.add(im_4);
		im_4.setBounds(-6, -11, 952, 455);
		im_4.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//XmlLogic.getInstance().exportCustomersToXML();
				manuepartya window1 = new manuepartya();
				window1.frame.setVisible(true);
				frame.setVisible(false); 
				

			}
		});	
		
	}
}
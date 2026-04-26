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

public class Frmsendorded {

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
	private JTextField txtKl;
	private JTextField txtSendingNoticeTo;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frmsendorded window = new Frmsendorded();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Frmsendorded() {
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
		
		txtKl = new JTextField();
		txtKl.setForeground(new Color(0, 128, 0));
		txtKl.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		txtKl.setBounds(45, 71, 431, 57);
		panel.add(txtKl);
		txtKl.setText("The order sennding to mangeparty system sucssfully✅");
		txtKl.setColumns(10);
		
		JComboBox c3 = new JComboBox();
		c3.setBackground(Color.BLUE);
		c3.setForeground(SystemColor.controlHighlight);
		c3.setBounds(58, 192, 179, 20);
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
		lblTheScheduleOf.setBounds(58, 146, 214, 35);
		panel.add(lblTheScheduleOf);
		
		JButton btnNewButton1 = new JButton("<-");
		btnNewButton1.setBounds(0, 0, 89, 23);
	
		btnNewButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				FrmPay window1 = new FrmPay();
				window1.frame.setVisible(true);
				frame.setVisible(false); 
				

			}
		});	
		
		panel.add(btnNewButton1);
		Image img = new ImageIcon(this.getClass().getResource("/cover3.jpeg")).getImage();
		JLabel im_4 = new JLabel("");
		im_4.setForeground(new Color(240, 128, 128));
		im_4.setBackground(new Color(216, 191, 216));
		panel.add(im_4);
		im_4.setBounds(-6, -11, 952, 455);
		im_4.setIcon(new ImageIcon(img));
		
		
	}
}
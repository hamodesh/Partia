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

public class Importjsonsucsses {

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
					Importjsonsucsses window = new Importjsonsucsses();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Importjsonsucsses() {
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
		JLabel lblCreatParty = new JLabel("import new party from json :    \r\n");
		lblCreatParty.setForeground(new Color(0, 0, 0));
		lblCreatParty.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblCreatParty.setBounds(10, 30, 358, 91);
		panel.add(lblCreatParty);
		
		txtKl = new JTextField();
		txtKl.setForeground(new Color(0, 128, 0));
		txtKl.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		txtKl.setBounds(139, 133, 345, 57);
		panel.add(txtKl);
		txtKl.setText("The new party are importet sucssfully✅");
		txtKl.setColumns(10);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(231, 133, 1, 1);
		panel.add(desktopPane);
		
		txtSendingNoticeTo = new JTextField();
		txtSendingNoticeTo.setText("Sending notice to vip customer ✅");
		txtSendingNoticeTo.setForeground(new Color(0, 128, 0));
		txtSendingNoticeTo.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		txtSendingNoticeTo.setColumns(10);
		txtSendingNoticeTo.setBounds(149, 202, 282, 57);
		panel.add(txtSendingNoticeTo);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.setBounds(0, 0, 89, 23);
		panel.add(btnNewButton);
		Image img = new ImageIcon(this.getClass().getResource("/cover3.jpeg")).getImage();
		JLabel im_4 = new JLabel("");
		im_4.setForeground(new Color(240, 128, 128));
		im_4.setBackground(new Color(216, 191, 216));
		panel.add(im_4);
		im_4.setBounds(-6, -11, 993, 455);
		im_4.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				manuepartya window1 = new manuepartya();
				window1.frame.setVisible(true);
				frame.setVisible(false); 
				

			}
		});	
	}
}
package boundary;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import control.FriendLogic;
import entity.CustomerinParty;
import entity.NewParty;
import entity.Party;
import entity.partywhithoutartist;

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

public class Manueaddbandsartist extends JFrame {

	private JPanel contentPane;
	protected Object frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Manueaddbandsartist frame = new Manueaddbandsartist();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Manueaddbandsartist() {
		setTitle("");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 804, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(418, 38, 212, 14);
		contentPane.add(lblError);

		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 74, 465, 112);
		contentPane.add(panel);

		JLabel lblClikTheParty = new JLabel("The Partys:\r\n");
		lblClikTheParty.setForeground(Color.BLACK);
		lblClikTheParty.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblClikTheParty.setBounds(10, 38, 282, 40);
		contentPane.add(lblClikTheParty);
		lblError.setText("");

		ArrayList<partywhithoutartist> results2 = new ArrayList<partywhithoutartist>();
		results2 = FriendLogic.getInstance().getpartywhitoutartist();

		if (results2.size() == 0) {
			// remove all components in panel.
			panel.removeAll();
			// refresh the panel.
			panel.updateUI();
			lblError.setText("No New Party ");
		} else {

			String[] column = new String[5];
			column[0] = "party Id";
			column[1] = "Number Artist";
			column[2] = "Name Party";
			column[3] = "Area";
			column[4] = "Date";

			// table body
			String data[][] = new String[results2.size()][5];
			int c = 0;
			for (int i = 0; i < results2.size(); i++) {

				data[i][0] = results2.get(i).getPartid();
				data[i][1] = results2.get(i).getNumberartist();
				data[i][2] = results2.get(i).getPartyname();
				data[i][3] = results2.get(i).getDate();
				data[i][4] = results2.get(i).getArea();
			}
			JTable jtable = new JTable(data, column);
			JScrollPane sp = new JScrollPane(jtable);
			// remove all components in panel.
			panel.removeAll();
			// refresh the panel.
			panel.updateUI();

			panel.add(sp);
			getContentPane().add(panel, BorderLayout.SOUTH);
			revalidate(); // called on a container once new components are added (refresh the page)

		}

		JLabel lblChooseWhatYou = new JLabel("choose what you want to Add:\r\n");
		lblChooseWhatYou.setForeground(Color.BLACK);
		lblChooseWhatYou.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblChooseWhatYou.setBounds(10, 231, 282, 40);
		contentPane.add(lblChooseWhatYou);

		JComboBox c1 = new JComboBox();
		c1.setForeground(new Color(25, 25, 112));
		c1.setBounds(20, 282, 179, 20);
		
		c1.addItem("Atrist");
		c1.addItem("female singers");
		c1.addItem("Bands");
		
		contentPane.add(c1);
		
		

		JButton btnNewButton = new JButton("choose");
		btnNewButton.setBounds(57, 327, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<-");
		btnNewButton_1.setBounds(0, 0, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ManueAgent window1 = new ManueAgent();
				window1.frame1.setVisible(true);
				setVisible(false);

			}
		});
		Image img=new ImageIcon(this.getClass().getResource("/cover3.jpeg")).getImage();
		
	
		JLabel im= new JLabel("");
		contentPane.add(im);
		im.setForeground(Color.WHITE);
		im.setBounds(-248, -30, 1134, 1149);
		im.setIcon(new ImageIcon(img));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String m = (String) (c1.getSelectedItem());
				if(m.equals("Atrist"))
				{
					AddArtist window1 = new AddArtist();
					window1.setVisible(true);
					setVisible(false);
				}
				if(m.equals("female singers"))
						{
					AddArtist window1 = new AddArtist();
					window1.setVisible(true);
					setVisible(false);
						}
				if(m.equals("Bands"))
						{
					AddBands window1 = new AddBands();
					window1.setVisible(true);
					setVisible(false);
						}
				

			}
		});
		

	}
}

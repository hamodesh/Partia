package boundary;

import java.awt.EventQueue;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import control.FriendLogic;

import control.jasperLogic;
import entity.Artist;
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

public class FrmRepoet extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRepoet frame = new FrmRepoet();
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
	public FrmRepoet() {
		setTitle("");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 833, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblError = new JLabel("");
		lblError.setForeground(new Color(255, 0, 0));
		lblError.setBounds(418, 38, 212, 14);
		contentPane.add(lblError);

		Choice comboBoxManagers = new Choice();

		comboBoxManagers.add("" + "Haifa");
		comboBoxManagers.add("" + "Tel aviv");
		comboBoxManagers.add("" + "south");
		comboBoxManagers.add("" + "Norht");

		comboBoxManagers.setBounds(50, 138, 161, 18);
		contentPane.add(comboBoxManagers);

		JButton btnAdd = new JButton("Select");
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				jasperLogic.getInstance()
				   .rptPartMounth((String) comboBoxManagers.getSelectedItem())
				   .setVisible(true);
				
				
				/*try {
					lblError.setText("");
					String m = (String) (comboBoxManagers.getSelectedItem());

					ArrayList<NewParty> results2 = new ArrayList<NewParty>();
					results2 = FriendLogic.getInstance().getNewParty();
					

					if (results2.size() == 0) {
						// remove all components in panel.
						panel.removeAll();
						// refresh the panel.
						panel.updateUI();
						lblError.setText("No New Party ");
					} else {

						String[] column = new String[6];
						column[0] = "party Name";
						column[1] = "Mounth";
						column[2] = "Adress";
						column[3] = "Music Type";
						column[4] = "Number Artist";
						column[5] = "Area";

						// table body
						String data[][] = new String[results2.size()][6];
						for (int i = 0; i < results2.size(); i++) {
							if (m.equals(results2.get(i).getArea())) {
								data[i][0] = results2.get(i).getPartyname();
								data[i][1] = results2.get(i).getAdress();
								data[i][2] = results2.get(i).getMounth();
								data[i][3] = results2.get(i).getMusicType();
								data[i][4] = results2.get(i).getNumberArtist();
								data[i][5] = results2.get(i).getArea();
							}
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
				} catch (Exception e1) {
					lblError.setText("Invalid Input");
				}*/
			}
		});
		btnAdd.setBounds(87, 186, 89, 23);
		contentPane.add(btnAdd);

		JLabel lblClikTheParty = new JLabel("Choose the Area For Report :\r\n");
		lblClikTheParty.setForeground(new Color(255, 192, 203));
		lblClikTheParty.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblClikTheParty.setBounds(10, 82, 282, 40);
		contentPane.add(lblClikTheParty);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(147, 112, 219));
		panel_2.setBackground(new Color(216, 191, 216));
		panel_2.setBounds(0, 0, 1019, 29);
		contentPane.add(panel_2);

		JButton btnNewButton_1 = new JButton("friendship");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FrmimportXmlAndLogin window1 = new FrmimportXmlAndLogin();
				window1.frame.setVisible(true);
				setVisible(false);

			}
		});

		JButton btnNewButton_2 = new JButton("pay crdiet");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FrmPay window1 = new FrmPay();
				window1.frame.setVisible(true);
				setVisible(false);

			}
		});

		JButton btnNewButton_4 = new JButton("report party this mounth ");

		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FrmRepoet window1 = new FrmRepoet();
				window1.setVisible(true);
				setVisible(false);

			}
		});

		JButton btnNewButton_5 = new JButton("import from jason  ");

		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Frmimportjson window1 = new Frmimportjson();
				window1.frame.setVisible(true);
				setVisible(false);

			}
		});

		JButton btnNewButton_31 = new JButton("Schedule of Party");
		btnNewButton_31.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Frmsch window1 = new Frmsch();
				window1.setVisible(true);
				setVisible(false); 
				

			}
		});
		
		JButton btnNewButton_10 = new JButton("My order");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Frmorder window1 = new Frmorder();
				window1.frame.setVisible(true);
				setVisible(false); 
				

			}
		});	
		
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_31, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_4, GroupLayout.PREFERRED_SIZE, 192, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_5, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_10, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(222, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnNewButton_2)
						.addComponent(btnNewButton_4)
						.addComponent(btnNewButton_31)
						.addComponent(btnNewButton_5)
						.addComponent(btnNewButton_10)
						.addComponent(btnNewButton_1))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		Image img1 = new ImageIcon(this.getClass().getResource("/cover3.jpeg")).getImage();
		panel_2.setLayout(gl_panel_2);
		JLabel im_2_3 = new JLabel("");
		contentPane.add(im_2_3);
		im_2_3.setBounds(-316, -54, 1287, 1134);
		im_2_3.setIcon(new ImageIcon(img1));

		JLabel lblClikTheParty_1 = new JLabel("Choose the Party to show Detailes:\r\n");
		lblClikTheParty_1.setForeground(new Color(106, 90, 205));
		lblClikTheParty_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblClikTheParty_1.setBounds(0, 305, 282, 40);
		contentPane.add(lblClikTheParty_1);

	}
}

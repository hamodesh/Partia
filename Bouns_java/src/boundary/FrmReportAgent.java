package boundary;

import javax.swing.JFrame;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.jasperLogic;
import control.FriendLogic;

import entity.Artist;
import entity.Party;
import entity.agentartist;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridLayout;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import java.awt.SystemColor;

public class FrmReportAgent extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6870528587630075141L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public FrmReportAgent() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 326);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<agentartist> cbProduct = new JComboBox<agentartist>();
		ArrayList<agentartist> results2 = new ArrayList<agentartist>();
		results2 = FriendLogic.getInstance().getagentartist();
		cbProduct.setModel(new DefaultComboBoxModel(FriendLogic.getInstance().getagentartist().toArray()));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(10, 25, 353, 239);
		contentPane.add(panel);
		
		JLabel asd = new JLabel("Choose  Artist:");
		asd.setAlignmentX(Component.RIGHT_ALIGNMENT);
		asd.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JButton btnProductOrdersByCountry = new JButton("The Show that send to Artist");
		btnProductOrdersByCountry.setForeground(SystemColor.textHighlight);
		btnProductOrdersByCountry.setBackground(SystemColor.window);
		btnProductOrdersByCountry.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbProduct.getItemCount() == 0)
					return; // replace with error dialog!
			
				final agentartist product = (agentartist) cbProduct.getSelectedItem();
			
		
				jasperLogic.getInstance()
						.rptPartMounth2(product.getAgent(),product.getArtistid())
						.setVisible(true);
			}
		});
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(cbProduct, 0, 328, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(asd, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(52)
					.addComponent(btnProductOrdersByCountry, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(76, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addComponent(asd)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cbProduct, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(30)
					.addComponent(btnProductOrdersByCountry, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(92, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.setBounds(5, 0, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ManueAgent window1 = new ManueAgent();
				window1.frame1.setVisible(true);
				setVisible(false); 
				

			}
		});
	}
}

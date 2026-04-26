package boundary;

import javax.swing.JFrame;


import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.jasperLogic;
import control.FriendLogic;

import entity.Artist;

import javax.swing.JButton;
import java.awt.event.ActionListener;
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

public class ArtistRpt2 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6870528587630075141L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ArtistRpt2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 326);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<Artist> cbProduct = new JComboBox<Artist>();
		cbProduct.setModel(new DefaultComboBoxModel(FriendLogic.getInstance().getArtist().toArray()));
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.activeCaption);
		panel.setBounds(5, 44, 342, 245);
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
			
				final Artist product = (Artist) cbProduct.getSelectedItem();
				int m = Integer.parseInt(product.getArtistid());
		
				jasperLogic.getInstance()
						.compileProductOrdersByCountryReport(m, product.getName())
						.setVisible(true);
			}
		});
		
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(cbProduct, 0, 288, Short.MAX_VALUE)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(10)
					.addComponent(asd, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(57)
					.addComponent(btnProductOrdersByCountry, GroupLayout.PREFERRED_SIZE, 216, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(69, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addComponent(asd)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cbProduct, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(34)
					.addComponent(btnProductOrdersByCountry, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(98, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.setBounds(5, 0, 89, 23);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ManueArtist window1 = new ManueArtist();
				window1.frame1.setVisible(true);
				setVisible(false); 
				

			}
		});
		
	}
}

package kape_System;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JToolBar;
public class home_page extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					home_page frame = new home_page();
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
	public home_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(380, 50, 800, 654);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
	
		JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mmMenu = new JMenu("Menu");
        menuBar.add(mmMenu);

        JMenuItem mtnmAccount = new JMenuItem("Account");
        ImageIcon accountIcon = new ImageIcon("C:\\Users\\kinpr\\Desktop\\Kape de cabuyao\\kape_System\\src\\kape_system_admin\\account.png");
        Image accountImg = accountIcon.getImage();
        Image newAccountImg = accountImg.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        accountIcon = new ImageIcon(newAccountImg);
        mtnmAccount.setIcon(accountIcon);
        mmMenu.add(mtnmAccount);

        JMenuItem mntmSettings = new JMenuItem("Settings");
        ImageIcon settingsIcon = new ImageIcon("C:\\Users\\kinpr\\Desktop\\Kape de cabuyao\\kape_System\\src\\kape_system_admin\\settings.png");
        Image settingsImg = settingsIcon.getImage();
        Image newSettingsImg = settingsImg.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        settingsIcon = new ImageIcon(newSettingsImg);
        mntmSettings.setIcon(settingsIcon);
        mmMenu.add(mntmSettings);
        

        JMenuItem mntmLogout = new JMenuItem("Logout");
        ImageIcon logoutIcon = new ImageIcon("C:\\Users\\kinpr\\Desktop\\Kape de cabuyao\\kape_System\\src\\kape_system_admin\\logout.png");
        Image logoutImg = logoutIcon.getImage();
        Image newLogoutImg = logoutImg.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
        logoutIcon = new ImageIcon(newLogoutImg);
        mntmLogout.setIcon(logoutIcon);
        mmMenu.add(mntmLogout);
                
        mntmLogout.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose(); 
        		login_page login = new login_page(); 
        		login.setVisible(true); 
        	}
        });
        
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Home");
		btnNewButton.setBackground(new Color(255, 235, 205));
		btnNewButton.setBounds(88, 126, 147, 43);
		contentPane.add(btnNewButton);
		
		JPanel panelContact = new JPanel();
		panelContact.setBackground(new Color(255, 235, 205));
		panelContact.setBounds(87, 179, 618, 324);
		contentPane.add(panelContact);
		panelContact.setLayout(null);
		
		JLabel lblTitle_3 = new JLabel("Welcome");
		lblTitle_3.setFont(new Font("Brush Script MT", Font.PLAIN, 30));
		lblTitle_3.setBounds(85, 21, 93, 14);
		panelContact.add(lblTitle_3);
		
		JTextPane txtpnZdvsdbhbnb = new JTextPane();
		txtpnZdvsdbhbnb.setBackground(new Color(255, 235, 205));
		txtpnZdvsdbhbnb.setEditable(false);
		txtpnZdvsdbhbnb.setFont(new Font("Tw Cen MT Condensed", Font.PLAIN, 14));
		txtpnZdvsdbhbnb.setText("Welcome to KAPE DE CABUYAO, your premier destination for all things coffee. From the rich aroma of our freshly roasted beans to the expertly crafted cups that will transport you to a world of pure delight, we're dedicated to bringing you the ultimate coffee experience. Whether you're a coffee connoisseur or just looking for a pick-me-up, our website is designed to make it easy for you to discover, learn about, and enjoy the best coffee in the world. With a range of specialty blends, single-origin coffees, and expertly curated gift sets, we've got everything you need to elevate your daily grind and make every moment a little brighter.");
		txtpnZdvsdbhbnb.setBounds(36, 54, 229, 228);
		panelContact.add(txtpnZdvsdbhbnb);
		
		JButton btnNewButton_1 = new JButton("More");
		btnNewButton_1.setBackground(new Color(255, 235, 205));
		btnNewButton_1.setBounds(84, 292, 74, 23);
		panelContact.add(btnNewButton_1);
		
		JLabel lblTitle_2 = new JLabel("");
		lblTitle_2.setBounds(244, 0, 378, 324);
		panelContact.add(lblTitle_2);

		ImageIcon originalIcon = new ImageIcon("C:\\Users\\kinpr\\Desktop\\Kape de cabuyao\\kape_System\\src\\kape_system_admin\\icon.png");
		Image originalImage = originalIcon.getImage();
		Image resizedImage = originalImage.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
		ImageIcon resizedIcon = new ImageIcon(resizedImage);
		lblTitle_2.setIcon(resizedIcon);

		
		JButton btnContact = new JButton("Contacts");
		btnContact.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contact_page contacts = new contact_page();
				contacts.setVisible(true);
				dispose();
			}
		});
		btnContact.setBackground(new Color(255, 235, 205));
		btnContact.setBounds(245, 126, 147, 43);
		contentPane.add(btnContact);
		
		JButton btnMenu = new JButton("Menu");
		btnMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu_page menuPage = new menu_page();
				menuPage.setVisible(true);
				dispose();
			}
		});
		btnMenu.setBackground(new Color(255, 235, 205));
		btnMenu.setBounds(402, 126, 147, 43);
		contentPane.add(btnMenu);
		
		JButton btnCart = new JButton("Cart");
		btnCart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cart_page cart = new cart_page(null);
				cart.setVisible(true);
				dispose();
			}
		});
		btnCart.setBackground(new Color(255, 235, 205));
		btnCart.setBounds(559, 126, 146, 43);
		contentPane.add(btnCart);
		
		JLabel lblTitle = new JLabel("Kape De Cabuyao");
		lblTitle.setForeground(new Color(205, 133, 63));
		lblTitle.setBackground(new Color(210, 180, 140));
		lblTitle.setFont(new Font("Brush Script MT", Font.BOLD, 40));
		lblTitle.setBounds(90, 34, 305, 35);
		contentPane.add(lblTitle);
		
		JLabel lblDescription = new JLabel("SMOOTH COFFE \r\n");
		lblDescription.setForeground(new Color(210, 180, 140));
		lblDescription.setFont(new Font("Serif", Font.PLAIN, 17));
		lblDescription.setBounds(191, 68, 147, 14);
		contentPane.add(lblDescription);
		
		JLabel lblBackground = new JLabel();
		lblBackground.setBackground(Color.WHITE);
        lblBackground.setBounds(0, 0, 786, 617);
        ImageIcon backgroundImg = new ImageIcon("C:\\Users\\kinpr\\Desktop\\Kape de cabuyao\\kape_System\\src\\kape_System\\background_kape.png");
        Image getBackground = backgroundImg.getImage();
        Image setBackground = getBackground.getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(), Image.SCALE_SMOOTH);
        backgroundImg = new ImageIcon(setBackground);
        lblBackground.setIcon(backgroundImg);
        
        contentPane.add(lblBackground);
		
		
	}

}

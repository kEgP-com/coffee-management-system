package kape_System;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class contact_page extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textInput;
	private JLabel lblContactTitle;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					contact_page frame = new contact_page();
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
	public contact_page() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(380, 100, 700, 400);
		
		getContentPane().setLayout(new BorderLayout(0, 0));
		
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

        JMenu mnPage = new JMenu("Page");
        menuBar.add(mnPage);

        JMenuItem mntmHome = new JMenuItem("Home");
        mntmHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                home_page homePage = new home_page();
                homePage.setVisible(true);
                dispose();
            }
        });
        mnPage.add(mntmHome);

        JMenuItem mntmMenu = new JMenuItem("Menu");
        mntmMenu.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                menu_page menuPage = new menu_page();
                menuPage.setVisible(true);
                dispose();
            }
        });
        mnPage.add(mntmMenu);

        JMenuItem mntmCart = new JMenuItem("Cart");
        mntmCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cart_page cartPage = new cart_page(null);
                cartPage.setVisible(true);
                dispose();
            }
        });
        mnPage.add(mntmCart);
        
		JPanel panel = new JPanel();	
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(null);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		lblContactTitle = new JLabel("Contact Us");
		lblContactTitle.setBounds(238, 10, 221, 50);
		lblContactTitle.setFont(new Font("Brush Script MT", Font.PLAIN, 50));
		panel.add(lblContactTitle);
		
		JLabel lblEmail = new JLabel("Our mailing address is kapeDeCabuyao@gmail.com");
		lblEmail.setBounds(32, 90, 285, 20);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 11));
		panel.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Katapatan homes");
		lblAddress.setBounds(32, 120, 161, 20);
		lblAddress.setFont(new Font("Arial", Font.PLAIN, 11));
		panel.add(lblAddress);
		
		JLabel lblNewLabel_2 = new JLabel("Cabuyao City");
		lblNewLabel_2.setBounds(123, 123, 72, 14);
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 11));
		panel.add(lblNewLabel_2);
		
		JLabel lblPhone = new JLabel("Phone: #09946902381");
		lblPhone.setBounds(32, 150, 161, 14);
		lblPhone.setFont(new Font("Arial", Font.PLAIN, 11));
		panel.add(lblPhone);
		
		JLabel txtEmail = new JLabel("E-mail:");
		txtEmail.setBounds(313, 90, 67, 14);
		txtEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		panel.add(txtEmail);
		
		textInput = new JTextField();
		textInput.setBounds(390, 90, 243, 30);
		textInput.setColumns(10);
		panel.add(textInput);
		
		JLabel txtFeedback = new JLabel("Feedback");
		txtFeedback.setFont(new Font("Arial", Font.PLAIN, 12));
		txtFeedback.setBounds(313, 140, 67, 14);
		panel.add(txtFeedback);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(390, 140, 243, 110);
		panel.add(scrollPane);

		JButton sendButton = new JButton("Send");
		sendButton.setBounds(538, 260, 95, 30);
		panel.add(sendButton);
	

		sendButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String email = textInput.getText();
			String message = textArea.getText();
			if (email.isEmpty() && message.isEmpty()) {
				JOptionPane.showMessageDialog(panel, "You need to input something", "Warning", JOptionPane.WARNING_MESSAGE);
			} else if (email.isEmpty()) {
				JOptionPane.showMessageDialog(panel, "Enter your email first", "Warning", JOptionPane.WARNING_MESSAGE);
			} else if (message.isEmpty()) {
				JOptionPane.showMessageDialog(panel, "Enter your message", "Warning", JOptionPane.WARNING_MESSAGE);
			} else {
				System.out.println("Email: " + email);
				System.out.println("Message: " + message);
				textInput.setText("");
				textArea.setText("");
				JOptionPane.showMessageDialog(panel, "Your feedback has been sent to our team", "Info", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		});

		textInput.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			textArea.requestFocus();
		}
		});
		
		JLabel lblBackground = new JLabel();
        lblBackground.setBackground(Color.WHITE);
        lblBackground.setBounds(0, 0, 686, 341); 
        ImageIcon backgroundImg = new ImageIcon("C:\\Users\\kinpr\\Desktop\\Kape de cabuyao\\kape_System\\src\\kape_System\\background_kape.png");
        Image getBackground = backgroundImg.getImage();
        Image setBackground = getBackground.getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(), Image.SCALE_SMOOTH);
        backgroundImg = new ImageIcon(setBackground);
        lblBackground.setIcon(backgroundImg);
        panel.add(lblBackground);
	}
}


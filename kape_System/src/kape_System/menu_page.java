package kape_System;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class menu_page extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private List<String> cartItems = new ArrayList<>();
    private JLabel lblNotif;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    menu_page frame = new menu_page();
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
    public menu_page() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(380, 50, 748, 642);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
		setResizable(false);
		
        JLabel lblBackground = new JLabel();
        lblBackground.setBounds(0, 0, 734, 583);
        ImageIcon backgroundImg = new ImageIcon("C:\\Users\\kinpr\\Desktop\\Kape de cabuyao\\kape_System\\src\\kape_system_admin\\background_lbl.jpg");
        Image getBackground = backgroundImg.getImage();
        Image setBackground = getBackground.getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(), Image.SCALE_SMOOTH);
        backgroundImg = new ImageIcon(setBackground);
        lblBackground.setIcon(backgroundImg);

		
        JMenuBar menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        JMenu mmMenu = new JMenu("Menu");
        menuBar.add(mmMenu);

        JMenuItem mtnmAccount = new JMenuItem("Account");
        mmMenu.add(mtnmAccount);

        JMenuItem mntmSettings = new JMenuItem("Settings");
        mmMenu.add(mntmSettings);

        JMenuItem mntmLogout = new JMenuItem("Logout");
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

        JMenuItem mntmCart = new JMenuItem("Cart");
        mntmCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cart_page cartPage = new cart_page(cartItems);
                cartPage.setVisible(true);
                dispose();
            }
        });
        mnPage.add(mntmCart);

        JMenuItem mntmContact = new JMenuItem("Contact");
        mntmContact.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                contact_page contactPage = new contact_page();
                contactPage.setVisible(true);
                dispose();
            }
        });
        mnPage.add(mntmContact);
        
        
        JLabel lblHotCoffee = new JLabel("Hot Coffee");
        lblHotCoffee.setBounds(212, 63, 257, 37);
        contentPane.add(lblHotCoffee);
        lblHotCoffee.setVerticalAlignment(SwingConstants.BOTTOM);
        lblHotCoffee.setHorizontalTextPosition(SwingConstants.LEFT);
        lblHotCoffee.setHorizontalAlignment(SwingConstants.CENTER);
        lblHotCoffee.setForeground(Color.BLACK);
        lblHotCoffee.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 27));
        lblHotCoffee.setBorder(null);

        coffeeItems(contentPane, "1. Americano Coffee", 131, 0);
        coffeeItems(contentPane, "2. Cappuccino", 155, 1);
        coffeeItems(contentPane, "3. Dark Choco", 181, 2);
        coffeeItems(contentPane, "4. Caramel Macchiato", 206, 3);
        coffeeItems(contentPane, "5. Latte", 230, 4);

        JLabel lblColdCoffee = new JLabel("Cold Coffee");
        lblColdCoffee.setBounds(212, 292, 257, 37);
        contentPane.add(lblColdCoffee);
        lblColdCoffee.setVerticalAlignment(SwingConstants.BOTTOM);
        lblColdCoffee.setHorizontalTextPosition(SwingConstants.LEFT);
        lblColdCoffee.setHorizontalAlignment(SwingConstants.CENTER);
        lblColdCoffee.setForeground(Color.BLACK);
        lblColdCoffee.setFont(new Font("Palatino Linotype", Font.BOLD | Font.ITALIC, 27));
        lblColdCoffee.setBorder(null);

        coffeeItems(contentPane, "1. Iced Americano", 364, 5);
        coffeeItems(contentPane, "2. Iced Vanilla Latte", 388, 6);
        coffeeItems(contentPane, "3. Iced Mocha", 414, 7);
        coffeeItems(contentPane, "4. Iced Macchiato", 439, 8);
        coffeeItems(contentPane, "5. Iced Hazelnut Latte", 463, 9);

        JButton btnViewCart = new JButton("VIEW CART");
        btnViewCart.setBounds(530, 500, 108, 23);
        contentPane.add(btnViewCart);
        btnViewCart.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cart_page cart = new cart_page(cartItems);
                cart.setVisible(true);
                dispose();
            }
        });
        
        
        lblNotif = new JLabel("");
        lblNotif.setBounds(200, 530, 300, 25);
        lblNotif.setFont(new Font("Tahoma", Font.BOLD, 12));
        lblNotif.setForeground(Color.RED);
        lblNotif.setHorizontalAlignment(SwingConstants.CENTER);
        
        
        
        contentPane.add(lblNotif);
        contentPane.add(lblBackground);

    }

    private void coffeeItems(JPanel panel, String coffeeName, int yPosition, int index) {
        JLabel lblProduct = new JLabel(coffeeName);
        lblProduct.setBounds(151, yPosition, 156, 25);
        panel.add(lblProduct);
        lblProduct.setForeground(Color.BLACK);
        lblProduct.setFont(new Font("Sitka Heading", Font.BOLD, 14));

        JLabel lblPrice = new JLabel("P39");
        lblPrice.setBounds(317, yPosition, 54, 25);
        panel.add(lblPrice);
        lblPrice.setForeground(Color.BLACK);
        lblPrice.setFont(new Font("Sitka Heading", Font.BOLD, 14));

        JComboBox<String> sizeComboBox = new JComboBox<>();
        sizeComboBox.setBounds(375, yPosition, 81, 22);
        panel.add(sizeComboBox);
        sizeComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Small", "Medium", "Large"}));
        sizeComboBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedSize = (String) sizeComboBox.getSelectedItem();
                switch (selectedSize) {
                    case "Small":
                        lblPrice.setText("P" + 39);
                        break;
                    case "Medium":
                        lblPrice.setText("P" + 49);
                        break;
                    case "Large":
                        lblPrice.setText("P" + 59);
                        break;
                }
            }
        });

        JLabel lblSize = new JLabel("Size");
        lblSize.setBounds(403, yPosition - 24, 46, 14);
        panel.add(lblSize);
        lblSize.setForeground(Color.BLACK);
        lblSize.setFont(new Font("Tahoma", Font.BOLD, 11));

        JSpinner itemCount = new JSpinner(new SpinnerNumberModel(1, 1, Integer.MAX_VALUE, 1));
        itemCount.setBounds(477, yPosition, 30, 20);
        panel.add(itemCount);

        JButton btnAdd = new JButton("ADD");
        btnAdd.setBounds(530, yPosition, 108, 23); 
        panel.add(btnAdd);
        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addToCart(coffeeName, lblPrice.getText(), sizeComboBox.getSelectedItem().toString(), itemCount.getValue().toString());
                lblNotif.setText(coffeeName + " added to cart!");
            }
        });
        
        
        
    }

    private void addToCart(String itemName, String price, String size, String quantity) {
        String cartItem = itemName + " - " + size + " - " + price + " x " + quantity;
        cartItems.add(cartItem);
    }
}


package kape_System;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import kape_system_admin.admin_panel;
import kape_system_admin.order_panel_page;
import kape_system_admin.user_admin_page;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class cart_page extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultListModel<String> receiptListModel;
    private JList<String> receiptList;
    private JLabel lblTotal;
    private List<String> removedItems;
    private JTextField textField;

    private String enteredText = "";

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    List<String> cartItems = new ArrayList<>();
                    cartItems.add("Americano - Medium - P49 x 2");
                    cartItems.add("Latte - Large - P59 x 1");
                    cart_page frame = new cart_page(cartItems);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public cart_page(List<String> cartItems) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 30, 1021, 719);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
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
        
        JMenuItem mntmContact = new JMenuItem("Contact");
        mntmContact.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		contact_page contactPage = new contact_page();
                contactPage.setVisible(true);
                dispose();
        	}
        });
        mnPage.add(mntmContact);

        JLabel lblBackground = new JLabel();
        lblBackground.setBounds(-766, -40, 1958, 822);
        lblBackground.setIcon(new ImageIcon("C:\\Users\\kinpr\\Desktop\\Kape de cabuyao\\kape_System\\src\\kape_System\\product.png"));

        lblTotal = new JLabel("Total: ");
        lblTotal.setOpaque(true);
        lblTotal.setBackground(new Color(255, 255, 255));
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTotal.setBounds(583, 312, 205, 43);
        
        textField = new JTextField();
        textField.setBounds(608, 421, 207, 28);
        contentPane.add(textField);
        textField.setColumns(10);

        lblTotal = new JLabel("Total: ");
        lblTotal.setOpaque(true);
        lblTotal.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblTotal.setBounds(608, 288, 205, 43);
        contentPane.add(lblTotal);
        
        JLabel lblDetails = new JLabel("Enter Payment No.");
        lblDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblDetails.setBounds(608, 397, 118, 13);
        contentPane.add(lblDetails);
        
	    JComboBox<String> selPaymentMethod = new JComboBox<>();
	    selPaymentMethod.setModel(new DefaultComboBoxModel(new String[] {"GCASH", "PAYMAYA", "CREDIT CARD", "CASH ON DELIVERY"}));
	    selPaymentMethod.setBounds(610, 359, 205, 28);
	    selPaymentMethod.addItemListener(new ItemListener() {
	        public void itemStateChanged(ItemEvent e) {
	            if (e.getStateChange() == ItemEvent.SELECTED) {
	                String selectedOption = (String) selPaymentMethod.getSelectedItem();
	                if (selectedOption.equals("CREDIT CARD")) {
	                    lblDetails.setText("Enter Credit Card No.");
	                    lblDetails.setVisible(true);
	                    textField.setVisible(true);
	                    textField.setText(enteredText);
	                } else if (selectedOption.equals("GCASH")) {
	                    lblDetails.setText("Enter GCASH No.");
	                    lblDetails.setVisible(true);
	                    textField.setVisible(true);
	                    textField.setText(enteredText);
	                } else if (selectedOption.equals("PAYMAYA")) {
	                    lblDetails.setText("Enter Paymaya No.");
	                    lblDetails.setVisible(true);
	                    textField.setVisible(true);
	                    textField.setText(enteredText);
	                } else {
	                    lblDetails.setVisible(false);
	                    textField.setVisible(false);
	                    textField.setText("");
	                    enteredText = ""; 
	                }
	            }
	        }
	    });


        JButton btnPayment = new JButton("Checkout");
        btnPayment.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to proceed with the payment?", "Confirm Payment", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                String paymentMethod = (String) selPaymentMethod.getSelectedItem();
                String[] receiptContent = new String[receiptListModel.size()];
                for (int i = 0; i < receiptListModel.size(); i++) {
                    receiptContent[i] = receiptListModel.getElementAt(i);
                }
                String total = lblTotal.getText().substring(7); 
                reciepts_return_page.recieptDisplay(receiptContent, total, paymentMethod);
                dispose();
            }
        });


        btnPayment.setBounds(318, 472, 205, 43);
        btnPayment.setFocusable(false);

        JButton btnRemoveProduct = new JButton("Remove Product");
        btnRemoveProduct.setBounds(608, 108, 136, 34);
        btnRemoveProduct.setFocusable(false);
        btnRemoveProduct.addActionListener(e -> {
            int selectedIndex = receiptList.getSelectedIndex();
            if (selectedIndex != -1) {
                String removedItem = receiptListModel.getElementAt(selectedIndex);
                receiptListModel.remove(selectedIndex);
                removedItems.add(removedItem);
                updateTotal();
            }
        });

        JButton btnRemoveAll = new JButton("Remove All");
        btnRemoveAll.setBounds(608, 152, 136, 34);
        btnRemoveAll.setFocusable(false);
        btnRemoveAll.addActionListener(e -> {
            while (receiptListModel.size() > 0) {
                String removedItem = receiptListModel.getElementAt(0);
                receiptListModel.remove(0);
                removedItems.add(removedItem);
            }
            updateTotal();
        });

        JButton btnRestore = new JButton("Restore");
        btnRestore.setBounds(608, 196, 136, 34);
        btnRestore.setFocusable(false);
        btnRestore.addActionListener(e -> {
            if (!removedItems.isEmpty()) {
                String lastRemovedItem = removedItems.remove(removedItems.size() - 1);
                receiptListModel.addElement(lastRemovedItem);
                updateTotal();
            }
        });

        JButton btnRestoreAll = new JButton("Restore All");
        btnRestoreAll.setFocusable(false);
        btnRestoreAll.setBounds(608, 240, 136, 34);
        btnRestoreAll.addActionListener(e -> {
            while (!removedItems.isEmpty()) {
                String restoredItem = removedItems.remove(0);
                receiptListModel.addElement(restoredItem);
            }
            updateTotal();
        });

        JLabel lblOptionPayment = new JLabel("Payment Option:");
        lblOptionPayment.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblOptionPayment.setBounds(610, 341, 118, 13);

        receiptListModel = new DefaultListModel<>();
        removedItems = new ArrayList<>();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(236, 108, 353, 343);
        receiptList = new JList<>(receiptListModel);
        scrollPane.setViewportView(receiptList);
        
        
        
        contentPane.add(selPaymentMethod);
        contentPane.add(btnRemoveProduct);
        contentPane.add(btnRemoveAll);
        contentPane.add(btnRestore);
        contentPane.add(btnRestoreAll);
        contentPane.add(lblOptionPayment);
        contentPane.add(btnPayment);
        contentPane.add(scrollPane);
        contentPane.add(lblBackground);
        

        if (cartItems != null) {
            for (String item : cartItems) {
                receiptListModel.addElement(item);
            }
            updateTotal();
        }
    }

    private void updateTotal() {
        double total = 0.0;
        for (int i = 0; i < receiptListModel.getSize(); i++) {
            String item = receiptListModel.getElementAt(i);
            String[] parts = item.split(" - ");
            try {
                String pricePart = parts[2].split(" ")[0].substring(1); 
                double price = Double.parseDouble(pricePart);
                String quantityPart = parts[2].split(" x ")[1]; 
                int quantity = Integer.parseInt(quantityPart);
                total += price * quantity;
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.err.println("Error parsing item: " + item);
            }
        }
        lblTotal.setText("Total: " + String.format("%.2f", total));
    }
}

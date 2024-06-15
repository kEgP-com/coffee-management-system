package kape_system_admin;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import kape_System.login_page;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

public class order_panel_page extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private DefaultListModel<String> listOrder;
    private List<String> pendingOrders;
    private List<String> originalOrders;
    private List<String> cancelOrder;
    private JTextField inputOrder;
    private JList<String> orderList;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    order_panel_page frame = new order_panel_page();
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
    public order_panel_page() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(510, 100, 756, 622);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

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
                admin_panel homePage = new admin_panel();
                homePage.setVisible(true);
                dispose();
            }
        });
        mnPage.add(mntmHome);

        JMenuItem mntmUser = new JMenuItem("User");
        mntmUser.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		user_admin_page userPage = new user_admin_page();
        		userPage.setVisible(true);
        		dispose();
        	}
        });
        mnPage.add(mntmUser);

        JMenuItem mntmProduct = new JMenuItem("Product");
        mntmProduct.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		product_add_page productPage = new product_add_page();
        		productPage.setVisible(true);
        		dispose();
        	}
        });
        mnPage.add(mntmProduct);

        listOrder = new DefaultListModel<>();
        orderList = new JList<>(listOrder);
        JScrollPane scrollPane = new JScrollPane(orderList);
        scrollPane.setBounds(61, 46, 602, 300);
        contentPane.add(scrollPane);

        pendingOrders = new ArrayList<>();
        originalOrders = new ArrayList<>();
        cancelOrder = new ArrayList<>();
        
        pendingOrders.add("Order 1: Caphuchino (Cold) - M - ₱39, Drack Chocolate (cold) - L - ₱ 49");
        pendingOrders.add("Order 2: Latte (Hot) -  M - ₱39, Black Forest (cold)- M - ₱39 ");
        pendingOrders.add("Order 3: Americano (Hot) L - ₱ 49");

        originalOrders.addAll(pendingOrders);

        for (String order : pendingOrders) {
        	listOrder.addElement(order);
        }

        inputOrder = new JTextField();
        inputOrder.setHorizontalAlignment(SwingConstants.LEFT);
        inputOrder.setBounds(61, 398, 446, 41);
        contentPane.add(inputOrder);
        inputOrder.setColumns(10);

        JButton btnCancel = new JButton("CANCEL");
        btnCancel.setBackground(new Color(255, 239, 213));
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = orderList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String removedOrder = pendingOrders.get(selectedIndex);
                    cancelOrder.add(removedOrder);
                    listOrder.remove(selectedIndex);
                    pendingOrders.remove(selectedIndex);
                } else {
                    JOptionPane.showMessageDialog(contentPane, "No order selected to remove.", "Selection Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnCancel.setBounds(61, 449, 135, 41);
        contentPane.add(btnCancel);

        JButton btnRestore = new JButton("RESTORE");
        btnRestore.setBackground(new Color(255, 239, 213));
        btnRestore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!cancelOrder.isEmpty()) {
                    String orderToRestore = cancelOrder.remove(cancelOrder.size() - 1);
                    pendingOrders.add(orderToRestore);
                    listOrder.addElement(orderToRestore);
                }
            }
        });
        btnRestore.setBounds(372, 449, 135, 41);
        contentPane.add(btnRestore);

        JButton btnCancelAll = new JButton("CANCEL ALL");
        btnCancelAll.setBackground(new Color(255, 239, 213));
        btnCancelAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	cancelOrder.addAll(pendingOrders);
            	listOrder.clear();
                pendingOrders.clear();
            }
        });
        btnCancelAll.setBounds(216, 449, 135, 41);
        contentPane.add(btnCancelAll);

        JButton btnRestoreAll = new JButton("RESTORE ALL");
        btnRestoreAll.setBackground(new Color(255, 239, 213));
        btnRestoreAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	listOrder.clear();
                pendingOrders.clear();
                for (String order : originalOrders) {
                	listOrder.addElement(order);
                    pendingOrders.add(order);
                }
            }
        });
        btnRestoreAll.setBounds(528, 449, 135, 41);
        contentPane.add(btnRestoreAll);

        JButton btnAddUpdate = new JButton("ADD/UPDATE");
        btnAddUpdate.setBackground(new Color(255, 239, 213));
        btnAddUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newOrder = inputOrder.getText();
                int selectedIndex = orderList.getSelectedIndex();
                if (!newOrder.isEmpty()) {
                    if (selectedIndex != -1) {
                    	listOrder.set(selectedIndex, newOrder);
                        pendingOrders.set(selectedIndex, newOrder);
                        updateOriginalOrders();  
                    } else {
                    	listOrder.addElement(newOrder);
                        pendingOrders.add(newOrder);
                        updateOriginalOrders();  
                    }
                    inputOrder.setText("");
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Order text cannot be empty.", "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        btnAddUpdate.setBounds(528, 398, 135, 41);
        contentPane.add(btnAddUpdate);

        JLabel lblNewLabel = new JLabel("Input Order/ Update Order");
        lblNewLabel.setBounds(61, 375, 280, 13);
        contentPane.add(lblNewLabel);
        
        
        JLabel lblBackground = new JLabel();
        lblBackground.setBounds(0, 0, 742, 569);
        ImageIcon backgroundImg = new ImageIcon("C:\\Users\\kinpr\\Desktop\\Kape de cabuyao\\kape_System\\src\\kape_system_admin\\order_bg.jpg");
        Image getBackground = backgroundImg.getImage();
        Image setBackground = getBackground.getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(), Image.SCALE_SMOOTH);
        backgroundImg = new ImageIcon(setBackground);
        lblBackground.setIcon(backgroundImg);
        
        contentPane.add(lblBackground);
        
    }

    private void updateOriginalOrders() {
        originalOrders.clear();
        originalOrders.addAll(pendingOrders);
    }
}

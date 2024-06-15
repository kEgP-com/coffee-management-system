package kape_system_admin;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import kape_System.login_page;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Color;

public class user_admin_page extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtEmail;
    private JTextField txtUsername;
    private JTextField txtPass;
    private JTable table;
    public DefaultTableModel tableModel;
    public JLabel lblNumberOfUsers;
    public List<String[]> userList;
    public List<String[]> removedUsers;
    public int nextId;
    private int selectedRowIndex = -1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    user_admin_page frame = new user_admin_page();
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
    public user_admin_page() {
        userList = new ArrayList<>();
        removedUsers = new ArrayList<>();
        nextId = 1;

        // Add sample data
        String[] user1 = new String[]{String.valueOf(nextId++), "jVvlad", "yutuc9@gmail.com", "09012"};
        String[] user2 = new String[]{String.valueOf(nextId++), "dairoJunver", "dairoJ@gmail.com", "54656"};
        userList.add(user1);
        userList.add(user2);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setBounds(250, 30, 1042, 791);

        // Menu Bar
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
                login_page loginPage = new login_page();
                loginPage.setVisible(true);
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

        JMenuItem mntmOrder = new JMenuItem("Order");
        mntmOrder.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		order_panel_page orderPage = new order_panel_page();
        		orderPage.setVisible(true);
        		dispose();
        	}
        });
        mnPage.add(mntmOrder);

        JMenuItem mntmProduct = new JMenuItem("Product");
        mntmProduct.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                product_add_page productPage = new product_add_page();
                productPage.setVisible(true);
                dispose();
            }
        });
        mnPage.add(mntmProduct);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(183, 44, 480, 598);

        tableModel = new DefaultTableModel(new Object[]{"ID", "Username", "Email", "Password"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };
        table = new JTable(tableModel);
        scrollPane.setViewportView(table);
        for (String[] user : userList) {
            tableModel.addRow(user);
        }

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setForeground(Color.BLACK);
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblEmail.setBounds(685, 118, 46, 41);

        txtEmail = new JTextField();
        txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
        txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtEmail.setBounds(765, 124, 121, 31);

        JLabel lblUsername = new JLabel("Username:");
        lblUsername.setForeground(Color.BLACK);
        lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblUsername.setBounds(685, 66, 80, 41);

        txtUsername = new JTextField();
        txtUsername.setHorizontalAlignment(SwingConstants.LEFT);
        txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtUsername.setBounds(765, 73, 121, 31);

        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setForeground(Color.BLACK);
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPassword.setBounds(685, 170, 80, 41);

        txtPass = new JTextField();
        txtPass.setHorizontalAlignment(SwingConstants.LEFT);
        txtPass.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtPass.setBounds(765, 177, 121, 31);

        JButton btnAdd = new JButton("ADD");
        btnAdd.setBounds(685, 339, 135, 41);

        JButton btnRemoveItem = new JButton("REMOVE");
        btnRemoveItem.setBounds(685, 390, 135, 41);

        JButton btnRemoveAll = new JButton("REMOVE ALL");
        btnRemoveAll.setBounds(685, 441, 135, 41);

        JButton btnRestoreAll = new JButton("RESTORE ALL");
        btnRestoreAll.setBounds(685, 492, 135, 41);

        JButton btnRestore = new JButton("RESTORE");
        btnRestore.setBounds(685, 543, 135, 41);

        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.setBounds(685, 292, 135, 41);

        lblNumberOfUsers = new JLabel("Number of Users: " + userList.size());
        lblNumberOfUsers.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNumberOfUsers.setBounds(183, 654, 190, 41);

        JLabel lblBackground = new JLabel();
        lblBackground.setBounds(0, 0, 1028, 732);
        ImageIcon backgroundImg = new ImageIcon("C:\\Users\\kinpr\\Desktop\\Kape de cabuyao\\kape_System\\src\\kape_system_admin\\background_lbl.jpg");
        Image getBackground = backgroundImg.getImage();
        Image setBackground = getBackground.getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(), Image.SCALE_SMOOTH);
        backgroundImg = new ImageIcon(setBackground);
        lblBackground.setIcon(backgroundImg);

        contentPane.add(scrollPane);
        contentPane.add(lblEmail);
        contentPane.add(lblUsername);
        contentPane.add(lblPassword);
        contentPane.add(txtEmail);
        contentPane.add(txtUsername);
        contentPane.add(txtPass);
        contentPane.add(btnAdd);
        contentPane.add(btnRemoveItem);
        contentPane.add(btnRemoveAll);
        contentPane.add(btnRestoreAll);
        contentPane.add(btnRestore);
        contentPane.add(btnUpdate);
        contentPane.add(lblNumberOfUsers);
        contentPane.add(lblBackground);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = txtUsername.getText();
                String email = txtEmail.getText();
                String password = txtPass.getText();
                if (!username.isEmpty() && !email.isEmpty() && !password.isEmpty()) {
                    String[] user = new String[]{String.valueOf(nextId++), username, email, password};
                    userList.add(user);
                    tableModel.addRow(user);
                    lblNumberOfUsers.setText("Number of Users: " + userList.size());
                    txtUsername.setText("");
                    txtEmail.setText("");
                    txtPass.setText("");
                } else {
                    JOptionPane.showMessageDialog(null, "All fields must be filled!", "Input Error", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        btnRemoveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow != -1) {
                    removedUsers.add(userList.get(selectedRow));
                    userList.remove(selectedRow);
                    tableModel.removeRow(selectedRow);
                    lblNumberOfUsers.setText("Number of Users: " + userList.size());
                }
            }
        });

        btnRemoveAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removedUsers.addAll(userList);
                userList.clear();
                tableModel.setRowCount(0);
                lblNumberOfUsers.setText("Number of Users: 0");
            }
        });

        btnRestoreAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (String[] user : removedUsers) {
                    userList.add(user);
                    tableModel.addRow(user);
                }
                removedUsers.clear();
                lblNumberOfUsers.setText("Number of Users: " + userList.size());
            }
        });

        btnRestore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!removedUsers.isEmpty()) {
                    String[] user = removedUsers.remove(removedUsers.size() - 1);
                    userList.add(user);
                    tableModel.addRow(user);
                    lblNumberOfUsers.setText("Number of Users: " + userList.size());
                }
            }
        });

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectedRowIndex != -1) {
                    String username = txtUsername.getText();
                    String email = txtEmail.getText();
                    String password = txtPass.getText();


                    if (username.isEmpty()) {
                        username = (String) tableModel.getValueAt(selectedRowIndex, 1);
                    }
                    if (email.isEmpty()) {
                        email = (String) tableModel.getValueAt(selectedRowIndex, 2);
                    }
                    if (password.isEmpty()) {
                        password = (String) tableModel.getValueAt(selectedRowIndex, 3);
                    }

                    userList.get(selectedRowIndex)[1] = username;
                    userList.get(selectedRowIndex)[2] = email;
                    userList.get(selectedRowIndex)[3] = password;

                    tableModel.setValueAt(username, selectedRowIndex, 1);
                    tableModel.setValueAt(email, selectedRowIndex, 2);
                    tableModel.setValueAt(password, selectedRowIndex, 3);

                    txtUsername.setText("");
                    txtEmail.setText("");
                    txtPass.setText("");
                    selectedRowIndex = -1;
                }
            }
        });

        table.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && table.getSelectedRow() != -1) {
                selectedRowIndex = table.getSelectedRow();
                txtUsername.setText((String) tableModel.getValueAt(selectedRowIndex, 1));
                txtEmail.setText((String) tableModel.getValueAt(selectedRowIndex, 2));
                txtPass.setText((String) tableModel.getValueAt(selectedRowIndex, 3));
            }
        });
    }
}

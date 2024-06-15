package kape_system_admin;

import java.awt.EventQueue;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import kape_System.login_page;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class product_add_page extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable listCoffee;
    private JButton btnAdd;
    private JButton btnRemove;
    private JButton btnRestore;
    private JButton btnUpdate;
    private JTextField txtName;
    private JTextField txtPrice;
    private JTextField txtSize;
    private DefaultTableModel contentList;
    private List<Object[]> removedRows = new ArrayList<>();
    private JLabel lblProductsNo;
    private JComboBox<String> typeBox;
    private int selectRowIn = -1;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    product_add_page frame = new product_add_page();
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
    public product_add_page() {
        getContentPane().setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(250, 30, 1043, 770);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

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
                login_page login = new login_page();
                login.setVisible(true);
            }
        });

        JMenu mnPage = new JMenu("Page");
        menuBar.add(mnPage);

        JMenuItem mntmHome = new JMenuItem("Home");
        mntmHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                admin_panel home = new admin_panel();
                home.setVisible(true);
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

        JMenuItem mntmOrder = new JMenuItem("Order");
        mntmOrder.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                order_panel_page orderPage = new order_panel_page();
                orderPage.setVisible(true);
                dispose();
            }
        });
        mnPage.add(mntmOrder);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(186, 53, 480, 598);
        contentPane.add(scrollPane);

        contentList = new DefaultTableModel(new Object[]{"No.", "Type", "Name", "Price", "Size"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false; 
            }
        };

        listCoffee = new JTable(contentList);
        scrollPane.setViewportView(listCoffee);

        // Add sample data
        Object[] coldProduct = {1, "Cold", "Iced Latte", "100", "L/M/S"};
        Object[] hotProduct = {2, "Hot", "Espresso", "80", "M/S"};
        contentList.addRow(coldProduct);
        contentList.addRow(hotProduct);

        btnAdd = new JButton("ADD ITEM");
        btnAdd.setBounds(690, 406, 135, 41);
        contentPane.add(btnAdd);

        btnRemove = new JButton("REMOVE ITEM");
        btnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = listCoffee.getSelectedRow();
                if (selectedRow != -1) {
                    Object[] removedRowData = new Object[listCoffee.getColumnCount()];
                    for (int i = 0; i < listCoffee.getColumnCount(); i++) {
                        removedRowData[i] = listCoffee.getValueAt(selectedRow, i);
                    }
                    removedRows.add(removedRowData);
                    contentList.removeRow(selectedRow);
                    lblProductsNo.setText("Number of Products: " + contentList.getRowCount());
                }
            }
        });
        btnRemove.setBounds(690, 457, 135, 41);
        contentPane.add(btnRemove);

        btnRestore = new JButton("RESTORE");
        btnRestore.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (!removedRows.isEmpty()) {
                    Object[] lastRemovedRow = removedRows.remove(removedRows.size() - 1);
                    contentList.addRow(lastRemovedRow);
                    lblProductsNo.setText("Number of Products: " + contentList.getRowCount());
                }
            }
        });
        btnRestore.setBounds(690, 610, 135, 41);
        contentPane.add(btnRestore);

        JLabel lblNewLabel = new JLabel("Type:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblNewLabel.setBounds(688, 122, 46, 41);
        contentPane.add(lblNewLabel);

        JLabel lblPrice = new JLabel("Price:");
        lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblPrice.setBounds(688, 232, 46, 41);
        contentPane.add(lblPrice);

        JLabel lblName = new JLabel("Name:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblName.setBounds(688, 181, 46, 41);
        contentPane.add(lblName);

        JLabel lblSize = new JLabel("Size:");
        lblSize.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblSize.setBounds(688, 283, 46, 41);
        contentPane.add(lblSize);

        typeBox = new JComboBox<>();
        typeBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
        typeBox.setModel(new DefaultComboBoxModel<>(new String[]{"Hot", "Cold"}));
        typeBox.setBounds(744, 127, 69, 31);
        contentPane.add(typeBox);

        JButton btnRestoreAll = new JButton("RESTORE ALL");
        btnRestoreAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                for (Object[] removedRow : removedRows) {
                	contentList.addRow(removedRow);
                }
                removedRows.clear();
                lblProductsNo.setText("Number of Products: " + contentList.getRowCount());
            }
        });
        btnRestoreAll.setBounds(690, 559, 135, 41);
        contentPane.add(btnRestoreAll);

        lblProductsNo = new JLabel("Number of Products: " + contentList.getRowCount());
        lblProductsNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lblProductsNo.setBounds(186, 661, 190, 41);
        contentPane.add(lblProductsNo);

        txtName = new JTextField();
        txtName.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtName.setHorizontalAlignment(SwingConstants.LEFT);
        txtName.setBounds(744, 188, 121, 31);
        contentPane.add(txtName);
        txtName.setColumns(10);

        txtPrice = new JTextField();
        txtPrice.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtPrice.setColumns(10);
        txtPrice.setBounds(744, 239, 121, 32);
        contentPane.add(txtPrice);

        txtSize = new JTextField();
        txtSize.setFont(new Font("Tahoma", Font.PLAIN, 12));
        txtSize.setColumns(10);
        txtSize.setBounds(744, 290, 121, 32);
        contentPane.add(txtSize);

        JButton btnRemoveAll = new JButton("REMOVE ALL");
        btnRemoveAll.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int rowCount = contentList.getRowCount();
                for (int i = rowCount - 1; i >= 0; i--) {
                    Object[] rowData = new Object[listCoffee.getColumnCount()];
                    for (int j = 0; j < listCoffee.getColumnCount(); j++) {
                        rowData[j] = listCoffee.getValueAt(i, j);
                    }
                    removedRows.add(rowData);
                    contentList.removeRow(i);
                }
                lblProductsNo.setText("Number of Products: " + contentList.getRowCount());
            }
        });
        btnRemoveAll.setBounds(690, 508, 135, 41);
        contentPane.add(btnRemoveAll);

        btnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (txtName.getText().isEmpty() || txtPrice.getText().isEmpty() || txtSize.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "All fields must be filled!", "Input Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    int rowCount = contentList.getRowCount();
                    Object[] rowData = {
                        rowCount + 1,
                        typeBox.getSelectedItem().toString(),
                        txtName.getText(),
                        txtPrice.getText(),
                        txtSize.getText()
                    };
                    contentList.addRow(rowData);
                    lblProductsNo.setText("Number of Products: " + contentList.getRowCount());
                    txtName.setText("");
                    txtPrice.setText("");
                    txtSize.setText("");
                }
            }
        });

        btnUpdate = new JButton("UPDATE");
        btnUpdate.setBounds(690, 353, 135, 41);
        contentPane.add(btnUpdate);

        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (selectRowIn != -1) {
                    String type = typeBox.getSelectedItem().toString();
                    String name = txtName.getText();
                    String price = txtPrice.getText();
                    String size = txtSize.getText();


                    if (name.isEmpty()) {
                        name = (String) contentList.getValueAt(selectRowIn, 2);
                    }
                    if (price.isEmpty()) {
                        price = (String) contentList.getValueAt(selectRowIn, 3);
                    }
                    if (size.isEmpty()) {
                        size = (String) contentList.getValueAt(selectRowIn, 4);
                    }

                    contentList.setValueAt(type, selectRowIn, 1);
                    contentList.setValueAt(name, selectRowIn, 2);
                    contentList.setValueAt(price, selectRowIn, 3);
                    contentList.setValueAt(size, selectRowIn, 4);

                    txtName.setText("");
                    txtPrice.setText("");
                    txtSize.setText("");
                    selectRowIn = -1;
                }
            }
        });

        listCoffee.getSelectionModel().addListSelectionListener(event -> {
            if (!event.getValueIsAdjusting() && listCoffee.getSelectedRow() != -1) {
            	selectRowIn = listCoffee.getSelectedRow();
                typeBox.setSelectedItem(listCoffee.getValueAt(selectRowIn, 1).toString());
                txtName.setText(listCoffee.getValueAt(selectRowIn, 2).toString());
                txtPrice.setText(listCoffee.getValueAt(selectRowIn, 3).toString());
                txtSize.setText(listCoffee.getValueAt(selectRowIn, 4).toString());
            }
        });

        JLabel lblBackground = new JLabel();
        lblBackground.setBounds(-713, -35, 1958, 822);
        lblBackground.setIcon(new ImageIcon("C:\\Users\\kinpr\\Desktop\\Kape de cabuyao\\kape_System\\src\\kape_system_admin\\product_background.png"));
        contentPane.add(lblBackground);
    }
}

package kape_System;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class login_page extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField Juser;
    private JPasswordField JPassword;
    private JComboBox<String> userOption;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    login_page frame = new login_page();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public login_page() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(435, 100, 663, 463);
        setResizable(false);
        
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblUsername = new JLabel("Username :");
        lblUsername.setFont(new Font("Bell MT", Font.PLAIN, 11));
        lblUsername.setBounds(182, 132, 71, 14);
        contentPane.add(lblUsername);

        JLabel lblPassword = new JLabel("Password :");
        lblPassword.setFont(new Font("Bell MT", Font.PLAIN, 11));
        lblPassword.setBounds(182, 172, 71, 14);
        contentPane.add(lblPassword);

        Juser = new JTextField();
        Juser.setFont(new Font("Bell MT", Font.PLAIN, 11));
        Juser.setBounds(253, 132, 148, 20);
        contentPane.add(Juser);
        Juser.setColumns(10);

        JPassword = new JPasswordField();
        JPassword.setFont(new Font("Bell MT", Font.PLAIN, 11));
        JPassword.setBounds(253, 168, 150, 20);
        contentPane.add(JPassword);

        JButton Jlogin = new JButton("Login");
        Jlogin.addActionListener(new ActionListener() {
            @SuppressWarnings("deprecation")
            public void actionPerformed(ActionEvent e) {
                if (Juser.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill out username");
                } else if (JPassword.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please fill out password");
                } else if (Juser.getText().contains("admin") && JPassword.getText().contains("123456")) {
                    String selectedOption = (String) userOption.getSelectedItem();
                    if ("Admin".equals(selectedOption)) {
                        kape_system_admin.admin_panel adminPanel = new kape_system_admin.admin_panel();
                        adminPanel.setVisible(true);
                        dispose();
                    } else if ("User".equals(selectedOption)) {
                        kape_System.home_page homePage = new kape_System.home_page();
                        homePage.setVisible(true);
                        dispose();
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Wrong username or password!", "Message", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        Jlogin.setFont(new Font("Bell MT", Font.PLAIN, 11));
        Jlogin.setForeground(UIManager.getColor("Button.disabledForeground"));
        Jlogin.setBackground(new Color(255, 240, 245));
        Jlogin.setBounds(281, 208, 89, 23);
        Jlogin.setFocusable(false);
        contentPane.add(Jlogin);

        JLabel lblLogin = new JLabel("Log In");
        lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblLogin.setForeground(new Color(160, 82, 45));
        lblLogin.setBounds(238, 82, 154, 40);
        lblLogin.setFont(new Font("Brush Script MT", Font.BOLD, 46));
        contentPane.add(lblLogin);

        JLabel lblPrivacyPolicy = new JLabel("Privacy Policy FAQ");
        lblPrivacyPolicy.setHorizontalAlignment(SwingConstants.CENTER);
        lblPrivacyPolicy.setFont(new Font("Bell MT", Font.BOLD, 10));
        lblPrivacyPolicy.setBounds(253, 287, 148, 23);
        contentPane.add(lblPrivacyPolicy);

        JLabel btnRegister = new JLabel("<html><u>Register a new account</u></html>");
        btnRegister.setHorizontalAlignment(SwingConstants.CENTER);
        btnRegister.setFont(new Font("Bell MT", Font.PLAIN, 11));
        btnRegister.setForeground(new Color(0, 0, 0));
        btnRegister.setBounds(253, 261, 148, 23);
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                personal_regis p1 = new personal_regis();
                p1.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnRegister);

        JLabel btnForgotPass = new JLabel("<html><u>Forgot Password?</u></html>");
        btnForgotPass.setHorizontalAlignment(SwingConstants.CENTER);
        btnForgotPass.setForeground(new Color(0, 0, 0));
        btnForgotPass.setFont(new Font("Bell MT", Font.PLAIN, 11));
        btnForgotPass.setBounds(253, 241, 148, 23);
        btnForgotPass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgot_password_page forgotPasswordPage = new forgot_password_page();
                forgotPasswordPage.setVisible(true);
                dispose();
            }
        });
        contentPane.add(btnForgotPass);

        JCheckBox JCShowpass = new JCheckBox("");
        JCShowpass.setBackground(new Color(240, 240, 240));
        JCShowpass.setFont(new Font("Bell MT", Font.PLAIN, 11));
        JCShowpass.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (JCShowpass.isSelected()) {
                    JPassword.setEchoChar((char) 0);
                } else {
                    JPassword.setEchoChar('*');
                }
            }
        });
        JCShowpass.setBounds(409, 168, 21, 20);
        contentPane.add(JCShowpass);

        userOption = new JComboBox<>();
        userOption.setModel(new DefaultComboBoxModel<>(new String[] {"User", "Admin"}));
        userOption.setBounds(550, 24, 79, 23);
        userOption.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) userOption.getSelectedItem();
                
                Juser.setText("");
                JPassword.setText("");
                if ("Admin".equals(selectedOption)) {
                    lblUsername.setText("Code Name");
                    lblPassword.setText("Securtiy Key :");
                    Jlogin.setText("Login");
                    btnRegister.setVisible(false);
                    btnForgotPass.setVisible(false);
                    lblPrivacyPolicy.setVisible(false);
                    
                    
                } else {
                    lblUsername.setText("Username :");
                    lblPassword.setText("Password :");
                    Jlogin.setText("Login");
                    btnRegister.setVisible(true);
                    btnForgotPass.setVisible(true);
                    lblPrivacyPolicy.setVisible(true);
                }
            }
        });
        contentPane.add(userOption);

        JLabel lblBox = new JLabel();
        lblBox.setBounds(71, 10, 506, 381);
        lblBox.setIcon(new ImageIcon("C:\\Users\\kinpr\\Desktop\\Kape de cabuyao\\kape_System\\src\\kape_System\\login_box.png"));

        JLabel lblBackground = new JLabel();
        lblBackground.setBounds(0, 0, 649, 426);
        ImageIcon backgroundImg = new ImageIcon("C:\\Users\\kinpr\\Desktop\\Kape de cabuyao\\kape_System\\src\\kape_system_admin\\order_bg.jpg");
        Image getBackground = backgroundImg.getImage();
        Image setBackground = getBackground.getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(), Image.SCALE_SMOOTH);
        backgroundImg = new ImageIcon(setBackground);
        lblBackground.setIcon(backgroundImg);

        
        contentPane.add(lblBox);
        contentPane.add(lblBackground);
    }
}
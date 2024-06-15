package kape_System;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JOptionPane;

public class reset_password_page extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPasswordField newPasswordField;
    private JPasswordField confirmPasswordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    reset_password_page frame = new reset_password_page();
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
    public reset_password_page() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(455, 100, 656, 494);
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblBackground = new JLabel();
        lblBackground.setBounds(-11, 0, 911, 542);
        ImageIcon icon = new ImageIcon("C:\\Users\\kinpr\\Desktop\\Kape de cabuyao\\kape_System\\src\\kape_System\\background_kape.png");
        lblBackground.setIcon(icon);

        JLabel lblTitle = new JLabel("Reset Password");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setForeground(new Color(160, 82, 45));
        lblTitle.setFont(new Font("Brush Script MT", Font.BOLD, 36));
        lblTitle.setBounds(210, 78, 235, 40);

        JLabel lblNewPassword = new JLabel("New Password:");
        lblNewPassword.setFont(new Font("Bell MT", Font.PLAIN, 14));
        lblNewPassword.setBounds(231, 140, 120, 14);

        newPasswordField = new JPasswordField();
        newPasswordField.setBounds(231, 165, 190, 25);

        JLabel lblConfirmPassword = new JLabel("Confirm Password:");
        lblConfirmPassword.setFont(new Font("Bell MT", Font.PLAIN, 14));
        lblConfirmPassword.setBounds(231, 201, 120, 14);

        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(231, 226, 190, 25);

        JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setBounds(231, 257, 150, 25);
        showPasswordCheckBox.setBackground(Color.WHITE);
        showPasswordCheckBox.setFont(new Font("Bell MT", Font.PLAIN, 12));

        JButton btnResetPassword = new JButton("Reset Password");
        btnResetPassword.setFont(new Font("Bell MT", Font.PLAIN, 12));
        btnResetPassword.setBounds(231, 294, 190, 30);
        btnResetPassword.setFocusable(false);

        btnResetPassword.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String newPassword = new String(newPasswordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                if (newPassword.isEmpty() || confirmPassword.isEmpty()) {
                    JOptionPane.showMessageDialog(contentPane, "Please fill in both password fields.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!newPassword.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(contentPane, "Passwords do not match. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Your password has been successfully reset.", "Success", JOptionPane.INFORMATION_MESSAGE);
                    new login_page().setVisible(true);
                    dispose();
                }
            }
        });

        showPasswordCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckBox.isSelected()) {
                    newPasswordField.setEchoChar((char) 0);
                    confirmPasswordField.setEchoChar((char) 0);
                } else {
                    newPasswordField.setEchoChar('*');
                    confirmPasswordField.setEchoChar('*');
                }
            }
        });

        contentPane.add(lblTitle);
        contentPane.add(lblNewPassword);
        contentPane.add(newPasswordField);
        contentPane.add(lblConfirmPassword);
        contentPane.add(confirmPasswordField);
        contentPane.add(showPasswordCheckBox);
        contentPane.add(btnResetPassword);
        contentPane.add(lblBackground);
    }
}

package kape_System;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class reciepts_return_page extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JProgressBar progressBar;
    private JList<String> receiptList;
    private DefaultListModel<String> receiptListModel;

    public reciepts_return_page(String[] receiptContent, String total, String paymentMethod) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 30, 678, 432); 
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
		setResizable(false);
		
        JLabel lblBackground = new JLabel();
        lblBackground.setBackground(Color.WHITE);
        lblBackground.setBounds(0, 0, 664, 395); 
        ImageIcon backgroundImg = new ImageIcon("C:\\Users\\kinpr\\Desktop\\Kape de cabuyao\\kape_System\\src\\kape_System\\background_kape.png");
        Image getBackground = backgroundImg.getImage();
        Image setBackground = getBackground.getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(), Image.SCALE_SMOOTH);
        backgroundImg = new ImageIcon(setBackground);
        lblBackground.setIcon(backgroundImg);
        contentPane.add(lblBackground); 

        receiptListModel = new DefaultListModel<>();
        for (String line : receiptContent) {
            receiptListModel.addElement(line);
        }
        receiptListModel.addElement("Total: " + total);
        receiptListModel.addElement("Payment Method: " + paymentMethod);

        receiptList = new JList<>(receiptListModel);
        receiptList.setFont(new Font("Tahoma", Font.PLAIN, 12));

        JScrollPane scrollPane = new JScrollPane(receiptList);
        scrollPane.setBounds(119, 48, 414, 200);
        lblBackground.add(scrollPane); 

        progressBar = new JProgressBar();
        progressBar.setBounds(119, 258, 414, 25);
        progressBar.setStringPainted(true);
        lblBackground.add(progressBar); 
        
        JButton btnCancelOrder = new JButton("Cancel Order");
        btnCancelOrder.addActionListener(e -> {
            int option = JOptionPane.showConfirmDialog(contentPane, "Are you sure you want to cancel the order?", "Confirm Cancellation", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(contentPane, "Canceling order...");
                menu_page menuPage = new menu_page();
                menuPage.setVisible(true);
                dispose();
            }
        });
        btnCancelOrder.setBounds(334, 293, 150, 25);
        btnCancelOrder.setFocusable(false);
        lblBackground.add(btnCancelOrder); 

        JButton btnDone = new JButton("Done");
        btnDone.setBounds(163, 293, 150, 25);
        btnDone.setFocusable(false);
        lblBackground.add(btnDone); 
        
        btnDone.addActionListener(e -> {
            new Thread(new Runnable() {
                public void run() {
                    for (int i = 0; i <= 100; i++) {
                        progressBar.setValue(i);
                        progressBar.setString("Loading " + i + "%");
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }
                    dispose();
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            menu_page menuPage = new menu_page();
                            menuPage.setVisible(true);
                        }
                    });
                }
            }).start();

            JOptionPane.showMessageDialog(contentPane, "Order is complete. Returning to Home.");
            home_page homePage = new home_page();
            homePage.setVisible(true);
        });
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    progressBar.setValue(i);
                    progressBar.setString("Delivery on process...");
                    try {
                        Thread.sleep(50);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        menu_page menuPage = new menu_page();
                        menuPage.setVisible(true);
                        dispose();
                    }
                });
            }
        }).start();
    }

    public static void recieptDisplay(String[] receiptContent, String total, String paymentMethod) {
        EventQueue.invokeLater(() -> {
            try {
                reciepts_return_page frame = new reciepts_return_page(receiptContent, total, paymentMethod);
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}


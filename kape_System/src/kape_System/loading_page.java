package kape_System;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;

public class loading_page extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JProgressBar progressBar;
    private JLabel loadingImg;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loading_page frame = new loading_page();
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
	public loading_page() {
        setBounds(100, 100, 803, 522);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        
        setContentPane(contentPane);
        contentPane.setLayout(null);
		setResizable(false);
        
        
        progressBar = new JProgressBar();
        progressBar.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
        progressBar.setForeground(new Color(25, 25, 112));
        progressBar.setBackground(new Color(192, 192, 192));
        progressBar.setBounds(249, 313, 286, 21);
        progressBar.setStringPainted(true); 
        contentPane.add(progressBar);
        
        loadingImg = new JLabel("");
        loadingImg.setIcon(new ImageIcon("C:\\Users\\kinpr\\Desktop\\Kape de cabuyao\\kape_System\\src\\kape_System\\tenor-unscreen.gif"));
        loadingImg.setBounds(151, 84, 410, 192);
        contentPane.add(loadingImg);
        
		JLabel lblBackground = new JLabel();
		lblBackground.setBackground(Color.WHITE);
        lblBackground.setBounds(0, 0, 786, 475);
        ImageIcon backgroundImg = new ImageIcon("C:\\Users\\kinpr\\Desktop\\Kape de cabuyao\\kape_System\\src\\kape_System\\background_kape.png");
        Image getBackground = backgroundImg.getImage();
        Image setBackground = getBackground.getScaledInstance(lblBackground.getWidth(), lblBackground.getHeight(), Image.SCALE_SMOOTH);
        backgroundImg = new ImageIcon(setBackground);
        lblBackground.setIcon(backgroundImg);
        
        contentPane.add(lblBackground);
		

        new Thread(new Runnable() {
            public void run() {
                updateProgressBar();
            }
        }).start();
    }

	public void updateProgressBar() {
        int i = 0;
        try {
            while (i <= 100) {
                progressBar.setValue(i);
                progressBar.setString("Loading " + i + "%");
                Thread.sleep(50); 
                i += 1;
            }
            if (i > 100) {
                dispose();
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            login_page login = new login_page();
                            login.setVisible(true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

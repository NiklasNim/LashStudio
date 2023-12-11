package gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow frame = new MainWindow();
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
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Lash Studio");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 72));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Booking");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookingClicked(); 
			}
		});
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 38));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Produkter/Ordre");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderClicked(); 
			}
		});
		btnNewButton_2.setFont(new Font("Lucida Grande", Font.BOLD, 38));
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Kunde");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerClicked(); 
			}
		});
		btnNewButton_1.setFont(new Font("Lucida Grande", Font.BOLD, 38));
		contentPane.add(btnNewButton_1);
	}
	private void BookingClicked() {
        JFrame newFrame = new JFrame("Booking valgmuligheder");
        newFrame.setSize(500, 300);
        newFrame.setLocationRelativeTo(null);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel newPanel = new JPanel();
        newPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Booking valgmuligheder");
        newPanel.add(label);

        newFrame.getContentPane().add(newPanel);
        newFrame.setVisible(true);
    }
	private void OrderClicked() {
        JFrame newFrame = new JFrame("Ordre valgmuligheder");
        newFrame.setSize(500, 300);
        newFrame.setLocationRelativeTo(null);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel newPanel = new JPanel();
        newPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Ordre valgmuligheder");
        newPanel.add(label);

        newFrame.getContentPane().add(newPanel);
        newFrame.setVisible(true);
    }
	private void CustomerClicked() {
        JFrame newFrame = new JFrame("Kunde valgmuligheder");
        newFrame.setSize(500, 300);
        newFrame.setLocationRelativeTo(null);
        newFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel newPanel = new JPanel();
        newPanel.setLayout(new FlowLayout());

        JLabel label = new JLabel("Kunde valgmuligheder");
        newPanel.add(label);

        newFrame.getContentPane().add(newPanel);
        newFrame.setVisible(true);
    }

}

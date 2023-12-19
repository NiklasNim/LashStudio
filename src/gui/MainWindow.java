package gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    private JPanel contentPane;
    
    public MainWindow() {
    	setFont(new Font("Arial", Font.PLAIN, 12));
    	setTitle("Hovedmenu"); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblNewLabel = new JLabel("Lash Studio");
        lblNewLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 72));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel);

        JButton btnNewButton = new JButton("Booking");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openBookingOptions();
            }
        });
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 38));
        contentPane.add(btnNewButton);
        btnNewButton.setToolTipText("Klik her for at gå til booking valgmuligheder");

        JButton btnNewButton_2 = new JButton("Produkter/Ordre");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openOrderOptions();
            }
        });
        btnNewButton_2.setFont(new Font("Arial", Font.BOLD, 38));
        contentPane.add(btnNewButton_2);
        btnNewButton_2.setToolTipText("Klik her for at gå til ordre valgmuligheder");

        JButton btnNewButton_1 = new JButton("Kunde");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                openCustomerOptions();
            }
        });
        btnNewButton_1.setFont(new Font("Arial", Font.BOLD, 38));
        contentPane.add(btnNewButton_1);
        btnNewButton_1.setToolTipText("Klik her for at gå til kunde valgmuligheder");
    }

    private void openBookingOptions() {
        guiHandler.createBookingOptionsUI();
    }

    private void openOrderOptions() {
        OrderOptionsUI orderOptions = new OrderOptionsUI();
        orderOptions.setVisible(true);
    }

    private void openCustomerOptions() {
        CustomerOptionsUI customerOptions = new CustomerOptionsUI();
        customerOptions.setVisible(true);
    }
}

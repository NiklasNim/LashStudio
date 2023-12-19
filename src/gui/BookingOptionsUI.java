package gui;

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

public class BookingOptionsUI extends JFrame {

    private JPanel contentPane;

    // Konstruktør for BookingOptionsUI
    public BookingOptionsUI() {
    	setTitle("Booking valgmuligheder menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblNewLabel = new JLabel("Booking valgmuligheder");
        lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 40));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 0));

        JButton btnNewButton = new JButton("Opret Booking");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                bookingClicked();
            }
        });
        
     
        
        btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
        buttonPanel.add(btnNewButton);
        btnNewButton.setToolTipText("Klik her for at oprette en booking");

        JButton btnNewButton_2 = new JButton("Redigér booking");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // OrderClicked();
            }
        });
        btnNewButton_2.setFont(new Font("Arial", Font.PLAIN, 20));
        buttonPanel.add(btnNewButton_2);
        btnNewButton_2.setToolTipText("Klik her for at gå til redigerer en booking");

        JButton btnNewButton_1 = new JButton("Slet booking");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // CustomerClicked();
            }
        });
        btnNewButton_1.setFont(new Font("Arial", Font.PLAIN, 20));
        buttonPanel.add(btnNewButton_1);
        btnNewButton_1.setToolTipText("Klik her for at gå slette en eksisterende bookning");

        JButton btnBackToMain = new JButton("Tilbage til hovedmenu");
        btnBackToMain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guiHandler.goBack();
            }
        });
        btnBackToMain.setFont(new Font("Arial", Font.PLAIN, 20));
        buttonPanel.add(btnBackToMain);

        contentPane.add(buttonPanel);
        btnBackToMain.setToolTipText("Klik her for at gå tilbage til hovedmenuen");
    }

    // Metode til at håndtere klik på "Opret Booking" knappen
	private void bookingClicked() {
		guiHandler.createBookingUI();
	}
}

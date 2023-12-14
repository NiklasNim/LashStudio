package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class CreateCustomerUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textPhone;

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DATABASE_USER = "your_username";
    private static final String DATABASE_PASSWORD = "your_password";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateCustomerUI frame = new CreateCustomerUI();
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
	public CreateCustomerUI() {
		setTitle("Opret kunde");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JLabel lblNewLabel_3 = new JLabel("Opret kunde");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridwidth = 2;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		contentPane.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JLabel lblNe = new JLabel("Indtast fornavn:");
		lblNe.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNe = new GridBagConstraints();
		gbc_lblNe.anchor = GridBagConstraints.EAST;
		gbc_lblNe.insets = new Insets(0, 0, 5, 5);
		gbc_lblNe.gridx = 0;
		gbc_lblNe.gridy = 2;
		contentPane.add(lblNe, gbc_lblNe);
		
		textPhone = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 1;
		gbc_textField_2.gridy = 2;
		contentPane.add(textPhone, gbc_textField_2);
		textPhone.setColumns(10);
		
		JLabel lblIndtastEfternavn = new JLabel("Indtast efternavn:");
		lblIndtastEfternavn.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GridBagConstraints gbc_lblIndtastEfternavn = new GridBagConstraints();
		gbc_lblIndtastEfternavn.insets = new Insets(0, 0, 5, 5);
		gbc_lblIndtastEfternavn.anchor = GridBagConstraints.EAST;
		gbc_lblIndtastEfternavn.gridx = 0;
		gbc_lblIndtastEfternavn.gridy = 4;
		contentPane.add(lblIndtastEfternavn, gbc_lblIndtastEfternavn);
		
		textLastName = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 4;
		contentPane.add(textLastName, gbc_textField_1);
		textLastName.setColumns(10);
		
		JLabel lblIndtastTelefonnr = new JLabel("Indtast telefon-nr:");
		lblIndtastTelefonnr.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		GridBagConstraints gbc_lblIndtastTelefonnr = new GridBagConstraints();
		gbc_lblIndtastTelefonnr.insets = new Insets(0, 0, 5, 5);
		gbc_lblIndtastTelefonnr.anchor = GridBagConstraints.EAST;
		gbc_lblIndtastTelefonnr.gridx = 0;
		gbc_lblIndtastTelefonnr.gridy = 6;
		contentPane.add(lblIndtastTelefonnr, gbc_lblIndtastTelefonnr);
		
		textFirstName = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 6;
		contentPane.add(textFirstName, gbc_textField);
		textFirstName.setColumns(10);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 2;
		gbc_panel.gridwidth = 2;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 8;
		contentPane.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnNewButton = new JButton("Tilbage");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goBackClicked();
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Opret");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opretClicked(); 
			}
		});
		panel.add(btnNewButton_1);
	}
	private void goBackClicked() {
      setVisible(false);
      CustomerOptionsUI customerOptionsUI = new CustomerOptionsUI();
      customerOptionsUI.setVisible(true);
	}
    private void opretClicked() {
        try {
            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);

            // SQL INSERT statement
            String sql = "INSERT INTO your_table (firstname, lastname, telefon) VALUES (?, ?, ?)";

            // Create a PreparedStatement
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Set values for the parameters
                preparedStatement.setString(1, textFirstName.getText());
                preparedStatement.setString(2, textLastName.getText());
                preparedStatement.setString(3, textPhone.getText());

                // Execute the statement
                preparedStatement.executeUpdate();
            }

            // Close the connection
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}

package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CreateOrderUI extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;	
    private JTextField textField7;
    private JButton btnSubmit;
    private JButton btnNewButton;

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/your_database";
    private static final String DATABASE_USER = "your_username";
    private static final String DATABASE_PASSWORD = "your_password";

    public CreateOrderUI() {
        initialize();
    }

    private void initialize() {
        setTitle("Opret ordre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new GridLayout(8, 2, 10, 10));

        JLabel lblNewLabel1 = new JLabel("Indtast produktnavn:");
        getContentPane().add(lblNewLabel1);

        textField1 = new JTextField();
        getContentPane().add(textField1);
        textField1.setColumns(10);

        JLabel lblNewLabel2 = new JLabel("Indtast stregkode/scan:");
        getContentPane().add(lblNewLabel2);

        textField2 = new JTextField();
        getContentPane().add(textField2);
        textField2.setColumns(10);

        JLabel lblNewLabel3 = new JLabel("Indtast produkttype:");
        getContentPane().add(lblNewLabel3);

        textField3 = new JTextField();
        getContentPane().add(textField3);
        textField3.setColumns(10);

        JLabel lblNewLabel4 = new JLabel("Indtast produktpris:");
        getContentPane().add(lblNewLabel4);

        textField4 = new JTextField();
        getContentPane().add(textField4);
        textField4.setColumns(10);

        JLabel lblNewLabel5 = new JLabel("Indtast udløbsdato:");
        getContentPane().add(lblNewLabel5);

        textField5 = new JTextField();
        getContentPane().add(textField5);
        textField5.setColumns(10);

        JLabel lblNewLabel6 = new JLabel("Indtast minimumbeholdning:");
        getContentPane().add(lblNewLabel6);

        textField6 = new JTextField();
        getContentPane().add(textField6);
        textField6.setColumns(10);
        
        JLabel lblNewLabel7 = new JLabel("Indtast antal:");
        getContentPane().add(lblNewLabel7);

        textField7 = new JTextField();
        getContentPane().add(textField7);
        textField7.setColumns(10);

        btnSubmit = new JButton("Tilbage");
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	goBackToMain();
            }
        });
        getContentPane().add(btnSubmit);
        
        btnNewButton = new JButton("Opret");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {

                String text1 = textField1.getText();
                String text2 = textField2.getText();
                String text3 = textField3.getText();
                String text4 = textField4.getText();
                String text5 = textField5.getText();
                String text6 = textField6.getText();
                String text7 = textField7.getText();
                System.out.println("Text from Field 1: " + text1);
                System.out.println("Text from Field 2: " + text2);
                System.out.println("Text from Field 3: " + text3);
                System.out.println("Text from Field 4: " + text4);
                System.out.println("Text from Field 5: " + text5);
                System.out.println("Text from Field 6: " + text6);
                System.out.println("Text from Field 7: " + text7);
        	}
        });
        getContentPane().add(btnNewButton);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CreateOrderUI frame = new CreateOrderUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void goBackToMain() {
        setVisible(false);
		OrderOptionsUI orderOptionsUI = new OrderOptionsUI();
		orderOptionsUI.setVisible(true);
    }
//    private void opretClicked() {
//        try {
//            Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USER, DATABASE_PASSWORD);
//
//            String sql = "INSERT INTO your_table (firstname, lastname, telefon) VALUES (?, ?, ?)";
//
//            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
//                // Set values for the parameters
//                preparedStatement.setString(1, textFirstName.getText());
//                preparedStatement.setString(2, textLastName.getText());
//                preparedStatement.setString(3, textPhone.getText());
//                preparedStatement.setString(4, textPhone.getText());
//                preparedStatement.setString(5, textPhone.getText());
//                preparedStatement.setString(6, textPhone.getText());
//                preparedStatement.setString(7, textPhone.getText());
//
//                preparedStatement.executeUpdate();
//            }
//
//            connection.close();
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//    }
}

package gui;

import com.github.lgooddatepicker.components.DatePicker;
import com.github.lgooddatepicker.components.DatePickerSettings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class CreateBookingUI2_TESTER extends JFrame {
    private JComboBox<String> serviceTypeComboBox;
    private JTextField nameTextField;
    private JComboBox<String> timeComboBox;
    private DatePicker datePicker;

    public CreateBookingUI2_TESTER() {
        initialize();
    }

    private void initialize() {
        setTitle("Booking Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new GridLayout(5, 2, 10, 10));

        JLabel lblNewLabel1 = new JLabel("Vælg Service Type:");
        getContentPane().add(lblNewLabel1);

        serviceTypeComboBox = new JComboBox<>(new String[]{"Hårklipning", "Negle", "Lashes"});
        getContentPane().add(serviceTypeComboBox);

        JLabel lblNewLabel2 = new JLabel("Indtast navn:");
        getContentPane().add(lblNewLabel2);

        nameTextField = new JTextField();
        getContentPane().add(nameTextField);
        nameTextField.setColumns(10);

        JLabel lblNewLabel3 = new JLabel("Vælg tidspunkt:");
        getContentPane().add(lblNewLabel3);

        timeComboBox = new JComboBox<>(new String[]{"9:00", "11:00", "2:00", "4:00"});
        getContentPane().add(timeComboBox);

        JLabel lblNewLabel4 = new JLabel("Vælg Dato:");
        getContentPane().add(lblNewLabel4);

        // Use JDatePicker for date selection
        DatePickerSettings dateSettings = new DatePickerSettings();
        datePicker = new DatePicker(dateSettings);
        getContentPane().add(datePicker);

        JButton btnTilbage = new JButton("Tilbage");
        btnTilbage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goBackClicked();
            }
        });
        getContentPane().add(btnTilbage);

        JButton btnSubmit = new JButton("Udfør Booking");
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitBooking();
            }
        });
        getContentPane().add(btnSubmit);
    }

    private void submitBooking() {
        String serviceType = (String) serviceTypeComboBox.getSelectedItem();
        String name = nameTextField.getText();
        String time = (String) timeComboBox.getSelectedItem();
        LocalDate date = datePicker.getDate();
        System.out.println("Service Type: " + serviceType);
        System.out.println("Name: " + name);
        System.out.println("Time: " + time);
        System.out.println("Date: " + date);
        JOptionPane.showMessageDialog(this, "Booking submitted successfully!");

        clearForm();
    }

    private void clearForm() {
        serviceTypeComboBox.setSelectedIndex(0);
        nameTextField.setText("");
        timeComboBox.setSelectedIndex(0);
        datePicker.clear();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CreateBookingUI2_TESTER frame = new CreateBookingUI2_TESTER();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

//    private void goBackClicked() {
//    	CreateBookingUI2_TESTER createBooking = new CreateBookingUI2_TESTER();
//        createBooking.setVisible(true);
//    }
}

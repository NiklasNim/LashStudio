package gui;

import javax.swing.*;

import connectDatabase.DatabaseConnection;
import model.Schedule;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

public class CreateBookingUI extends JFrame {
    private JComboBox<String> serviceTypeComboBox;
    private JTextField nameTextField;
    private JComboBox<String> dateComboBox;
    private JTextField txtPrisHer;

    public CreateBookingUI() {
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

        JLabel lblNewLabel3 = new JLabel("Vælg Dag og Tidspunkt:");
        getContentPane().add(lblNewLabel3);

        dateComboBox = new JComboBox<>(/*new String[]{"2023-01-01", "2023-01-02", "2023-01-03"}*/);
        getContentPane().add(dateComboBox);
        
        JButton btnTilbage = new JButton("Tilbage");
        btnTilbage.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goBackClicked();
            }
        });
        
        JLabel lblNewLabel = new JLabel("Pris:");
        getContentPane().add(lblNewLabel);
        
        txtPrisHer = new JTextField();
        getContentPane().add(txtPrisHer);
        txtPrisHer.setColumns(10);
        getContentPane().add(btnTilbage);

        JButton btnSubmit = new JButton("Udfør Booking");
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitBooking();
            }
        });
        getContentPane().add(btnSubmit);
        populatDateComboBoxFromDatabase();
        
    }

    private void submitBooking() {
        String serviceType = (String) serviceTypeComboBox.getSelectedItem();
        String name = nameTextField.getText();
        //String time = (String) timeComboBox.getSelectedItem();
        String date = (String) dateComboBox.getSelectedItem();
        System.out.println("Service Type: " + serviceType);
        System.out.println("Name: " + name);
        //System.out.println("Time: " + time);
        System.out.println("Date: " + date);
        JOptionPane.showMessageDialog(this, "Booking submitted successfully!");

        clearForm();
    }

    private void clearForm() {
        serviceTypeComboBox.setSelectedIndex(0);
        nameTextField.setText("");
        //timeComboBox.setSelectedIndex(0);
        dateComboBox.setSelectedIndex(0);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	CreateBookingUI frame = new CreateBookingUI();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private void goBackClicked() {
    	CreateBookingUI createBooking = new CreateBookingUI(); // skal refereres til OrderOptions isf
        createBooking.setVisible(true);
    }
    
    private void populatDateComboBoxFromDatabase() {
        List<Timestamp> schedules = new ArrayList<>();
        String sql = "SELECT schedule.* FROM Schedule " +
                     "LEFT JOIN BookingLine ON BookingLine.scheduleId_FK = Schedule.scheduleId " +
                     "WHERE BookingLine.bookingLineId IS NULL " +
                     "AND startTime <= DATEADD(day, 7, GetDate()) " +
                     "AND startTime > GetDate()";

        try {
            DatabaseConnection dbConn = DatabaseConnection.getInstance();
            PreparedStatement pstmt = dbConn.getConnection().prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                Timestamp startTime = rs.getTimestamp("startTime");
                schedules.add(startTime);
            }

            updateDateComboBox(schedules);

        } catch (SQLException e) {
            e.printStackTrace(); 
        }
    }

    private void updateDateComboBox(List<Timestamp> timestamps) {
        dateComboBox.removeAllItems();
        for (Timestamp timestamp : timestamps) {
            dateComboBox.addItem(timestamp.toString()); 
        }
    }

    
}

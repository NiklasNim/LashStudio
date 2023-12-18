package gui;

import javax.swing.*;
import controller.*;
import model.Schedule;
import model.Service;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

public class CreateBookingUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JComboBox<Service> serviceComboBox;
    private ServiceController serviceController;
    private ScheduleController scheduleController;
    private BookingController bookingController;
    private JTextField nameTextField;
    private JComboBox<Schedule> dateComboBox;
    
    public CreateBookingUI() {
    	setFont(new Font("Arial", Font.PLAIN, 12));
    	getContentPane().setFont(new Font("Arial", Font.PLAIN, 13));
        this.serviceController = new ServiceController();
        this.bookingController = new BookingController();
        this.scheduleController = new ScheduleController();
        initialize();
    }

    private void initialize() {
        setTitle("Booking Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(new GridLayout(6, 2, 10, 10));

        JLabel label_2 = new JLabel("Vælg Service inklusiv pris:");
        label_2.setFont(new Font("Arial", Font.PLAIN, 13));
        getContentPane().add(label_2);
        serviceComboBox = new JComboBox<>();
        serviceComboBox.setFont(new Font("Arial", Font.PLAIN, 13));
        getContentPane().add(serviceComboBox);
        updateServiceComboBox();

        JLabel label_1 = new JLabel("Indtast kundens telefonnummer:");
        label_1.setFont(new Font("Arial", Font.PLAIN, 13));
        getContentPane().add(label_1);
        nameTextField = new JTextField();
        nameTextField.setFont(new Font("Arial", Font.PLAIN, 13));
        getContentPane().add(nameTextField);
        nameTextField.setColumns(10);

        JLabel label = new JLabel("Vælg Dag og Tidspunkt:");
        label.setFont(new Font("Arial", Font.PLAIN, 13));
        getContentPane().add(label);
        dateComboBox = new JComboBox<>();
        dateComboBox.setFont(new Font("Arial", Font.PLAIN, 13));
        getContentPane().add(dateComboBox);
        populateDateComboBoxFromDatabase();

        JButton btnBack = new JButton("Tilbage");
        btnBack.setFont(new Font("Arial", Font.PLAIN, 13));
        btnBack.addActionListener(e -> guiHandler.goBack());
        getContentPane().add(btnBack);
        

        JButton btnSubmit = new JButton("Udfør Booking");
        btnSubmit.setFont(new Font("Arial", Font.PLAIN, 13));
        btnSubmit.addActionListener(e -> submitBooking());
        getContentPane().add(btnSubmit);
    }


    private void submitBooking() {
        try {
            Service selectedService = (Service) serviceComboBox.getSelectedItem();
            if (selectedService == null) {
                JOptionPane.showMessageDialog(this, "Vælg venligst en service.");
                return;
            }

            int phone;
            try {
                phone = Integer.parseInt(nameTextField.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Indtast venligst et gyldigt telefonnummer.", "Inputfejl", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (dateComboBox.getSelectedItem() == null) {
                JOptionPane.showMessageDialog(this, "Ingen tilgængelig tidsplan fundet for det valgte tidspunkt.");
                return;
            }
       
            Schedule selectedSchedule = (Schedule)dateComboBox.getSelectedItem();
            LocalDate bookingDate = selectedSchedule.getStartTime().toLocalDateTime().toLocalDate();            
            
            bookingController.createBooking(bookingDate, phone, selectedSchedule.getScheduleId(), selectedService.getServiceId());

            String bookingSummary = "Service: " + selectedService + ", Dato/Tid: " + selectedSchedule;
            
            System.out.println("Succesfuld booking");
            JOptionPane.showMessageDialog(this, "Booking gemt med succes. " + bookingSummary);
            guiHandler.goBack();
    
            clearForm();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Fejl under oprettelse af booking: " + ex.getMessage(), "Booking Fejl", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void updateServiceComboBox() {
        List<Service> services = serviceController.getAllServices();
        for (Service service : services) {
            serviceComboBox.addItem(service);
        }
    }
    
    private void populateDateComboBoxFromDatabase() {
    	List<Schedule> allSchedules = scheduleController.getAllAvailableSchedules();
    	updateDateComboBox(allSchedules);
    }
  
    private void clearForm() {
        serviceComboBox.setSelectedIndex(0);
        nameTextField.setText("");
        dateComboBox.setSelectedIndex(0);
    }
    
    private void updateDateComboBox(List<Schedule> schedules) {
	    dateComboBox.removeAllItems();
	    for (Schedule schedule : schedules) {
	        dateComboBox.addItem(schedule);
	    }
	}

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                CreateBookingUI frame = new CreateBookingUI();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
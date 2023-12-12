package gui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateOrderUI extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton btnSubmit;
    private JButton btnNewButton;

    public CreateOrderUI() {
        initialize();
    }

    private void initialize() {
        setTitle("Opret ordre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        getContentPane().setLayout(new GridLayout(7, 2, 10, 10));

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

        btnSubmit = new JButton("Tilbage");
        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String text1 = textField1.getText();
                String text2 = textField2.getText();
                String text3 = textField3.getText();
                String text4 = textField4.getText();
                String text5 = textField5.getText();
                String text6 = textField6.getText();
                System.out.println("Text from Field 1: " + text1);
                System.out.println("Text from Field 2: " + text2);
                System.out.println("Text from Field 3: " + text3);
                System.out.println("Text from Field 4: " + text4);
                System.out.println("Text from Field 5: " + text5);
                System.out.println("Text from Field 6: " + text6);
            }
        });
        getContentPane().add(btnSubmit);
        
        btnNewButton = new JButton("Udfør");
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
}

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
import java.sql.SQLException;

public class OrderOptionsUI extends JFrame {

    private JPanel contentPane;
    private MainWindow mainWindow; 

    public OrderOptionsUI() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(0, 1, 0, 0));

        JLabel lblNewLabel = new JLabel("Ordre valgmuligheder");
        lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblNewLabel);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4, 10, 0));

        JButton btnNewButton = new JButton("Opret Ordre");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               createOrderClicked();
            }
        });
        btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        buttonPanel.add(btnNewButton);

        JButton btnNewButton_2 = new JButton("Redigér Ordre");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // OrderClicked();
            }
        });
        btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        buttonPanel.add(btnNewButton_2);

        JButton btnNewButton_1 = new JButton("Slet Ordre");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // deleteOrderClicked();
            }
        });
        btnNewButton_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        buttonPanel.add(btnNewButton_1);

        JButton btnBackToMain = new JButton("Tilbage til hovedmenu");
        btnBackToMain.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                goBackToMain();
            }
        });
        btnBackToMain.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        buttonPanel.add(btnBackToMain);

        contentPane.add(buttonPanel);
    }

    private void goBackToMain() {
        setVisible(false);
        mainWindow.setVisible(true);
    }

    private void createOrderClicked() {
        CreateOrderUI createOrder = new CreateOrderUI();
        createOrder.setVisible(true);
    }
//    private void deleteOrderClicked() {
//        OrderOverviewUI orderOverview = new OrderOverviewUI();
//        orderOverview.setVisible(true);
//    }
}
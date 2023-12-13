package gui;
import javax.swing.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
// import connectDatabase.*; 
import database.*;
import java.awt.Font;

public class OrderOverviewUI extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private OrderOptionsUI orderOptions; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderOverviewUI frame = new OrderOverviewUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	// Connection connection=null; 
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public OrderOverviewUI() throws SQLException {
		setTitle("Produkt oversigt");
		// connection=TryToConnect.(); //Arbejder på connection
		//connection=ProductDB.connect(); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLoadTable = new JButton("Load Data");
		btnLoadTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLoadTable.setBounds(296, 18, 117, 29);
		contentPane.add(btnLoadTable);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 56, 438, 142);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblTekstOverTabel = new JLabel("Oversigt over produkter:");
		lblTekstOverTabel.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblTekstOverTabel.setBounds(10, 18, 231, 29);
		contentPane.add(lblTekstOverTabel);
	}
}
//    private void goBackToOrderOptions() { // klar til tilknytning af knap
//        setVisible(false);
//        orderOptions.setVisible(true);
//    }

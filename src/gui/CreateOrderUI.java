package gui;

import javax.swing.*;
import controller.OrderController;
import model.Customer;
import model.OrderLine;
import model.Product;
import java.awt.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreateOrderUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private JComboBox<Product> productComboBox;
	private OrderController orderController;
	private JTextField quantityTextField;
	private JTextField nameTextField;

	public CreateOrderUI() {
		setFont(new Font("Arial", Font.PLAIN, 12));
		getContentPane().setFont(new Font("Arial", Font.PLAIN, 13));
		this.orderController = new OrderController();
		initialize();
	}

//	private Customer findCustomerByPhone(int phone) {
//		try {
//			return orderController.findCustomerByPhone(phone);
//		} catch (Exception ex) {
//			ex.printStackTrace();
//			JOptionPane.showMessageDialog(this, "Error finding customer by phone: " + ex.getMessage(), "Customer Error",
//					JOptionPane.ERROR_MESSAGE);
//			return null;
//		}
//	}

	private void initialize() {
		setTitle("Order Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(new GridLayout(4, 2, 10, 10));

		JLabel label_3 = new JLabel("Indtast kundens telefonnummer:");
		label_3.setFont(new Font("Arial", Font.PLAIN, 13));
		getContentPane().add(label_3);
		nameTextField = new JTextField();
		nameTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		getContentPane().add(nameTextField);
		nameTextField.setColumns(10);

		JLabel lblVlgProduct = new JLabel("Vælg product:");
		lblVlgProduct.setFont(new Font("Arial", Font.PLAIN, 13));
		getContentPane().add(lblVlgProduct);

		productComboBox = new JComboBox<>();
		productComboBox.setFont(new Font("Arial", Font.PLAIN, 13));
		getContentPane().add(productComboBox);
		updateProductComboBox();

		JLabel lblVlgMngde = new JLabel("Vælg mængde:");
		lblVlgMngde.setFont(new Font("Arial", Font.PLAIN, 13));
		getContentPane().add(lblVlgMngde);

		quantityTextField = new JTextField();
		quantityTextField.setFont(new Font("Arial", Font.PLAIN, 13));
		getContentPane().add(quantityTextField);
		quantityTextField.setColumns(10);

		JButton btnBack = new JButton("Tilbage");
		btnBack.setFont(new Font("Arial", Font.PLAIN, 13));
		btnBack.addActionListener(e -> guiHandler.goBack());
		getContentPane().add(btnBack);

		JButton btnSubmit = new JButton("Udfør Order");
		btnSubmit.setFont(new Font("Arial", Font.PLAIN, 13));
		btnSubmit.addActionListener(e -> submitOrder());
		getContentPane().add(btnSubmit);
	}

	private void submitOrder() {
		try {
			Product selectedProduct = (Product) productComboBox.getSelectedItem();
			if (selectedProduct == null) {
				JOptionPane.showMessageDialog(this, "Please select a product.");
				return;
			}

			int quantity;
			try {
				quantity = Integer.parseInt(quantityTextField.getText().trim());
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(this, "Please enter a valid quantity.", "Input Error",
						JOptionPane.ERROR_MESSAGE);
				return;
			}

			List<OrderLine> orderLines = new ArrayList<>();
			orderLines.add(new OrderLine(selectedProduct, selectedProduct.getPrice(), quantity));

			orderController.createOrder(LocalDate.now(), orderLines);

			String orderSummary = "Product: " + selectedProduct + ", Quantity: " + quantity;

			System.out.println("Successful order placement");
			JOptionPane.showMessageDialog(this, "Order placed successfully. " + orderSummary);
			guiHandler.goBack();

			clearForm();
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(this, "Error placing order: " + ex.getMessage(), "Order Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	private void updateProductComboBox() {
		List<Product> products = orderController.findAllProducts();
		for (Product product : products) {
			productComboBox.addItem(product);
		}
	}

	private void clearForm() {
		productComboBox.setSelectedIndex(0);
		quantityTextField.setText("");
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				CreateOrderUI frame = new CreateOrderUI();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}

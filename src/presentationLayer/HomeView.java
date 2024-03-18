package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JMenuBar;
import javax.swing.JComboBox;
import javax.swing.JTable;

public class HomeView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	protected JTabbedPane tabbedPane;
	LoginView loginView = new LoginView();
	private JTable productResultTable;
	private JTextField productNameField;
	private JTextField priceField;
	private JTextField productIDUpdateField;
	private JTextField productNameUpdateField;
	private JTextField productPriceUpdateField;
	private JTextField productIdDeleteField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeView frame = new HomeView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public HomeView() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setBounds(100, 100, 1028, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel headerLabel = new JLabel("PRODUCT MANAGEMENT");
		
		JPanel header = new JPanel();
		header.setBackground(new Color(30, 144, 255));
		header.setBounds(0, 0, 1014, 54);
		contentPane.add(header);
		
		headerLabel.setFont(new Font("Tahoma", Font.BOLD, 36));
		header.add(headerLabel);
		
		JPanel sidebar = new JPanel();
		sidebar.setBackground(new Color(30, 144, 255));
		sidebar.setBounds(0, 0, 132, 563);
		contentPane.add(sidebar);
		sidebar.setLayout(null);
		
		JButton AddNewButton = new JButton("ADD PRODUCT");
		AddNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				headerLabel.setText("ADD PRODUCT FORM");
				tabbedPane.setSelectedIndex(0);
			}
		});
		AddNewButton.setBounds(0, 67, 122, 35);
		sidebar.add(AddNewButton);
		
		JButton findProductButton = new JButton("PRODUCT LIST");
		findProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				headerLabel.setText("FIND PRODUCT FORM");
				tabbedPane.setSelectedIndex(1);
			}
		});
		findProductButton.setBounds(0, 113, 122, 35);
		sidebar.add(findProductButton);
		
		JButton editProductButton = new JButton("EDIT PRODUCT");
		editProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				headerLabel.setText("EDIT PRODUCT FORM");
				tabbedPane.setSelectedIndex(2);
			}
		});
		editProductButton.setBounds(0, 159, 122, 35);
		sidebar.add(editProductButton);
		
		JButton deleteProductButton = new JButton("DELETE PRODUCT");
		deleteProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				headerLabel.setText("DELETE PRODUCT FORM");
				tabbedPane.setSelectedIndex(3);
			}
		});
		deleteProductButton.setBounds(0, 205, 122, 35);
		sidebar.add(deleteProductButton);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnLogout.setBounds(10, 487, 112, 23);
		sidebar.add(btnLogout);
		
		JLabel usernameLabel = new JLabel("User name");
		usernameLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		usernameLabel.setBounds(10, 462, 112, 14);
		sidebar.add(usernameLabel);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(130, 33, 884, 530);
		contentPane.add(tabbedPane);
		
		JPanel addProductForm = new JPanel();
		tabbedPane.addTab("New tab", null, addProductForm, null);
		addProductForm.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(10, 156, 142, 38);
		addProductForm.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Price");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setBounds(10, 205, 142, 38);
		addProductForm.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Company Name");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1_1.setBounds(10, 257, 142, 38);
		addProductForm.add(lblNewLabel_1_1_1);
		
		productNameField = new JTextField();
		productNameField.setBounds(171, 158, 557, 38);
		addProductForm.add(productNameField);
		productNameField.setColumns(10);
		
		priceField = new JTextField();
		priceField.setColumns(10);
		priceField.setBounds(171, 207, 557, 38);
		addProductForm.add(priceField);
		
		JComboBox companyNameField = new JComboBox();
		companyNameField.setBounds(171, 259, 557, 38);
		addProductForm.add(companyNameField);
		
		JButton clearProductName = new JButton("Clear");
		clearProductName.setBounds(738, 158, 57, 38);
		addProductForm.add(clearProductName);
		
		JButton clearPrice = new JButton("Clear");
		clearPrice.setBounds(738, 207, 57, 38);
		addProductForm.add(clearPrice);
		
		JButton addProduct = new JButton("Add");
		addProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		addProduct.setForeground(new Color(0, 0, 0));
		addProduct.setBackground(new Color(0, 255, 0));
		addProduct.setBounds(171, 308, 120, 38);
		addProductForm.add(addProduct);
		
		JButton resetAllFields = new JButton("Reset");
		resetAllFields.setBounds(302, 308, 120, 38);
		addProductForm.add(resetAllFields);
		
		JLabel lblNewLabel_2 = new JLabel("Enter product information");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(171, 55, 557, 38);
		addProductForm.add(lblNewLabel_2);
		
		JPanel productListForm = new JPanel();
		tabbedPane.addTab("New tab", null, productListForm, null);
		productListForm.setLayout(null);
		
		JComboBox companyField = new JComboBox();
		companyField.setBounds(201, 5, 550, 36);
		productListForm.add(companyField);
		
		JButton searchBtn = new JButton("Search");
		searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchBtn.setBounds(761, 5, 118, 36);
		productListForm.add(searchBtn);
		
		productResultTable = new JTable();
		productResultTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name", "Price", "Company"
				}
			));
		productResultTable.setBounds(10, 108, 869, 240);
		productListForm.add(productResultTable);
		
		JLabel lblNewLabel = new JLabel("Select Company:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 5, 181, 36);
		productListForm.add(lblNewLabel);
		
		JLabel lblProductList = new JLabel("Product List:");
		lblProductList.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblProductList.setBounds(10, 61, 181, 36);
		productListForm.add(lblProductList);
		
		JPanel editProductForm = new JPanel();
		tabbedPane.addTab("New tab", null, editProductForm, null);
		editProductForm.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Enter product information to update");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(225, 53, 273, 14);
		editProductForm.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Product ID");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setBounds(50, 86, 100, 34);
		editProductForm.add(lblNewLabel_4);
		
		productIDUpdateField = new JTextField();
		productIDUpdateField.setEnabled(false);
		productIDUpdateField.setBounds(160, 86, 437, 34);
		editProductForm.add(productIDUpdateField);
		productIDUpdateField.setColumns(10);
		
		productNameUpdateField = new JTextField();
		productNameUpdateField.setColumns(10);
		productNameUpdateField.setBounds(160, 131, 437, 34);
		editProductForm.add(productNameUpdateField);
		
		productPriceUpdateField = new JTextField();
		productPriceUpdateField.setColumns(10);
		productPriceUpdateField.setBounds(160, 176, 437, 34);
		editProductForm.add(productPriceUpdateField);
		
		JComboBox companyNameUpdateField = new JComboBox();
		companyNameUpdateField.setBounds(160, 221, 437, 34);
		editProductForm.add(companyNameUpdateField);
		
		JLabel lblNewLabel_4_1 = new JLabel("Name");
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_1.setBounds(50, 131, 100, 34);
		editProductForm.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("Price");
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_2.setBounds(50, 176, 100, 34);
		editProductForm.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("Company Name");
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4_3.setBounds(50, 221, 100, 34);
		editProductForm.add(lblNewLabel_4_3);
		
		JButton updateBtn = new JButton("Update");
		updateBtn.setBounds(159, 266, 100, 34);
		editProductForm.add(updateBtn);
		
		JPanel deleteProductForm = new JPanel();
		tabbedPane.addTab("New tab", null, deleteProductForm, null);
		deleteProductForm.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Product ID");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_6.setBounds(144, 59, 91, 36);
		deleteProductForm.add(lblNewLabel_6);
		
		productIdDeleteField = new JTextField();
		productIdDeleteField.setBounds(245, 59, 409, 36);
		deleteProductForm.add(productIdDeleteField);
		productIdDeleteField.setColumns(10);
		
		JButton deleteButton = new JButton("Delete");
		deleteButton.setBounds(390, 147, 99, 36);
		deleteProductForm.add(deleteButton);
	}
}

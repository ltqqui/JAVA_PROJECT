package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import businessLogicLayer.Company;
import businessLogicLayer.Product;
import businessLogicLayer.ProductManagement;
import businessLogicLayer.User;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.Box;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
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
	private JComboBox companyNameField;
	private DefaultTableModel model;
	private JComboBox companyField;
	private JLabel headerLabel;
	private JComboBox companyNameUpdateField;
	private JLabel usernameLabel;
	private ArrayList<Company> companyList = new ProductManagement().getCompany();
	private ArrayList<Product> productList= new ProductManagement().searchProduct("All");
	private ProductManagement pmm= new ProductManagement();

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
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 * @throws RemoteException 
	 */
	public HomeView() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException, RemoteException {
		ProductManagement pmm= new ProductManagement();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		setBounds(100, 100, 1028, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		headerLabel = new JLabel("PRODUCT MANAGEMENT");

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

		JButton upadateProductButton = new JButton("UPDATE PRODUCT");
		upadateProductButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chooseProductAction();
			}
		});
		upadateProductButton.setBounds(0, 159, 122, 35);
		sidebar.add(upadateProductButton);

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
				logoutAction();
			}
		});
		btnLogout.setBounds(10, 487, 112, 23);
		sidebar.add(btnLogout);

		usernameLabel = new JLabel("ABC");
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

		companyNameField = new JComboBox();
		for (Company company : companyList) {
			companyNameField.addItem(company.getCompanyName());
		}
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
		addProduct.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					addProductAction();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		JButton resetAllFields = new JButton("Reset");
		resetAllFields.setBounds(302, 308, 120, 38);
		resetAllFields.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				productNameField.setText("");
				priceField.setText("");
			}
		});
		addProductForm.add(resetAllFields);

		JLabel lblNewLabel_2 = new JLabel("Enter product information");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(171, 55, 557, 38);
		addProductForm.add(lblNewLabel_2);

		JPanel productListForm = new JPanel();
		tabbedPane.addTab("New tab", null, productListForm, null);
		productListForm.setLayout(null);

		companyField = new JComboBox();
		companyField.setBounds(201, 5, 550, 36);
		productListForm.add(companyField);
		companyField.addItem("All");
		for (Company company : companyList) {
			companyField.addItem(company.getCompanyName());
		}

		JButton searchBtn = new JButton("Search");
		searchBtn.setFont(new Font("Tahoma", Font.PLAIN, 16));
		searchBtn.setBounds(761, 5, 118, 36);
		productListForm.add(searchBtn);
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					searchProductAction();
				} catch (RemoteException e1) {
					e1.printStackTrace();
				}
			}
		});

		
		JLabel lblNewLabel = new JLabel("Select Company:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 5, 181, 36);
		productListForm.add(lblNewLabel);

		JLabel lblProductList = new JLabel("Product List:");
		lblProductList.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblProductList.setBounds(10, 61, 181, 36);
		productListForm.add(lblProductList);
		
		
		productResultTable = new JTable();
		productResultTable = new JTable();
		productResultTable.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name", "Price", "Company"
				}
			));
		productResultTable.setBounds(10, 108, 860, 240);
		productListForm.add(productResultTable);
		 JScrollPane scrollPane = new JScrollPane(productResultTable);
	        scrollPane.setBounds(10, 108, 860, 240);
	        productListForm.add(scrollPane);
	        
	        showTable();


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

		companyNameUpdateField = new JComboBox();
		companyNameUpdateField.setBounds(160, 221, 437, 34);
		editProductForm.add(companyNameUpdateField);
		for (Company company : companyList) {
			companyNameUpdateField.addItem(company.getCompanyName());
		}

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
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					updateProductAction();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

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
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					deleteProductAction();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		setVisible(true);
	}
	
	
	public void showTable() throws RemoteException {
    	String companyIDSent = "All";
    	for (Company company : companyList) {
			if(company.getCompanyName().equals(companyField.getSelectedItem().toString())) {
				companyIDSent= String.valueOf(company.getCompanyID());
			}
		}
		productList= new ProductManagement().searchProduct(companyIDSent);
		model= (DefaultTableModel) productResultTable.getModel();
		for (Product product : productList) {
			String companyName="";
			for (Company company : companyList) {
				if(product.getCompanyID()==company.getCompanyID()) {
					companyName=company.getCompanyName();
				}
			}
			model.addRow(
					new Object[] {
							product.getProductID(),
							product.getProductName(),
							product.getPrice(),
							companyName
					}
					);
		}
	}
	
	public void setUserProfile(String userName) {
		usernameLabel.setText(userName);
	}
	
	
	public void loadDatabaseAction() throws RemoteException {
		this.productList.clear();
		model.setNumRows(0);
		showTable();
	}
    
	
	 public void addProductAction() throws RemoteException {
	    	
	    	if(productNameField.getText().isEmpty() || priceField.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Input not emty !", "Warning", JOptionPane.WARNING_MESSAGE);	
				return;
			}
	    	else {
	    		try {
	    			float value = Float.parseFloat(priceField.getText());
	    			String productName= productNameField.getText();
	    	    	float price = Float.valueOf(priceField.getText());
	    	    	int companyID=0;
	    	    	String companyName= String.valueOf(companyNameField.getSelectedItem());
	    	    	for (Company company : companyList) {
	    				if(company.getCompanyName().equals(companyName)) {
	    					companyID=company.getCompanyID();
	    				}
	    			}
	    	    	Product product= new Product();
	    	    	product.setProductName(productName);
	    	    	product.setPrice(price);
	    	    	product.setCompanyID(companyID);
	    	    	pmm.addProduct(product);
	    	    	loadDatabaseAction();
	    	    	productNameField.setText("");
	    	    	priceField.setText("");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Input price must a be a number  !", "Error", JOptionPane.ERROR_MESSAGE);
				}
	    	}
	    }
	 
	   public void searchProductAction() throws RemoteException {
	    	String key = (String) companyField.getSelectedItem();
	    	String companyIDSent = "";
	    	for (Company company : companyList) {
				if(company.getCompanyName().equals(key)) {
					companyIDSent= String.valueOf(company.getCompanyID());
				}
			}
	    	pmm.searchProduct(companyIDSent);
	    	loadDatabaseAction();
	    }
	   
	   void chooseProductAction() {
		   model=(DefaultTableModel) productResultTable.getModel();
			int i_row= productResultTable.getSelectedRow();
			if(i_row==-1) {
				JOptionPane.showMessageDialog(null, "Select a product from the PRODUCT LIST to update  !", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else {
				int id= (int) model.getValueAt(i_row, 0) ;
				String name = (String) model.getValueAt(i_row, 1);
				float price= (float) model.getValueAt(i_row, 2);
				String companyName = (String)(model.getValueAt(i_row, 3)) ;
				productIDUpdateField.setText(id+"");
				productNameUpdateField.setText(name);
				productPriceUpdateField.setText(price+"");
				companyNameUpdateField.setSelectedItem(companyName);
				headerLabel.setText("EDIT PRODUCT FORM");
				tabbedPane.setSelectedIndex(2);
			}
	   }
	   public void updateProductAction() throws RemoteException {
		   	if(productNameUpdateField.getText().isEmpty()|| productPriceUpdateField.getText().isEmpty()) {
		   		JOptionPane.showMessageDialog(null, "Input cannot be empty  !", "Error", JOptionPane.ERROR_MESSAGE);
		   		return;
		   	}
		   	else {
		   		try {
		   			float value = Float.parseFloat(productPriceUpdateField.getText());
		   			int id= Integer.valueOf( productIDUpdateField.getText());
			   		String name= String.valueOf(productNameUpdateField.getText());
			   		float price= Float.valueOf(productPriceUpdateField.getText());
			   		int companyID=0;
			   		for (Company company : companyList) {
						if(company.getCompanyName().equals(companyNameUpdateField.getSelectedItem())) {
							companyID=company.getCompanyID();
						}
					}
			   		Product product= new Product(id,name,price,companyID);
			   		pmm.updateProduct(product);
			   		loadDatabaseAction();
					tabbedPane.setSelectedIndex(1);
				} catch (NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Input price must a be a number  !", "Error", JOptionPane.ERROR_MESSAGE);
				}
		   	}
	   }
	   
	   public void deleteProductAction() throws RemoteException {
		   if(productIdDeleteField.getText().isEmpty()) {
 			   JOptionPane.showMessageDialog(null, "Input cannot be empty  !", "Error", JOptionPane.ERROR_MESSAGE);
 			   return;
 		   }
		   try {
	            // Thử chuyển đổi giá trị sang kiểu int
	            int value = Integer.parseInt(productIdDeleteField.getText());
	 		   int id= Integer.valueOf(productIdDeleteField.getText());
	 		   pmm.deleteProduct(id);
	 		   productIdDeleteField.setText("");
	 		   loadDatabaseAction();
	 		   tabbedPane.setSelectedIndex(1);
	        } catch (NumberFormatException e) {
	        	JOptionPane.showMessageDialog(null, "Input must a be a integer  !", "Error", JOptionPane.ERROR_MESSAGE);
	        }
	   }
	   public void logoutAction() {
		   pmm.logout();
		   new LoginView().setVisible(true);;
		   dispose();
	   }
}

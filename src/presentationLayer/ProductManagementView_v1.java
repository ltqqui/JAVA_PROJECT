package presentationLayer;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import businessLogicLayer.Company;
import businessLogicLayer.Product;
import businessLogicLayer.ProductManagement;
import businessLogicLayer.User;

public class ProductManagementView_v1 extends JFrame {
    private CardLayout cardLayout;
    private JPanel cards;
    private static final long serialVersionUID = 1L;
    private JPanel loginLayout;
    private JPanel homeLayout;
    private JTable tableList;
    private JPanel productListLayout;
    private JPanel addProductLayout;
    private JPanel updateProductLayout;
    private JTextField textFieldUserName;
    private JTextField textFieldPassword;
    private DefaultTableModel model;
    private JTextField textFieldName;
    private	JTextField textFieldPrice;
    private JComboBox comboBoxCompany;
    private JComboBox comboBoxSearch;
    private JLabel labelAccount;
    private ProductManagement pm= new ProductManagement();
    private ArrayList<Product> productList= new ProductManagement().searchProduct("");
    private ArrayList<Company> companyList = new ProductManagement().getCompany();
    User userLogin= new User();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ProductManagementView_v1 frame = new ProductManagementView_v1();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * @throws RemoteException 
     */
    public ProductManagementView_v1() throws RemoteException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 675, 389);

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        loginLayout = new JPanel();
        loginLayout.setBackground(new Color(192, 192, 192));
        loginLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
        loginLayout.setLayout(null);
        cards.add(loginLayout, "loginLayout");

        homeLayout = new JPanel();
        homeLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
        homeLayout.setLayout(null);
        cards.add(homeLayout, "homeLayout");

        setContentPane(cards);

        JLabel titleLogin = new JLabel("Login");
        titleLogin.setFont(new Font("Tahoma", Font.BOLD, 23));
        titleLogin.setBounds(273, 24, 87, 49);
        loginLayout.add(titleLogin);

        JLabel labelUserName = new JLabel("User name");
        labelUserName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelUserName.setBounds(88, 121, 94, 25);
        loginLayout.add(labelUserName);

        textFieldUserName = new JTextField();
        textFieldUserName.setBounds(219, 121, 201, 25);
        loginLayout.add(textFieldUserName);
        textFieldUserName.setColumns(10);

        JLabel labelPassword = new JLabel("Password");
        labelPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
        labelPassword.setBounds(88, 193, 94, 25);
        loginLayout.add(labelPassword);

        textFieldPassword = new JTextField();
        textFieldPassword.setColumns(10);
        textFieldPassword.setBounds(219, 193, 201, 25);
        loginLayout.add(textFieldPassword);

        JButton btnNewButton = new JButton("Submit");
        btnNewButton.setForeground(new Color(64, 0, 64));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnNewButton.setBounds(275, 252, 100, 27);
        loginLayout.add(btnNewButton);
        btnNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    loginView();
                    if(pm.userProfile.getUserName()!=null) {   
                    	cardLayout.show(cards, "homeLayout");
                    }
                    else {
                    	JOptionPane.showMessageDialog(null, "User name or password invalid !", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 69, 22);
        homeLayout.add(menuBar);

        JMenu menuOption = new JMenu("Options");
        menuBar.add(menuOption);

        JMenuItem menuProductList = new JMenuItem("Product list");
        menuOption.add(menuProductList);
        menuProductList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cards, "productListLayout");
				
			}
		});

        JMenuItem menuAddProduct = new JMenuItem("Add product");
        menuOption.add(menuAddProduct);
        menuAddProduct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardLayout.show(cards,"addProductLayout");
			}
		});

        JMenuItem menuEidtProduct = new JMenuItem("Edit Product");
        menuOption.add(menuEidtProduct);

        JMenuItem mntmNewMenuItem = new JMenuItem("Delete product");
        menuOption.add(mntmNewMenuItem);

        JMenuItem menuLogout = new JMenuItem("Logout");
        menuOption.add(menuLogout);
        
        
        System.out.println(userLogin.getUserName());
        labelAccount = new JLabel();
        labelAccount.setFont(new Font("Tahoma", Font.BOLD, 13));
        labelAccount.setBounds(530, 0, 160, 22);
        homeLayout.add(labelAccount);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("D:\\img9.png"));
        lblNewLabel.setBounds(-14, -30, 792, 425);
        homeLayout.add(lblNewLabel);
        
        productListLayout= new JPanel();
        productListLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
        cards.add(productListLayout, "productListLayout");
        
		setContentPane(cards);
		productListLayout.setLayout(null);
		JLabel labelProductList = new JLabel("PRODUCT LIST");
		labelProductList.setFont(new Font("Tahoma", Font.BOLD, 15));
		labelProductList.setBounds(253, 23, 125, 35);
		productListLayout.add(labelProductList);
		comboBoxSearch = new JComboBox();
		comboBoxSearch.addItem("");
		for (Company company : companyList) {
			comboBoxSearch.addItem(company.getCompanyName());
		}
		comboBoxSearch.setBounds(11, 85, 440, 32);
		productListLayout.add(comboBoxSearch);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(529, 85, 85, 32);
		productListLayout.add(btnSearch);
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					searchProductView();
					
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		tableList = new JTable();
		tableList.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"ID", "Name", "Price", "Company"
				}
			));
		tableList.setBounds(10, 130, 641, 135);
		productListLayout.add(tableList);
		
		Button btnUpdate = new Button("Update");
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setBackground(new Color(0, 128, 192));
		btnUpdate.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setBounds(196, 281, 85, 21);
		productListLayout.add(btnUpdate);
		
		Button btnDelete = new Button("Delete");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(255, 128, 128));
		btnDelete.setFont(new Font("Dialog", Font.PLAIN, 13));
		btnDelete.setBounds(363, 281, 85, 21);
		productListLayout.add(btnDelete);
		
		JButton btnBackProductList = new JButton("<- Back");
		btnBackProductList.setBounds(0, 330, 85, 21);
		btnBackProductList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardLayout.previous(cards);
			}
		});
		productListLayout.add(btnBackProductList);
        showTable();
        
        addProductLayout = new JPanel();
        addProductLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
        cards.add(addProductLayout,"addProductLayout");
        JScrollPane scrollPane = new JScrollPane(tableList);
        scrollPane.setBounds(10, 130, 641, 135);
        productListLayout.add(scrollPane);
		setContentPane(cards);
		addProductLayout.setLayout(null);
		
		JButton btnBackAddProduct = new JButton("<- Back");
		btnBackAddProduct.setBounds(0, 330, 85, 21);
		addProductLayout.add(btnBackAddProduct);
		btnBackAddProduct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cardLayout.show(cards,"homeLayout");
			}
		});
		
		JLabel lableAddProduct = new JLabel("ADD PRODUCT");
		lableAddProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
		lableAddProduct.setBounds(246, 10, 149, 32);
		addProductLayout.add(lableAddProduct);
		
		JLabel laeleProductName = new JLabel("Product name");
		laeleProductName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		laeleProductName.setBounds(53, 83, 107, 21);
		addProductLayout.add(laeleProductName);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(215, 83, 297, 32);
		addProductLayout.add(textFieldName);
		textFieldName.setColumns(10);
		
		JLabel labelPice = new JLabel("Price");
		labelPice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelPice.setBounds(53, 128, 107, 21);
		addProductLayout.add(labelPice);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(215, 129, 297, 32);
		addProductLayout.add(textFieldPrice);
		
		JLabel labelCompany = new JLabel("Company");
		labelCompany.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCompany.setBounds(53, 172, 107, 21);
		addProductLayout.add(labelCompany);
		JButton btnAddProduct = new JButton("Add product");
		btnAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddProduct.setBounds(286, 238, 128, 25);
		addProductLayout.add(btnAddProduct);
		btnAddProduct.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					addProductView();
				} catch (RemoteException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		comboBoxCompany = new JComboBox();
		for (Company company : companyList) {
			comboBoxCompany.addItem(company.getCompanyName());
		}
		comboBoxCompany.setBounds(215, 174, 297, 32);
		addProductLayout.add(comboBoxCompany);
		
		
		
        
		
//		updateProductLayout = new JPanel();
//		updateProductLayout.setBorder(new EmptyBorder(5, 5, 5, 5));
//        cards.add(addProductLayout,"addProductLayout");
//		setContentPane(cards);
//		updateProductLayout.setLayout(null);
//		
//		JButton btnBackUpdate = new JButton("<- Back");
//		btnBackUpdate.setBounds(0, 330, 85, 21);
//		addProductLayout.add(btnBackUpdate);
//		btnBackUpdate.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				cardLayout.show(cards,"homeLayout");
//			}
//		});
//		
//		JLabel lableUpdateProduct = new JLabel("UPDATE PRODUCT");
//		lableUpdateProduct.setFont(new Font("Tahoma", Font.BOLD, 15));
//		lableUpdateProduct.setBounds(246, 10, 149, 32);
//		addProductLayout.add(lableAddProduct);
//		
//		JLabel laeleUpdateName = new JLabel("Product name");
//		laeleProductName.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		laeleProductName.setBounds(53, 83, 107, 21);
//		addProductLayout.add(laeleProductName);
//		
//		textFieldName = new JTextField();
//		textFieldName.setBounds(215, 83, 297, 32);
//		addProductLayout.add(textFieldName);
//		textFieldName.setColumns(10);
//		
//		JLabel labelUpdatePice = new JLabel("Price");
//		labelPice.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		labelPice.setBounds(53, 128, 107, 21);
//		addProductLayout.add(labelPice);
//		
//		textFieldPrice = new JTextField();
//		textFieldPrice.setColumns(10);
//		textFieldPrice.setBounds(215, 129, 297, 32);
//		addProductLayout.add(textFieldPrice);
//		
//		JLabel labelCompany = new JLabel("Company");
		labelCompany.setFont(new Font("Tahoma", Font.PLAIN, 14));
		labelCompany.setBounds(53, 172, 107, 21);
		addProductLayout.add(labelCompany);
//		JButton btnAddProduct = new JButton("Add product");
		btnAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddProduct.setBounds(286, 238, 128, 25);
//		addProductLayout.add(btnAddProduct);
//		btnAddProduct.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				try {
//					addProductView();
//				} catch (RemoteException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//			}
//		});
		
		comboBoxCompany = new JComboBox();
		for (Company company : companyList) {
			comboBoxCompany.addItem(company.getCompanyName());
		}
		comboBoxCompany.setBounds(215, 174, 297, 32);
		addProductLayout.add(comboBoxCompany);
		
		
		
		
        
//		cardLayout.show(cards, "productListLayout");
//		cardLayout.show(cards,"addProductLayout");
        cardLayout.show(cards, "loginLayout");
        
        setVisible(true);
    }
    
    public void showTable() throws RemoteException {
    	String companyIDSent = "";
    	for (Company company : companyList) {
			if(company.getCompanyName().equals(comboBoxSearch.getSelectedItem().toString())) {
				companyIDSent= String.valueOf(company.getCompanyID());
			}
		}
		productList= new ProductManagement().searchProduct(companyIDSent);
		model= (DefaultTableModel) tableList.getModel();
		int index=1;
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
    
	public void loadDatabaseView() throws RemoteException {
		this.productList.clear();
		model.setNumRows(1);
		showTable();
	}
    
    public void loginView() throws RemoteException {
    	String userName = textFieldUserName.getText();
    	String password = textFieldPassword.getText();
    	userLogin=pm.login(userName, password);
    	labelAccount.setText("Hi! "+userLogin.getUserName());
    	
    }
    public void searchProductView() throws RemoteException {
    	String key = (String) comboBoxSearch.getSelectedItem();
    	String companyIDSent = "";
    	for (Company company : companyList) {
			if(company.getCompanyName().equals(key)) {
				companyIDSent= String.valueOf(company.getCompanyID());
			}
		}
    	pm.searchProduct(companyIDSent);
    	loadDatabaseView();
    }
    
    public void addProductView() throws RemoteException {
    	
    	if(textFieldName.getText().isEmpty() || textFieldPrice.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Input not emty !", "Warning", JOptionPane.WARNING_MESSAGE);	
			return;
		}
    	String productName= textFieldName.getText();
    	float price = Float.valueOf(textFieldPrice.getText());
    	int companyID=0;
    	String companyName= String.valueOf(comboBoxCompany.getSelectedItem());
    	for (Company company : companyList) {
			if(company.getCompanyName().equals(companyName)) {
				companyID=company.getCompanyID();
			}
		}
    	Product product= new Product();
    	product.setProductName(productName);
    	product.setPrice(price);
    	product.setCompanyID(companyID);
    	pm.addProduct(product);
    	loadDatabaseView();
    	 JOptionPane.showMessageDialog(null,"" + "Add product success");
    	textFieldName.setText("");
    	textFieldPrice.setText("");
    }
    
}

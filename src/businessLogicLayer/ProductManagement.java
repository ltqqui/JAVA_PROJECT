package businessLogicLayer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dataAccessLayer.ConnectDatabase;



public class ProductManagement extends UnicastRemoteObject implements ProductManagementInterface  {
	private ArrayList <Product> productList= new ArrayList();
	private ArrayList<Company> companyList= new ArrayList();
	public User userProfile= new User();
	public ConnectDatabase connect = new ConnectDatabase();
	public ProductManagement() throws RemoteException {}

	@Override
	public ArrayList<Product> searchProduct(String key) throws RemoteException {
		if(!key.isEmpty()) {
			try (Connection connection = connect.getJDBC()) {
		    	PreparedStatement statement = connection.prepareStatement("SELECT * FROM Products WHERE companyID=?");
		        if (connection != null) {
		            statement.setString(1, key);
		            ResultSet resultSet = statement.executeQuery();
		            while (resultSet.next()) {
		            	 int productID = resultSet.getInt("productID");
		                    String productName = resultSet.getString("productName");
		                    Float price = resultSet.getFloat("price");
		                    int companyID = resultSet.getInt("companyID");
		                    Product product = new Product(productID, productName, price,companyID);
		                    productList.add(product);
		            }
		        } else {
		            System.out.println("Kết nối thất bại");
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("Thực hiện truy vấn thất bại");
		    }
		}
		else {
		    	 try (Connection connection = connect.getJDBC();
			             Statement statement = connection.createStatement()) {
			            if (connection != null) {
			                String query = "SELECT * FROM Products";
			                ResultSet resultSet = statement.executeQuery(query);
			                while (resultSet.next()) {
			                	int productID = resultSet.getInt("productID");
			                    String productName = resultSet.getString("productName");
			                    Float price = resultSet.getFloat("price");
			                    int companyID = resultSet.getInt("companyID");
			                    Product product = new Product(productID, productName, price,companyID);
			                    productList.add(product);
			                }
			                
			            } else {
			                System.out.println("Kết nối thất bại");
			            }
		
			        } catch (SQLException e) {
			            e.printStackTrace();
			            System.out.println("Thực hiện truy vấn thất bại");
			        }
		}
		return productList;
	}

	@Override
	public void addProduct(Product product) throws RemoteException {
		 try (Connection connection = connect.getJDBC();
		         PreparedStatement countStatement = connection.prepareStatement("SELECT COUNT(*) FROM Company WHERE companyID = ?");
		         PreparedStatement insertStatement = connection.prepareStatement("INSERT INTO Products (productName, price, companyID) VALUES (?, ?, ?)")) {

		        // Set companyID for countStatement
		        countStatement.setInt(1, product.getCompanyID());
		        ResultSet resultSet = countStatement.executeQuery();

		        // Check if the company exists
		        if (resultSet.next() && resultSet.getInt(1) > 0) {
		            insertStatement.setString(1, product.getProductName());
		            insertStatement.setDouble(2, product.getPrice());
		            insertStatement.setInt(3, product.getCompanyID());

		            // Execute the INSERT statement
		            insertStatement.executeUpdate();
		        } else {
		            System.out.println("Công ty không tồn tại trong cơ sở dữ liệu.");
		        }

		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("Thực hiện truy vấn thất bại");
		    }
		
	}

	@Override
	public void deleteProduct(int id) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateProduct(Product product) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User login(String userName, String password) throws RemoteException {
		try (Connection connection = connect.getJDBC()) {
	    	PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE userName=? and password=?");
	        if (connection != null) {
	            statement.setString(1, userName);
	            statement.setString(2, password);
	            ResultSet resultSet = statement.executeQuery();
	            if (resultSet.next() && resultSet.getInt(1)>0) {
	            	int userID= resultSet.getInt("userID");
	            	String name= resultSet.getString("userName");
	            	String pass= resultSet.getString("password");
	            	String email= resultSet.getString("email");
	            	String phone= resultSet.getString("phone");
	                userProfile= new User(userID, name, pass, email, phone);
	            }
	        } else {
	            System.out.println("Kết nối thất bại");
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Thực hiện truy vấn thất bại");
	    }
		return userProfile;
	}

	@Override
	public void register(User user) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	
	
	public ArrayList<Company> getCompany(){
		 ConnectDatabase connect = new ConnectDatabase();
		 try (Connection connection = connect.getJDBC();
	             Statement statement = connection.createStatement()) {
	        	
	            if (connection != null) {
	                String query = "SELECT * FROM Company";
	                ResultSet resultSet = statement.executeQuery(query);
	                while (resultSet.next()) {
	                   int companyID = resultSet.getInt("companyID");
	                    String companyName = resultSet.getString("companyName");
	                    String address= resultSet.getString("address");
	                    String email= resultSet.getString("email");
	                    String phone= resultSet.getString("phone");
	                    Company company= new Company(companyID,companyName,address, email, phone);
	                    companyList.add(company);
	                }
	                
	            } else {
	                System.out.println("Kết nối thất bại");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	            System.out.println("Thực hiện truy vấn thất bại");
	        }
		return this.companyList;
	}
	
}

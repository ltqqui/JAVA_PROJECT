package businessLogicLayer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface ProductManagementInterface extends Remote {
	public ArrayList<Product> searchProduct( String key) throws RemoteException  ;
	public void addProduct(Product product) throws RemoteException;
	public void deleteProduct(int id) throws RemoteException;
	public void updateProduct(Product product) throws RemoteException;
	public User login(String userName, String password) throws RemoteException;
	public void register (User user ) throws RemoteException;
}

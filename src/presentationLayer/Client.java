package presentationLayer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businessLogicLayer.ProductManagementInterface;

public class Client {
	 public static void main(String args[]) throws RemoteException {
		 try {
	            //Xác định RMI máy chủ.
	        	ProductManagementInterface  product = (ProductManagementInterface) Naming.lookup("rmi://192.168.72.1:6789/SeptemberRMI");	
	            new ProductManagementView();
	        } catch (NotBoundException e) {
	            e.printStackTrace();
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        } catch (RemoteException e) {
	            e.printStackTrace();
	        }
	    }
}
	
package presentationLayer;

import java.net.MalformedURLException;
import java.nio.channels.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

import businessLogicLayer.ProductManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Server {
	    public static void main(String args[]) throws java.rmi.AlreadyBoundException {
	        try {
	           ProductManagement product  = new ProductManagement();
	            LocateRegistry.createRegistry(6789);

				// Đăng ký đối tượng này với rmiregistry
	            Naming.bind("rmi://localhost:6789/SeptemberRMI", product);
	            System.out.println(">>>>>INFO: RMI Server started!!!!!!!!");

	        } catch (RemoteException e) {
	            e.printStackTrace();
	        } catch (AlreadyBoundException e) {
	            e.printStackTrace();
	        } catch (MalformedURLException e) {
	            e.printStackTrace();
	        }
	    }
	}

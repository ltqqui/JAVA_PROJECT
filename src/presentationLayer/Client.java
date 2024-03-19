package presentationLayer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.UnsupportedLookAndFeelException;

import businessLogicLayer.ProductManagementInterface;

public class Client {
	public static void main(String args[]) throws RemoteException, ClassNotFoundException,
			IllegalAccessException, UnsupportedLookAndFeelException, InstantiationException {
		try {
			// Xác định RMI máy chủ.
			ProductManagementInterface product = (ProductManagementInterface) Naming
					.lookup("rmi://localhost:6789/SeptemberRMI");
	            new LoginView().setVisible(true);
		} catch (NotBoundException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}

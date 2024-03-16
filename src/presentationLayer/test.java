package presentationLayer;

import java.rmi.RemoteException;

import businessLogicLayer.ProductManagement;

public class test {
	public static void main(String[] args) throws RemoteException {
		ProductManagement product= new ProductManagement();
		product.searchProduct("");
	}
}

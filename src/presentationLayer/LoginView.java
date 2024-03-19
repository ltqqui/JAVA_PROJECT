package presentationLayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import businessLogicLayer.ProductManagement;
import businessLogicLayer.User;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.RemoteException;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class LoginView extends JFrame {
	private static final long serialVersionUID = 1L;
	public JPanel loginView;
	private JTextField usernameField;
	private JPasswordField passwordField;
	static LoginView frame = new LoginView();

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginView frame = new LoginView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public LoginView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		loginView = new JPanel();
		loginView.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(loginView);
		loginView.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("User Login");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 42));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(187, 11, 405, 80);
		loginView.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(141, 138, 147, 47);
		loginView.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1_1.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(141, 196, 147, 47);
		loginView.add(lblNewLabel_1_1);
		
		usernameField = new JTextField();
		usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		usernameField.setBounds(356, 149, 236, 36);
		loginView.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 22));
		passwordField.setBounds(356, 207, 236, 36);
		loginView.add(passwordField);
		JButton loginBtn = new JButton("Login");
		loginBtn.setBackground(new Color(0, 255, 127));
		loginBtn.setFont(new Font("Segoe UI", Font.BOLD, 26));
		loginBtn.setBounds(304, 322, 167, 47);
		
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
		            char[] password = passwordField.getPassword();
		            String passwordString = new String(password);
		            String userName= usernameField.getText();
		            if(usernameField.getText().isEmpty() || passwordString.isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Error: Input can not be empty !", "Error", JOptionPane.ERROR_MESSAGE);
		            } else {
		                ProductManagement pmm = new ProductManagement();
		                pmm.login(userName, passwordString);
		                if(pmm.userProfile.getUserName()!=null) {
		                	User user= new User();
		                	user.setUserName(pmm.userProfile.getUserName());
		                	new HomeView().setUserProfile(userName);
		                	dispose();
		                }
		            }
		        }
				catch (RemoteException e1) {
		            e1.printStackTrace();
		        } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (InstantiationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IllegalAccessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedLookAndFeelException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		loginView.add(loginBtn);
	}
}

package Frames;
import Classes.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.User;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.Font;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private MenuFrame menu;
	private JTextField txtPassword;
	private SignUpFrame signup=new SignUpFrame(this);
	private User user;
	
	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(124, 58, 145, 20);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(124, 33, 74, 14);
		contentPane.add(lblUsername);
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(124, 90, 74, 14);
		contentPane.add(lblPassword);
		
		JLabel lblDontHaveAcc = new JLabel("If you do not have an account.");
		lblDontHaveAcc.setBounds(124, 171, 197, 14);
		contentPane.add(lblDontHaveAcc);
		
		JLabel errorLabel = new JLabel("");
		errorLabel.setBounds(99, 221, 226, 29);
		contentPane.add(errorLabel);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password, username;
				username  = txtUsername.getText();
				password =  txtPassword.getText();
				user=new User(username,password);
				if(CarSys.logIn(user)) {
					menu=new MenuFrame(user);
					menu.setVisible(true); 
					dispose();
				}else {
					errorLabel.setText("username or password is wrong.");
				}
					
				
			}
		});
		btnLogin.setBounds(154, 146, 89, 23);
		contentPane.add(btnLogin);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				signup.setVisible(true);
			}
		});
		btnSignUp.setBounds(154, 187, 89, 23);
		contentPane.add(btnSignUp);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(124, 115, 145, 20);
		contentPane.add(txtPassword);
		txtPassword.setColumns(10);
		
		
	}
}

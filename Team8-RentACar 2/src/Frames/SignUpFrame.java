package Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.CarSys;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUpFrame extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JTextField passwordField;
	
	

	/**
	 * Create the frame.
	 */
	public SignUpFrame(LoginFrame login) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 242);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(155, 11, 163, 20);
		contentPane.add(usernameField);
		usernameField.setColumns(10);
		
		passwordField = new JTextField();
		passwordField.setBounds(155, 52, 163, 20);
		contentPane.add(passwordField);
		passwordField.setColumns(10);
		
		JLabel resultLabel = new JLabel("");
		resultLabel.setBounds(71, 148, 176, 30);
		contentPane.add(resultLabel);
		
		JButton btnNewButton = new JButton("Sign Up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String password,username;
				username=usernameField.getText();
				password=passwordField.getText();
				if(CarSys.addUser(username, password)) {
					resultLabel.setText("Registered succesfully.");
				}
				else {
					resultLabel.setText("this username already exists");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(130, 111, 95, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Enter username:");
		lblNewLabel.setBounds(28, 6, 95, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Enter password:");
		lblNewLabel_1.setBounds(28, 54, 106, 18);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton_1 = new JButton("Close");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(257, 169, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
	}
}

package Frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Classes.CarSys;
import Classes.User;

import javax.swing.JTextPane;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReturnCarFrame extends JFrame {

	private JPanel contentPane;
	private JTextField idField;

	/**
	 * Create the frame.
	 */
	public ReturnCarFrame(User user,MenuFrame menu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 326);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane resultArea = new JTextPane();
		resultArea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		resultArea.setEnabled(false);
		resultArea.setEditable(false);
		resultArea.setBounds(10, 38, 414, 168);
		contentPane.add(resultArea);
		
		JLabel lblNewLabel = new JLabel("CARS YOU OWNED");
		lblNewLabel.setBounds(167, 11, 104, 16);
		contentPane.add(lblNewLabel);
		
		idField = new JTextField();
		idField.setBounds(67, 250, 97, 26);
		contentPane.add(idField);
		idField.setColumns(10);
		
		JButton btnNewButton = new JButton("RETURN CAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(CarSys.returnCar(Integer.parseInt(idField.getText()),user)){
					JOptionPane.showMessageDialog(null, "SUCCESFULLY RETURNED YOU CAN UPDATE AVAILABLE CAR LIST ON RETURN CAR MENU");
				}
				else {
					JOptionPane.showMessageDialog(null, "RETURN OPERATION FAILED BECAUSE YOU DONT HAVE THAT CAR");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(174, 241, 143, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER ID:");
		lblNewLabel_1.setBounds(10, 249, 66, 23);
		contentPane.add(lblNewLabel_1);
		
		
		
		JButton btnNewButton_1 = new JButton("CLOSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(327, 249, 89, 23);
		contentPane.add(btnNewButton_1);
		
		String output=CarSys.displayNotAvailableCars(user);
		
		if(output!="")
			resultArea.setText(output);
		else
			resultArea.setText("You have no cars");
		
		
		
		JLabel lblPleaseEnterCar = new JLabel("please enter car id and submit to return your car");
		lblPleaseEnterCar.setBounds(20, 217, 404, 16);
		contentPane.add(lblPleaseEnterCar);
	}
}

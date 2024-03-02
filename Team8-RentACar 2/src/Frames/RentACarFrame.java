package Frames;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Classes.Car;
import Classes.CarSys;
import Classes.User;

import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;

public class RentACarFrame extends JFrame {

	private JPanel contentPane;
	private JTextField txtID;
	private JTextField txtDuration;
	private Car car;
	private boolean calculated=false,found=true;
	/**
	 * Create the frame.
	 */
	public RentACarFrame(User user,MenuFrame menu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 395);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane resultArea = new JTextPane();
		resultArea.setBounds(198, 257, 258, 20);
		contentPane.add(resultArea);
		
		JButton btnNewButton = new JButton("RENT");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(calculated) {
					JOptionPane.showMessageDialog(null, "YOU HAVE SUCCESFULLY RENTED VISIT US TO GET YOUR CAR IN 24 HOURS");
					CarSys.rentCar(user, car.getCarID());
				}
				calculated=false;
			}
		});
		btnNewButton.setBounds(339, 288, 117, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Available Cars");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(169, 11, 195, 14);
		contentPane.add(lblNewLabel);
		
		txtID = new JTextField();
		txtID.setBounds(78, 232, 86, 20);
		contentPane.add(txtID);
		txtID.setColumns(10);
		
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 36, 421, 185);
		contentPane.add(scrollPane);
		
		JTextPane txtCarInfo = new JTextPane();
		scrollPane.setViewportView(txtCarInfo);
		
		JLabel lblNewLabel_1 = new JLabel("Cost of renting this car.");
		lblNewLabel_1.setBounds(198, 232, 166, 14);
		contentPane.add(lblNewLabel_1);
		
		txtDuration = new JTextField();
		txtDuration.setBounds(78, 262, 86, 20);
		contentPane.add(txtDuration);
		txtDuration.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Read From File");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CarSys.readTxt();
				txtCarInfo.setText(CarSys.displayAvailableCars());
			}
		});
		btnNewButton_1.setBounds(10, 7, 117, 23);
		contentPane.add(btnNewButton_1);
		
		txtCarInfo.setText(CarSys.displayAvailableCars());
		
		JLabel lblID = new JLabel("Enter ID:");
		lblID.setBounds(10, 235, 64, 20);
		contentPane.add(lblID);
		
		JLabel lblNewLabel_2 = new JLabel("Duration");
		lblNewLabel_2.setBounds(10, 265, 64, 12);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("(in days)");
		lblNewLabel_3.setBounds(10, 281, 64, 20);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_2 = new JButton("UPDATE LIST");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCarInfo.setText(CarSys.displayAvailableCars());
			}
		});
		btnNewButton_2.setBounds(374, 11, 128, 19);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CALCULATE PRICE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					car=CarSys.searchCar(Integer.parseInt(txtID.getText()));
					if(car==null){
						resultArea.setText("Car with that id couldnt found");
					}else {
						calculated=true;
						car.setDuration(Integer.parseInt(txtDuration.getText()));
						resultArea.setText(Double.toString(car.calculatePrice()));
					}
				}catch(Exception exc) {
					JOptionPane.showMessageDialog(null, "AN EXCEPTION OCCURED PLEASE TRY AGAIN");
				}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.setBounds(163, 288, 166, 32);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("CLOSE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				menu.setVisible(true);
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_4.setBounds(10, 322, 95, 23);
		contentPane.add(btnNewButton_4);
		
		
	}
}

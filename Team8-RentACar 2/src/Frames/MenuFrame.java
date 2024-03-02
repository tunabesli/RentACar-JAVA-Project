package Frames;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import Classes.*;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
public class MenuFrame extends JFrame {

	private JPanel contentPane;
	private LoginFrame login =new LoginFrame();
	
	
	public MenuFrame(User user) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\22102115\\Downloads\\RentACar111\\wattahel\\arababg.jpg"));
		RentACarFrame rentacar = new RentACarFrame(user,this);
		AddCarFrame addCar = new AddCarFrame(this);
		ReturnCarFrame returnCar=new ReturnCarFrame(user,this);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 573, 515);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton addCarButton = new JButton("ADD YOUR CAR");
		addCarButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		addCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addCar.setVisible(true);
			}
		});
		addCarButton.setBounds(10, 200, 537, 64);
		contentPane.add(addCarButton);
		
		JButton rentCarButton = new JButton("RENT A CAR");
		rentCarButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		rentCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rentacar.setVisible(true);
				dispose();
			}
		});
		rentCarButton.setBounds(308, 11, 239, 183);
		contentPane.add(rentCarButton);
		
		JButton logOutButton = new JButton("Log Out");
		logOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.setVisible(true);
				dispose();
			}
		});
		logOutButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		logOutButton.setBounds(430, 436, 117, 29);
		contentPane.add(logOutButton);
		
		JButton btnNewButton = new JButton("RETURN CAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				returnCar.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton.setBounds(10, 11, 249, 183);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("WELCOME!");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 24));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(215, 276, 197, 37);
		contentPane.add(lblNewLabel);
	}
}

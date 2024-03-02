package Frames;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import Classes.Car;
import Classes.CarSys;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

public class AddCarFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField carIdField;
	private JTextField brandField;
	private JTextField modelField;
	private JTextField yearField;
	private JTextField dailyPriceField;
	private JTextField turboField;
	private JTextField horsePowerField;
	private JTextField tractionSystemField;
	private JTextField cargoSpaceField;
	private Car car;
	private JTextField seatCountField;
	private JTextField multimediaField;
	/**
	 * Create the frame.
	 */
	public AddCarFrame(MenuFrame menu) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 528, 382);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel sportPanel = new JPanel();
		sportPanel.setLayout(null);
		sportPanel.setToolTipText("");
		sportPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		sportPanel.setBounds(10, 188, 495, 87);
		contentPane.add(sportPanel);
		
		JLabel lblTurbo = new JLabel("Turbo(yes/no):");
		lblTurbo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTurbo.setBounds(22, 11, 223, 20);
		sportPanel.add(lblTurbo);
		
		JLabel lblHorsePower = new JLabel("Horse Power:");
		lblHorsePower.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblHorsePower.setBounds(22, 42, 185, 23);
		sportPanel.add(lblHorsePower);
		
		turboField = new JTextField();
		turboField.setColumns(10);
		turboField.setBounds(201, 14, 191, 20);
		sportPanel.add(turboField);
		
		horsePowerField = new JTextField();
		horsePowerField.setColumns(10);
		horsePowerField.setBounds(201, 42, 191, 20);
		sportPanel.add(horsePowerField);
		sportPanel.setVisible(true);
		
		JPanel sedanPanel = new JPanel();
		sedanPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		sedanPanel.setBounds(10, 188, 495, 87);
		contentPane.add(sedanPanel);
		sedanPanel.setLayout(null);
		
		
		
		JLabel lblSeatCount = new JLabel("Seat Count:");
		lblSeatCount.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblSeatCount.setBounds(10, 11, 223, 20);
		sedanPanel.add(lblSeatCount);
		
		JLabel lblMultimediayesno = new JLabel("Multimedia(yes/no):");
		lblMultimediayesno.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMultimediayesno.setBounds(10, 42, 185, 23);
		sedanPanel.add(lblMultimediayesno);
		
		seatCountField = new JTextField();
		seatCountField.setColumns(10);
		seatCountField.setBounds(205, 14, 191, 20);
		sedanPanel.add(seatCountField);
		
		multimediaField = new JTextField();
		multimediaField.setColumns(10);
		multimediaField.setBounds(205, 46, 191, 20);
		sedanPanel.add(multimediaField);
		sedanPanel.setVisible(false);
		
		JPanel suvPanel = new JPanel();
		suvPanel.setBounds(10, 188, 495, 87);
		contentPane.add(suvPanel);
		suvPanel.setLayout(null);
		suvPanel.setToolTipText("");
		suvPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		
		JLabel lblTractionSystem_1 = new JLabel("Traction System:");
		lblTractionSystem_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTractionSystem_1.setBounds(10, 11, 234, 34);
		suvPanel.add(lblTractionSystem_1);
		
		JLabel lblCargoSpace_1 = new JLabel("Cargo Space:");
		lblCargoSpace_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCargoSpace_1.setBounds(10, 53, 175, 20);
		suvPanel.add(lblCargoSpace_1);
		
		tractionSystemField = new JTextField();
		tractionSystemField.setColumns(10);
		tractionSystemField.setBounds(201, 21, 191, 20);
		suvPanel.add(tractionSystemField);
		
		cargoSpaceField = new JTextField();
		cargoSpaceField.setColumns(10);
		cargoSpaceField.setBounds(201, 56, 191, 20);
		suvPanel.add(cargoSpaceField);
		
		suvPanel.setVisible(false);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(10, 37, 495, 158);
		contentPane.add(mainPanel);
		mainPanel.setToolTipText("");
		mainPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		mainPanel.setLayout(null);
		
		carIdField = new JTextField();
		carIdField.setBounds(201, 11, 191, 20);
		mainPanel.add(carIdField);
		carIdField.setColumns(10);
		
		JLabel lblCarId = new JLabel("Car Id:");
		lblCarId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCarId.setBounds(22, 1, 61, 35);
		mainPanel.add(lblCarId);
		
		JLabel lblBrand = new JLabel("Brand:");
		lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblBrand.setBounds(22, 42, 89, 20);
		mainPanel.add(lblBrand);
		
		JLabel lblModel = new JLabel("Model:");
		lblModel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblModel.setBounds(22, 67, 71, 28);
		mainPanel.add(lblModel);
		
		JLabel lblYear = new JLabel("Year:");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblYear.setBounds(22, 94, 71, 26);
		mainPanel.add(lblYear);
		
		JLabel lblDailyPrice = new JLabel("Daily Price:");
		lblDailyPrice.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDailyPrice.setBounds(22, 125, 126, 19);
		mainPanel.add(lblDailyPrice);
		
		brandField = new JTextField();
		brandField.setColumns(10);
		brandField.setBounds(201, 42, 191, 20);
		mainPanel.add(brandField);
		
		modelField = new JTextField();
		modelField.setColumns(10);
		modelField.setBounds(201, 68, 191, 20);
		mainPanel.add(modelField);
		
		yearField = new JTextField();
		yearField.setColumns(10);
		yearField.setBounds(201, 94, 191, 20);
		mainPanel.add(yearField);
		
		dailyPriceField = new JTextField();
		dailyPriceField.setColumns(10);
		dailyPriceField.setBounds(201, 127, 191, 20);
		mainPanel.add(dailyPriceField);
		  
		JRadioButton rdbtnSedan = new JRadioButton("Sedan");
		rdbtnSedan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sportPanel.setVisible(false);
				sedanPanel.setVisible(true);
				suvPanel.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnSedan);
		rdbtnSedan.setBounds(192, 7, 63, 23);
		contentPane.add(rdbtnSedan);
		
		JRadioButton rdbtnSUV = new JRadioButton("SUV");
		rdbtnSUV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sportPanel.setVisible(false);
				suvPanel.setVisible(true);
				sedanPanel.setVisible(false);
			}
		});
		buttonGroup.add(rdbtnSUV);
		rdbtnSUV.setBounds(257, 7, 63, 23);
		contentPane.add(rdbtnSUV);
		
		JRadioButton rdbtnSport = new JRadioButton("Sport");
		rdbtnSport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sportPanel.setVisible(true);
				suvPanel.setVisible(false);
			}
		});
		rdbtnSport.setSelected(true);
		buttonGroup.add(rdbtnSport);
		rdbtnSport.setBounds(322, 7, 78, 23);
		contentPane.add(rdbtnSport);
		
		JLabel lblType = new JLabel("Type Of Your Car");
		lblType.setBounds(20, 11, 136, 14);
		contentPane.add(lblType);
		
		JButton addCarButton = new JButton("Add Car");
		addCarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnSport.isSelected()) {
					CarSys.addCar("sport",Double.parseDouble(dailyPriceField.getText()),brandField.getText() , modelField.getText(),Integer.parseInt(carIdField.getText()), Integer.parseInt(yearField.getText()), turboField.getText(), Double.parseDouble(horsePowerField.getText()));
				}
				else if(rdbtnSUV.isSelected()) {
					CarSys.addCar("SUV",Double.parseDouble(dailyPriceField.getText()),brandField.getText() , modelField.getText(),Integer.parseInt(carIdField.getText()), Integer.parseInt(yearField.getText()), turboField.getText(), Double.parseDouble(horsePowerField.getText()));
				}
				else {
					CarSys.addCar("sedan",Double.parseDouble(dailyPriceField.getText()),brandField.getText() , modelField.getText(),Integer.parseInt(carIdField.getText()), Integer.parseInt(yearField.getText()), turboField.getText(), Double.parseDouble(horsePowerField.getText()));
				}
				JOptionPane.showMessageDialog(null, "YOUR CAR IS ADDED");
			} 
		});
		addCarButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		addCarButton.setBounds(192, 288, 103, 35);
		contentPane.add(addCarButton);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menu.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 17));
		btnNewButton.setBounds(359, 288, 109, 37);
		contentPane.add(btnNewButton);
		
		
		mainPanel.setVisible(true);
	}
}

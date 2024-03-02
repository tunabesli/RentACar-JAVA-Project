package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CarSys {
	public static ArrayList<Car> carList=new ArrayList<>();
	public static ArrayList<User> userList=new ArrayList<>();
	
	
	public static Car searchCar(int carId) {
		for(Car i:carList) {
			if(i.getCarID()==carId) {
				return i;
			}
		}
		return null;
	}
	
	public static User searchUser(String username) {
		for(User i:userList) {
			if(i.findUser(username)) {
				return i;
			}
		}
		return null;
	}
	
	public static boolean readTxt() {
		File file = new File("ExistingCars.txt");
		Scanner scanner;
		Car car;
		int carID, year;
		double horsePower,seatCount;
		String brand, model, type, tractionSystem;
		double dailyPrice, cargoSpace;
		String turbo,multimedia;
		try {
        	scanner = new Scanner(file);
            while (scanner.hasNext()) {
            	carID = scanner.nextInt();
            	type = scanner.next();
            	dailyPrice = scanner.nextDouble();
            	year = scanner.nextInt();
            	brand = scanner.next();
            	model = scanner.next();
            	if (type.equalsIgnoreCase("SUV")){
					tractionSystem=scanner.next();
					cargoSpace=scanner.nextDouble();
					car = new SUV(carID, dailyPrice, year, brand , model,tractionSystem, cargoSpace);
	            	carList.add(car);
				}
				else if (type.equalsIgnoreCase("Sedan")){
					seatCount= scanner.nextDouble();
					multimedia = scanner.next();
					car = new Sedan(carID, dailyPrice, year, brand , model, seatCount, multimedia);
	            	carList.add(car);
				}
				else if (type.equalsIgnoreCase("Sport")){
					horsePower=scanner.nextDouble();
					turbo = scanner.next();
					car = new Sport(carID, dailyPrice, year, brand , model, horsePower, turbo);
	            	carList.add(car);
				}
            }
        }catch (FileNotFoundException exc) {
                	System.out.println("error");
                	return false;
        }
		return true;
	}
	
	public static boolean addCar(String carType,double dailyPrice,String brand,String model,int carID,int year,String tractionOrTurboOrMultimedia,double seatCountOrHpOrCargoSpace) {
		Car car;
		
		
		if (searchCar(carID) != null) {
			return false;
		}
		
		if (carType.equalsIgnoreCase("suv")) { // SUV
			car = new SUV(carID,dailyPrice,year,brand,model,tractionOrTurboOrMultimedia,seatCountOrHpOrCargoSpace);
		} else if(carType.equalsIgnoreCase("sedan")) { // Sedan
			car = new Sedan(carID,dailyPrice,year,brand,model,seatCountOrHpOrCargoSpace,tractionOrTurboOrMultimedia);
		}
		else { //Sport
			car=new Sport(carID,dailyPrice,year,brand,model,seatCountOrHpOrCargoSpace,tractionOrTurboOrMultimedia);
		}
		
		car.calculatePrice();
		
		carList.add(car);
		
		return true;
	}
	
	public static boolean addUser(String userName,String password) {
		User user;
		
		if (searchUser(userName) != null) {
			return false;
		}
		
		user=new User(userName,password);
		userList.add(user);
		
		return true;
	}
	
	public static boolean rentCar(User user, int carID) {
		
		Car foundCar = null;
		
		for (Car car : carList) {
			if (car.findID(carID)) {
				foundCar = car;
				break;
			}
		}
		
		if (foundCar != null&&foundCar.getUser()==null) {
			foundCar.setUser(user);
			return true;
		}
		return false;
	}
	
	public static boolean returnCar(int carID,User user) {
		Car foundCar = null;
		
		for (Car car : carList) {
			if (car.findID(carID)) {
				foundCar = car;
				break;
			}
		}
		
		if(foundCar.getUser()!=null&&foundCar.getUser().getUserName().equals(user.getUserName())) {
			foundCar.setUser(null);
			return true;
		}
		return false;
	}

	
	public static String displayAvailableCars() {
		String result = "";
		for(Car car:carList) {
			if(car.getUser()==null)
				result+=car.toString();
		}
		
		return result;
	}
	
	public static String displayNotAvailableCars(User user) {
		String result = "";
		for(Car car:carList) {
			if(car.getUser()!=null)
				result+=car.toString();
		}
		
		return result;
	}
	
	public static boolean logIn(User user) {
		for(User i:userList) {
			if(i.getPassword().equals(user.getPassword()) && i.getUserName().equals(user.getUserName())) {
				return true;
			} 
		}
		return false;
	}
	
	
	public static void findFinalPrice(Car car) {
		car.calculatePrice();
	}
	
}

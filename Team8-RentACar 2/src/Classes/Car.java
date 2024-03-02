package Classes;

import java.util.Scanner;

public abstract class Car implements IVAT{
	protected int carID;
	protected double dailyPrice;
	protected int year;
	protected String brand;
	protected String model;
	protected User user;
	protected int duration;
	
	Car(int carID,double dailyPrice,int year, String brand,String model){
		this.carID=carID;
		this.dailyPrice=dailyPrice;
		this.year=year;
		this.brand=brand;
		this.model=model;
		user=null;
	}

	public boolean findID(int carID) {
		if(this.carID==carID)
			return true;
		return false;
	}
	public int getCarID() {
		return carID;
	}
	
	public void setDuration(int duration) {
		this.duration=duration;
	}
	

	public double getDailyPrice() {
		return dailyPrice;
	}

	public int getYear() {
		return year;
	}


	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user=user;
	}

	
	public abstract double calculatePrice();
	
	public String toString() {
		return "Car Info"+
				"\nID: "+carID+
				"\nDaily Price: "+dailyPrice+
				"\nYear: "+year+
				"\nModel: "+model+
				"\nBrand: "+brand+"\n";
	}
	
	
}

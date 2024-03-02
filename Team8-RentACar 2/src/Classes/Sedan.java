package Classes;

public class Sedan extends Car{
	private double seatCount;
	private String multimedia;
	
	Sedan(int carID,double dailyPrice,int year,String brand,String model,double seatCount,String multimedia){
		super(carID,dailyPrice,year,brand,model);
		this.multimedia=multimedia;
		this.seatCount=seatCount;
		
	}

	@Override
	public double calculatePrice() {
		return dailyPrice*duration*addVat()*1.4;
	}

	@Override
	public double addVat() {
		//Vat for SUV's is 12%
		return 1.12;
	}
	
	@Override
	public String toString() {
		return super.toString()+"Seat Count: "+seatCount+"\nMultimedia: "+multimedia+"\n\n";
	}
}

package Classes;

public class SUV extends Car{
	private String tractionSystem;
	private double cargoSpace;
	
	SUV(int carID,double dailyPrice,int year,String brand,String model,String tractionSystem,double cargoSpace){
		super(carID,dailyPrice,year,brand,model);
		this.tractionSystem=tractionSystem;
		this.cargoSpace=cargoSpace;
		
	}

	@Override
	public double calculatePrice() {
		return dailyPrice*duration*addVat()*2;
	}

	@Override
	public double addVat() {
		//Vat for SUV's is 8%
		return 1.08;
	}
	
	@Override
	public String toString() {
		return super.toString()+"Traction System: "+tractionSystem+"\nCargo Space: "+cargoSpace+"\n\n";
	}
}

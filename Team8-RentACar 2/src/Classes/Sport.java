package Classes;

public class Sport extends Car{
	private double horsePower;
	private String turbo;
	
	Sport(int carID,double dailyPrice,int year,String brand,String model,double horsePower,String turbo){
		super(carID,dailyPrice,year,brand,model);
		this.horsePower=horsePower;
		this.turbo=turbo;
		
	}

	@Override
	public double calculatePrice() {
		return dailyPrice*duration*addVat()*2.5;
	}

	@Override
	public double addVat() {
		//Vat for SUV's is 18%
		return 1.18;
	}
	
	@Override
	public String toString() {
		return super.toString()+"Turbo: "+turbo+"\nHorse Power: "+horsePower+"\n\n";
	}
}

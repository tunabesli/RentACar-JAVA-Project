package Classes;
import Frames.*;

public class CarMain {

	public static void main(String[] args) {
		LoginFrame lf=new LoginFrame();
		lf.setVisible(true);
		CarSys.addUser("admin", "admin");
	}

}

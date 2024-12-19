package activities;

public class Activity1 {

	public static void main(String args[]) {
		Car honda = new Car();
		honda.make = 2014;
		honda.fuel = "Petrol";
		honda.transmission = "Manual";
		honda.color = "White";
		
		honda.characterisiticOfCar();
		honda.accelerate();
		honda.brake();	
	}
}

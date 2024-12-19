package activities;

public class Car {
	//Member variables of class
	int make;
	String fuel;
	String transmission;
	String color;
	int tyres;
	int doors;
	
	//constructor
	Car(){
		tyres = 4;
		doors = 2;
	}
	//class method
	public void characterisiticOfCar () {
		
		System.out.println("Make of the car is " + make);
		System.out.println("Fuel type of the car is " + fuel);
		System.out.println("Transmission of the car is " + transmission);
		System.out.println("Color of the car is " + color);
	}
	public void accelerate() {
		System.out.println("Car shold move forward while accelerating");
	}
	public void brake() {
		System.out.println("Car should stop while applying brake");
	}
	
}

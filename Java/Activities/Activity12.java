package activities;

interface Addable {
	int add (int num1, int num2);
}
public class Activity12 {
		public static void main (String[] args) {
			
			Addable ad1 = (num1, num2) -> (num1 + num2);
			System.out.println("Addition of 15 & 35 is " + ad1.add(15, 35));
			
			Addable ad2 = (int num1, int num2) -> {
				return num1+num2;
			};
			System.out.println("Addition of 100 & 125 is " + ad2.add(100, 125));
		}
	}



/*Create an interface named Addable that contains a single method, add(). This method accepts two arguments, num1 and num2.
Next, create a class named Activity12 with a main method.
In this main method, create two variables, both of type Addable(the interface).
One variable, say ad1, contains a lambda expression(no body), that saves the result of num1 plus num2.
The other variable, say ad2, contains a lambda function(has a body), that also saves the result of num1 plus num2.*/
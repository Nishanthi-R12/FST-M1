package activities;

import java.util.ArrayList;

public class Activity9 {

	public static void main(String[] args) {
		ArrayList<String> myList = new ArrayList<String>();
		//default index
		myList.add("Chennai");
		myList.add("Bangalore");
		myList.add("Hyderabad");
		myList.add("Trivandrum");
		//specific index
		myList.add(3, "Mumbai");
		myList.add(1, "Delhi");
		
		System.out.println("Print the objects");
		for(String city:myList) {
			System.out.println(city);
		}
		System.out.println("3rd name in the ArrayList is " + myList.get(2));
		System.out.println("Is Pune listed in the above list of cities" + myList.contains("Pune"));
		System.out.println("Size of array list is " + myList.size());
		
		myList.remove("Mumbai");
		System.out.println("New size of array list is " + myList.size());
	}
}
/* Create an ArrayList named myList of type String.
Add 5 names to the ArrayList using add() method.
Then print all the names using for loop.
Then use get() method to retrieve the 3rd name in the ArrayList.
Use contains() method to check if a name exists in the ArrayList.
Use size() method to print the number of names in the ArrayList.
Use remove() method to remove a name from the list and print the size() of the list again.*/
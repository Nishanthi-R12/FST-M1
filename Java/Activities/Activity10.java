package activities;

import java.util.HashSet;

public class Activity10 {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("Doctor");
		hs.add("Engineer");
		hs.add("Teacher");
		hs.add("Architect");
		hs.add("Chef");
		hs.add("Police");
		
		System.out.println("Size of the HashSet is " + hs.size());
		System.out.println("List of the HashSet is " + hs);
		System.out.println("Removing 2nd element from the HashSet - " + hs.remove("Engineer"));
		
		if (hs.remove("Teacher")) {
			System.out.println("Teacher removed from the hashset");
		} else {
			System.out.println("Teacher is not in the list");
		}
		System.out.println("Checking if Architect is present - " + hs.contains("Architect"));
		System.out.println("New set " + hs);
		
	}

}

/* Create a HashSet named hs.
Add 6 objects using add() method to the HashSet.
Then print the size of the HashSet using the size() method.
Remove an element using the remove() method.
Also try to remove an element that is not present in the Set.
Use the contains() method to check if an item is in the Set or not.
Print the updated set. */

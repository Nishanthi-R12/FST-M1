package activities;

import java.util.HashMap;

	public class Activity11 {
	    public static void main(String[] args) {
	        HashMap<Integer, String> hash_map = new HashMap<Integer, String>();
	        hash_map.put(1, "Red");
	        hash_map.put(2, "Green");
	        hash_map.put(3, "Blue");
	        hash_map.put(4, "White");
	        hash_map.put(5, "Black");

	        System.out.println("The Original map: " + hash_map);
	        
	        // Remove one colour
	        hash_map.remove(4);
	        // Map after removing a colour
	        System.out.println("After removing White: " + hash_map);
	        
	        // Check if green exists
	        if(hash_map.containsValue("Green")) {
	            System.out.println("Green exists in the Map");
	        } else {
	            System.out.println("Green does not exist in the Map");
	        }
	        
	        // Print the size of the Map
	        System.out.println("Number of pairs in the Map is: " + hash_map.size());
	    }
	}



/* Create a Map named colours with integer keys and String values.
Add 5 random colours to it and print the Map to the console.
Remove one colour using the remove() method.
Check if the colour green exists in the Map using the containsValue() method.
Print the size of the Map using the size() method. */

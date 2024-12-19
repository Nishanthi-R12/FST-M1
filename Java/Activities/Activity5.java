package activities;


abstract class Book {
	String title;
	//abstract method
	abstract void setTitle(String s);
	//concrete method
	String getTitle() {
		return title;
	}
}
class MyBook extends Book {
	//Define abstract method
	public void setTitle(String s) {
		title = s;
	}
}


public class Activity5 {
	public static void main(String[] args) {
		String title = "You Can Win";
		Book newJournal = new MyBook();
		newJournal.setTitle(title);
		
		System.out.println("Title is " + newJournal.getTitle());
	}
	}
	
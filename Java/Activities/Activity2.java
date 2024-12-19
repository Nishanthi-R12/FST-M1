package activities;

public class Activity2 {
	
	public static void main (String args[]) {
		
	int sum = 0;
	int fixedSum = 30;
	int[] arrNum = {10, 77, 10, 54, -11, 10};
		
	for(int i=0;i<6;i++) {
		if (arrNum[i]==10) {
			sum = sum + 10;
		}
		}
	System.out.println("Sum of 10's in the array is " + sum + " which is equal to fixedsum value " + fixedSum);
	}
}

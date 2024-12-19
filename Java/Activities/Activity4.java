package activities;

import java.util.Arrays;

public class Activity4 {
	static void insertionSorting (int arr[]) {
		int size = arr.length, i;
		for (i=1;i<size;i++) {
			int key = arr[i];
			int j = i-1;
			
			while (j>=0 && key < arr[j]) {
				arr[j+1] = arr[j];
				--j;
			}
			arr[j+1] = key;
		}
	}
	public static void main(String[] args) {
		int[] numbers = {9, 7, 1, 4, 8};
		insertionSorting(numbers);
		System.out.println("Array in ascending order");
		System.out.println(Arrays.toString(numbers));
	}
}

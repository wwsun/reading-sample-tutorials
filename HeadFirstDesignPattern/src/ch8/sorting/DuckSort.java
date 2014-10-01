package ch8.sorting;

import java.util.Arrays;

public class DuckSort {
	public static void main(String[] args) {
		
		Duck[] ducks = {
			new Duck("Daffy", 8),
			new Duck("Well", 12),
			new Duck("Lily", 4),
			new Duck("Tom", 2)
		};
		
		System.out.println("===Before sorting===");
		display(ducks);
		
		System.out.println("===After sorting===");
		Arrays.sort(ducks);//check the source code of function sort
		display(ducks);
	}

	private static void display(Duck[] ducks) {
		for (Duck duck : ducks) {
			System.out.println(duck);
		}
	}
}

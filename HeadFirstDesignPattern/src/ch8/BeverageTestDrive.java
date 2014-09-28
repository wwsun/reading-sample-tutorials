package ch8;

public class BeverageTestDrive {
	public static void main(String[] args) {
		CoffeeWithHook cofHook = new CoffeeWithHook();
		
		System.out.println("\nMaking coffee....");
		cofHook.prepareRecipe();
	}
}

package ch8;

public abstract class CaffeineBeverage {
	
	/**
	 * We use final for the purpose of subclasses cannot modify this method.
	 */
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		addCondiments();
	}
	
	public abstract void addCondiments();

	public abstract void brew();

	public void boilWater() {
		System.out.println("Boling water");
	}
	
	public void pourInCup() {
		System.out.println("Pouring in cup");
	}
}

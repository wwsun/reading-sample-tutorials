package ch8;

public abstract class CaffeineBeverageWithHook {
	
	/**
	 * We use final for the purpose of subclasses cannot modify this method.
	 */
	final void prepareRecipe() {
		boilWater();
		brew();
		pourInCup();
		if(customerWantsCondiments()){
			addCondiments();
		}
	}
	
	/**
	 * A default method, user can change this method in the subclass
	 * @return
	 */
	public boolean customerWantsCondiments() {
		return true;
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

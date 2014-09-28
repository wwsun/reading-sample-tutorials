package ch8;

public class Coffee extends CaffeineBeverage {

	@Override
	public void addCondiments() {
		System.out.println("Boiling water");
	}

	@Override
	public void brew() {
		System.out.println("Pouring into cup");
	}
}

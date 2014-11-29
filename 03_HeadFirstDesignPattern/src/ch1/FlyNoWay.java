package ch1;

public class FlyNoWay implements FlyBehavior {
	
	/**
	 * The implementation of fly behavior
	 * Can be used by those ducks who cannot fly
	 */
	public void fly() {
		System.out.println("I can't fly");
	}

}

package ch7;

public class WildTurkey implements Turkey {

	@Override
	public void gobble() {
		System.out.println("Gobbnle gobble");
	}

	@Override
	public void fly() {
		System.out.println("I'm flying a short distance");
	}

}

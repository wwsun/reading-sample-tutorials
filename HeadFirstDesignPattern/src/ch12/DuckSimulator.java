package ch12;

public class DuckSimulator {
	public static void main(String[] args) {
		DuckSimulator sim = new DuckSimulator();
		sim.simulate();
	}
	
	void simulate() {
		Quackable mallardDuck = new QuackCounter(new MallardDuck());
		Quackable redheadDuck = new QuackCounter(new RedHeadDuck());
		Quackable duckCall = new QuackCounter(new DuckCall());
		Quackable rubberDuck = new QuackCounter(new RubberDuck());
		
		Quackable gooseDuck = new GooseAdapter(new Goose());
		
		System.out.println("\nDuck Simulator");
		
		simulate(mallardDuck);
		simulate(redheadDuck);
		simulate(duckCall);
		simulate(rubberDuck);
		
		simulate(gooseDuck);
		
		System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
	}	
	void simulate(Quackable duck){
		duck.quack();
	}
}

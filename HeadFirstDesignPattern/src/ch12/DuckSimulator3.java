package ch12;

public class DuckSimulator3 {
	public static void main(String[] args) {
		DuckSimulator3 sim = new DuckSimulator3();
		AbstractDuckFactory duckFactory = new CountingDuckFactory();
		sim.simulate(duckFactory);
	}
	
	void simulate(AbstractDuckFactory duckFactory) {
		Quackable mallardDuck = duckFactory.createMallardDuck();
		Quackable redheadDuck = duckFactory.createRedheadDuck();
		Quackable duckCall = duckFactory.createDuckCall();
		Quackable rubberDuck = duckFactory.createRubberDuck();
		
		Quackable gooseDuck = new GooseAdapter(new Goose());
		
		System.out.println("\nDuck Simulator: With composite - Flocks");
		
		Flock flockOfDucks = new Flock();
		
		flockOfDucks.add(redheadDuck);
		flockOfDucks.add(mallardDuck);
		flockOfDucks.add(duckCall);
		flockOfDucks.add(rubberDuck);
		flockOfDucks.add(gooseDuck);
		
		simulate(flockOfDucks);

		
		System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times");
	}	
	void simulate(Quackable duck){
		duck.quack();
	}
}

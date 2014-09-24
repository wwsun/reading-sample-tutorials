package ch7;

public class DuckTestDrive {
	public static void main(String[] args) {
		MallardDuck duck = new MallardDuck();
		
		WildTurkey turkey = new WildTurkey();
		Duck TurkeyAdapter = new TurkeyAdapter(turkey);
		
		System.out.println("The turkey say ....");
		turkey.gobble();
		turkey.fly();
		
		System.out.println("The Duck says ....");
		testDuck(duck);
		
		System.out.println("The TurkeyAdapter says ....");
		testDuck(TurkeyAdapter);
	}

	private static void testDuck(Duck duck) {
		duck.quack();
		duck.fly();
	}
}

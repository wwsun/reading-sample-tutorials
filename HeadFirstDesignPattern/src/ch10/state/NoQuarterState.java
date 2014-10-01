package ch10.state;

/**
 * No quarter inserted, ask the customer to insert a quarter
 * @author Weiwei
 *
 */
public class NoQuarterState implements State {
	
	GumballMachine gumballMachine;
	
	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("You inserted a quarter");
		gumballMachine.setState(gumballMachine.getHasQuarterState());
	}

	@Override
	public void ejectQuarter() {
		System.out.println("You haven't inserted a quarter!");
	}

	@Override
	public void turnCrank() {
		System.out.println("You turned, but ther is no quarter!");
	}

	@Override
	public void dispense() {
		System.out.println("You need to pay first!");
	}

}

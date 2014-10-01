package ch10.state;

public class SoldOutState implements State {
	
	GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		System.out.println("You can't insert a quarter, the machine is sold out!");
	}

	@Override
	public void ejectQuarter() {
		System.out.println("No quarter you inserted!");
	}

	@Override
	public void turnCrank() {
		System.out.println("you turned, but there are no gumballs.");
	}

	@Override
	public void dispense() {
		System.out.println("No gumball dispensed!");
	}

}

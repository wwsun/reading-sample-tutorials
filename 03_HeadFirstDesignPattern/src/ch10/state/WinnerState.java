package ch10.state;

public class WinnerState implements State {
	
	GumballMachine gumballMachine;
	
	public WinnerState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	@Override
	public void insertQuarter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void ejectQuarter() {
		// TODO Auto-generated method stub

	}

	@Override
	public void turnCrank() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispense() {
		System.out.println("You are a winner! you get two guumballs for your quarter!");
		gumballMachine.releaseBall();
		if (gumballMachine.getCount() == 0){
			gumballMachine.setState(gumballMachine.getSoldOutState());
		} else {
			gumballMachine.releaseBall();
			if(gumballMachine.getCount() > 0){
				gumballMachine.setState(gumballMachine.getNoQuarterState());
			} else {
				System.out.println("Ops, out of gumbals");
				gumballMachine.setState(gumballMachine.getSoldOutState());
			}
		}
	}

}

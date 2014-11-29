package ch10;

public class GumballMachine {
	final static int SOLD_OUT = 0;
	final static int NO_QUARTER = 1;
	final static int HAS_QUARTER = 2;
	final static int SOLD = 3;
	
	int state = SOLD_OUT;
	int count = 0;//the number of gumballs in this machine
	
	public GumballMachine(int count) {
		this.count = count;
		if(count > 0){
			state = NO_QUARTER;
		}
	}
	
	public void insertQuarter() {
		if(state == HAS_QUARTER){
			System.out.println("You cannot insert another quarter");
		} else if(state == NO_QUARTER){
			System.out.println("You inserted a quarter");
		} else if(state == SOLD_OUT){
			System.out.println("You can't insert a quarter, the machine is sold out");
		} else if(state == SOLD){
			System.out.println("Please wait,we're alreday giving you a gumball");
		}
	}
	
	public void ejectQuarter(){
		if(state == HAS_QUARTER){
			System.out.println("Quarter returned");
		} else if(state == NO_QUARTER){
			System.out.println("You haven't inserted a quarter");
		} else if(state == SOLD_OUT){
			System.out.println("You can't ejct, you haven't inserted a quarter yet");
		} else if(state == SOLD){
			System.out.println("Sorry, you already turned the crank");
		}
	}
	
	public void turnCrank(){
		if(state == HAS_QUARTER){
			System.out.println("You turned...");
			state = SOLD;
			dispense();//send out the gumballs
		} else if(state == NO_QUARTER){
			System.out.println("Please insert a quarter before you turn the crank");
		} else if(state == SOLD_OUT){
			System.out.println("You turned, but there are no gumballs");
		} else if(state == SOLD){
			System.out.println("Turning twice doesn't yet you another gumball!");
		}
	}

	private void dispense() {
		if(state == HAS_QUARTER){
			System.out.println("No gumball dispensed");
		} else if(state == NO_QUARTER){
			System.out.println("You need to pay first!");
		} else if(state == SOLD_OUT){
			System.out.println("No gumball dispensed!");
		} else if(state == SOLD){
			System.out.println("A gumball comes rolling out the slot");
			count--;
			if(count == 0){
				System.out.println("Ops, out of gumballs!");
				state = SOLD_OUT;
			} else {
				state = NO_QUARTER;
			}
		}
	}
	
	
}

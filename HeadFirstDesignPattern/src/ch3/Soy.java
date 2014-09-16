package ch3;

public class Soy extends CondimentDecorator {
	
	Beverage beverage;
	
	public Soy(Beverage bev) {
		beverage = bev;
	}
	
	public int getSize(){
		return beverage.getSize();
	}

	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	@Override
	public double cost() {
		double cost = beverage.cost();
		if(getSize() == Beverage.TALL){
			cost += .10;
		} else if(getSize() == Beverage.GRANDE){
			cost += .15;
		} else if(getSize() == Beverage.VENTI) {
			cost += .20;
		}
		return cost;
	}

}

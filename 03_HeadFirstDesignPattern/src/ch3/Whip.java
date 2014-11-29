package ch3;

public class Whip extends CondimentDecorator {
	
	Beverage beverage;
	
	public Whip(Beverage bev) {
		beverage = bev;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}

	@Override
	public double cost() {
		return 0.10 + beverage.cost();
	}

}
package ch4;

import ch4.ingredient.Cheese;
import ch4.ingredient.Clams;
import ch4.ingredient.Dough;
import ch4.ingredient.Pepperoni;
import ch4.ingredient.Sauce;
import ch4.ingredient.ThinCrustDough;
import ch4.ingredient.Veggies;

public class NYPizzaInredientFactory implements PizzaIngredientFactory {

	@Override
	public Dough createDough() {
		return new ThinCrustDough();
	}

	@Override
	public Sauce createSauce() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cheese createCheese() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Veggies[] createVeggies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pepperoni createPepperoni() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Clams createClam() {
		// TODO Auto-generated method stub
		return null;
	}

}

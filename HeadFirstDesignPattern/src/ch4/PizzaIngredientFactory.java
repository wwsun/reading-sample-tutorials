package ch4;

import ch4.ingredient.Cheese;
import ch4.ingredient.Clams;
import ch4.ingredient.Dough;
import ch4.ingredient.Pepperoni;
import ch4.ingredient.Sauce;
import ch4.ingredient.Veggies;

/**
 * The pizza ingredient factory will in charge of creating all kinds of ingredients
 * @author Weiwei
 *
 */
public interface PizzaIngredientFactory {
	public Dough createDough();
	public Sauce createSauce();
	public Cheese createCheese();
	public Veggies[] createVeggies();
	public Pepperoni createPepperoni();
	public Clams createClam();
}

package ch4;

public class NYPizzaStore extends PizzaStore {

	@Override
	Pizza createPizza(String type) {
		Pizza pizza = null;
		
		PizzaIngredientFactory ingredientFactory = new NYPizzaIngredientFactory();
		
		if(type.equals("cheese")){
			
		}
		
		return pizza;
	}

}

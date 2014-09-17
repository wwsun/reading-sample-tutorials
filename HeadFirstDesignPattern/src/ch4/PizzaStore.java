package ch4;

/**
 * the super-class of every city's pizza store
 * @author Weiwei
 *
 */
public abstract class PizzaStore {
//	SimplePizzaFactory factory;
//	
//	public PizzaStore(SimplePizzaFactory factory) {
//		this.factory = factory;
//	}
	
	public Pizza orderPizza(String type){
		Pizza pizza;
		pizza = createPizza(type);
		
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
		
		return pizza;
	}
	
	/**
	 * Every pizza store has its own method to create pizza
	 * We use a method as a factory, rather than a class
	 * The factory method is used to create objects
	 * @param type
	 * @return
	 */
	abstract  Pizza createPizza(String type);
}

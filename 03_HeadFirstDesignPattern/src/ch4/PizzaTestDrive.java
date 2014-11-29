package ch4;

public class PizzaTestDrive {
	public static void main(String[] args) {
		PizzaStore store = new NYStylePizzaStore();
		Pizza pizza = store.orderPizza("cheese");
		System.out.println("Weiwei ordered a " + pizza.getName() + "\n");
	}
}

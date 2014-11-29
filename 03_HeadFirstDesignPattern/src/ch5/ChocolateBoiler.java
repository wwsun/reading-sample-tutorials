package ch5;

public class ChocolateBoiler {
	
	private boolean empty;
	private boolean boiled;
	
	private static ChocolateBoiler uniqueInstance;
	
	private ChocolateBoiler() {
		empty = true;
		boiled = false;
	}
	
	public static synchronized ChocolateBoiler getInstance(){
		if(uniqueInstance==null){
			uniqueInstance = new ChocolateBoiler();
		}
		return uniqueInstance;
	}
	
	public void fill(){
		if(isEmpty()){
			empty = false;
			boiled = false;
		}
	}
	
	public void drain() {
		if(!isEmpty() && isBoiled()){
			empty = true;
		}
	}
	
	public void boil() {
		if(!isEmpty() && !isBoiled()){
			boiled = true;
		}
	}
	
	private boolean isEmpty() {
		return empty;
	}
	
	private boolean isBoiled() {
		return boiled;
	}
}

package ch5;

public class ChocolateBoiler2 {
	
	private boolean empty;
	private boolean boiled;
	
	private volatile static ChocolateBoiler2 uniqueInstance;
	
	private ChocolateBoiler2() {
		empty = true;
		boiled = false;
	}
	
	public static synchronized ChocolateBoiler2 getInstance(){
		if(uniqueInstance==null){
			
			synchronized (ChocolateBoiler2.class) {
				if(uniqueInstance == null)
					uniqueInstance = new ChocolateBoiler2();
			}
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

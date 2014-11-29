package ch5;

public class Singleton {
	
	//step-1
	private static Singleton uniqueInstance;
	
	//step-2
	private Singleton() {
		
	}
	
	//step-3 and step-4
	public static synchronized Singleton getInstance() {
		if(uniqueInstance == null) {
			uniqueInstance = new Singleton();
		}
		
		return uniqueInstance;
	}
}

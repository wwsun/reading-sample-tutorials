package ch3;

public abstract class Beverage {
	
	public static final int TALL = 0;
	public static final int GRANDE = 1;
	public static final int VENTI = 2;
	private int size;
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	String description = "Unknown Beverage";
	
	public abstract double cost();
	
	public String  getDescription(){
		return description;
	}
}

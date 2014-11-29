package ch8.sorting;

public class Duck implements Comparable<Object> {
	
	String name;
	int weight;
	
	public Duck(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}
	
	@Override
	public String toString() {
		return name + " weighs " + weight;
	}

	@Override
	public int compareTo(Object o) {
		Duck otherDuck = (Duck)o;
		if(this.weight < otherDuck.weight){
			return -1;
		}else if(this.weight == otherDuck.weight){
			return 0;
		}else {
			return 1;
		}
	}
}

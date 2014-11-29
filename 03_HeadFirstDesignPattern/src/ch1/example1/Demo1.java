package ch1.example1;

public class Demo1 {
	public static void main(String[] args) {
		Character queue = new Queue();
		queue.setWeapon(new AxeBehavior());
		queue.performWeaponBehavior();
	}
}

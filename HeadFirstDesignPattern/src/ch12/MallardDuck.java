package ch12;

public class MallardDuck implements Quackable {
	Observable observable;
	
	public MallardDuck() {
		observable = new Observable(this);
	}
	
	@Override
	public void quack() {
		System.out.println("Quack");
		notifyObservers();
	}

	@Override
	public void notifyObservers() {
		observable.notifyObservers();
	}

	@Override
	public void registerObserver(ch12.Observer observer) {
		observable.registerObserver(observer);
	}

}

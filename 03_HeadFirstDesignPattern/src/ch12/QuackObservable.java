package ch12;

public interface QuackObservable {
	public void registerObserver(Observer observer);
	public void notifyObservers();
}

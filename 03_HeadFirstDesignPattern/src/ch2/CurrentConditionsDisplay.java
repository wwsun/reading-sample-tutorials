package ch2;

public class CurrentConditionsDisplay implements Observer, DisplayElement {

	private float temperature;
	private float humidity;
	private Subject weatherData;
	
	public CurrentConditionsDisplay(Subject wData){
		this.weatherData = wData;
		weatherData.registerObserver(this);
	}
	
	@Override
	public void display() {
		System.out.println("current conditions: " + temperature + "F degrees and " + humidity + "% humidity");
	}

	@Override
	public void update(float temp, float humidity, float pressure) {
		this.temperature = temp;
		this.humidity = humidity;
		display();
	}

}

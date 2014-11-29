package ch2;

public class WeatherStation {
	public static void main(String[] args) {
		WeatherData wdata = new WeatherData();
		//CurrentConditionsDisplay ccd = new CurrentConditionsDisplay(wdata);
		wdata.setMeasurements(80, 60, 30.4f);
	}
}

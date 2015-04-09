package designpattern.observer;


import designpattern.observer.javaapi.observable.WeatherData;
import designpattern.observer.javaapi.observer.CurrentConditionDisplay;
import designpattern.observer.javaapi.observer.ForecastDisplay;
import designpattern.observer.javaapi.observer.StaticsDisplay;

public class WeatherEnvironment {
	
	static WeatherData weatherData;					// Observable WeatherData
	
	static CurrentConditionDisplay currentDisplay;	// 현재 온도 출력 장비
	static ForecastDisplay forecastDisplay;			// 기압 변화 출력 장비
	static StaticsDisplay staticsDisplay;			// 온도 통계 장비
	
	
	// WeatherData 객체 생성
	public static void weatherStation(){
		weatherData = new WeatherData();
	}
	
	// weatherData에 데이터를 전달한다.
	public static void changeWeather(float temp, float humity, float pressure) {
		
		weatherData.setMeasurements(temp, humity, pressure);

	}


		// 디스플레이 장비 객체를 생성한다.
	public static void clientDisplay(){
		staticsDisplay = new StaticsDisplay(weatherData);			// staticsDisplay 객체 생성하면서 옵저버로 등록
		currentDisplay = new CurrentConditionDisplay(weatherData);	// currentDisplay 객체 생성하면서 옵저버로 등록
		forecastDisplay = new ForecastDisplay(weatherData);			// forecastDisplay 객체 생성하면서 옵저버로 등록
		
	}
	
	// 현재 각 장비의 저장 데이터 출력
	public static void requestCurrentWeather(){
		//currentDisplay.display();
		/*forecastDisplay.display();
		staticsDisplay.display();*/
	}
	
	
	
	public static void main(String[] args){
		weatherStation();		// weather 객체 생성
		clientDisplay();		// 디스플레이 장비 객체 생성
		
		
		// WeatherStation에서 날씨의 변화를 입력한다.
		System.out.println("-----날씨가 변한다.----");
		changeWeather(40, 50, 10);					// 온도 40, 습도 50, 기압 10 데이터 weatherData에 전달
		System.out.println("");
		
		System.out.println("-----날씨가 변한다.----");
		changeWeather(50, 60, 20);					// 온도 50, 습도 60, 기압 20 데이터 weatherData에 전달
		System.out.println("");
		
		System.out.println("----사용자가 현재의 날씨를 요청한다.----");
		changeWeather(50, 60, 20);					// 온도 50, 습도 60, 기압 20 데이터 weatherData에 전달
//	requestCurrentWeather();
	}
	


}

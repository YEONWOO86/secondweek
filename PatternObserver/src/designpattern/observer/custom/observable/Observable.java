package designpattern.observer.custom.observable;

import designpattern.observer.custom.observer.Observer;

public interface Observable {
	
	public void addObserver(Observer o);
	public void deleteObserver(Observer o);
	public void notifyObservers();

}

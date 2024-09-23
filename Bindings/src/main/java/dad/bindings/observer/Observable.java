package dad.bindings.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {

    private List<Observer> observers = new ArrayList();

    public void suscribe (Observer<T> observer) {
        this.observers.add(Observer);
    }

    public void notifyAll(T value) {
        this.observers.forEach(o -> o.notify(value));
    }

}

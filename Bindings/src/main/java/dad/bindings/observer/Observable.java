package dad.bindings.observer;

import java.util.ArrayList;
import java.util.List;

public class Observable<T> {

    private List<Observer<T>> observers = new ArrayList<>();

    public void suscribe(Observer<T> observer) {
        this.observers.add(observer);
    }

    public void notifyAll(T value) {
        this.observers.forEach(o -> o.notify(value));
    }
}

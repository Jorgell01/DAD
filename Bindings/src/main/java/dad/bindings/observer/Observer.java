package dad.bindings.observer;

public interface Observer<T> {
    void notify(T value);
}

package dad.bindings.observer;

import java.util.ArrayList;

public interface Observer<T> {

    void notify(T value);

}

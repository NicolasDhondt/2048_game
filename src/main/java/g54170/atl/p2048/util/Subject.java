package g54170.atl.p2048.util;

import java.util.ArrayList;
import java.util.List;

/**
 * The subject
 *
 * @author Nicolas, g54170
 */
public class Subject {

    private List<Observer> observers = new ArrayList();

    /**
     * register a observer
     *
     * @param obs the given observer
     */
    public void register(Observer obs) {
        if (obs == null) {
            throw new IllegalArgumentException("An observer can't be null!");
        }
        if (!observers.contains(obs)) {
            observers.add(obs);
        }
    }

    /**
     * unregister a observer
     *
     * @param obs the given observer
     */
    public void unregister(Observer obs) {
        observers.remove(obs);
    }

    /**
     * informs the observers
     */
    protected void notifyObservers() {
        observers.forEach(observer -> {
            observer.update();
        });
    }
}

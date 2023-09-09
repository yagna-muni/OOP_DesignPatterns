package edu.umb.cs680.hw17;

import java.util.ArrayList;
import java.util.List;

public class Observable<StockEvent> {

    public List<Observer<StockEvent>> observersList = new ArrayList<>();

    public void addObserver(Observer<StockEvent> observer) {
        this.observersList.add(observer);
    }

    public List<Observer<StockEvent>> getObserversList() {
        return observersList;
    }

    public int countObservers() {
        return this.observersList.size();
    }

    public void removeObserver(Observer<StockEvent> observer) {
        this.observersList.remove(observer);
    }

    public void clearObservers() {
        observersList = new ArrayList<>();
    }

    public void notifyObservers(StockEvent stockEvent) {
        for (Observer<StockEvent> observer : observersList) {
            observer.update(this, stockEvent);
        }
    }

    public static void main(String[] args) {

    }
}

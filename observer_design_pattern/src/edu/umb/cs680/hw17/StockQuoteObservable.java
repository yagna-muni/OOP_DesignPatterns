package edu.umb.cs680.hw17;

import java.util.HashMap;

public class StockQuoteObservable extends Observable<StockEvent> {

    private HashMap<String, Double> map;

    public HashMap<String, Double> getMap() {
        return map;
    }
    public StockQuoteObservable() {
        map = new HashMap<>();
    }

    public void changeQuote(String ticker, Double quote) {
        map.put(ticker, quote);
        this.notifyObservers(new StockEvent(ticker, quote));
    }
}

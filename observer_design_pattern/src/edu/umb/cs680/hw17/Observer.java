package edu.umb.cs680.hw17;

public interface Observer<StockEvent> {

    void update(Observable<StockEvent> sender, StockEvent stockEvent);
}

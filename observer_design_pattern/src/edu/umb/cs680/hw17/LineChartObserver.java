package edu.umb.cs680.hw17;

public class LineChartObserver implements Observer<StockEvent> {

    @Override
    public void update(Observable<StockEvent> sender, StockEvent stockEvent) {
        System.out.println(stockEvent.getQuote()
                + " " +
                stockEvent.getTicker());
    }
}

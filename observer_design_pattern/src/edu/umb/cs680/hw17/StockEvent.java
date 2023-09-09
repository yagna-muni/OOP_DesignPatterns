package edu.umb.cs680.hw17;

public class StockEvent {

    private String ticker;
    private Double quote;

    public StockEvent(String ticker, Double quote) {
        this.ticker = ticker;
        this.quote = quote;
    }

    public String getTicker() {
        return ticker;
    }

    public Double getQuote() {
        return quote;
    }
}

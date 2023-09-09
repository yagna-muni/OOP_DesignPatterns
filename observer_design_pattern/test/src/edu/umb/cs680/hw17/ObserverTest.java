package edu.umb.cs680.hw17;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ObserverTest {

    @Test
    public void testChangeQuoteObserver()
    {
        StockQuoteObservable stockObservable = new StockQuoteObservable();
        HashMap<String, Double> map = new HashMap<>();
        stockObservable.changeQuote("YHM", 999.0);
        map.put("YHM",999.0);
        assertTrue(map.equals(stockObservable.getMap()));
    }

    @Test
    public void testStockQuoteObservable() {
        StockQuoteObservable O = new StockQuoteObservable();
        ThreeDimensionalObserver observer = new ThreeDimensionalObserver();
        TableObserver observer1 = new TableObserver();
        LineChartObserver observer2 = new LineChartObserver();
        O.addObserver(observer);
        O.addObserver(observer1);
        O.addObserver(observer2);
        assertEquals(3, O.countObservers() );
    }

    @Test
    public void testDJIAObservable() {
        DJIAQuoteObservable O = new DJIAQuoteObservable();
        ThreeDimensionalObserver observer = new ThreeDimensionalObserver();
        TableObserver observer1 = new TableObserver();
        LineChartObserver observer2 = new LineChartObserver();
        O.addObserver(observer);
        O.addObserver(observer1);
        O.addObserver(observer2);
        assertEquals(3, O.countObservers() );
    }

    @Test
    public void testLEObserver() {
        StockQuoteObservable observable = new StockQuoteObservable();
        Observer<StockEvent> ObsLE = (Observable<StockEvent> observable1, StockEvent event) -> { };
        Observer<StockEvent> ObsLE2 = (Observable<StockEvent> observable1, StockEvent event) -> {};
        observable.addObserver(ObsLE);
        observable.addObserver(ObsLE2);
        assertEquals(2, observable.countObservers());
    }

    @Test
    public void testLEObserverDJIA() {
        DJIAQuoteObservable observable = new DJIAQuoteObservable();
        Observer<StockEvent> ObsLE = (Observable<StockEvent> observable1, StockEvent event) -> { };
        observable.addObserver(ObsLE);
        assertEquals(1, observable.countObservers());
    }

    @Test
    public void testNewStockEvent() {
        StockQuoteObservable O = new StockQuoteObservable();
        ThreeDimensionalObserver observer = new ThreeDimensionalObserver();
        TableObserver observer1 = new TableObserver();
        LineChartObserver observer2 = new LineChartObserver();
        O.addObserver(observer);
        O.addObserver(observer1);
        O.addObserver(observer2);
        assertEquals(ThreeDimensionalObserver.class, O.getObserversList().get(0).getClass());
    }

    @Test
    public void testStockObservable()
    {
        StockQuoteObservable stockObservable = new StockQuoteObservable();
        HashMap<String, Float> floatHashMap = new HashMap<>();
        assertTrue(stockObservable.getMap().keySet().containsAll((floatHashMap.keySet())));
    }
}

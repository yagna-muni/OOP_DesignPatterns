package edu.umb.cs680.hw17;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

public class StockQuoteObservableTest {
	StockQuoteObservable stockObservable = new StockQuoteObservable();
	HashMap<String, Float> map = new HashMap<>();
	
	@Test
	public void testObserver()
	{
		
		stockObservable.changeQuote("ABC",85);
		stockObservable.changeQuote("DEF", 12);
		stockObservable.changeQuote("ABC",15 );
		
		map.put("ABC",(float) 85);
		map.put("DEF",(float)  12);
		map.put("ABC",(float) 15);
		
		//contains same key		
		assertTrue(stockObservable.getMap().keySet().containsAll((map.keySet())));
		
		//mapping objects are same		
		assertTrue(map.equals(stockObservable.getMap()));
	}
}

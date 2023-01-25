package edu.umb.cs680.hw11;


import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


public class DistanceTest {
	public ArrayList<Double> arrayToList(double[] p) {
		ArrayList<Double> pList = new ArrayList<Double>();
		
		for(double d : p) {
			pList.add(d);
		}
		
		return pList;
	}
	
	@Test
	void test() {
		Distance d = new Distance();
		//test case 1
		double p1[] = {4.3,5.0,6.6};
		double p2[] = {3.0,7.4,1.0};
		
		
		double distEuc = d.get(arrayToList(p1), arrayToList(p2));
		double distMan = d.get(arrayToList(p1), arrayToList(p2), new Manhattan());
		
		assertion(6.23, distEuc);
		assertion(9.3, distMan);
		
		//test case 2
		double p1_2[] = {1.0,2.0,3.0};
		double p2_2[] = {4.0,5.0,6.0};
		
		double dist_2 = d.get(arrayToList(p1_2), arrayToList(p2_2));
		double distMan_2 = d.get(arrayToList(p1_2), arrayToList(p2_2), new Manhattan());
		
		assertion(5.2, dist_2);
		assertion(9.0, distMan_2);
		
		//test case 3
		double p1_3[] = {1.26,3.5,4.2};
		double p2_3[] = {8.3,6.5,4.2};
		
		double dist_3 = d.get(arrayToList(p1_3), arrayToList(p2_3));
		double distMan_3 = d.get(arrayToList(p1_3), arrayToList(p2_3), new Manhattan());
		
		assertion(7.65, dist_3);
		assertion(10.04, distMan_3);

		//test case 4
		double p1_4[] = {2.0,4.0,6.0};
		double p2_4[] = {3.0,6.0,9.0};
		
		double dist_4 = d.get(arrayToList(p1_4), arrayToList(p2_4));
		double distMan_4 = d.get(arrayToList(p1_4), arrayToList(p2_4), new Manhattan());
		
		assertion(3.74, dist_4);
		assertion(6.0, distMan_4);
		
		//test case 5
		double p1_5[] = {1.0,1.0,1.0};
		double p2_5[] = {2.0,2.0,2.0};
		
		double dist_5 = d.get(arrayToList(p1_5), arrayToList(p2_5));
		double distMan_5 = d.get(arrayToList(p1_5), arrayToList(p2_5), new Manhattan());
		
		assertion(1.73, dist_5);
		assertion(3.0, distMan_5);

	}
	
	void assertion(double res, double actual) {
		assertEquals(res, actual);
	}
}

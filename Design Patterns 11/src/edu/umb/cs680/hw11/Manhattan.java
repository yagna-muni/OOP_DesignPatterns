package edu.umb.cs680.hw11;

import java.util.ArrayList;

public class Manhattan implements DistanceMetric{

	@Override
	public double distance(ArrayList<Double> p1, ArrayList<Double> p2) {
		// TODO Auto-generated method stub
		double res =  Math.abs(p1.get(0)-p2.get(0)) + Math.abs(p1.get(1)-p2.get(1)) + Math.abs(p1.get(2)-p2.get(2));
		String s = String.format("%.2f",res);
		return Double.parseDouble(s);
	}
	
}

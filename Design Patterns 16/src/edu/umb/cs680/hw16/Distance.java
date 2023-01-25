package edu.umb.cs680.hw16;

import java.util.ArrayList;
import java.util.Collections;


public class Distance{
	
	private static DistanceMetric manhattan = (point1,point2) -> {
		double res =  Math.abs(point1.get(0)-point2.get(0)) + Math.abs(point1.get(1)-point2.get(1)) + Math.abs(point1.get(2)-point2.get(2));
		String s = String.format("%.2f",res);
		return Double.parseDouble(s);
	};

	public double get(ArrayList<Double> p1, ArrayList<Double> p2) {
		double x1,y1,z1,x2,y2,z2;
		x1 = p1.get(0);
		y1 = p1.get(1);
		z1 = p1.get(2);
		
		x2 = p2.get(0);
		y2 = p2.get(1);
		z2 = p2.get(2);
		
		double a = x1-x2;
		double b = y1-y2;
		double c = z1-z2;
		
		double res =  Math.sqrt(a * a + b * b + c * c);
		String s = String.format("%.2f",res);
		return Double.parseDouble(s);
	}
	
	public double get(ArrayList<Double> p1, ArrayList<Double> p2, DistanceMetric metric) {
		return metric.distance(p1,p2);
	}
	
	public ArrayList<ArrayList<Double>> matrix(ArrayList<ArrayList<Double>> points) {
		ArrayList<ArrayList<Double>> matrix = new ArrayList<ArrayList<Double>>();
		double distance = get(points.get(0), points.get(1));
		
		ArrayList<Double> a1 = new ArrayList<Double>(Collections.nCopies(5, 0.0));
		a1.set(4, distance);
		ArrayList<Double> a2 = new ArrayList<Double>(Collections.nCopies(5, 0.0));
		a2.set(3, distance);
		ArrayList<Double> a3 = new ArrayList<Double>(Collections.nCopies(5, 0.0));
		a3.set(2, distance);
		ArrayList<Double> a4 = new ArrayList<Double>(Collections.nCopies(5, 0.0));
		a4.set(1, distance);
		ArrayList<Double> a5 = new ArrayList<Double>(Collections.nCopies(5, 0.0));
		a5.set(0, distance);
		
		matrix.add(a1);
		matrix.add(a2);
		matrix.add(a3);
		matrix.add(a4);
		matrix.add(a5);
		
		return matrix;
	}
	
	public ArrayList<ArrayList<Double>> matrix(ArrayList<ArrayList<Double>> points, DistanceMetric metric) {
		ArrayList<ArrayList<Double>> matrix = new ArrayList<ArrayList<Double>>();
		double distance = get(points.get(0), points.get(1), metric);
		
		ArrayList<Double> a1 = new ArrayList<Double>(Collections.nCopies(5, 0.0));
		a1.set(4, distance);
		ArrayList<Double> a2 = new ArrayList<Double>(Collections.nCopies(5, 0.0));
		a2.set(3, distance);
		ArrayList<Double> a3 = new ArrayList<Double>(Collections.nCopies(5, 0.0));
		a3.set(2, distance);
		ArrayList<Double> a4 = new ArrayList<Double>(Collections.nCopies(5, 0.0));
		a4.set(1, distance);
		ArrayList<Double> a5 = new ArrayList<Double>(Collections.nCopies(5, 0.0));
		a5.set(0, distance);
		
		matrix.add(a1);
		matrix.add(a2);
		matrix.add(a3);
		matrix.add(a4);
		matrix.add(a5);
		
		return matrix;
	}

	public static void main(String args[]) {
		ArrayList<ArrayList<Double>> points = new ArrayList<ArrayList<Double>>();
		
		ArrayList<Double> p1 = new ArrayList<>();
		p1.add(1.0);
		p1.add(1.0);
		p1.add(1.0);
		
		ArrayList<Double> p2 = new ArrayList<>();
		p2.add(2.0);
		p2.add(2.0);
		p2.add(2.0);
		
		points.add(p1);
		points.add(p2);
		
		System.out.println("Euclidian distance : " + new Distance().get(p1,p2));
		System.out.println("Euclidian distance matrix : " + new Distance().matrix(points));
		System.out.println("Manhattan distance : " + new Distance().get(p1, p2, manhattan));
		System.out.println("Manhattan distance matrix : " + new Distance().matrix(points, manhattan));
	}
	
}

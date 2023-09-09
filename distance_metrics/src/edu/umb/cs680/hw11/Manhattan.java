package edu.umb.cs680.hw11;

import java.util.List;

public class Manhattan implements DistanceMetric{

    @Override
    public double distance(List<Double> p1, List<Double> p2) throws Exception {
        if(p1.size() == p2.size()) {
            double sumDistance = 0.0;
            for(int i=0; i < p1.size(); i++) {
                sumDistance += p1.get(i) - p2.get(i);
            }
            return Math.abs(sumDistance);
        } else {
            throw new Exception("p1 and p2 sizes are not equal");
        }
    }
}

package edu.umb.cs680.hw16;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {
    static List<Double> p1 = Arrays.asList(4.0, 10.0, 2.0);
    static List<Double> p2 = Arrays.asList(2.0, 7.0, 10.0);
    static List<Double> p3 = Arrays.asList(2.0, 5.0, 7.0);
    static List<Double> p4 = Arrays.asList(25.0, 27.0, 69.0);
    static List<Double> p5 = Arrays.asList(1.0, 8.0, 9.0);

    private static List<List<Double>> DoubleList = new LinkedList<>();

    @BeforeAll
    static void setUpBeforeClass(){
        DoubleList.add(p1);
        DoubleList.add(p2);
        DoubleList.add(p3);
        DoubleList.add(p4);
        DoubleList.add(p5);
    }

    @Test
    void checkManhattanDistance() {
        try {
            double distMan = Distance.get(p1, p2, (P1, P2) -> (Math.abs(P1.get(0) - P2.get(0)) + Math.abs(P1.get(1) - P2.get(1)) + Math.abs(P1.get(2) - P2.get(2))));
            assertEquals(13.0, distMan);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    void checkManhattanDistance_3_5() {
        try {
            double distMan = Distance.get(p3, p5, (P1, P2) -> (Math.abs(P1.get(0) - P2.get(0)) + Math.abs(P1.get(1) - P2.get(1)) + Math.abs(P1.get(2) - P2.get(2))));
            assertEquals(6.0, distMan);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void checkTwoValAndManhattan() throws Exception {
        double actual = Distance.get(p2, p4, (List<Double> point1, List<Double> point2) -> IntStream.range(0, point1.size()).mapToDouble(i -> Math.abs(point1.get(i) - point2.get(i))).sum());
        assertEquals(102.0, actual);
    }

    @Test
    public void checkMatrixLEManhattan() {
        List<List<Double>> actual;
        Double[][] expected = {{0.0, 13.0, 12.0, 105.0, 12.0}, {13.0, 0.0, 5.0, 102.0, 3.0}, {12.0, 5.0, 0.0, 107.0, 6.0}, {105.0, 102.0, 107.0, 0.0, 103.0}, {12.0, 3.0, 6.0, 103.0, 0.0}};

        try {
            actual = Distance.matrix(DoubleList, (List<Double> P1, List<Double> P2) -> IntStream.range(0, P1.size()).mapToDouble(i -> Math.abs(P1.get(i) - P2.get(i))).sum());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        for(int i=0; i<expected.length; i++) {
            for(int j=0; j<expected[i].length; j++) {
                assertEquals(expected[i][j],actual.get(i).get(j));
            }
        }
    }

}
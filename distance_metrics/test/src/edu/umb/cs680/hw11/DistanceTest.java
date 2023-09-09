package edu.umb.cs680.hw11;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DistanceTest {

    Distance dist = new Distance();
    List<Double> p1 = Arrays.asList(4.0, 10.0, 2.0);
    List<Double> p2 = Arrays.asList(2.0, 7.0, 10.0);
    List<Double> p3 = Arrays.asList(2.0, 5.0, 7.0);
    List<Double> p4 = Arrays.asList(25.0, 27.0, 69.0);
    List<Double> p5 = Arrays.asList(1.0, 8.0, 9.0);

    @Test
    void get_Manhattan() {
        try {
            assertEquals(3.0, Distance.get(p1,p2, new Manhattan()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void get_Euclidean() {
        try {
            assertEquals(8.774964387392123, Distance.get(p1,p2));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void get_Manhattan_3_4() {
        try {
            assertEquals(107.0, Distance.get(p3,p4, new Manhattan()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void get_Euclidean_3_4() {
        try {
            assertEquals(69.6921803361037, Distance.get(p3,p4));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void get_Manhattan_1_5() {
        try {
            assertEquals(2.0, Distance.get(p1,p5, new Manhattan()));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void get_Euclidean_1_5() {
        try {
            assertEquals(7.874007874011811, Distance.get(p1,p5));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }








}
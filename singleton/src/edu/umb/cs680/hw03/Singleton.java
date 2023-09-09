package edu.umb.cs680.hw03;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Objects;

public class Singleton {
        private Singleton(){};
        private static Singleton instance = null;
        public static Singleton getInstance(){
            if(instance == null)
                instance = new Singleton();
            return instance;
        }

    public static void main(String[] args) {
        Singleton S1 = new Singleton();
        Singleton S2 = new Singleton();

        if(S1.getInstance() == S2.getInstance()) {
            System.out.println("Returned Identical Instance when called multiple times");
        }
    }
}


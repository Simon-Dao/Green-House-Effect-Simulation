package Simulation.main;

import java.util.Random;

public class RandomDigit {

    Random random = new Random();

    public int nextInt(int min, int max) {

        int output = 0;

        try {
            output = (int) (Math.random()*((max+1)-min))+min;
        } catch(Exception e) {

        }
        return output;
    }
}

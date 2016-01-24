package com.github.zhve.topcoder.task250;

public class FixedPointTheorem {
    public double cycleRange(double R) {
        double x = .25;
        for (int i = 0; i < 200000; i++) {
            x = R * x * (1 - x);
        }
        double min = x;
        double max = x;
        for (int i = 0; i < 1000; i++) {
            x = R * x * (1 - x);
            if (x < min) {
                min = x;
            }
            if (x > max) {
                max = x;
            }
        }
        return max - min;
    }

    public static void main(String[] args) {
        System.out.print(new FixedPointTheorem().cycleRange(3.4499));
    }
}

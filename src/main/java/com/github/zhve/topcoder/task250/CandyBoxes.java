package com.github.zhve.topcoder.task250;

public class CandyBoxes {
    public int remainingCandies(int[] candies) {
        while (true) {
            int min = candies[0];
            int minI = 0;
            int max = candies[0];
            int maxI = 0;
            for (int i = 0; i < candies.length; i++) {
                int num = candies[i];
                if (num < min) {
                    min = num;
                    minI = i;
                }
                if (num > max) {
                    max = num;
                    maxI = i;
                }
            }
            if (min == max) {
                return min;
            }
            candies[maxI] -= min;
        }
    }
}

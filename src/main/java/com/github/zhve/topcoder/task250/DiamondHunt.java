package com.github.zhve.topcoder.task250;

public class DiamondHunt {
    public int countDiamonds(String mine) {
        int diamondIndex = -1;
        int counter = 0;
        while ((diamondIndex = mine.indexOf("<>")) != -1) {
            counter++;
            mine = mine.replaceFirst("<>", "");
        }
        return counter;
    }
}

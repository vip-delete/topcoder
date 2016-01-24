package com.github.zhve.topcoder.task250;

public class StringSegment {
    public double average(String s) {
        int n = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                n++;
            }
        }
        return 1.0 * s.length() / n;
    }
}

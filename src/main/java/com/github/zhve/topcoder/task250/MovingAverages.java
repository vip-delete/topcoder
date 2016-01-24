package com.github.zhve.topcoder.task250;

public class MovingAverages {
    public int[] calculate(String[] times, int n) {
        int[] sec = new int[times.length];
        for (int i = 0; i < times.length; i++) {
            String[] d = times[i].split(":");
            sec[i] = Integer.parseInt(d[0]) * 3600 + Integer.parseInt(d[1]) * 60 + Integer.parseInt(d[2]);
        }

        int c = times.length - n + 1;
        int[] result = new int[c];
        for (int i = 0; i < c; i++) {
            int g = 0;
            for (int j = 0; j < n; j++) {
                g += sec[i + j];
            }
            result[i] = g / n;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] times = new String[]{"01:19:10", "01:17:40", "01:19:44", "01:17:23", "01:17:07"};
        int n = 5;
        System.out.print(new MovingAverages().calculate(times, n));
    }
}

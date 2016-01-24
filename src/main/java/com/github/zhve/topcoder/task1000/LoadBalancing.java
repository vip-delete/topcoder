package com.github.zhve.topcoder.task1000;

public class LoadBalancing {
    //TODO: TIMEOUT
    public int minTime(int[] chunkSizes) {
        int[] c = new int[chunkSizes.length];
        for (int i = 0; i < chunkSizes.length; i++) {
            c[i] = chunkSizes[i] / 1024;
        }

        boolean[] s = new boolean[c.length];
        int min = Integer.MAX_VALUE;
        while (true) {
            int cpu1 = 0;
            int cpu2 = 0;
            for (int i = 0; i < s.length; i++) {
                if (s[i]) {
                    cpu1 += c[i];
                } else {
                    cpu2 += c[i];
                }
            }
            min = Math.min(min, Math.max(cpu1, cpu2));
            int i = 0;
            while (i < s.length && s[i]) {
                s[i] = false;
                i++;
            }
            if (i == s.length) {
                return min * 1024;
            }
            s[i] = true;
        }
    }

    public static void main(String[] ar) {
        int[] r = new int[]{4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304,
                4194304, 4194304, 4194304, 4194304, 4194304};
        System.out.print(new LoadBalancing().minTime(r));
    }
}

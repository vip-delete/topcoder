package com.github.zhve.topcoder.task250;

public class Trekking {
    public int findCamps(String trail, String[] plans) {
        int result = Integer.MAX_VALUE;
        for (String plan : plans) {
            int i = 0;
            int count = 0;
            while (i < trail.length() && (trail.charAt(i) != '^' || plan.charAt(i) != 'C')) {
                if (plan.charAt(i) == 'C') {
                    count++;
                }
                i++;
            }
            if (i == trail.length() && count < result) {
                result = count;
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}

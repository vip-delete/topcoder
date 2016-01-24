package com.github.zhve.topcoder.task250;

public class OptimalList {
    public String optimize(String inst) {
        int N = 0;
        int W = 0;
        for (char c : inst.toCharArray()) {
            switch (c) {
                case 'E':
                    W--;
                    break;
                case 'N':
                    N++;
                    break;
                case 'S':
                    N--;
                    break;
                case 'W':
                    W++;
                    break;
            }
        }
        StringBuffer result = new StringBuffer(inst.length());
        if (W < 0) {
            for (int i = 0; i < -W; i++) {
                result.append('E');
            }
        }
        if (N > 0) {
            for (int i = 0; i < N; i++) {
                result.append('N');
            }
        }
        if (N < 0) {
            for (int i = 0; i < -N; i++) {
                result.append('S');
            }
        }
        if (W > 0) {
            for (int i = 0; i < W; i++) {
                result.append('W');
            }
        }
        return result.toString();
    }
}

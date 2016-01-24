package com.github.zhve.topcoder.task500;

import java.util.ArrayList;
import java.util.List;

public class LeaguePicks {
    public int[] returnPicks(int position, int friends, int picks) {
        List<Integer> list = new ArrayList<Integer>();
        if (position <= picks) {
            list.add(position);
        }

        int i = position;
        while (true) {
            i = 2 * (friends - position) + i + 1;
            if (i > picks) {
                int[] r = new int[list.size()];
                i = 0;
                for (int k : list) {
                    r[i++] = k;
                }
                return r;
            }
            list.add(i);

            i = 2 * (position) + i - 1;
            if (i > picks) {
                int[] r = new int[list.size()];
                i = 0;
                for (int k : list) {
                    r[i++] = k;
                }
                return r;
            }
            list.add(i);
        }
    }

    public static void main(String[] args) {
        int position = 1;
        int friends = 2;
        int picks = 39;
        int[] r = new LeaguePicks().returnPicks(position, friends, picks);
        int t = 0;
    }
}

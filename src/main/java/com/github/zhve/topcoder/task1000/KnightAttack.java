package com.github.zhve.topcoder.task1000;

import java.util.LinkedList;
import java.util.Queue;

public class KnightAttack {
    public String isReachable(String[] chessboard, String[] queries) {
        int X = 0;
        int Y = 0;
        int C = 0;
        int[][] data = new int[8][8];
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                char c = chessboard[y].charAt(x);
                if (c == 'N') {
                    data[y][x] = 0;
                    X = x;
                    Y = y;
                } else if (c == 'x') {
                    data[y][x] = -2;
                } else {
                    data[y][x] = -1;
                }
            }
        }

        Queue<Integer> qx = new LinkedList<Integer>();
        Queue<Integer> qy = new LinkedList<Integer>();
        Queue<Integer> qc = new LinkedList<Integer>();
        qx.add(X);
        qy.add(Y);
        qc.add(0);
        while (!qx.isEmpty()) {
            X = qx.poll();
            Y = qy.poll();
            C = qc.poll() + 1;
            int[] x = new int[]{X - 2, X - 2, X - 1, X + 1, X + 2, X + 2, X + 1, X - 1};
            int[] y = new int[]{Y + 1, Y - 1, Y - 2, Y - 2, Y - 1, Y + 1, Y + 2, Y + 2};
            for (int i = 0; i < 8; i++) {
                if (x[i] >= 0 && x[i] < 8 && y[i] >= 0 && y[i] < 8 && data[y[i]][x[i]] == -1) {
                    data[y[i]][x[i]] = C;
                    qx.add(x[i]);
                    qy.add(y[i]);
                    qc.add(C);
                }
            }
        }

        String result = "";
        String qall = "abcdefgh";
        for (String q : queries) {
            int i = 0;
            while (q.charAt(0) != qall.charAt(i)) {
                i++;
            }
            X = i;
            Y = 8 - Integer.parseInt(q.substring(1, 2));
            int count = Integer.parseInt(q.substring(3));
            result += data[Y][X] <= count && ((data[Y][X] % 2) == (count % 2)) ? "Y" : "N";
        }
        return result;
    }

    public static void main(String[] args) {
        String[] chessboard = new String[]{
                ".x.xx..x",
                ".x.x.xx.",
                "xx..xx..",
                "x.x.xx..",
                ".x.xx...",
                "x..N..xx",
                "xx....xx",
                "x.xx...."};
        String[] queries = new String[]{"b3 24", "e2 42", "e2 13", "d5 475",
                "g6 60", "h5 445", "f1 404", "a4 535",
                "e2 748", "g5 844", "d5 683", "g6 467",
                "h1 755", "h7 932", "c7 81", "c6 616",
                "h1 706", "e2 449", "c2 109", "g1 456",
                "b1 533", "b3 921", "b1 65", "e2 235",
                "b1 635", "c7 713", "d2 351", "a4 933",
                "d6 854", "a8 394", "g8 603", "e3 534",
                "h4 265", "e3 416", "a7 638", "e2 611",
                "f3 770", "e3 102", "e2 205", "f3 221",
                "c7 515", "c4 951", "b5 557", "c3 114",
                "c6 110", "f2 254", "h7 830", "c8 257", "c2 673", "b3 16"};
/*
 String[] chessboard = new String[]
 {"...x....",
 ".N......",
 "...x....",
 "..x.....",
 "..xx....",
 "....xx..",
 "...x....",
 "..x....."};
 String[] queries = new String[]{"a5 1", "b3 2", "a1 3", "c2 4", "e1 5", "g2 6"};
*/
        System.out.print(new KnightAttack().isReachable(chessboard, queries));
    }
}

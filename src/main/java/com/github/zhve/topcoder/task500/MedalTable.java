package com.github.zhve.topcoder.task500;

import java.util.*;

public class MedalTable {
    public String[] generate(String[] results) {
        Map<String, G> r = new HashMap<String, G>();
        for (String result : results) {
            String[] data = result.split(" ");
            if (!r.containsKey(data[0])) {
                r.put(data[0], new G(data[0], 0, 0, 0));
            }
            if (!r.containsKey(data[1])) {
                r.put(data[1], new G(data[1], 0, 0, 0));
            }
            if (!r.containsKey(data[2])) {
                r.put(data[2], new G(data[2], 0, 0, 0));
            }

            G t = r.get(data[0]);
            r.put(t.n, new G(t.n, t.g0 + 1, t.g1, t.g2));
            t = r.get(data[1]);
            r.put(t.n, new G(t.n, t.g0, t.g1 + 1, t.g2));
            t = r.get(data[2]);
            r.put(t.n, new G(t.n, t.g0, t.g1, t.g2 + 1));
        }

        List<G> list = new ArrayList<G>();
        for (G g : r.values()) {
            list.add(g);
        }
        Collections.sort(list);
        String[] re = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            G d = list.get(i);
            re[i] = d.n + " " + d.g0 + " " + d.g1 + " " + d.g2;
        }
        return re;
    }

    private class G implements Comparable {
        public String n;
        public int g0;
        public int g1;
        public int g2;

        public G(String n, int g0, int g1, int g2) {
            this.n = n;
            this.g0 = g0;
            this.g1 = g1;
            this.g2 = g2;
        }

        public int compareTo(Object o) {
            G y = (G) o;
            if (y.g0 != g0) {
                return y.g0 < g0 ? -1 : 1;
            }
            if (y.g1 != g1) {
                return y.g1 < g1 ? -1 : 1;
            }
            if (y.g2 != g2) {
                return y.g2 < g2 ? -1 : 1;
            }
            return n.compareTo(y.n);
        }

        public boolean equals(Object obj) {
            return n.equals(((G) obj).n);
        }
    }

    public static void main(String[] arg) {
        String[] res = new String[]{"ITA JPN AUS", "KOR TPE UKR", "KOR KOR GBR", "KOR CHN TPE"};
        String[] hh = new MedalTable().generate(res);
        int y = 1;
    }
}

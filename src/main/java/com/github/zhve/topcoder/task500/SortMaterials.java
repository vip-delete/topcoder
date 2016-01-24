package com.github.zhve.topcoder.task500;

public class SortMaterials {
    public int totalVolume(String[] data, String[] requirements) {
        int res = 0;
        for (String d : data) {
            String[] m = d.split(" ");
            int edge = Integer.parseInt(m[0]);
            int quality = Integer.parseInt(m[1]);
            String color = m[2];
            boolean ok = true;
            for (String r : requirements) {
                if (r.startsWith("E") && Integer.parseInt(r.split("=")[1]) != edge) {
                    ok = false;
                    break;
                }
                if (r.startsWith("Q") && Integer.parseInt(r.split("=")[1]) > quality) {
                    ok = false;
                    break;
                }
                if (r.startsWith("C") && !r.split("=")[1].equals(color)) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                res += edge * edge * edge;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] data = new String[]{"1 20 red", "2 30 blue", "10 1 green"};
        String[] requirements = new String[]{"QUALITY=20"};
        int result = new SortMaterials().totalVolume(data, requirements);
        System.out.print(result);
    }
}

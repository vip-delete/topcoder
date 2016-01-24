package com.github.zhve.topcoder.task1000;

import java.util.*;

public class QuantumAlchemy {
    public int minSteps(String initial, String[] reactions) {
        ArrayList<Character> initials = new ArrayList<Character>();
        for (char c : initial.toCharArray()) {
            initials.add(c);
        }

        Map<Character, ArrayList<Character>> charFromReaction = new HashMap<Character, ArrayList<Character>>();
        for (String reaction : reactions) {
            String[] data = reaction.split("->");
            ArrayList<Character> r = new ArrayList<Character>();
            for (char c : data[0].toCharArray()) {
                r.add(c);
            }
            charFromReaction.put(data[1].charAt(0), r);
        }

        Queue<Integer> qc = new LinkedList<Integer>();
        Queue<ArrayList<Character>> qr = new LinkedList<ArrayList<Character>>();

        qc.add(0);
        qr.add(initials);

        while (!qc.isEmpty()) {
            int c = qc.poll();
            ArrayList<Character> r = qr.poll();
            if (r.contains('X')) {
                return c;
            }

            for (Map.Entry<Character, ArrayList<Character>> entry : charFromReaction.entrySet()) {
                if (r.containsAll(entry.getValue())) {
                    int c_new = c + 1;

                    ArrayList<Character> r_new = (ArrayList<Character>) r.clone();
                    for (Character character : entry.getValue()) {
                        int index = r_new.indexOf(character);
                        if (index > -1) {
                            r_new.remove(index);
                        }
                    }
                    r_new.add(entry.getKey());

                    qc.add(c_new);
                    qr.add(r_new);
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String initial = "NVNNNNNVVVNNNVVNVNVVVVVNVN";
        String[] reactions = new String[]{"VNRH->D", "DR->Y", "RKD->E", "NV->H", "YDA->X", "DANR->K", "NVH->R", "HR->A"};
        System.out.print(new QuantumAlchemy().minSteps(initial, reactions));
    }
}

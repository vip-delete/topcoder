package com.github.zhve.topcoder.task1000;

public class ProblemWriting {
    public String myCheckData(String dotForm) {
        if (dotForm.length() > 25) {
            return "dotForm must contain between 1 and 25 characters, inclusive.";
        }

        int i = 0;

        while (true) {
            if (i == dotForm.length()) {
                return "dotForm is not in dot notation, check character " + i + ".";
            }
            if (dotForm.charAt(i) < '0' || dotForm.charAt(i) > '9') {
                return "dotForm is not in dot notation, check character " + i + ".";
            }
            i++;
            if (i == dotForm.length()) {
                return "";
            }

            while (i < dotForm.length() && dotForm.charAt(i) == '.') {
                i++;
            }
            if (i == dotForm.length()) {
                return "dotForm is not in dot notation, check character " + i + ".";
            }
            if (dotForm.charAt(i) != '+' && dotForm.charAt(i) != '*' && dotForm.charAt(i) != '-' && dotForm.charAt(i) != '/') {
                return "dotForm is not in dot notation, check character " + i + ".";
            }
            i++;
            while (i < dotForm.length() && dotForm.charAt(i) == '.') {
                i++;
            }
        }
    }
}

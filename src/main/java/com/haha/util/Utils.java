package com.haha.util;

public class Utils {
    public static String isNull(String s) {
        if (s.equals(""))
            return null;
        return s.trim();
    }
}

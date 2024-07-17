package com.oss.nur.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {
    public static final Pattern pattern = Pattern.compile("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");

    public static boolean isValidEmail(String str) {
        Matcher matcher = pattern.matcher(str);
        return matcher.matches();
    }

    public static boolean checkPassword(String password) {
        return true;
    }
}

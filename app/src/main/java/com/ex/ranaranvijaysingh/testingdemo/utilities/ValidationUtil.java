package com.ex.ranaranvijaysingh.testingdemo.utilities;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by on 16/02/17.
 * Purpose of this class is to
 */
public class ValidationUtil {
    private static final String REGEX_EMAIL = "^[a-zA-Z0-9.]+@[a-zA-Z0-9]+.[a-zA-Z0-9]+$";

    public static boolean isValidEmailAddress(String emailAddress) {
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(emailAddress);
        return matcher.matches();
    }
}

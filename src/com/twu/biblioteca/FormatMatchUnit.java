package com.twu.biblioteca;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class FormatMatchUnit {

    static boolean isValidLibraryNumber(String input){
        String regEx = "[0-9]{3}-[0-9]{4}";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }
}

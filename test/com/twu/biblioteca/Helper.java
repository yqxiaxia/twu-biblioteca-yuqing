package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class Helper {

    ByteArrayOutputStream systemOutput(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        return output;
    }
}

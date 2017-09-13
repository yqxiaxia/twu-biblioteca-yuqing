package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void customerGetWelcomeMassage() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        new BibliotecaApp().biblioteca("customer");
        assertEquals(output.toString(),"Welcome to Biblioteca!");
    }
}

package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void GetWelcomeMassageWhenInputCustomer() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        new BibliotecaApp().welcomeMessage("customer");
        assertEquals(output.toString(),"Welcome to Biblioteca!\n");
    }

    @Test
    public void GetBookListAfterWelcome(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        new BibliotecaApp().showBookList();
        assertEquals(output.toString(),"firstBook\n" + "secondBook\n" + "thirdBook\n" + "forthBook\n" + "fifthBook\n");
    }

}

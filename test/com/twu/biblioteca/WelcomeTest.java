package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class WelcomeTest {
    private SystemInput systemInput = mock(SystemInput.class);
    private BibliotecaApp app = new BibliotecaApp();
    private Helper helper = new Helper();

    @Test
    public void GetWelcomeMassageWhenInputRightCustomer() throws IOException {
        when(systemInput.getInputString()).thenReturn("YuqingXia");
        ByteArrayOutputStream systemOutput =helper.systemOutput();
        app.welcomeMessage(systemInput);
        assertEquals("please input your name:\n" + "Welcome YuqingXia to Biblioteca!\n\n", systemOutput.toString());
    }

    @Test
    public void ReinputWhenInputWrongCustomerName() {
        when(systemInput.getInputString()).thenReturn("onbody").thenReturn("YuqingXia");
        ByteArrayOutputStream systemOutput = helper.systemOutput();
        app.welcomeMessage(systemInput);
        assertEquals("please input your name:\n" + "User name error,please try again!\n" +
                             "please input your name:\n" + "Welcome YuqingXia to Biblioteca!\n\n", systemOutput.toString());
        verify(systemInput, times(2)).getInputString();
    }
}

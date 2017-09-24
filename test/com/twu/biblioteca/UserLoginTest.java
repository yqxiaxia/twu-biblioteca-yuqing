package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class UserLoginTest {
    private SystemInput systemInput = mock(SystemInput.class);
    private BibliotecaApp app = new BibliotecaApp();
    private Helper helper = new Helper();

    @Test
    public void GetWelcomeMassageWhenInputRightCustomer() throws IOException {
        when(systemInput.getInputString()).thenReturn("YuqingXia");
        ByteArrayOutputStream systemOutput =helper.systemOutput();
        app.userLogin(systemInput);
        assertEquals("please input your name:\n" + "Welcome YuqingXia to Biblioteca!\n\n", systemOutput.toString());
    }

    @Test
    public void ReinputWhenInputWrongCustomerName() {
        when(systemInput.getInputString()).thenReturn("onbody").thenReturn("YuqingXia");
        ByteArrayOutputStream systemOutput = helper.systemOutput();
        app.userLogin(systemInput);
        assertEquals("please input your name:\n" +
                "User name error,please try again! please input your name:\n" +
                "Welcome YuqingXia to Biblioteca!\n\n", systemOutput.toString());
        verify(systemInput, times(2)).getInputString();
    }

    @Test
    public void GetWelcomeMassageWhenInputRightLibraryNumAndPsw() throws IOException {
        when(systemInput.getInputString()).thenReturn("007-1234");
        ByteArrayOutputStream systemOutput =helper.systemOutput();
        app.userLoginWithPsw(systemInput);
        assertEquals("please input your library number:\n" +
                "Welcome 007-1234 to Biblioteca!\n\n", systemOutput.toString());
    }

    @Test
    public void showErrorMassageWhenInputInvalidLibraryNumber() throws IOException {
        when(systemInput.getInputString()).thenReturn("007-123").thenReturn("007-1234");
        ByteArrayOutputStream systemOutput =helper.systemOutput();
        app.userLoginWithPsw(systemInput);
        assertEquals("please input your library number:\n" +
                "Invalid library number,please try again! please input your library number:\n" +
                "Welcome 007-1234 to Biblioteca!\n\n", systemOutput.toString());
        verify(systemInput,times(2)).getInputString();
    }



}

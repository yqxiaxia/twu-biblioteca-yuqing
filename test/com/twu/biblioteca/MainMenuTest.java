package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MainMenuTest {

    private SystemInput systemInput = mock(SystemInput.class);
    private BibliotecaApp app = new BibliotecaApp();
    private Helper helper = new Helper();

    @Test
    public void showBookListDeatilWhenInput1() throws Exception {
        when(systemInput.getInputInt()).thenReturn(1);
        ByteArrayOutputStream systemOutput = helper.systemOutput();
        app.mainMenu(systemInput);
        assertEquals("1.List Book  2.Quit\n", systemOutput.toString());
    }

    @Test
    public void showCallTwiceWhenInputInvalidValueAndThenInput1() throws Exception {
        when(systemInput.getInputInt()).thenReturn(10).thenReturn(1);
        ByteArrayOutputStream systemOutput = helper.systemOutput();
        app.mainMenu(systemInput);
        verify(systemInput, times(2)).getInputInt();
    }

    @Test
    public void exitSystemWhenInput2() throws Exception {
//        when(systemInput.getInputInt()).thenReturn(2);
//        ByteArrayOutputStream systemOutput = helper.systemOutput();
//        app.mainMenu(systemInput);
    }

}
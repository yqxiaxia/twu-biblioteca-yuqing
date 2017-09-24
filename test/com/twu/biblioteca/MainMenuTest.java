package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.Assertion;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class MainMenuTest {

    private SystemInput systemInput = mock(SystemInput.class);
    private BibliotecaApp app = new BibliotecaApp();
    private Helper helper = new Helper();
    private ByteArrayOutputStream systemOutput = helper.systemOutput();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void showBookListDeatilWhenInput1() throws Exception {
        when(systemInput.getInputInt()).thenReturn(1).thenReturn(3);
        exit.expectSystemExitWithStatus(0);
        exit.checkAssertionAfterwards(new Assertion() {
            public void checkAssertion() throws Exception {
                assertEquals("1.List Books 2.List Movies 3.Quit\n" +
                        "--------------------------------BookList Detail--------------------------------\n" +
                        "\n" + "1.Check-out 2.Return Book 3.Quit\n", systemOutput.toString());
                verify(systemInput, times(2)).getInputInt();
            }
        });
        app.mainMenu(systemInput);

    }

    @Test
    public void showCallTwiceWhenInputInvalidValueAndThenInput1() throws Exception {
        when(systemInput.getInputInt()).thenReturn(10).thenReturn(3);
        exit.expectSystemExitWithStatus(0);
        exit.checkAssertionAfterwards(new Assertion() {
            public void checkAssertion() throws Exception {
                verify(systemInput, times(2)).getInputInt();
            }
        });
        app.mainMenu(systemInput);
    }

    @Test
    public void exitSystemWhenInput3() throws Exception {
        when(systemInput.getInputInt()).thenReturn(3);
        exit.expectSystemExitWithStatus(0);
        app.mainMenu(systemInput);
    }

    @Test
    public void showMovieListWhenInput2() throws Exception {
        when(systemInput.getInputInt()).thenReturn(2).thenReturn(2);
        exit.expectSystemExitWithStatus(0);
        exit.checkAssertionAfterwards(new Assertion() {
            public void checkAssertion() throws Exception {
                verify(systemInput, times(2)).getInputInt();
                assertEquals("1.List Books 2.List Movies 3.Quit\n" +
                        "--------------------------------MovieList Detail--------------------------------\n\n"
                        + "1.Check-out Movie 2.Quit\n",systemOutput.toString());
            }
        });
        app.mainMenu(systemInput);

    }

}

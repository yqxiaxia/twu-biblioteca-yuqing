package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.Assertion;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CheckOutMovieTest {
    private SystemInput systemInput = mock(SystemInput.class);
    private BibliotecaApp app = new BibliotecaApp();
    private Helper helper = new Helper();
    private final ByteArrayOutputStream systemOutput = helper.systemOutput();
    private final ArrayList<Movie> movieList = helper.createMovieListInTest();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldSetInLibraryFalseWhenInputCheckOutMovieNumber() throws Exception {
        when(systemInput.getInputInt()).thenReturn(1).thenReturn(1).thenReturn(2);

        exit.expectSystemExitWithStatus(0);
        exit.checkAssertionAfterwards(new Assertion() {
            public void checkAssertion() throws Exception {
                verify(systemInput, times(3)).getInputInt();
                assertEquals(false,movieList.get(1).isInLibrary());
                assertEquals("1.Check-out Movie 2.Quit\n" +
                        "Please input Check-out book id:\n" +
                        "Thank you! Enjoy the movie\n" +
                        "1.Check-out Movie 2.Quit\n", systemOutput.toString());
            }
        });
        app.movieManageMenu(systemInput, movieList);
    }
}

package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class ReturnBookTest {

    private SystemInput systemInput = mock(SystemInput.class);
    private BibliotecaApp app = new BibliotecaApp();
    private Helper helper = new Helper();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldSetInLibraryTrueWhenInputReturnBookNumber() throws Exception {
        when(systemInput.getInputInt()).thenReturn(2).thenReturn(1);
        ByteArrayOutputStream systemOutput = helper.systemOutput();
        ArrayList<Book> bookList = helper.createBookListHasCheckout();
        app.bookManageMenu(systemInput, bookList);
        verify(systemInput, times(2)).getInputInt();
        assertEquals(true,bookList.get(1).isInLibrary());
        assertEquals("1.Check-out 2.Return Book 3.Quit\n" +
                "Please input return book id:\n" +
                "Thank you for returning the book.\n",systemOutput.toString());
    }

    @Test
    public void shouldCallTwiceWhenInputInvalidAndThenInputValidNumber() throws Exception {
        when(systemInput.getInputInt()).thenReturn(2).thenReturn(10).thenReturn(1);
        ArrayList<Book> bookList = helper.createBookListHasCheckout();
        app.bookManageMenu(systemInput, bookList);
        verify(systemInput, times(3)).getInputInt();
        assertEquals(true,bookList.get(1).isInLibrary());
    }

}

package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CheckBookTest {

    private SystemInput systemInput = mock(SystemInput.class);
    private BibliotecaApp app = new BibliotecaApp();
    private Helper helper = new Helper();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldRemoveOneBookInBookListWhenInputBookNumber() throws Exception {
        when(systemInput.getInputInt()).thenReturn(1).thenReturn(1);
        ByteArrayOutputStream systemOutput = helper.systemOutput();
        ArrayList<Book> bookList = helper.createBookListInTest();
        app.bookManageMenu(systemInput, bookList);
        verify(systemInput, times(2)).getInputInt();
        assertEquals(bookList.size(), 2);
        assertEquals("1.Check-out 2.Return Book 3.Quit\n" +
                "Please input Check-out book id:\n" +
                "Thank you! Enjoy the book\n", systemOutput.toString());
    }

    @Test
    public void shouldCallTwiceWhenInputInvaildAndThenInputVaildNumber() throws Exception {
        when(systemInput.getInputInt()).thenReturn(1).thenReturn(10).thenReturn(1);
        ByteArrayOutputStream systemOutput = helper.systemOutput();
        ArrayList<Book> bookList = helper.createBookListInTest();
        app.bookManageMenu(systemInput, bookList);
        verify(systemInput, times(3)).getInputInt();
        assertEquals(bookList.size(), 2);
        assertEquals("1.Check-out 2.Return Book 3.Quit\n" +
                "Please input Check-out book id:\n" +
                "That book is not available, Please input Check-out book id:\n" +
                "Thank you! Enjoy the book\n", systemOutput.toString());
    }

    @Test
    public void shouldCallOnceAndExitWhenChooseQiut() throws Exception {
        when(systemInput.getInputInt()).thenReturn(3);
        ArrayList<Book> bookList = helper.createBookListInTest();
        exit.expectSystemExitWithStatus(0);
        app.bookManageMenu(systemInput, bookList);
        verify(systemInput, times(1)).getInputInt();
    }

}

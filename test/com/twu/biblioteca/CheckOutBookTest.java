package com.twu.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.Assertion;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CheckOutBookTest {

    private SystemInput systemInput = mock(SystemInput.class);
    private BibliotecaApp app = new BibliotecaApp();
    private Helper helper = new Helper();
    private final ByteArrayOutputStream systemOutput = helper.systemOutput();
    private final ArrayList<Book> bookList = helper.createBookListInTest();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldSetInLibraryFalseWhenInputCheckOutBookNumber() throws Exception {
        when(systemInput.getInputInt()).thenReturn(1).thenReturn(1).thenReturn(3);

        exit.expectSystemExitWithStatus(0);
        exit.checkAssertionAfterwards(new Assertion() {
            public void checkAssertion() throws Exception {
                verify(systemInput, times(3)).getInputInt();
                assertEquals(false,bookList.get(1).isInLibrary());
                assertEquals("1.Check-out 2.Return Book 3.Quit\n" +
                        "Please input Check-out book id:\n" +
                        "Thank you! Enjoy the book\n" +
                        "1.Check-out 2.Return Book 3.Quit\n", systemOutput.toString());
            }
        });
        app.bookManageMenu(systemInput, bookList);
    }

    @Test
    public void shouldCallTwiceWhenInputInvalidAndThenInputValidNumber() throws Exception {
        when(systemInput.getInputInt()).thenReturn(1).thenReturn(10).thenReturn(1).thenReturn(3);
        final ArrayList<Book> bookList = helper.createBookListInTest();
        exit.expectSystemExitWithStatus(0);
        exit.checkAssertionAfterwards(new Assertion() {
            public void checkAssertion() throws Exception {
                verify(systemInput, times(4)).getInputInt();
                assertEquals("1.Check-out 2.Return Book 3.Quit\n" +
                        "Please input Check-out book id:\n" +
                        "That book is not available, Please input Check-out book id:\n" +
                        "Thank you! Enjoy the book\n" +
                        "1.Check-out 2.Return Book 3.Quit\n", systemOutput.toString());
            }
        });
        app.bookManageMenu(systemInput, bookList);
    }

    @Test
    public void shouldCallOnceAndExitWhenChooseQiut() throws Exception {
        when(systemInput.getInputInt()).thenReturn(3);
        ArrayList<Book> bookList = helper.createBookListInTest();
        exit.expectSystemExitWithStatus(0);
        exit.checkAssertionAfterwards(new Assertion() {
            public void checkAssertion() throws Exception {
                verify(systemInput, times(1)).getInputInt();
            }
        });
        app.bookManageMenu(systemInput, bookList);
    }

}

package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class CheckBookTest {

        private SystemInput systemInput = mock(SystemInput.class);
        private BibliotecaApp app = new BibliotecaApp();
        private Helper helper = new Helper();

        @Test
        public void shouldRemoveOneBookInBookListWhenInputBookNumber() throws Exception {
            when(systemInput.getInputInt()).thenReturn(1).thenReturn(1);
            ByteArrayOutputStream systemOutput =helper.systemOutput();
            ArrayList<Book> bookList = helper.createBookListInTest();
            app.chooseCheckoutBook(systemInput,bookList);
            verify(systemInput,times(2)).getInputInt();
            assertEquals(bookList.size(),2);
            assertEquals("1.Check-out 2.Quit\n" +
                    "Please input Check-out book id:\n" +
                    "Thank you! Enjoy the book\n", systemOutput.toString());
        }

        @Test
        public void shouldCallTwiceWhenInputInvaildAndThenInputVaildNumber() throws Exception {
            when(systemInput.getInputInt()).thenReturn(1).thenReturn(10).thenReturn(1);
            ByteArrayOutputStream systemOutput =helper.systemOutput();
            ArrayList<Book> bookList = helper.createBookListInTest();
            app.chooseCheckoutBook(systemInput,bookList);
            verify(systemInput,times(3)).getInputInt();
            assertEquals(bookList.size(),2);
            assertEquals("1.Check-out 2.Quit\n" +
                    "Please input Check-out book id:\n" +
                    "That book is not available, Please input Check-out book id:\n" +
                    "Thank you! Enjoy the book\n", systemOutput.toString());
        }

}

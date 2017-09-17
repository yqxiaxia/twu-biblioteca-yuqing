package com.twu.biblioteca;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class GetBookListTest {

    private BibliotecaApp app = new BibliotecaApp();
    private Helper helper = new Helper();

    @Test
    public void GetBookNameList(){

        ArrayList<Book> bookList = helper.createBookListInTest();
        ByteArrayOutputStream systemOutput =helper.systemOutput();
        app.showBookList(bookList);
        assertEquals("testbook-0\n" +
                "testbook-1\n" +
                "testbook-2\n",systemOutput.toString());
    }

    @Test
    public void GetBookDetailList(){

        ArrayList<Book> bookList = helper.createBookListInTest();
        ByteArrayOutputStream systemOutput =helper.systemOutput();
        app.showBookListDetial(bookList);
        assertEquals("0 | testbook-0 | test-0 | 2017-10-00\n" +
                "1 | testbook-1 | test-1 | 2017-10-01\n" +
                "2 | testbook-2 | test-2 | 2017-10-02\n",systemOutput.toString());
    }

}

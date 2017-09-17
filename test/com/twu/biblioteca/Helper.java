package com.twu.biblioteca;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

class Helper {

    ByteArrayOutputStream systemOutput(){
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        return output;
    }

    ArrayList<Book> createBookListInTest(){
        ArrayList<Book> bookList = new ArrayList<Book>();
        for (int i = 0; i < 3; i++) {
            Book book = new Book();
            book.setBookId(i);
            book.setBookName("testbook-" + i);
            book.setBookAuthor("test-" + i);
            book.setBookPubliced("2017-10-0" + i);
            bookList.add(book);
        }
        return bookList;
    }
}

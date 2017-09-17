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
        for (int i = 0; i < 2; i++) {
            Book book = new Book();
            book.setBookId(i);
            book.setBookName("testbook-" + i);
            book.setBookAuthor("test-" + i);
            book.setBookPubliced("2017-10-0" + i);
            book.setInLibrary(true);
            bookList.add(book);
        }
        return bookList;
    }

    ArrayList<Book> createBookListHasCheckout(){
        ArrayList<Book> bookList = new ArrayList<Book>();
        for (int i = 0; i < 2; i++) {
            Book book = new Book();
            book.setBookId(i);
            book.setBookName("testbook-" + i);
            book.setBookAuthor("test-" + i);
            book.setBookPubliced("2017-10-0" + i);
            if(i == 0){
                book.setInLibrary(true);
            }else {
                book.setInLibrary(false);
            }
            bookList.add(book);
        }
        return bookList;
    }
}

package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> bookList = new ArrayList<Book>();

    ArrayList<Book> getBookList() {
        return bookList;
    }

    void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    void initBookDetails() {
        ArrayList<Book> bookList = new ArrayList<Book>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setBookId(i);
            book.setBookName("book-" + i);
            book.setBookAuthor("yuqing-" + i);
            book.setBookPubliced("2017-09-0" + i);
            bookList.add(book);
        }
        setBookList(bookList);
    }

}

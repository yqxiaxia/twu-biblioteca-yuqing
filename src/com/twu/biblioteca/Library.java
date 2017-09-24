package com.twu.biblioteca;

import java.util.ArrayList;

class Library {

    private ArrayList<Book> bookList = new ArrayList<Book>();

    ArrayList<Book> getBookList() {
        return bookList;
    }

    private void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    void initBookDetails() {
        ArrayList<Book> bookList = FileUnit.readFromFile("Library_Store.txt");
        setBookList(bookList);
    }

}

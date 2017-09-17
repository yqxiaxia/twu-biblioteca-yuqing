package com.twu.biblioteca;

public class Book {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private boolean inLibrary;

    public boolean isInLibrary() {
        return inLibrary;
    }

    public void setInLibrary(boolean inLibrary) {
        this.inLibrary = inLibrary;
    }

    int getBookId() {
        return bookId;
    }

    void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPubliced() {
        return bookPubliced;
    }

    public void setBookPubliced(String bookPubliced) {
        this.bookPubliced = bookPubliced;
    }

    private String bookPubliced;
}

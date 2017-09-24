package com.twu.biblioteca;

public class Book {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private boolean inLibrary;
    private String bookPubliced;

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
        if (bookName == null){
            bookName = "bookName";
        }
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        if (bookAuthor == null){
            bookAuthor = "bookAuthor";
        }
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPubliced() {
        if (bookPubliced == null){
            bookPubliced = "bookPubliced";
        }
        return bookPubliced;
    }

    public void setBookPubliced(String bookPubliced) {
        this.bookPubliced = bookPubliced;
    }
}

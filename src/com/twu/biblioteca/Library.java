package com.twu.biblioteca;

import java.util.ArrayList;

class Library {

    private ArrayList<Book> bookList = new ArrayList<Book>();
    private ArrayList<Movie> movieList = new ArrayList<Movie>();

    ArrayList<Book> getBookList() {
        return bookList;
    }

    private void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }

    void initBookDetails() {
        ArrayList<Book> bookList = FileUnit.readBookFromFile("Library_Book_Store.txt");
        setBookList(bookList);
    }

    void initMovieDetails(){
        ArrayList<Movie> movieList = FileUnit.readMovieFromFile("Library_Movie_Store.txt");
        setMovieList(movieList);
    }

}

package com.twu.biblioteca;

import java.util.ArrayList;

class Library {

    private ArrayList<Book> bookList = new ArrayList<Book>();
    private ArrayList<Movie> movieList = new ArrayList<Movie>();
    private ArrayList<User> userList;

    ArrayList<User> getUserList() {
        return userList;
    }

    void setUserList(ArrayList<User> userList) {
        this.userList = userList;
    }

    ArrayList<Book> getBookList() {
        return bookList;
    }

    private void setBookList(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    ArrayList<Movie> getMovieList() {
        return movieList;
    }

    private void setMovieList(ArrayList<Movie> movieList) {
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

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

    ArrayList<Movie> createMovieListInTest(){
        ArrayList<Movie> movieList = new ArrayList<Movie>();
        for (int i = 0; i < 2; i++) {
            Movie movie = new Movie();
            movie.setMovieId(i);
            movie.setName("movie-"+i);
            movie.setDirector("yuqing-"+i);
            movie.setYear("2017-"+i);
            movie.setRating("10");
            movie.setInLibrary(true);
            movieList.add(movie);
        }
        return movieList;
    }

    User createUserInfoTest() {
        User user = new User();
        user.setLibraryNumber("007-1234");
        user.setName("YuqingXia");
        user.setPassword("123456");
        user.setPhoneNumber("13545092422");
        user.setEmail("yqxia@thoughtworks.com");
        user.setAddress("Wuhan");
        return user;
    }
}

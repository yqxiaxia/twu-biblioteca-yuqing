package com.twu.biblioteca;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();

        System.out.println("-------------------------------Biblioteca System-------------------------------");
        System.out.println("please input your name:");
        Scanner input = new Scanner(System.in);
        String str = input.next();

        app.welcomeMessage(str);
        System.out.println("-------------------------------BookList-------------------------------");
        app.showBookList(app.createBooks());

        System.out.println("-------------------------------BookList Detail-------------------------------");
        app.showBookListDetial(app.createBookDetails());

    }

    void welcomeMessage(String str) {
        if (str.equals("customer")) {
            System.out.println("Welcome to Biblioteca!");
        }
    }

    void showBookList(ArrayList<String> bookList) {
        for (String book: bookList) {
            System.out.println(book);
        }
    }

    void showBookListDetial(ArrayList<Book> bookList) {
        for (Book book: bookList) {
            System.out.println(book.getBookName() + " | " + book.getBookAuthor() + " | " + book.getBookPubliced());
        }
    }

    private ArrayList<Book> createBookDetails(){
        ArrayList<Book> bookList = new ArrayList<Book>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setBookId(i);
            book.setBookName("book-"+i);
            book.setBookAuthor("yuqing-"+i);
            book.setBookPubliced("2017-09-0"+i);
            bookList.add(book);
        }
        return bookList;
    }

    private ArrayList<String> createBooks(){
        ArrayList<String> bookList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            bookList.add("book-"+i);
        }
        return bookList;
    }


}

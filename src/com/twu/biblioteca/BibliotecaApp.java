package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();

        System.out.println("please input your name:");
        Scanner input = new Scanner(System.in);
        String str = input.next();

        app.welcomeMessage(str);
        System.out.println("================BookList================");
        app.showBookList();
    }

    void welcomeMessage(String str) {
        if (str.equals("customer")) {
            System.out.println("Welcome to Biblioteca!");
        }
    }

    void showBookList() {
        String[] bookList = {"firstBook","secondBook","thirdBook","forthBook","fifthBook"};
        for (String book: bookList) {
            System.out.println(book);
        }
    }


}

package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();

        System.out.println("please input your name:");
        Scanner input = new Scanner(System.in);
        String str = input.next();

        app.biblioteca(str);
    }

    void biblioteca(String str) {

        if (str.equals("customer")) {
            System.out.print("Welcome to Biblioteca!");
        }
    }


}

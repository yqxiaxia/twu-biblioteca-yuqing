package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();

        System.out.println("-------------------------------Biblioteca System-------------------------------");
        System.out.println("please input your name:");
        Scanner input = new Scanner(System.in);
        String strWelcome = input.next();
        app.welcomeMessage(strWelcome);

        app.mainMenu();

        System.out.println("-------------------------------BookList Detail-------------------------------");
        app.showBookListDetial(app.createBookDetails());

    }

    private void mainMenu() {
        Scanner input = new Scanner(System.in);
        boolean showList = true;
        while (showList){
            System.out.println("1.List Books 2.Quit");
            int menuOption = -1;

            try {
                menuOption = input.nextInt();
            }catch(Exception e){
                input = new Scanner(System.in);
            }

            switch (menuOption){
                case 1:
                    System.out.println("-------------------------------BookList-------------------------------");
                    showBookList(createBooks());
                    showList = false;
                    break;
                case 2:
                    System.exit(0);
                    showList = false;
                    break;
                default:
                    System.out.println("Select a valid option!");
                    break;

            }
        }
    }

    void welcomeMessage(String str) {
        if (str.equals("customer")) {
            System.out.println("Welcome to Biblioteca!");
        }
    }

    static void showBookList(ArrayList<String> bookList) {
        for (String book: bookList) {
            System.out.println(book);
        }
    }

    private static ArrayList<String> createBooks(){
        ArrayList<String> bookList = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            bookList.add("book-"+i);
        }
        return bookList;
    }

    void showBookListDetial(ArrayList<Book> bookList) {
        for (Book book: bookList) {
            System.out.println(book.getBookName() + " | " + book.getBookAuthor() + " | " + book.getBookPubliced());
        }
    }

    private static ArrayList<Book> createBookDetails(){
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

}

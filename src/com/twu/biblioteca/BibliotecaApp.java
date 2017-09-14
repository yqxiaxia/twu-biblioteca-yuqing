package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    public static Library library = new Library();

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();

        library.setBookList(createBookDetails());

        System.out.println("-------------------------------Biblioteca System-------------------------------");
        System.out.println("please input your name:");
        Scanner input = new Scanner(System.in);
        String strWelcome = input.next();
        app.welcomeMessage(strWelcome);

        app.mainMenu();
        app.chooseCheckoutBook();

    }

    private void mainMenu() {
        Scanner input = new Scanner(System.in);
        boolean showList = true;
        while (showList) {
            System.out.println("1.List Books 2.Quit");
            int menuOption = -1;

            try {
                menuOption = input.nextInt();
            } catch (Exception e) {
                input = new Scanner(System.in);
            }

            switch (menuOption) {
                case 1:
                    System.out.println("-------------------------------BookList Detail-------------------------------");
                    showBookListDetial(createBookDetails());
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

    private void chooseCheckoutBook() {
        Scanner input = new Scanner(System.in);
        boolean showCheckout = true;
        while (showCheckout) {
            System.out.println("1.Check-out 2.Quit");

            int listOption = -1;

            try {
                listOption = input.nextInt();
            } catch (Exception e) {
                input = new Scanner(System.in);
            }

            switch (listOption) {
                case 1:
                    System.out.print("Check-out book id:");
                    input = new Scanner(System.in);
                    checkoutBook(input);
                    showCheckout = false;
                    break;
                case 2:
                    System.exit(0);
                    showCheckout = false;
                    break;
                default:
                    System.out.println("Select a valid option!");
                    break;

            }

        }
    }

    private void checkoutBook(Scanner input) {
        boolean hasBook = false;
        boolean checkoutBook = true;

        while (checkoutBook) {
            int checekOutBookId = -1;
            try {
                checekOutBookId = input.nextInt();
            } catch (Exception e) {
                System.out.println("Select a valid option!");
                input = new Scanner(System.in);
            }
            ArrayList<Book> bookList = library.getBookList();
            if (library.getBookList().size() > 0 && checekOutBookId > -1) {
                for (Book book : bookList) {
                    if (book.getBookId() == checekOutBookId) {
                        bookList.remove(book);
                        hasBook = true;
                        checkoutBook = false;
                        break;
                    }
                }
                if (hasBook) {
                    System.out.println("Thank you! Enjoy the book");
                } else {
                    System.out.println("That book is not available");
                }
            } else {
                System.out.println("That book is not available");

            }
        }


    }


    void welcomeMessage(String str) {
        if (str.equals("customer")) {
            System.out.println("Welcome to Biblioteca!");
        }else {
            System.out.println("User name error!");
            System.exit(0);
        }
    }

    static void showBookList(ArrayList<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book.getBookName());
        }
    }

    static void showBookListDetial(ArrayList<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book.getBookId() + " | " + book.getBookName() + " | " + book.getBookAuthor() + " | " + book.getBookPubliced());
        }
    }

    private static ArrayList<Book> createBookDetails() {
        ArrayList<Book> bookList = new ArrayList<Book>();
        for (int i = 0; i < 10; i++) {
            Book book = new Book();
            book.setBookId(i);
            book.setBookName("book-" + i);
            book.setBookAuthor("yuqing-" + i);
            book.setBookPubliced("2017-09-0" + i);
            bookList.add(book);
        }
        return bookList;
    }

}

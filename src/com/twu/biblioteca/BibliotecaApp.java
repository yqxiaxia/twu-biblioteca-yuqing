package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaApp {

    private static Library library = new Library();

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        SystemInput systemInput = new SystemInput();
        library.initBookDetails();

        System.out.println("-------------------------------Biblioteca System-------------------------------");

        app.welcomeMessage(systemInput);
        app.mainMenu(systemInput);
        System.out.println("--------------------------------BookList Detail--------------------------------");
        showBookListDetial(library.getBookList());
        app.chooseCheckoutBook(systemInput);
        app.checkoutBook(systemInput);
        app.chooseCheckoutBook(systemInput);
        System.out.println("--------------------------------BookList Detail--------------------------------");
        showBookListDetial(library.getBookList());

    }

    void mainMenu(SystemInput systemInput) {
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1.List Book  2.Quit");
            int menuOption;
            try {
                menuOption = systemInput.getInputInt();
            } catch (Exception e) {
                menuOption = -1;
            }
            switch (menuOption) {
                case 1:
                    showMenu = false;
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Select a valid option!\n");
                    break;
            }
        }
    }

    private void chooseCheckoutBook(SystemInput systemInput) {
        boolean showCheckout = true;
        while (showCheckout) {
            System.out.println("1.Check-out 2.Quit");

            int checkOption;
            try {
                checkOption = systemInput.getInputInt();
            } catch (Exception e) {
                checkOption = -1;
            }

            switch (checkOption) {
                case 1:
                    showCheckout = false;
                    break;
                case 2:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Select a valid option!");
                    break;
            }
        }
    }

    private void checkoutBook(SystemInput systemInput) {
        boolean hasBook = false;
        boolean checkoutBook = true;

        while (checkoutBook) {
            System.out.println("Please input Check-out book id:");

            int checekOutBookId;
            try {
                checekOutBookId = systemInput.getInputInt();
            } catch (Exception e) {
                checekOutBookId = -1;
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
                    System.out.print("That book has Checked out,");
                }
                hasBook = false;
            } else {
                System.out.print("That book is not available,");

            }
        }


    }


    void welcomeMessage(SystemInput systemInput) {
        while (true) {
            System.out.println("please input your name:");

            String name = systemInput.getInputString();
            if (name.equals("YuqingXia")) {
                System.out.println("Welcome " + name + " to Biblioteca!\n");
                break;
            } else {
                System.out.println("User name error,please try again!");
            }
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
}

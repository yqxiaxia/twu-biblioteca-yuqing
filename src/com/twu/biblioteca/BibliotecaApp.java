package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    private static Library library = new Library();

    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        SystemInput systemInput = new SystemInput();
        library.initBookDetails();

        System.out.println("-------------------------------Biblioteca System-------------------------------");
        app.userLogin(systemInput);
        app.mainMenu(systemInput);
        System.out.println("--------------------------------BookList Detail--------------------------------");
        app.showBookListDetial(library.getBookList());
        System.out.println();
        app.bookManageMenu(systemInput,library.getBookList());

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
                    System.out.print("Select a valid option! ");
                    break;
            }
        }
    }

    void bookManageMenu(SystemInput systemInput, ArrayList<Book> bookList) {
        while (true) {
            System.out.println("1.Check-out 2.Return Book 3.Quit");

            int checkOption;
            try {
                checkOption = systemInput.getInputInt();
            } catch (Exception e) {
                checkOption = -1;
            }

            switch (checkOption) {
                case 1:
                    checkoutBook(systemInput, bookList);
                    break;
                case 2:
                    returnBook(systemInput,bookList);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.print("Select a valid option! ");
                    break;
            }
        }
    }

    private void checkoutBook(SystemInput systemInput, ArrayList<Book> bookList) {
        boolean checkoutBook = true;

        while (checkoutBook) {
            System.out.println("Please input Check-out book id:");

            int checekOutBookId;
            try {
                checekOutBookId = systemInput.getInputInt();
            } catch (Exception e) {
                checekOutBookId = -1;
            }

            checkoutBook = removeBookById(bookList,checekOutBookId);
        }
    }

    private boolean removeBookById(ArrayList<Book> bookList,int checekOutBookId){
        boolean checkoutBook = true;
        boolean hasBook = false;
        if (bookList.size() > 0 && checekOutBookId != -1) {
            for (Book book : bookList) {
                if (book.getBookId() == checekOutBookId && book.isInLibrary()) {
                    book.setInLibrary(false);
                    hasBook = true;
                    checkoutBook = false;
                    break;
                }
            }
            if (hasBook) {
                System.out.println("Thank you! Enjoy the book");
            } else {
                System.out.print("That book is not available, ");
            }
        } else {
            System.out.print("That book is not available, ");
        }
        return checkoutBook;
    }


    private void returnBook(SystemInput systemInput,ArrayList<Book> bookList){
        boolean returnBook = true;

        while (returnBook) {
            System.out.println("Please input return book id:");

            int returnBookId;
            try {
                returnBookId = systemInput.getInputInt();
            } catch (Exception e) {
                returnBookId = -1;
            }

            returnBook = addBookById(bookList,returnBookId);
        }
    }

    private boolean addBookById(ArrayList<Book> bookList, int returnBookId) {
        boolean returnBook = true;
        boolean hasBook = false;
        if (bookList.size() > 0 && returnBookId != -1) {
            for (Book book : bookList) {
                if (book.getBookId() == returnBookId && !book.isInLibrary()) {
                    book.setInLibrary(true);
                    returnBook = false;
                    hasBook = true;
                    break;
                }
            }
            if (hasBook){
                System.out.println("Thank you for returning the book.");
            }else {
                System.out.print("That is not a valid book to return. ");
            }

        } else {
            System.out.print("That is not a valid book to return. ");
        }
        return returnBook;
    }


    void userLogin(SystemInput systemInput) {
        while (true) {
            System.out.println("please input your name:");

            String name = systemInput.getInputString();
            if (name.equals("YuqingXia")) {
                System.out.println("Welcome " + name + " to Biblioteca!\n");
                break;
            } else {
                System.out.print("User name error,please try again! ");
            }
        }
    }

    void showBookList(ArrayList<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book.getBookName());
        }
    }

    void showBookListDetial(ArrayList<Book> bookList) {
        for (Book book : bookList) {
            System.out.println(book.getBookId() + " | " + book.getBookName() + " | "
                             + book.getBookAuthor() + " | " + book.getBookPubliced() + " | "
                             + book.isInLibrary());
        }
    }
}

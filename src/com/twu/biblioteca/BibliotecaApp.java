package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    private static Library library = new Library();
    private static User user = new User();
    private static String bookFileName = "Library_Book_Store.txt";
    private static String movieFileName = "Library_Movie_Store.txt";


    public static void main(String[] args) {
        BibliotecaApp app = new BibliotecaApp();
        SystemInput systemInput = new SystemInput();
        library.initBookDetails();
        library.initMovieDetails();
        user.initUserInfo();

        System.out.println("-------------------------------Biblioteca System-------------------------------");
        app.userLoginWithPsw(systemInput, user.getUser());
        app.mainMenu(systemInput);

    }

    void mainMenu(SystemInput systemInput) {
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1.List Books 2.List Movies 3.Quit 4.show my information");
            int menuOption;
            try {
                menuOption = systemInput.getInputInt();
            } catch (Exception e) {
                menuOption = -1;
            }
            switch (menuOption) {
                case 1:
                    showMenu = false;
                    System.out.println("--------------------------------BookList Detail--------------------------------");
                    showBookListDetial(library.getBookList());
                    System.out.println();
                    bookManageMenu(systemInput,library.getBookList());
                    break;
                case 2:
                    showMenu = false;
                    System.out.println("--------------------------------MovieList Detail--------------------------------");
                    showMovieListDetial(library.getMovieList());
                    System.out.println();
                    movieManageMenu(systemInput,library.getMovieList());
                    break;
                case 3:
                    System.exit(0);
                    break;
                case 4:
                    showUserInfo(user.getUser());
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
                FileUnit.writeBookToFile(bookFileName,library.getBookList());
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
                FileUnit.writeBookToFile(bookFileName,library.getBookList());
            }else {
                System.out.print("That is not a valid book to return. ");
            }

        } else {
            System.out.print("That is not a valid book to return. ");
        }
        return returnBook;
    }

    void movieManageMenu(SystemInput systemInput,ArrayList<Movie> movieList){
        while (true) {
            System.out.println("1.Check-out Movie 2.Quit");

            int checkOption;
            try {
                checkOption = systemInput.getInputInt();
            } catch (Exception e) {
                checkOption = -1;
            }

            switch (checkOption) {
                case 1:
                    checkoutMovie(systemInput, movieList);
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

    void checkoutMovie(SystemInput systemInput, ArrayList<Movie> movieList){
        boolean checkoutMovie = true;

        while (checkoutMovie) {
            System.out.println("Please input Check-out book id:");

            int checekOutMovieId;
            try {
                checekOutMovieId = systemInput.getInputInt();
            } catch (Exception e) {
                checekOutMovieId = -1;
            }

            checkoutMovie = removeMovieById(movieList,checekOutMovieId);
        }
    }

    private boolean removeMovieById(ArrayList<Movie> movieList,int checkOutMovieId){
        boolean checkoutMovie = true;
        boolean hasMovie = false;
        if (movieList.size() > 0 && checkOutMovieId != -1) {
            for (Movie movie : movieList) {
                if (movie.getMovieId() == checkOutMovieId && movie.isInLibrary()) {
                    movie.setInLibrary(false);
                    hasMovie = true;
                    checkoutMovie = false;
                    break;
                }
            }
            if (hasMovie) {
                System.out.println("Thank you! Enjoy the movie");
                FileUnit.writeMovieToFile(movieFileName,library.getMovieList());
            } else {
                System.out.print("That movie is not available, ");
            }
        } else {
            System.out.print("That movie is not available, ");
        }
        return checkoutMovie;
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

    void userLoginWithPsw(SystemInput systemInput, User user) {
        while (true) {
            System.out.println("please input your library number:");
            String libraryNum = systemInput.getInputString();
            if (FormatMatchUnit.isValidLibraryNumber(libraryNum)){
                if (libraryNum.equals(user.getLibraryNumber())) {
                    System.out.println("please input your password:");
                    String psw = systemInput.getInputString();
                    if (psw.equals(user.getPassword())){
                        System.out.println("Welcome " + libraryNum + " to Biblioteca!\n");
                        break;
                    }else {
                        System.out.println("Error password,please try again!");
                    }
                } else {
                    System.out.print("Library number error,please try again! ");
                }
            }else {
                System.out.print("Invalid library number,please try again! ");
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

    void showMovieListDetial(ArrayList<Movie> movieList) {

        for (Movie movie:movieList) {
            System.out.println(movie.getMovieId() + " | " + movie.getName() + " | "
                    + movie.getDirector() + " | " + movie.getYear() + " | "
                    + movie.getRating() + " | " + movie.isInLibrary());
        }
    }

    void showUserInfo(User user) {
        System.out.println(user.getLibraryNumber() + " | " + user.getName() + " | "
                + user.getPhoneNumber() + " | " + user.getEmail()
                + " | " + user.getAddress());
    }
}

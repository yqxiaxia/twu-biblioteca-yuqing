package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;

public class FileUnit {

    public static ArrayList<Book> readBookFromFile(String fileName) {
        ArrayList<Book> list = new ArrayList<Book>();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                list.add(getBookFromLine(temp.split(",")));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static Book getBookFromLine(String[] str) {
        Book book= new Book();
        book.setBookId(Integer.parseInt(str[0]));
        book.setBookName(str[1]);
        book.setBookAuthor(str[2]);
        book.setBookPubliced(str[3]);
        book.setInLibrary(Boolean.parseBoolean(str[4]));
        return book;
    }

    public static ArrayList<Movie> readMovieFromFile(String fileName) {
        ArrayList<Movie> list = new ArrayList<Movie>();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                list.add(getMovieFromLine(temp.split(",")));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private static Movie getMovieFromLine(String[] str) {
        Movie movie= new Movie();
        movie.setMovieId(Integer.parseInt(str[0]));
        movie.setName(str[1]);
        movie.setDirector(str[2]);
        movie.setYear(str[3]);
        movie.setRating(str[4]);
        movie.setInLibrary(Boolean.parseBoolean(str[5]));
        return movie;
    }

    public static User readUserFromFile(String fileName) {
        User user = new User();
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String temp = null;
            while ((temp = reader.readLine()) != null) {
                user = getUserFromLine(temp.split(","));
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }

    private static User getUserFromLine(String[] str) {
        User user= new User();
        user.setLibraryNumber(str[0]);
        user.setName(str[1]);
        user.setPassword(str[2]);
        user.setPhoneNumber(str[3]);
        user.setEmail(str[4]);
        user.setAddress(str[5]);
        return user;
    }

    public static void writeBookToFile(String filename, ArrayList<Book> list) {

        StringBuilder sb = new StringBuilder();

        for (Book book : list) {
            sb.append(book.getBookId()).append(",")
                    .append(book.getBookName()).append(",")
                    .append(book.getBookAuthor()).append(",")
                    .append(book.getBookPubliced()).append(",")
                    .append(book.isInLibrary()).append("\n");
        }
        writeFile(filename, sb);
    }

    public static void writeMovieToFile(String filename, ArrayList<Movie> list) {

        StringBuilder sb = new StringBuilder();

        for (Movie movie : list) {
            sb.append(movie.getMovieId()).append(",")
                    .append(movie.getName()).append(",")
                    .append(movie.getDirector()).append(",")
                    .append(movie.getYear()).append(",")
                    .append(movie.getRating()).append(",")
                    .append(movie.isInLibrary()).append("\n");
        }
        writeFile(filename, sb);
    }

    public static void writeUserToFile(String filename, ArrayList<User> list) {
        StringBuilder sb = new StringBuilder();

        for (User user : list) {
            sb.append(user.getLibraryNumber()).append(",")
                    .append(user.getName()).append(",")
                    .append(user.getPassword()).append(",")
                    .append(user.getPhoneNumber()).append(",")
                    .append(user.getEmail()).append(",")
                    .append(user.getAddress()).append("\n");
        }
        writeFile(filename, sb);
    }
    private static void writeFile(String filename, StringBuilder sb) {
        try {
            FileWriter writer = new FileWriter(filename);
            BufferedWriter bw = new BufferedWriter(writer);
            bw.write(sb.toString());

            bw.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

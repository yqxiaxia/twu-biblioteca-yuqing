package com.twu.biblioteca;

import java.io.*;
import java.util.ArrayList;

public class FileUnit {

    public static ArrayList<Book> readFromFile(String fileName) {
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

    public static void writeToFile(String filename, ArrayList<Book> list) {

        StringBuilder sb = new StringBuilder();

        for (Book book : list) {
            sb.append(book.getBookId()).append(",")
                    .append(book.getBookName()).append(",")
                    .append(book.getBookAuthor()).append(",")
                    .append(book.getBookPubliced()).append(",")
                    .append(book.isInLibrary()).append("\n");
        }
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

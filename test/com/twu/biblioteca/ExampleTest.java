package com.twu.biblioteca;

import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ExampleTest {

    @Test
    public void GetWelcomeMassageWhenInputCustomer() {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        new BibliotecaApp().welcomeMessage("customer");
        assertEquals(output.toString(),"Welcome to Biblioteca!\n");
    }

    @Test
    public void GetBookListAfterWelcome(){

        ArrayList<String> bookList = new ArrayList<String>();
        bookList.add("book-1");
        bookList.add("book-2");

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        new BibliotecaApp().showBookList(bookList);
        assertEquals(output.toString(),"book-1\n"+ "book-2\n");
    }

    @Test
    public void GetBookListDetailAfterGetBookList(){

        ArrayList<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book();
        book1.setBookId(1);
        book1.setBookName("name1");
        book1.setBookAuthor("yuqing1");
        book1.setBookPubliced("2017-09-11");
        bookList.add(book1);

        Book book2 = new Book();
        book2.setBookId(2);
        book2.setBookName("name2");
        book2.setBookAuthor("yuqing2");
        book2.setBookPubliced("2017-09-12");
        bookList.add(book2);

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));
        new BibliotecaApp().showBookListDetial(bookList);
        assertEquals(output.toString(),"name1 | yuqing1 | 2017-09-11\n" + "name2 | yuqing2 | 2017-09-12\n");

    }

}

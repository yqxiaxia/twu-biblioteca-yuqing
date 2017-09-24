package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GetMovieListTest {

    private BibliotecaApp app = new BibliotecaApp();
    private Helper helper = new Helper();

    @Test
    public void GetMovieList(){

        ArrayList<Movie> movieList = helper.createMovieListInTest();
        ByteArrayOutputStream systemOutput =helper.systemOutput();
        app.showMovieListDetial(movieList);
        assertEquals("0 | movie-0 | yuqing-0 | 2017-0 | 10 | true\n" +
                "1 | movie-1 | yuqing-1 | 2017-1 | 10 | true\n",systemOutput.toString());
    }
}

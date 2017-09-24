package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.Assert.assertEquals;

public class GetUserInfoTest {

    private BibliotecaApp app = new BibliotecaApp();
    private Helper helper = new Helper();

    @Test
    public void GetUserInfo(){

        User user = helper.createUserInfoTest();
        ByteArrayOutputStream systemOutput =helper.systemOutput();

    }
}

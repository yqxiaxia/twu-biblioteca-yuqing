package com.twu.biblioteca;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;

public class GetUserInfoTest {

    private BibliotecaApp app = new BibliotecaApp();
    private Helper helper = new Helper();

    @Test
    public void GetUserInfo(){
        User user = helper.createUserInfoTest();
        ByteArrayOutputStream systemOutput =helper.systemOutput();
        app.showUserInfo(user);
        Assert.assertEquals("007-1234 | YuqingXia | 13545092422 | yqxia@thoughtworks.com | Wuhan\n", systemOutput.toString());
    }
}

package com.twu.biblioteca;

import java.util.ArrayList;

class User {
    private String libraryNumber;
    private String password;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    String getLibraryNumber() {
        return libraryNumber;
    }

    void setLibraryNumber(String libraryNumber) {
        this.libraryNumber = libraryNumber;
    }

    String getPassword() {
        return password;
    }

    void setPassword(String password) {
        this.password = password;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    String getEmail() {
        return email;
    }

    void setEmail(String email) {
        this.email = email;
    }

    String getAddress() {
        return address;
    }

    void setAddress(String address) {
        this.address = address;
    }

    String getPhoneNumber() {
        return phoneNumber;
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    void initUserInfo() {
        User user = FileUnit.readUserFromFile("User_Info.txt");
        setUser(user);
    }
}

package com.twu.biblioteca;

import java.util.Scanner;

class SystemInput {

    String getInputString() {
        String input = "";
        try {
            Scanner sc = new Scanner(System.in);
            input = sc.next();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return input;
    }

    int getInputInt() throws Exception{
        int input;

        Scanner sc = new Scanner(System.in);
        input = sc.nextInt();

        return input;
    }
}

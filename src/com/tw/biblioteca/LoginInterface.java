//accepts library number and password from user
package com.tw.biblioteca;

import java.util.Scanner;

public class LoginInterface {
    Scanner scanner;

    public LoginInterface(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readLibraryNumber() {
        System.out.println("Enter the library number: ");
        return scanner.nextLine();
    }
}

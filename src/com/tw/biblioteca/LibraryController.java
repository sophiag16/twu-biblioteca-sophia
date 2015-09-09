//controls the issue and return of books of library
package com.tw.biblioteca;

import java.util.Scanner;

public class LibraryController {
    private Library library = new Library();

    public LibraryController(Library library) {
        this.library = library;
    }

    public void issueBook() {
        System.out.println("Enter the name of book to issueBook");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        if(library.removeBook(bookName))
            System.out.println("Thank you! Enjoy the book");
        else
            System.out.println("That book is not available");
    }

    public void returnBook() {
        System.out.println("Enter the name of book to issueBook");
        Scanner scanner = new Scanner(System.in);
        String bookName = scanner.nextLine();
        if(library.addBook(bookName))
            System.out.println("Thank you for returning the book.");
        else
            System.out.println("That is not a valid book to return.");

    }
}
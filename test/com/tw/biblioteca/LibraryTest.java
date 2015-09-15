package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class LibraryTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @Before
    public void setStreams() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void CleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldDisplayListOfBookInformation() {
        Library library = new Library();

        library.printBooks();

        assertEquals("Name\tAuthor\tYear of Publishing\n" +
                "Harry Potter\tJ K Rowling\t2001\n" +
                "To Kill A Mockingbird\tHarper Lee\t1970\n" +
                "A Brief History Of Time\tStephen Hawking\t1988\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotDisplayCheckedOutBooks() {
        Library library = new Library();

        library.removeBook("Harry Potter");
        library.printBooks();

        assertEquals("Name\tAuthor\tYear of Publishing\n" +
                "To Kill A Mockingbird\tHarper Lee\t1970\n" +
                "A Brief History Of Time\tStephen Hawking\t1988\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldReturnTrueIfSuccessfullyIssued() {
        Library library = new Library();

        assertEquals(true, library.removeBook("Harry Potter"));
    }

    @Test
    public void shouldReturnFalseIfFailedToIssue() {
        Library library = new Library();

        assertEquals(false, library.removeBook("Harry"));
    }

    @Test
    public void shouldAgainDisplayReturnedBooks() {
        Library library = new Library();

        library.removeBook("Harry Potter");
        library.addBook("Harry Potter");
        library.printBooks();

        assertEquals("Name\tAuthor\tYear of Publishing\n" +
                "To Kill A Mockingbird\tHarper Lee\t1970\n" +
                "A Brief History Of Time\tStephen Hawking\t1988\n" +
                "Harry Potter\tJ K Rowling\t2001\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldReturnTrueIfSuccessfullyReturned() {
        Library library = new Library();

        library.removeBook("Harry Potter");

        assertEquals(true, library.addBook("Harry Potter"));
    }

    @Test
    public void shouldReturnFalseIfFailedToReturn() {
        Library library = new Library();

        assertEquals(false, library.addBook("Harry"));
    }
}

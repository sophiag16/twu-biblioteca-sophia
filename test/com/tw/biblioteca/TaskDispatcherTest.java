package com.tw.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class TaskDispatcherTest {
    private final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Before
    public void setStreams() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }

    @After
    public void CleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldDisplayListOfBooksIfOptionOneIsChosen() {
        TaskDispatcher taskDispatcher = new TaskDispatcher(1, new BookInfoList());
        BookInfoList bookInfoList = new BookInfoList();

        taskDispatcher.dispatch();

        assertEquals("Name\tAuthor\tYear of Publishing\n" +
                "Harry Potter\tJ K Rowling\t2001\n" +
                "To Kill A Mockingbird\tHarper Lee\t1970\n" +
                "A Brief History Of Time\tStephen Hawking\t1988\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldExitIfOptionTwoIsChosen() {
        exit.expectSystemExit();
        TaskDispatcher taskDispatcher = new TaskDispatcher(2, new BookInfoList());
        taskDispatcher.dispatch();
    }

    @Test
    public void shouldCheckoutBookIfOptionThreeIsChosen() {
        String input = "Harry Potter";
        ByteArrayInputStream inContent = new ByteArrayInputStream(input.getBytes());
        System.setIn(inContent);
        BookInfoList bookInfoList = mock(BookInfoList.class);
        TaskDispatcher taskDispatcher = new TaskDispatcher(3, bookInfoList);

        taskDispatcher.dispatch();

        Mockito.verify(bookInfoList, times(1)).remove(input);
    }
}
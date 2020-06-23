package com.zorba.study.reflection;

import java.util.Arrays;

public class App {

    public static void main(String[] args) throws ClassNotFoundException {
        Class<Book> bookClass = Book.class;

        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

        Class<?> aClass1 = Class.forName("com.zorba.study.reflection.Book");
        Arrays.stream(aClass.getDeclaredFields()).forEach(System.out::println);
    }
}

package com.zorba.study.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Book> bookClass = Book.class;

        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

        Class<?> aClass1 = Class.forName("com.zorba.study.reflection.Book");
        Arrays.stream(aClass.getDeclaredFields()).forEach(System.out::println);

        // 기본 생성자 만들기
        Class<?> bClass = Class.forName("com.zorba.study.reflection.Book");
        Constructor<?> constructor = bClass.getConstructor(null);
        Book book1 = (Book)constructor.newInstance();
        System.out.println("book1: "+book1);

        // argument가 있는 생성자 만들기
        Class<?> bClass1 = Class.forName("com.zorba.study.reflection.Book");
        Constructor<?> constructor1 = bClass.getConstructor(String.class);
        Book book2 = (Book)constructor1.newInstance("myBook");
        System.out.println("book2: "+book2);
    }
}

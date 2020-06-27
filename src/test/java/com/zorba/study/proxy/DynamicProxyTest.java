package com.zorba.study.proxy;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 런타임에 특정 인터페이스를 구현하는 클래스 또는 인스턴스를 만드는 기술
 * */
public class DynamicProxyTest {

    // 다이나믹 프록시 사용시, 전달해주는 객체가 반드시 인터페이스여야 동작함
    BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class}, new InvocationHandler() {
        BookService bookService = new DefaultBookService();
        @Override
        public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
            System.out.println("aaaaa");
            Object invoke = method.invoke(bookService, objects);
            System.out.println("bbbbb");
            return invoke;
        }
    });

    @Test
    public void di() {
        Book book = new Book();
        book.setTitle("greek Zorba");
        bookService.rent(book);
    }

}

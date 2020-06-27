package com.zorba.study.proxy;

public class BookRepository {

    public void save(Book book) {
        System.out.println("I rent a "+book.getTitle()+" and database to save!!");
    }
}

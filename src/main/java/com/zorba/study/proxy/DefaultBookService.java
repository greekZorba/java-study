package com.zorba.study.proxy;

public class DefaultBookService implements BookService {

    BookRepository bookRepository = new BookRepository();

    @Override
    public void rent(Book book) {
        bookRepository.save(book);
    }
}

package com.zorba.study.reflection;

public class Book {

    private static String B = "Book";

    private static final String C = "Book";

    private String a = "a";

    public String d = "d";

    protected String e = "e";

    public Book() {
    }

    public Book(String a, String d, String e) {
        this.a = a;
        this.d = d;
        this.e = e;
    }
}

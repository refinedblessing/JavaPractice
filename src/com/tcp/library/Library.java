package com.tcp.library;

import java.util.ArrayList;

public class Library {
    String id;
    String address;
    String name;
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    public Library(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void addBook(Book book) {
        this.books.add(book);
    }

    public void addBooks(ArrayList<Book> books) {
        this.books.addAll(books);
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void addUsers(ArrayList<User> users) {
        this.users.addAll(users);
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<User> getUsers() {
        return users;
    }
}

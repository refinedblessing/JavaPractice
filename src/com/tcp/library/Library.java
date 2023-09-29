package com.tcp.library;

import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    String id;
    String address;
    String name;
    ArrayList<Book> books = new ArrayList<>();
    ArrayList<User> users = new ArrayList<>();

    HashMap<String, Book> register = new HashMap<>();

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

    public void registerUser(User user) {
        user.libraryID = user.name + "Lib1";
    }

    public ArrayList<Book> listBooks() {
        return books;
    }

    public ArrayList<User> listUsers() {
        return users;
    }

    public Book findBookByISBN(String ISBN) {
        for (Book book : this.books) {
            if (book.ISBN.equals(ISBN)) {
                return book;
            }
        }
        return null;
    }

    public Book findBookByTitle(String title) {
        for (Book book : this.books) {
            if (book.title.equals(title)) {
                return book;
            }
        }
        return null;
    }

    public Book lendBook(String uid, String ISBN) {
        Book book = findBookByISBN(ISBN);
        if (book != null) {
            register.put(uid, book);
            this.books.remove(book);
            return book;
        }
        System.out.println("Book is currently not available");
        return null;
    }

    public void processReturn(String uid) {
        this.addBook(register.get(uid));
        register.remove(uid);
    }
}

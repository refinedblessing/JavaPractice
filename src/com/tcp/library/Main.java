package com.tcp.library;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("lib234", "Martin Luther Library", "1234, West La");

        User user1 = new User("Blessing E",20);
        User user2 = new User("Blessing k",22);
        User user3 = new User("Blessing q",2);

        Book book1 = new Book("745668367635", "Smart Woman", user1, "finance", "2023-01-02");
        Book book2 = new Book("74563333333333", "Smart Woman1", user2, "romance", "2020-01-02");
        Book book3 = new Book("7464674367635", "Smart Woman2", user3, "fiction", "2019-01-02");

//        Add book to library
        library.addBook(book1);
//        list library books
        System.out.println(library.listBooks());
//        Add books to library
//        create list of books
        ArrayList<Book> books = new ArrayList<>();
        books.add(book2);
        books.add(book3);
        library.addBooks(books);
//        list library books
        System.out.println(library.listBooks());

//        add user to library
        library.addUser(user1);
//        list users
        System.out.println(library.listUsers());
//        user borrows book from library
        System.out.println(library.lendBook(user1.uid, book1.ISBN));
//        try to lend out same book, logs error
        System.out.println(library.lendBook(user2.uid, book1.ISBN));
//        return book
        library.processReturn(user1.uid);
//        user2 should be able to borrow the book now
        System.out.println(library.lendBook(user2.uid, book1.ISBN));
    }
}

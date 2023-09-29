package com.tcp.library;

public class Main {
    public static void main(String[] args) {
        Library library = new Library("lib234", "Martin Luther Library", "1234, West La");

        User user1 = new User("Blessing E",20);
        Book book1 = new Book("745668367635", "Smart Woman", user1, "finance", "2023-01-02");

//        Add book to library
        library.addBook(book1);
//        list library books
        System.out.println(library.getBooks());

//        add user to library
        library.addUser(user1);
//        list users
        System.out.println(library.getUsers());
    }
}

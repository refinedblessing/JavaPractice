package com.tcp.library;

public class Book {
    String ISBN;
    String title;
    User author;
    String genre;
    String releaseDate;

    public Book(String ISBN, String title, User author, String genre, String releaseDate) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public User getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "ISBN='" + ISBN + '\'' +
                ", title='" + title + '\'' +
                ", author=" + author.name +
                ", genre='" + genre + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}

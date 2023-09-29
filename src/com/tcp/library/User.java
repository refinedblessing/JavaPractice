package com.tcp.library;

import java.util.ArrayList;

public class User {
    String name;
    String uid;
    String address;
    String libraryID;
    int age;
    ArrayList<String> favoriteGenres;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User(String name, String address, String libraryID, int age, ArrayList<String> favoriteGenres) {
        this.name = name;
        this.address = address;
        this.libraryID = libraryID;
        this.age = age;
        this.favoriteGenres = favoriteGenres;
    }

    public ArrayList<String> getFavoriteGenres() {
        return favoriteGenres;
    }

    public void addFavoriteGenres(ArrayList<String> favoriteGenres) {
        this.favoriteGenres.addAll(favoriteGenres);
    }

    public void changeAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", uid='" + uid + '\'' +
                ", address='" + address + '\'' +
                ", libraryID='" + libraryID + '\'' +
                ", age=" + age +
                ", favoriteGenres=" + favoriteGenres +
                '}';
    }
}

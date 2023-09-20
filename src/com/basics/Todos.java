package com.basics;

import java.util.Scanner;

public class Todos {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
//  ask user for number of todos
        System.out.print("How many things do you have to do? ");
        int num = input.nextInt();

        String[] todos = new String[num];
        for(int i = 0; i < todos.length; i++) {
//  loop through number of todos
            System.out.print("Enter a todo item ");
            String favorite = input.next();
//  add user input to the todos array
            todos[i] = favorite;
        }
//  print out the list of todos
        System.out.println("Your todo list includes the following:\n" + String.join("\n", todos));
        input.close();
    }
}

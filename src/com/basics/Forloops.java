package com.basics;

import java.util.Scanner;

public class Forloops {
    public static void main(String[] args) {
        int start = 0;
        int end = 99;
        int sumOfOdd = 0;
        int sumOfEven = 0;
        for (int i = start; i <= end; i++) {
//            display a string 99 times
            System.out.println("Always Display: " + i);
        }

        System.out.println("====================");

        for (int i = start; i <= end; i++) {
//            display odd numbers
            if ((i % 2) != 0) System.out.println(i);
        }

        System.out.println("====================");

        for (int i = start; i <= end; i++) {
//            display even numbers
            if ((i % 2) == 0) System.out.println(i);
        }

        System.out.println("====================");

        for (int i = start; i <= end; i++) {
//            display even numbers in a different way
            if (!((i % 2) != 0)) System.out.println(i);
        }

        System.out.println("====================");

        for (int i = start; i <= end; i++) {
//            sum up all odd numbers
            if ((i % 2) != 0) sumOfOdd += i;
        }
        System.out.println(sumOfOdd);

        System.out.println("====================");

        for (int i = start; i <= end; i++) {
//            sum up all even numbers
            if ((i % 2) == 0) sumOfEven += i;
        }

        System.out.println(sumOfEven);

        System.out.println("====================");

//        Sum of numbers between 2 numbers inclusive
        sumBtwNumbers();
    }

    static void sumBtwNumbers() {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        int first = input.nextInt();
        System.out.print("Enter second number: ");
        int second = input.nextInt();
        int sum = 0;

        for (int i = first; i <= second; i++) {
            sum += i;
        }
        
        input.close();
        System.out.println("The sum of all numbers between both numbers inclusive is: " + sum);
    }
}

package com.basics;

import java.util.Scanner;

public class FlowControl {
    public static void main(String[] args) {
        System.out.println("Enter 2 numbers with a difference of at least *200*");

//        Get user input
        Scanner input = new Scanner(System.in);
        System.out.print("Enter first number: ");
        int int1 = input.nextInt();
        System.out.print("Enter second number: ");
        int int2 = input.nextInt();

//        check if diff is less than 200 and return immediately
        int diff = Math.abs(int1 - int2);
        if (diff < 200) return;

//        set start and end of loop
        int start = Math.min(int1, int2);
        int end = Math.max(int1, int2);

//        sum up the numbers that are even and also divisible by 4
        int currPos = start;
//        Represents sum of even numbers divisible by 4
        int sumOfEven4 = 0;
//        Represents sum of even numbers divisible by 8
        int sumOfEven8 = 0;
//        Represents sum of not even and not divisible by 5
        int sumOfNotEven5 = 0;

//        Solving the problem with a do..while loop and a switch

        do {
            int mod = currPos % 2;
            switch (mod) {
//                case for when number is even;
                case 0:
                    if (currPos % 4 == 0) sumOfEven4 += currPos;
                    if (currPos % 8 == 0) sumOfEven8 += currPos;
                    break;
//                case for when number is odd;
                default:
                    if (currPos % 5 != 0) sumOfNotEven5 += currPos;
            }
            currPos++;
        }
        while (currPos <= end);

//        Print out the values
        System.out.println("=======================================================================\n");
        System.out.println("Solution using a do..while loop");
        System.out.println("Sum of the numbers that are even and also divisible by 4: " + sumOfEven4);
        System.out.println("Sum of the numbers that are even and also divisible by 8: " + sumOfEven8);
        System.out.println("Sum of the numbers that are not even and not divisible by 5: " + sumOfNotEven5);
        System.out.println("=======================================================================\n");


//        Solving the problem with a while loop and using if's

//        reset variables
        currPos = start;
        sumOfEven4 = 0;
        sumOfEven8 = 0;
        sumOfNotEven5 = 0;

//        run while loop
        while (currPos <= end) {
            int mod = currPos % 2;
            //   check for when number is even
            if (mod == 0) {
                if (currPos % 4 == 0) sumOfEven4 += currPos;
                if (currPos % 8 == 0) sumOfEven8 += currPos;
            } else {
                //  check for when number is odd and not divisible by 5
                if (currPos % 5 != 0) sumOfNotEven5 += currPos;
            }
            currPos++;
        }

//        Print out the values
        System.out.println("Solution using a while loop");
        System.out.println("Sum of the numbers that are even and also divisible by 4: " + sumOfEven4);
        System.out.println("Sum of the numbers that are even and also divisible by 8: " + sumOfEven8);
        System.out.println("Sum of the numbers that are not even and not divisible by 5: " + sumOfNotEven5);
        System.out.println("=======================================================================\n");


//        Solving the problem with a for loop and using if's

//        reset variables
        sumOfEven4 = 0;
        sumOfEven8 = 0;
        sumOfNotEven5 = 0;

//        run while loop
        for (currPos = start; currPos <= end; currPos++) {
            //   check for when number is even
            if ((currPos % 2) == 0) {
                if (currPos % 4 == 0) sumOfEven4 += currPos;
                if (currPos % 8 == 0) sumOfEven8 += currPos;
                continue;
            }
            //  check for when number is odd and not divisible by 5
            if (currPos % 5 != 0) sumOfNotEven5 += currPos;
        }

//        Print out the values
        System.out.println("Solution using a for loop");
        System.out.println("Sum of the numbers that are even and also divisible by 4: " + sumOfEven4);
        System.out.println("Sum of the numbers that are even and also divisible by 8: " + sumOfEven8);
        System.out.println("Sum of the numbers that are not even and not divisible by 5: " + sumOfNotEven5);
        System.out.println("=======================================================================\n");
    }
}

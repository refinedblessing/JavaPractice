package com.basics;

import java.util.Scanner;

interface ArithmeticFunction {
    <T> void apply(T a, T b);
}

// An application that gets inputs(2) from a user and applies a randomly selected mathematical function
public class InputRoulette {
    //        array of all functions
    static ArithmeticFunction[] functions = new ArithmeticFunction[4];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

//        Get user input
        System.out.println("Welcome to the Input Roulette\nEnter two values and choose a function to apply to them.\nGoodluck!");
        System.out.print("Enter First Input: ");
        String input1 = input.nextLine();
        System.out.print("Enter Second Input: ");
        String input2 = input.nextLine();

//        Verify that user inputs right format for function selection
        int selection = 0;
        while(selection < 1 || selection > 4) {
            System.out.print("Select a number from 1 to 4, this determines the function that will be applied to input: ");
            selection = input.nextInt();
        }

//        setupFunctions
        setupFunctions();

//        apply function based on user's selection
        ArithmeticFunction function = functions[selection - 1];

        try {
//        convert input to integers
            function.apply(Integer.parseInt(input1), Integer.parseInt(input2));
//        convert input to Double
            function.apply(Double.parseDouble(input1), Double.parseDouble(input2));
        } catch (NumberFormatException e) {
            System.out.println("Ooops! you get to miss out on the real math");
        }

//        use input as strings
        function.apply(input1, input2);
        input.close();
    }

    static void setupFunctions() {
//        setup addition
        functions[0] = new ArithmeticFunction() {
            public <T> void apply(T a, T b) {
                if (a instanceof Integer) {
                    Integer sum = (Integer) a + (Integer) b;
                    System.out.printf("The result of summing 2 Integers: %d\n", sum);
                } else if (a instanceof Double) {
                    Double sum = (Double) a + (Double) b;
                    System.out.printf("The result of summing 2 Doubles: %.2f\n", sum);
                } else {
                    System.out.println("The result of summing strings: " + (String) a + (String) b);
                }
            }
        };

//        setup subtraction
        functions[1] = new ArithmeticFunction() {
            public <T> void apply(T a, T b) {
                if (a instanceof Integer) {
                    Integer val = (Integer) a - (Integer) b;
                    System.out.printf("The result of subtracting 2 Integers: %d\n", val);
                } else if (a instanceof Double) {
                    Double val = (Double) a - (Double) b;
                    System.out.printf("The result of subtracting 2 Doubles: %.2f\n", val);
                } else {
                    System.out.println("Can't perform this operation on strings");
                }
            }
        };

//        setup multiplication
        functions[2] = new ArithmeticFunction() {
            public <T> void apply(T a, T b) {
                if (a instanceof Integer) {
                    Integer val = (Integer) a * (Integer) b;
                    System.out.printf("The result of multiplying 2 Integers: %d\n", val);
                } else if (a instanceof Double) {
                    Double val = (Double) a * (Double) b;
                    System.out.printf("The result of multiplying 2 Doubles: %.2f\n", val);
                } else {
                    System.out.println("Can't perform this operation on strings");
                }
            }
        };

//        setup division
        functions[3] = new ArithmeticFunction() {
            public <T> void apply(T a, T b) {
                if (a instanceof Integer) {
                    Integer val = (Integer) a / (Integer) b;
                    System.out.printf("The result of dividing 2 Integers: %d\n", val);
                } else if (a instanceof Double) {
                    Double val = (Double) a / (Double) b;
                    System.out.printf("The result of dividing 2 Doubles: %.2f\n", val);
                } else {
                    System.out.println("Can't perform this operation on strings");
                }
            }
        };
    }
}

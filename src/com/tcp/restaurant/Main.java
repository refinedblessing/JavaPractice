package com.tcp.restaurant;

import java.util.HashMap;
import java.util.Scanner;


public class Main {
    static String[] appetizers = {
            "Caprese Salad",
            "Garlic Bread",
            "Spinach and Artichoke Dip",
            "Bruschetta",
            "Mozzarella Sticks"
    };

    static String[] entrees = {
            "Grilled Salmon",
            "Chicken Alfredo",
            "Vegetable Stir-Fry",
            "Steak with Mashed Potatoes",
            "Pasta Carbonara"
    };

    static String[] desserts = {
            "Chocolate Cake",
            "Tiramisu",
            "New York Cheesecake",
            "Apple Pie",
            "Creme Brulee"
    };

    final static int MAX_ORDERS = 20;
    final static int MEAL_COUNT = 5;

    public static void main(String[] args) {
//        create a menu with 3 different rows representing 3 food groups
        String[][] menu = {appetizers, entrees, desserts};

//        instantiate Restaurant with specific menu
        Restaurant restaurant = new Restaurant(menu);

//        Start restaurant order prompt
        int orders = 0;
        HashMap<int[], Integer> ordersList = new HashMap<>();

//        Prepare to collect user input
        Scanner input = new Scanner(System.in);
        while (orders < MAX_ORDERS) {
            System.out.println("For Appetizers Press 1\nFor Entrees Press 2\nFor Deserts Press 3\nTo Order Press 4\nTo Quit Press Any Other Key\n");

            System.out.print("Enter Number: ");

            try {
                int mealCourseChoice = input.nextInt();
                int mealChoice = 1;

                switch (mealCourseChoice) {
                    case 1:
                        printMealChoices(0, menu);
                        break;
                    case 2:
                        printMealChoices(1, menu);
                        break;
                    case 3:
                        printMealChoices(2, menu);
                        break;
                    case 4:
                        if (ordersList.size() > 0)
                            restaurant.order(ordersList);
                        else System.out.println("You ordered Nothing!");
                        return;
//                        for when user quits
                    default:
                        System.out.println("Thanks for Stopping By :)");
                        return;
                }

                int entry = input.nextInt();
                if (entry <= MEAL_COUNT) {
                    mealChoice = entry;
                }

                String mealSelected = menu[mealCourseChoice - 1][mealChoice - 1];
                System.out.println(mealSelected + " was selected.");
                System.out.print("How many of this meal do you want? ");
                int mealCount = Math.min(input.nextInt(), (MAX_ORDERS - orders));
                orders += mealCount;
                System.out.println("\n" + mealCount + " " + mealSelected + " cooking...");

//                    register order
                int[] order = {mealCourseChoice - 1, mealChoice - 1};
                int quantity = ordersList.get(order) == null ? mealCount : ordersList.get(order) + mealCount;
                ordersList.put(order, quantity);
                System.out.println("-----------------------------------------------------");

            } catch (Exception e) {
                System.out.println("We will order on your behalf and you will pay for it :(\n");
                //        order from restaurant: 20 random orders
                restaurant.order(generateMaxOrder(menu));
                return;
            }
        }

        if (orders == MAX_ORDERS) {
            restaurant.order(ordersList);
        }

    }

    static void generateReceipt(int[][] orderList, String[][] menu) {

    }

    static void printMealChoices(int mealCourse, String[][] menu) {
        System.out.println("Press any of the numbers below to order meal.");
        for (int i = 0; i < menu[mealCourse].length; i++) {
            System.out.println(i + 1 + ". " + menu[mealCourse][i]);
        }
        System.out.print("Enter number: ");
    }

    static HashMap<int[], Integer> generateMaxOrder(String[][] menu) {
        int orders = 0;
        HashMap<int[], Integer> ordersList = new HashMap<>();

        int mealCoursesCount = menu.length;
//        assuming that all mealCourses have equal length of meals
        int mealCount = menu[0].length;

        while (orders < MAX_ORDERS) {
//            randomly generate meal course index (0: appetizers, 1: entrees, 2: deserts)
            int mealCourseChoice = (int) (Math.random() * mealCoursesCount);

//            randomly generate meal index
            int mealChoice = (int) (Math.random() * mealCount);

//            add meal-course index and meal index to order
            int[] order = {mealCourseChoice, mealChoice};

            int quantity = ordersList.get(order) == null ? mealCount : ordersList.get(order) + mealCount;
            ordersList.put(order, quantity);
            orders++;
        }

        return ordersList;
    }
}

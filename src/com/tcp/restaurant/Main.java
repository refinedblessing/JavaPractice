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

//    This can be easily updated
    final static int MAX_MEALS_PER_ORDER = 1;
    final static int MAX_ORDERS_PER_SESSION = 5;

//        assuming that all mealCourses have equal length of meals
    final static int NO_OF_MEALS_PER_COURSE = 5;

    final static int NO_OF_COURSES = 3;

    public static void main(String[] args) {
//        create a menu with 3 different rows representing 3 food groups
        String[][] menu = {appetizers, entrees, desserts};

//        instantiate Restaurant with specific menu
        Restaurant restaurant = new Restaurant(menu);

//        Start restaurant order prompt
//        Prepare to collect user input
        Scanner input = new Scanner(System.in);

        int totalOrders = 0;

//        open drive through for the day, limited to max orders per session
        while (totalOrders <= MAX_ORDERS_PER_SESSION) {
            int mealsOrdered = 0;
            HashMap<String, Integer> mealsOrderedList = new HashMap<>();

//            start taking orders but limit to the max meal per order
            selectMeal:
            while (mealsOrdered < MAX_MEALS_PER_ORDER) {
                try {
//                    Ask user for meal course preference
                    System.out.println("For Appetizers Press 1\nFor Entrees Press 2\nFor Deserts Press 3\nTo Order Press 4\nTo Quit Press Any Other Number");
                    System.out.print("Enter Number: ");
                    int mealCourseChoice = input.nextInt();

//                   set a default meal choice to be used if user enters incorrect meal choice value
                    int mealChoice = 1;

                    switch (mealCourseChoice) {
                        case 1 -> printMealChoices(0, menu);
                        case 2 -> printMealChoices(1, menu);
                        case 3 -> printMealChoices(2, menu);
                        case 4 -> {
                            if (mealsOrderedList.size() > 0) {
                                restaurant.order(mealsOrderedList);
                            }
                            else System.out.println("You ordered Nothing!\n");
                            break selectMeal;
                        }
//                        for when user quits
                        default -> {
                            System.out.println("Thanks for Stopping By :)");
                            break selectMeal;
                        }
                    }

//                Get user meal preference
                    int entry = input.nextInt();

                    if (entry <= NO_OF_MEALS_PER_COURSE) {
                        mealChoice = entry;
                    }

                    String mealSelected = menu[mealCourseChoice - 1][mealChoice - 1];
                    System.out.println(mealSelected + " was selected.");

                    System.out.print("How many " + mealSelected + " do you want? ");

//                enforcing the max meal restriction
                    int mealCount = Math.min(input.nextInt(), (MAX_MEALS_PER_ORDER - mealsOrdered));
//                update the count of ordered meals
                    mealsOrdered += mealCount;

//                    register meal in the mealsOrderedList
                    String order = (mealCourseChoice - 1) + " " + (mealChoice - 1);
                    int quantity = mealsOrderedList.get(order) == null ? mealCount : mealsOrderedList.get(order) + mealCount;
                    mealsOrderedList.put(order, quantity);
                    System.out.println("-----------------------------------------------------");

                } catch (Exception e) {
//                A quick way to order 20 meals fast
                    System.out.println("We will order on your behalf and you will pay for it :(\n");
                    //        order from restaurant: 20 random orders
                    restaurant.order(generateMaxOrder());
                }
            }

            if (mealsOrderedList.size() > 0) {
                restaurant.order(mealsOrderedList);
            }

            totalOrders++;
        }

        restaurant.printOrderRegister();
    }

    static void printMealChoices(int mealCourse, String[][] menu) {
        System.out.println("Press any of the numbers below to order meal.");
        for (int i = 0; i < menu[mealCourse].length; i++) {
            System.out.println(i + 1 + ". " + menu[mealCourse][i]);
        }
        System.out.print("Enter number: ");
    }

    static HashMap<String, Integer> generateMaxOrder() {
        int orders = 0;
        HashMap<String, Integer> ordersList = new HashMap<>();

        while (orders < MAX_MEALS_PER_ORDER) {
//            randomly generate meal course index (0: appetizers, 1: entrees, 2: deserts)
            int mealCourseChoice = (int) (Math.random() * NO_OF_COURSES);

//            randomly generate meal index
            int mealChoice = (int) (Math.random() * NO_OF_MEALS_PER_COURSE);

//            add meal-course index and meal index to order
            String order = mealCourseChoice + " " + mealChoice;

            int quantity = ordersList.get(order) == null ? 1 : ordersList.get(order) + 1;
            ordersList.put(order, quantity);
            orders++;
        }

        return ordersList;
    }
}

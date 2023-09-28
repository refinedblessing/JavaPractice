package com.tcp.restaurant;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    private final String[][] menu;

    static Double[] pricing;
    Double minFoodPrice = 4.99;

    private static int totalOrdersProcessed = 0;
    private static int mealsServed = 0;
    private static double totalMade = 0.0;

//    order Register to keep track of daily orders
    private HashMap<String, Integer> orderRegister = new HashMap<>();

    public Restaurant(String[][] menu) {
        this.menu = menu;
        setMealCoursePrices();

        System.out.println("Welcome to Mummy Z's Restaurant :)");
        celebrateMilestones();
    }

    private void setMealCoursePrices() {
        pricing = new Double[menu.length];

        for (int multiplier = 1; multiplier <= menu.length; multiplier++) {
            pricing[multiplier - 1] = multiplier * minFoodPrice;
        }
    }

    static double calculateTotalOrderCost(HashMap<String, Integer> ordersList) {
        double totalCost = 0.0;

//        Calculate total cost
        for (Map.Entry<String, Integer> mapElement : ordersList.entrySet()) {
            String[] order = mapElement.getKey().split(" ");

            int quantity = mapElement.getValue();
            int mealCourseChoice = Integer.parseInt(order[0]);

            double totalPrice = pricing[mealCourseChoice] * quantity;
            totalCost += totalPrice;
        }
        return totalCost;
    }

    public void order(HashMap<String, Integer> ordersList) {
        double totalCost = calculateTotalOrderCost(ordersList);

//        create receipt format
        System.out.println("You ordered we Answered");
        Date today = new Date();
        StringBuilder receipt = new StringBuilder("Your receipt for today: " + today + "\n\n");
        receipt.append(String.format("%-35s %-12s %-8s %% of sale\n", "Item", "Quantity", "Price"));
        receipt.append("------------------------------------------------------------------------\n");

        for (Map.Entry<String, Integer> mapElement : ordersList.entrySet()) {
            String orderStr = mapElement.getKey();
            String[] orderArr = orderStr.split(" ");
            int quantity = mapElement.getValue();

            int mealCourseChoice = Integer.parseInt(orderArr[0]);
            int mealChoice = Integer.parseInt(orderArr[1]);
            String meal = menu[mealCourseChoice][mealChoice];

//            update mealsServed
            mealsServed += quantity;

//            update restaurant register
            int totalQuantity = orderRegister.get(orderStr) == null ? quantity : orderRegister.get(orderStr) + quantity;
            orderRegister.put(orderStr, totalQuantity);

            System.out.println(quantity + " " + meal + " cooking.....\n");

            double totalPrice = pricing[mealCourseChoice] * quantity;
            Double percentageOfSale = (totalPrice/totalCost) * 100;

            receipt.append(String.format("%-35s %-12s %-8.2f %.2f%%\n", meal, quantity, totalPrice, percentageOfSale));
        }

        receipt.append("------------------------------------------------------------------------\n");
        receipt.append(String.format("Total: %.2f", totalCost));
        receipt.append("\n------------------------------------------------------------------------\n");

//        update total made to date
        totalMade += totalCost;

//        update successful orders Count
        totalOrdersProcessed += 1;

        celebrateMilestones();

        System.out.println(receipt);
        System.out.println("Thanks for trusting us with your belly!\n");
    }

    static void celebrateMilestones() {
//        Celebrate milestones for every 100 meals served and every 5 orders processed
//        Include sales report
        if (mealsServed == 0) return;
        if ((mealsServed % 100) == 0) {
            System.out.println("We have successfully served "+ mealsServed +" meals!!!\nThank You");
        }

        if ((totalOrdersProcessed % 5) == 0) {
            System.out.println("We have successfully processed "+ totalOrdersProcessed +" orders!!!\nThank You");
        }

        if ((totalMade % 1000) == 0) {
            System.out.println("Another 1000 in the Bag!!!");
        }
    }

    void printOrderRegister() {
        double totalCost = calculateTotalOrderCost(orderRegister);
        StringBuilder receipt = new StringBuilder("Order Register printed today: " + new Date() + "\n");
        receipt.append(String.format("%-35s %-12s %-8s %% of sale\n", "Item", "Quantity", "Price"));
        receipt.append("------------------------------------------------------------------------\n");

        for (Map.Entry<String, Integer> mapElement : orderRegister.entrySet()) {
            String orderStr = mapElement.getKey();
            String[] orderArr = orderStr.split(" ");
            int quantity = mapElement.getValue();

            int mealCourseChoice = Integer.parseInt(orderArr[0]);
            int mealChoice = Integer.parseInt(orderArr[1]);
            String meal = menu[mealCourseChoice][mealChoice];

            double totalPrice = pricing[mealCourseChoice] * quantity;
            Double percentageOfSale = (totalPrice/totalCost) * 100;

            receipt.append(String.format("%-35s %-12s %-8.2f %.2f%%\n", meal, quantity, totalPrice, percentageOfSale));
        }

        receipt.append("------------------------------------------------------------------------\n");
        receipt.append(String.format("Total: %.2f", totalCost));
        receipt.append("\n------------------------------------------------------------------------\n");
        System.out.println(receipt);
    }
}

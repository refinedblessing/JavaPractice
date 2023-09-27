package com.tcp.restaurant;

import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Restaurant {
    private final String[][] menu;

    Double[] pricing;
    Double minFoodPrice = 4.99;

    public Restaurant(String[][] menu) {
        this.menu = menu;
        setMealCoursePrices();

        System.out.println("Welcome to Mummy Z's Restaurant :)");
    }

    private void setMealCoursePrices() {
        pricing = new Double[menu.length];

        for (int multiplier = 1; multiplier <= menu.length; multiplier++) {
            pricing[multiplier - 1] = multiplier * minFoodPrice;
        }
    }

    public Double singleOrder(int mealCourse, int meal) {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        System.out.print("You ordered for " + this.menu[mealCourse][meal] + " it costs ");
        System.out.println(fmt.format(pricing[mealCourse]));

        return pricing[mealCourse];
    }

    public void order(HashMap<String, Integer> ordersList) {
        System.out.println("You ordered we Answered");
        Date today = new Date();
        StringBuilder receipt = new StringBuilder("Your receipt for today: " + today + "\n\n");
        double totalCost = 0.0;

//        Calculate total cost
        for (Map.Entry<String, Integer> mapElement : ordersList.entrySet()) {
            String[] order = mapElement.getKey().split(" ");
            int quantity = mapElement.getValue();

            int mealCourseChoice = Integer.parseInt(order[0]);
            double price = pricing[mealCourseChoice] * quantity;
            totalCost += price;
        }


//        create receipt format
        receipt.append(String.format("%-35s %-12s %-8s %% of sale\n", "Item", "Quantity", "Price"));
        receipt.append("------------------------------------------------------------------------\n");

        for (Map.Entry<String, Integer> mapElement : ordersList.entrySet()) {
            String[] order = mapElement.getKey().split(" ");
            int quantity = mapElement.getValue();

            int mealCourseChoice = Integer.parseInt(order[0]);
            int mealChoice = Integer.parseInt(order[1]);
            String meal = menu[mealCourseChoice][mealChoice];
            double price = pricing[mealCourseChoice] * quantity;
            Double percentageOfSale = (price/totalCost) * 100;

            receipt.append(String.format("%-35s %-12s %-8.2f %.2f%%\n", meal, quantity, price, percentageOfSale));
        }

        receipt.append("------------------------------------------------------------------------\n");
        receipt.append(String.format("Total: %.2f", totalCost));
        receipt.append("\n------------------------------------------------------------------------\n");

        System.out.println(receipt);
        System.out.println("Thanks for trusting us with your belly!\nYou are one of the great ones");
    }
}

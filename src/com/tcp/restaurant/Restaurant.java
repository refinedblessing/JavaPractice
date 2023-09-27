package com.tcp.restaurant;

import java.text.NumberFormat;
import java.util.HashMap;

public class Restaurant {
    private String[][] menu;

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

    public String[][] getMenu() {
        return menu;
    }

    public void order(HashMap<int[], Integer> ordersList) {
        System.out.println("You ordered we Answered");
    }
}

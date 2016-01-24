package com.github.zhve.topcoder.task250;

public class CarBuyer {
    public double lowestCost(String[] cars, int fuelPrice, int annualDistance, int years) {
        double min = Double.MAX_VALUE;
        for (String car : cars) {
            String[] splited = car.split(" ");
            int PURCHASE_COST = Integer.parseInt(splited[0]);
            int TAX = Integer.parseInt(splited[1]);
            int FUEL_EFFICIENCY = Integer.parseInt(splited[2]);

            double cost = PURCHASE_COST + years * TAX + 1.0 * years * fuelPrice * annualDistance / FUEL_EFFICIENCY;
            if (cost < min) {
                min = cost;
            }
        }
        return min;
    }
}

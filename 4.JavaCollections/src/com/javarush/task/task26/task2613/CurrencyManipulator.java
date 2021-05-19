package com.javarush.task.task26.task2613;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator {
    private final String currencyCode;
    private final Map<Integer, Integer> denominations;

    public CurrencyManipulator(String currencyCode) {
        this.currencyCode = currencyCode;
        this.denominations = new HashMap<>();
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void addAmount(int denomination, int count) {
        if (denominations.containsKey(denomination)) {
            denominations.put(denomination, denominations.get(denomination) + count);
        } else {
            denominations.put(denomination, count);
        }
    }

    public int getTotalAmount(){
        int sum = 0;
        for (Integer denomination: denominations.keySet()) {
            sum += denomination * denominations.get(denomination);
        }
        return sum;
    }

    public boolean hasMoney() {
        return !denominations.isEmpty();
    }

}

package scum;

import java.util.HashMap;
import java.util.Map;

public class Human {
    public Human(String name) {
        this.name = name;
    }

    String name;
    Map<String, Integer> purchases = new HashMap<>();
    int sumMoney;

    int getSumMoney() {
        return this.sumMoney;
    }

    void sumMoney() {
        this.sumMoney = 0;
        for (int val : purchases.values()) {
            sumMoney += val;
        }
    }

    void addPurchases(String name, Integer cost) {
        purchases.put(name, cost);
        sumMoney();
        if (ScumCalculate.allPurchases.containsKey(name)) {
            ScumCalculate.allPurchases.replace(name, ScumCalculate.allPurchases.get(name) + 1);
        } else {
            ScumCalculate.allPurchases.put(name, 1);
        }
        if (ScumCalculate.allPurchasesCost.containsKey(name)) {
            ScumCalculate.allPurchasesCost.replace(name, ScumCalculate.allPurchasesCost.get(name) + cost);
        } else {
            ScumCalculate.allPurchasesCost.put(name, cost);
        }
    }

    String seePurchases() {
        return this.name + purchases.toString();
    }
}

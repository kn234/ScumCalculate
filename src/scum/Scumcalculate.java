package scum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Scumcalculate {
    public static class Human {
        public Human(String name) {
            this.name = name;
            humanList.add(this);
        }

        String name;
        Map<String, Integer> purchases = new HashMap<>();
        int summoney;

        int getSummoney() {
            return this.summoney;
        }

        void sumMoney() {
            this.summoney = 0;
            for (int val : purchases.values()) {
                summoney += val;
            }
        }

        void addPurchases(String name, Integer cost) {
            purchases.put(name, cost);
            sumMoney();
            if (allPurchases.containsKey(name)) {
                allPurchases.replace(name, allPurchases.get(name) + 1);
            } else {
                allPurchases.put(name, 1);
            }
            if (allPurchasesCost.containsKey(name)) {
                allPurchasesCost.replace(name, allPurchasesCost.get(name) + cost);
            } else {
                allPurchasesCost.put(name, cost);
            }
        }

        String seePurchases() {
            return this.name + purchases.toString();
        }
    }

    public static ArrayList<Human> humanList = new ArrayList<>();

    public int seeHumanListSize() {
        return humanList.size();
    }

    static String seeHumanList() {
        return humanList.toString();
    }

    public static Map<String, Integer> allPurchases = new HashMap<>();

    static String seeAllPurchases() {
        return allPurchases.toString();
    }

    static Map<String, Integer> allPurchasesCost = new HashMap<>();

    static String seeAllPurchasesCost() {
        return allPurchasesCost.toString();
    }

    public static String result() {
        Map<String, Integer> resultMap = new HashMap<>();

        for (Human humans : humanList) {
            for (String purchase : allPurchases.keySet()) {
                if (allPurchases.get(purchase) > 1) {
                    if (resultMap.containsKey(humans.name)) {
                        if (humans.purchases.containsKey(purchase)) {
                            resultMap.replace(humans.name, resultMap.get(humans.name) - (allPurchasesCost.get(purchase) / allPurchases.get(purchase)));
                        }
                    } else {
                        if (humans.purchases.containsKey(purchase)) {
                            resultMap.put(humans.name, humans.purchases.get(purchase) - (allPurchasesCost.get(purchase) / allPurchases.get(purchase)));
                        }
                    }
                }
            }
        }


        return resultMap.toString();
    }

}

package scum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScumCalculate {
    private final List<Human> humanList;
    private final Map<String, Integer> allPurchases;
    private final Map<String, Integer> allPurchasesCost;

    public ScumCalculate() {
        this.humanList = new ArrayList<>();
        allPurchases = new HashMap<>();
        allPurchasesCost = new HashMap<>();
    }

    public void addHuman(Human human) {
        this.humanList.add(human);
    }

    public List<Human> getHumanList() {
        return humanList;
    }

    public int getHumanListSize() {
        return humanList.size();
    }

    public String humanListToString() {
        return humanList.toString();
    }

    public Map<String, Integer> getAllPurchases() {
        return allPurchases;
    }

    public String seeAllPurchases() {
        return allPurchases.toString();
    }

    public String seeAllPurchasesCost() {
        return allPurchasesCost.toString();
    }

    public String result() {
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

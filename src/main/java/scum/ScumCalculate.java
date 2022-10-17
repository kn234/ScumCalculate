package scum;

import model.Person;
import model.Product;
import model.Purchase;

import java.util.*;

public class ScumCalculate {
    private final List<Product> products;
    private final List<Purchase> purchases;

    public ScumCalculate() {
        products = new ArrayList<>();
        purchases = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void addPurchase(Purchase purchase) {
        this.purchases.add(purchase);
    }


    public Debts calculateDebts() {
        Map<Person, Integer> debts = new HashMap<>();
        for (Product product : products) {
            for (Person person : product.getPersons()) {
                debts.merge(person, product.getCost() / product.getPersons().size(), Integer::sum);
            }
        }

        for (Purchase purchase : purchases) {
            debts.merge(purchase.getWhoPaid(), purchase.getPaid(), (was, paid) -> was - paid);
        }

        return new Debts(debts);
    }

    public static class Debts {
        private final Map<Person, Integer> values;

        public Debts(Map<Person, Integer> debts) {
            this.values = debts;
        }

        public Map<Person, Integer> getValues() {
            return values;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            for (Map.Entry<Person, Integer> debt : values.entrySet()) {
                String toDo;
                if (debt.getValue() >= 0) {
                    toDo = "should pay " + debt.getValue();
                } else {
                    toDo = "should be paid " + (-debt.getValue());
                }

                stringBuilder.append(debt.getKey()).append(" ").append(toDo).append("\n");
            }

            return stringBuilder.toString();
        }
    }
}

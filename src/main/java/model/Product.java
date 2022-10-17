package model;

import java.util.List;

public class Product {
    private final int cost;
    private final List<Person> persons;

    public Product(int cost, List<Person> persons) {
        this.cost = cost;
        this.persons = persons;
    }


    public int getCost() {
        return cost;
    }

    public List<Person> getPersons() {
        return persons;
    }
}

package model;

public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        final Person other = (Person) obj;
        return this.getName().equals(((Person) obj).getName());
    }

    @Override
    public String toString() {
        return this.getName();
    }
}

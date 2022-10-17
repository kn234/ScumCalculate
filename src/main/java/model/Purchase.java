package model;

public class Purchase {
    private final int paid;
    private final Person whoPaid;

    public Purchase(int paid, Person whoPaid) {
        this.paid = paid;
        this.whoPaid = whoPaid;
    }

    public int getPaid() {
        return paid;
    }

    public Person getWhoPaid() {
        return whoPaid;
    }
}

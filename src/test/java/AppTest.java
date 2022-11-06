import model.Person;
import model.Product;
import model.Purchase;
import org.junit.jupiter.api.Test;
import scum.ScumCalculate;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static scum.ScumCalculate.Debts;

public class AppTest {
    @Test
    public void test() {
        Person leha = new Person("Leha");
        Person dimas = new Person("Dimas");

        Product vodka = new Product(200, List.of(leha, dimas));
        Product garage = new Product(50, List.of(leha));

        Purchase kb = new Purchase(250, leha);

        ScumCalculate scumCalculate = new ScumCalculate();
        scumCalculate.addProduct(vodka);
        scumCalculate.addProduct(garage);
        scumCalculate.addPurchase(kb);

        Debts debts = scumCalculate.calculateDebts();

        System.out.println(debts.toString());

        assertThat(debts.getValues().get(dimas)).isEqualTo(100);
        assertThat(debts.getValues().get(leha)).isEqualTo(-100);
    }

    @Test
    public void test1() {
        Person leha = new Person("Leha");
        Person dimas = new Person("Dimas");
        Person domas = new Person("Domas");
        Person demas = new Person("Demas");

        Product vodka = new Product(200, List.of(leha, dimas));
        Product garage = new Product(50, List.of(leha));
        Product vodka1 = new Product(200, List.of(leha, domas));
        Product vodka2 = new Product(300, List.of(leha, domas, demas));

        Purchase kb = new Purchase(250, leha);
        Purchase kb1 = new Purchase(500, leha);

        ScumCalculate scumCalculate = new ScumCalculate();
        scumCalculate.addProduct(vodka);
        scumCalculate.addProduct(garage);
        scumCalculate.addProduct(vodka1);
        scumCalculate.addProduct(vodka2);
        scumCalculate.addPurchase(kb);
        scumCalculate.addPurchase(kb1);

        Debts debts = scumCalculate.calculateDebts();

        System.out.println(debts.toString());

        assertThat(debts.getValues().get(dimas)).isEqualTo(100);
        assertThat(debts.getValues().get(leha)).isEqualTo(-400);
        assertThat(debts.getValues().get(domas)).isEqualTo(200);
        assertThat(debts.getValues().get(demas)).isEqualTo(100);
    }

    @Test
    public void test2() {
        Person leha = new Person("Leha");
        Person dimas = new Person("Dimas");
        Person domas = new Person("Domas");
        Person demas = new Person("Demas");

        Product vodka = new Product(200, List.of(leha, dimas));
        Product garage = new Product(50, List.of(leha));
        Product vodka1 = new Product(200, List.of(leha, domas));
        Product vodka2 = new Product(300, List.of(leha, domas, demas));

        Purchase kb = new Purchase(250, leha);
        Purchase kb1 = new Purchase(500, demas);

        ScumCalculate scumCalculate = new ScumCalculate();
        scumCalculate.addProduct(vodka);
        scumCalculate.addProduct(garage);
        scumCalculate.addProduct(vodka1);
        scumCalculate.addProduct(vodka2);
        scumCalculate.addPurchase(kb);
        scumCalculate.addPurchase(kb1);

        Debts debts = scumCalculate.calculateDebts();

        System.out.println(debts.toString());

        assertThat(debts.getValues().get(dimas)).isEqualTo(100);
        assertThat(debts.getValues().get(leha)).isEqualTo(100);
        assertThat(debts.getValues().get(domas)).isEqualTo(200);
        assertThat(debts.getValues().get(demas)).isEqualTo(-400);
    }
}

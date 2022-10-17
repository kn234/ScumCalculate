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
}

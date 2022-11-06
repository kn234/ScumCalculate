import model.Person;
import model.Product;
import model.Purchase;
import scum.ScumCalculate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static stringToListOfPerson.StringToListOfPerson.stringToList;

public class GUI extends JFrame {
    private final JTextField inputHumanName = new JTextField("name", 5);
    private final JTextField inputProductCost = new JTextField("cost", 5);
    private final JTextField inputProductListNames = new JTextField("names", 5);
    private final JTextField inputPurchasePaid = new JTextField("paid", 5);
    private final JTextField inputPurchaseWhoName = new JTextField("whopaid", 5);
    private final ScumCalculate scumCalculate;
    public ArrayList<Person> personList = new ArrayList<>();

    public GUI() {
        super("ScumCalculus");
        this.scumCalculate = new ScumCalculate();
        this.setBounds(200, 200, 1000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Container container = this.getContentPane();
        container.setLayout(new GridLayout(4, 4, 2, 4));


        JLabel labelProductName = new JLabel("Введите товар: ");
        container.add(labelProductName);
        container.add(inputProductCost);
        container.add(inputProductListNames);
        JButton addProductName = new JButton("Add Product");
        addProductName.addActionListener(new ButtonAddProductName());
        container.add(addProductName);

        JLabel labelPurchaseName = new JLabel("Введите покупку/кто оплатил: ");
        container.add(labelPurchaseName);
        container.add(inputPurchaseWhoName);
        container.add(inputPurchasePaid);
        JButton addPurchaseName = new JButton("Add Purchase");
        addPurchaseName.addActionListener(new ButtonAddPurchaseName());
        container.add(addPurchaseName);

        JLabel labelHumanName = new JLabel("Введите имя человека: ");
        container.add(labelHumanName);
        container.add(inputHumanName);
        JButton addHumanName = new JButton("Add Human");
        addHumanName.addActionListener(new ButtonAddHumanName());
        container.add(addHumanName);

        JButton result = new JButton("Result");
        result.addActionListener(new ButtonResult());
        container.add(result);

        JLabel labelTable = new JLabel(personList.toString());
        container.add(labelTable);
    }

    class ButtonResult implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ScumCalculate.Debts debts = scumCalculate.calculateDebts();
            String message = debts.toString();
            JOptionPane.showMessageDialog(null, message, "Result", JOptionPane.PLAIN_MESSAGE);
        }
    }

    class ButtonAddHumanName implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Person person = new Person(inputHumanName.getText());
            if (!personList.contains(person)) {
                personList.add(person);
            }
            System.out.println(personList);
        }
    }

    class ButtonAddPurchaseName implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Person persons : personList) {
                if (inputPurchaseWhoName.getText().equals(persons.getName())) {
                    Purchase purchase = new Purchase(Integer.parseInt(inputPurchasePaid.getText()), persons);
                    scumCalculate.addPurchase(purchase);
                    System.out.println("покупка занесена");
                }
            }
        }
    }

    class ButtonAddProductName implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Product product = new Product(Integer.parseInt(inputProductCost.getText()), stringToList(inputProductListNames.getText()));
            scumCalculate.addProduct(product);
            System.out.println("продукт добавлен");
        }
    }
}


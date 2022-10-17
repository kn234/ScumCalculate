import model.Person;
import scum.ScumCalculate;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame {
    private final JTextField inputHumanName = new JTextField("", 5);
    private final ScumCalculate scumCalculate;

    public GUI() {
        super("ScumCalculus");
        this.scumCalculate = new ScumCalculate();
        this.setBounds(500, 300, 500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Container container = this.getContentPane();
        container.setLayout(new GridLayout(3, 3, 2, 4));

        JLabel labelHumanName = new JLabel("Введите имя человека: ");
        container.add(labelHumanName);
        container.add(inputHumanName);
        JButton addHumanName = new JButton("Add Human");
        addHumanName.addActionListener(new ButtonAddHumanName());
        container.add(addHumanName);

        JLabel labelPurchaseName = new JLabel("Введите название продукта: ");
        container.add(labelPurchaseName);
        JTextField inputPurchaseName = new JTextField("", 5);
        container.add(inputPurchaseName);
        JButton addPurchaseName = new JButton("Add Purchase");
        addPurchaseName.addActionListener(new ButtonAddPurchaseName());
        container.add(addPurchaseName);

        JButton result = new JButton("Result");
        result.addActionListener(new ButtonResult());
        container.add(result);

        JLabel labelTable = new JLabel("nothing");
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
            String humanName = inputHumanName.getText();
            Person person = new Person(humanName);
        }
    }

    static class ButtonAddPurchaseName implements ActionListener {
        public void actionPerformed(ActionEvent e) {

        }
    }
}


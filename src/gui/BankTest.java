package gui;

import javax.swing.*;
import java.awt.*;

public class BankTest extends JFrame {

    public BankTest() {
//        setSize(400, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        JTextField input = new JTextField();
        JButton go = new JButton("Go");

        go.setPreferredSize(new Dimension(100, 100));
        go.setFont(new Font("Consolas", Font.BOLD, 30));

        input.setPreferredSize(new Dimension(400, 100));
        input.setFont(new Font("Consolas", Font.BOLD, 30));
        input.setHorizontalAlignment(SwingConstants.CENTER);

        go.addActionListener(a -> {
            try {
                int total = Integer.parseInt(input.getText());
                new Bankovky(total).setVisible(true);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null,
                        "Please input a whole number.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        add(input);
        add(go);
        pack();
    }

    public static void main(String[] args) {
        new BankTest().setVisible(true);
    }
}
class Bankovky extends JFrame {
    public Bankovky(int i) {
        setSize(500, 800);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        String text = String.valueOf(i);
        int vysledek = 0;

        JPanel center = new JPanel(new GridLayout(3, 4, 10, 10));

        JLabel input = new JLabel(text);

        input.setPreferredSize(new Dimension(500, 150));
        input.setFont(new Font("Consolas", Font.BOLD, 40));
        input.setHorizontalAlignment(SwingConstants.CENTER);
        input.setVerticalAlignment(SwingConstants.CENTER);

        input.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, false));

        for (int j = 0; j < 12; j++) {
            if (j == 0){
                vysledek = i / 5000;
                i %= 5000;
                center.add(new Pocty(vysledek).add(new JLabel("5000")));
            }if (j == 1){
                vysledek = i / 2000;
                i %= 2000;
                center.add(new Pocty(vysledek).add(new JLabel("2000")));
            }if (j == 2){
                vysledek = i / 1000;
                i %= 1000;
                center.add(new Pocty(vysledek).add(new JLabel("1000")));
            }if (j == 3){
                vysledek = i / 500;
                i %= 500;
                center.add(new Pocty(vysledek).add(new JLabel("500")));
            }if (j == 4){
                vysledek = i / 200;
                i %= 200;
                center.add(new Pocty(vysledek).add(new JLabel("200")));
            }if (j == 5){
                vysledek = i / 100;
                i %= 100;
                center.add(new Pocty(vysledek).add(new JLabel("100")));
            }if (j == 6){
                vysledek = i / 50;
                i %= 50;
                center.add(new Pocty(vysledek).add(new JLabel("50")));
            }if (j == 7){
                vysledek = i / 20;
                i %= 20;
                center.add(new Pocty(vysledek).add(new JLabel("20")));
            }if (j == 8){
                vysledek = i / 10;
                i %= 10;
                center.add(new Pocty(vysledek));
            }if (j == 9){
                vysledek = i / 5;
                i %= 5;
                center.add(new Pocty(vysledek).add(new JLabel("5")));
            }if (j == 10){
                vysledek = i / 2;
                i %= 2;
                center.add(new Pocty(vysledek).add(new JLabel("2")), BorderLayout.SOUTH);
            }if (j == 11){
                vysledek = i;
                i %= 1;
                center.add(new Pocty(vysledek).add(new JLabel("1")));
            }
        }

        add(input, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
    }
}
class Pocty extends JPanel {
    public Pocty(int vysledek) {
        setLayout(new BorderLayout());

        JLabel total = new JLabel(String.valueOf(vysledek) + "x");

        if (vysledek > 0) {
            total.setBackground(Color.GREEN);
        }

        add(total, BorderLayout.NORTH);
    }
}
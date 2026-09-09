package gui;

import javax.swing.*;
import java.awt.*;

public class Griding extends JFrame {

    public Griding() {
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridLayout(4, 4));

        for (int i = 0; i < 16; i++) {
            add(new JButton(String.valueOf(i + 1)));
        }
    }

    public static void main(String[] args) {
        new Griding().setVisible(true);
    }
}

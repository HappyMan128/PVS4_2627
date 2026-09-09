package gui;

import javax.swing.*;
import java.awt.*;

public class Flowing extends JFrame {

    public Flowing() {
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        for (int i = 0; i < 6; i++) {
            JButton button = new JButton(String.valueOf(i + 1));
            button.setFont(new Font("Consolas", Font.BOLD, 20));
            button.setBackground(Color.blue);
            button.setForeground(Color.white);
            add(button);
        }
    }

    public static void main(String[] args) {
        new Flowing().setVisible(true);
    }
}

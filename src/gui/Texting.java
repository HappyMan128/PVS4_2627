package gui;

import javax.swing.*;
import java.awt.*;

public class Texting extends JFrame {
    public Texting() {
//        setSize(600, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new FlowLayout());

        JTextField textField = new JTextField("19");
        textField.setPreferredSize(new Dimension(200, 70));
        textField.setFont(new Font("Calibri", Font.PLAIN, 34));
//        textField.setBackground(Color.yellow);
        textField.setHorizontalAlignment(SwingConstants.CENTER);



        JButton button = new JButton("Print");
        button.setSize(140, 70);
        button.addActionListener(e -> {
            int x = Integer.parseInt(textField.getText());
            new GridPane(x).setVisible(true);
        });

        add(button);
        add(textField);
        pack();
    }

    public static void main(String[] args) {
        new Texting().setVisible(true);
    }
}

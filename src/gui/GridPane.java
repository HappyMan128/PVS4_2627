package gui;

import javax.swing.*;
import java.awt.*;

public class GridPane extends JFrame {

    public GridPane() {
        int dimension = 10;
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setLayout(new GridLayout(dimension, dimension));

        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if ((i + j) % 2 == 0) {
                    add(new Piece(Color.cyan));
                }
                else {
                    add(new Piece(Color.red));
                }
            }

        }
    }

    public static void main(String[] args) {
        new GridPane().setVisible(true);
    }
}

//custom component
class Piece extends JLabel {
    public Piece(Color color) {
        setText(" ");
        setFont(new Font("Comic Sans", Font.PLAIN, 18));
        setHorizontalAlignment(CENTER);
        setVerticalAlignment(CENTER);
        setBorder(BorderFactory.createLineBorder(Color.black, 4));
        setOpaque(true);
        setBackground(color);
    }
}
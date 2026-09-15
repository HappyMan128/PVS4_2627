package gui;

import javax.swing.*;
import java.awt.*;

public class GridPane extends JFrame {

    final static int DEFAULT_DIM = 10;

    public GridPane(int dim) {
        int dimension = dim;
        setSize(600, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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

    public GridPane() {
        this(DEFAULT_DIM);
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
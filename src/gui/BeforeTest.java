package gui;

import javax.swing.*;
import java.awt.*;

public class BeforeTest extends JFrame {

    public BeforeTest() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setTitle("Prosím za 1. :)");
        setLayout(new BorderLayout());

        int rows = 10;
        int columns = 11;

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel leftPanel = new JPanel(new GridLayout(5, 1));
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel centerPanel = new JPanel(new GridLayout(10, 11, 5, 5));

        JRadioButton optA = new JRadioButton("Option A");
        JRadioButton optB = new JRadioButton("Option B");
        JRadioButton optC = new JRadioButton("Option C");
        JRadioButton optD = new JRadioButton("Option D");
        JRadioButton optE = new JRadioButton("Option E");

        JLabel result = new JLabel((rows * columns) + " results");
        JLabel query = new JLabel("Query:");

        JButton searchButton = new JButton("Search");


        JTextField searchBar = new JTextField();

        searchBar.setPreferredSize(new Dimension(200, 20));
        topPanel.setBorder(BorderFactory.createLineBorder(Color.black, 2, false));
        result.setFont(new Font("Calibri", Font.ITALIC, 12));

        for (int i = 0; i < rows * columns; i++) {
            JButton b = new JButton("Tile " + (i + 1));
            b.setBackground(Color.white);
            b.setFocusable(false);
            b.setFont(new Font("Calibri", Font.PLAIN, 15));
            b.setHorizontalAlignment(SwingConstants.CENTER);
            b.setVerticalAlignment(SwingConstants.CENTER);
            centerPanel.add(b);
        }

        ButtonGroup group = new ButtonGroup();

        group.add(optA);
        group.add(optB);
        group.add(optC);
        group.add(optD);
        group.add(optE);

        leftPanel.add(optA);
        leftPanel.add(optB);
        leftPanel.add(optC);
        leftPanel.add(optD);
        leftPanel.add(optE);

        bottomPanel.add(result);

        topPanel.add(query);
        topPanel.add(searchBar);
        topPanel.add(searchButton);

        add(topPanel, BorderLayout.NORTH);
        add(leftPanel, BorderLayout.WEST);
        add(bottomPanel, BorderLayout.SOUTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    static void main() {
        new BeforeTest().setVisible(true);
    }
}
//class FancyButton extends JButton {
//    public FancyButton() {
//        setFont(new Font("Calibri", Font.PLAIN, 12));
//        setHorizontalAlignment(CENTER);
//        setVerticalAlignment(CENTER);
//    }
//}

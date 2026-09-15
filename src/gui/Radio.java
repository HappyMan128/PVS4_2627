package gui;

import javax.swing.*;
import java.awt.*;

public class Radio extends JFrame {

    public Radio() {
        setSize(600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel(new FlowLayout());
        JPanel centerPanel = new JPanel();

        JRadioButton rbRed = new JRadioButton("Red");
        JRadioButton rbGreen = new JRadioButton("Green");
        JRadioButton rbBlue = new JRadioButton("Blue");

        JCheckBox cdBorder = new JCheckBox("Border");

        JButton button = new JButton("Paint");

        button.addActionListener(e -> {
            if (rbRed.isSelected()){
                centerPanel.setBackground(Color.red);
            }
            else if (rbGreen.isSelected()){
                centerPanel.setBackground(Color.green);
            }
            else if (rbBlue.isSelected()){
                centerPanel.setBackground(Color.blue);
            }

            if (cdBorder.isSelected()) {
                centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 10, false));
            }
            else {
                centerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 0, false));
            }
        });

        ButtonGroup group = new ButtonGroup();

        topPanel.add(rbRed);
        topPanel.add(rbGreen);
        topPanel.add(rbBlue);
        topPanel.add(cdBorder);
        topPanel.add(button);

        group.add(rbRed);
        group.add(rbGreen);
        group.add(rbBlue);

        centerPanel.setBackground(Color.MAGENTA);
        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new Radio().setVisible(true);
    }
}

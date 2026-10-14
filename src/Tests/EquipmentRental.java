package Tests;

import gui.Grid;
import gui.GridPane;

import javax.swing.*;
import java.awt.*;

public class EquipmentRental extends JFrame {

    JTextField name, roomNumber;
    JRadioButton ski, snowboard, crossSkis;
    JCheckBox discount;
    JSlider days;
    JButton rent, clear;

    public EquipmentRental() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(600, 600);
        setTitle("Ski Rental");
        setLocationRelativeTo(null);

        JLabel top = new JLabel("Mountain Equipment Rental");
        JPanel center = new JPanel(new GridLayout(5, 1));
        JPanel bottom = new JPanel(new FlowLayout());

        top.setFont(new Font("Calibri", Font.BOLD, 30));
        top.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel nameLabel = new JLabel("Customer name:");
        JLabel numberLabel = new JLabel("Room Number:");
        JLabel equipmentLabel = new JLabel("Equipment:");
        JLabel discountLabel = new JLabel("Student discount:");
        JLabel daysLabel = new JLabel("Rental days:");

        name = new JTextField();
        roomNumber = new JTextField();

        name.setPreferredSize(new Dimension(50, 50));
        roomNumber.setPreferredSize(new Dimension(50, 50));

        ski = new JRadioButton("Skis");
        snowboard = new JRadioButton("Snowboard");
        crossSkis = new JRadioButton("Cross-country skis");

        discount = new JCheckBox();

        days = new JSlider(1, 14, 1);

        days.setMajorTickSpacing(1);
        days.setPaintTicks(true);
        days.setPaintLabels(true);
        days.setPaintTrack(true);

        ButtonGroup group = new ButtonGroup();

        group.add(ski);
        group.add(snowboard);
        group.add(crossSkis);

        ski.setSelected(true);

        rent = new JButton("Rent");
        clear = new JButton("Clear");

        rent.addActionListener(e -> rentEquipment());
        clear.addActionListener(e -> clearApp());

        bottom.add(rent);
        bottom.add(clear);

        center.add(nameLabel);
        center.add(name);
        center.add(numberLabel);
        center.add(roomNumber);
        center.add(equipmentLabel);
        center.add(new EquipmentContent(ski, snowboard, crossSkis));
        center.add(discountLabel);
        center.add(discount);
        center.add(daysLabel);
        center.add(days);

        add(top, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        add(bottom, BorderLayout.SOUTH);
    }

    public void rentEquipment() {
        String message = "";
        boolean problem = false;
        if (name.getText().isBlank()) {
            message = message + "Customer name is missing. ";
            problem = true;
        }

        try {
            if (roomNumber.getText().isBlank()) {
                message = message + "Room number is missing. ";
                problem = true;
            } else if (Integer.parseInt(roomNumber.getText()) < 100 || Integer.parseInt(roomNumber.getText()) > 699) {
                message = message + "Invalid room number. Room numbers are 100 - 699. ";
                problem = true;
            }
        } catch (NumberFormatException e) {
            message = message + "Invalid room number. Please type a whole number from 100 - 699. ";
            problem = true;
        }

        if (crossSkis.isSelected() && discount.isSelected()) {
            message = message + "Student discount is not for Cross-country skis. ";
            problem = true;
        }

        if (crossSkis.isSelected() && days.getValue() > 7) {
            message = message + "Cross-country skis can be rented only for a week. ";
            problem = true;
        }

        if (!problem) {
            message = "OK";
        }

        JOptionPane.showMessageDialog(null,
                message,
                "Rent",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public void clearApp() {
        name.setText("");
        roomNumber.setText("");
        discount.setSelected(false);
    }

    static void main() {
        new EquipmentRental().setVisible(true);
    }
}

class EquipmentContent extends JPanel{
     public EquipmentContent(JRadioButton one, JRadioButton two, JRadioButton three) {
         setLayout(new FlowLayout());
         add(one);
         add(two);
         add(three);
     }
}
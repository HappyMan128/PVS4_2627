package gui;

import javax.swing.*;

public class Options {
    public static void main(String[] args) {
        String input = JOptionPane.showInputDialog("Zadej něco");
        System.out.println(input);

        int answer = JOptionPane.showConfirmDialog(null,
        "Uzavřená otázka",
                "titulek",
                JOptionPane.YES_NO_OPTION);

        JOptionPane.showMessageDialog(null,
                "Uzavřená otázka",
                "titulek",
                JOptionPane.QUESTION_MESSAGE);

        JFileChooser chooser = new JFileChooser();
        int code = chooser.showOpenDialog(null);
        System.out.println(code);
        System.out.println(chooser.getSelectedFile().getAbsolutePath());
    }
}

package gui;

import javax.swing.*;
import java.awt.*;

public class Progressing extends JFrame {

    JProgressBar bar;

    public Progressing() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(800, 400);
        setLayout(null);

        bar = new JProgressBar(0, 500);
        bar.setFont(new Font("Consolas", Font.BOLD, 20));
        bar.setForeground(Color.MAGENTA);

        bar.setBounds(0, 0, getWidth(), 60);
        bar.setValue(50);
        bar.setStringPainted(true);

        add(bar);
    }

    public void fill() {
        int counter = 500;
        bar.setValue(500);
        while (counter > 0) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            counter--;
            bar.setValue(counter);
        }
    }

    static void main() {
        Progressing p = new Progressing();
        p.setVisible(true);
        p.fill();
    }
}

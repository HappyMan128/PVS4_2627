package Tests;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class FileTest {
    public static void main(String[] args) {
        new InputWindow().setVisible(true);
    }
}
class InputWindow extends JFrame {
    public InputWindow() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setSize(600, 300);
        setTitle("File Statistics");

        JTextField path = new JTextField();
        JPanel center = new JPanel(new FlowLayout());

        JButton load = new JButton("Load File");
        JButton stats = new JButton("Show Statistics");

        load.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            int code = chooser.showOpenDialog(null);
            System.out.println(code);
            path.setText(chooser.getSelectedFile().getAbsolutePath());
        });

        stats.addActionListener(a -> {
            File p = new File(path.getText());
            if (!p.exists() && p.listFiles() == null) {
                JOptionPane.showMessageDialog(null,
                        "File or directory does not exist.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                new Statistics(p).setVisible(true);
            }
        });

        center.add(load);
        center.add(stats);

        add(path, BorderLayout.NORTH);
        add(center, BorderLayout.CENTER);
        this.pack();
    }
}
class Statistics extends JFrame {;
    public Statistics(File path) {
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(800, 600);
        setLayout(new GridLayout(8, 1));
        setTitle("Statistics");

        String name = path.getName();
        String type;
        String textPath = path.getAbsolutePath();
        int sumFiles;
        int sumDirectories;
        String sumSize;
        String biggestFile;
        String biggestFileSize;

        if (!path.isDirectory()) {
            type = "Soubor";
            sumFiles = 1;
            sumDirectories = 0;
            sumSize = (path.getTotalSpace() / 1024 * 1024) + "MB";
            biggestFile = path.getName();
            biggestFileSize = (path.getTotalSpace() / 1024 * 1024) + "MB";
        } else {
            type = "Složka";
            File[] content = path.listFiles();
            sumFiles = content.length;
            int count = 0;
            float sum = 0;
            float helpSum = 0;
            File helpBiggest = new File("");
            for (int i = 0; i < content.length; i++) {
                helpSum = content[i].getTotalSpace() / 1024 * 1024;
                if (content[i].isDirectory()) {
                    count++;
                }
                if (helpBiggest.getTotalSpace() < content[i].getTotalSpace()) {
                    helpBiggest = content[i];
                }
                sum += helpSum;
            }
            sumDirectories = count;
            sumSize = sum + "MB";
            biggestFile = helpBiggest.getName();
            biggestFileSize = (helpBiggest.getTotalSpace() / 2048) + "MB";
        }

        add(new StatPanel("Název:", name));
        add(new StatPanel("Typ:", type));
        add(new StatPanel("Cesta:", textPath));
        add(new StatPanel("Počet souborů:", String.valueOf(sumFiles)));
        add(new StatPanel("Počet podsložek:", String.valueOf(sumDirectories)));
        add(new StatPanel("Celková velikost souborů:", sumSize));
        add(new StatPanel("Největší soubor:", biggestFile));
        add(new StatPanel("Velikost největšího souboru:", biggestFileSize));
    }
}
class StatPanel extends JPanel {
    public StatPanel(String thing, String s) {
        setLayout(new FlowLayout());

        JLabel what = new JLabel(thing);
        JLabel stat = new JLabel(s);

        what.setFont(new Font("Consolas", Font.BOLD, 12));
        stat.setFont(new Font("Consolas", Font.BOLD, 12));
        what.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        stat.setBorder(BorderFactory.createLineBorder(Color.black, 1));

        add(what);
        add(stat);
    }
}
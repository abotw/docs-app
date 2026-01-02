import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyAdvancedGui {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Advanced GUI Example");
        
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem newItem = new JMenuItem("New");
        fileMenu.add(newItem);
        newItem.addActionListener(new ActionListener() {    // anonymous class
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "You selected 'new'!", "Menu Action", JOptionPane.PLAIN_MESSAGE);
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit");
        fileMenu.add(exitItem);
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Confirm Exit", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });

        JMenu optionsMenu = new JMenu("Options");
        menuBar.add(optionsMenu);

        final JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);
        panel.setBackground(Color.LIGHT_GRAY);

        JMenuItem changeColorItem = new JMenuItem("Change Background Color");
        optionsMenu.add(changeColorItem);
        changeColorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int r = (int) (Math.random() * 256);
                int g = (int) (Math.random() * 256);
                int b = (int) (Math.random() * 256);

                Color newColor = new Color(r, g, b);

                panel.setBackground(newColor);
                panel.setOpaque(true);
                panel.repaint();
            }
        });

        JButton infoButton = new JButton("Show Information");
        panel.add(infoButton);
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, 
                    "This is an exapmle for interactive GUI programming.",
                    "About",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });

        frame.setVisible(true);
    }
}
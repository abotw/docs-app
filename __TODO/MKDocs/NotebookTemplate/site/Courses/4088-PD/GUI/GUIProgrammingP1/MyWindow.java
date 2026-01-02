import javax.swing.*;

public class MyWindow extends JFrame {
    public MyWindow() {
        this.setTitle("JFrame Example");
        this.setSize(400, 300);
        this.setLocation(600, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JMenuBar menuBar = new JMenuBar();
        JMenu menuF = new JMenu("File");
        JMenuItem item1 = new JMenuItem("Open");
        JMenuItem item2 = new JMenuItem("Save As");
        menuF.add(item1);
        menuF.add(item2);
        JMenu menuH = new JMenu("help");
        menuBar.add(menuF);
        menuBar.add(menuH);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new MyWindow();
    }
}
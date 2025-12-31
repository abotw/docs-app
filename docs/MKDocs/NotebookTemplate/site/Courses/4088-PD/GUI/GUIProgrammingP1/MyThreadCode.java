import javax.swing.JFrame;

class MyThreadCode implements Runnable {
    @Override
    public void run() {
        JFrame f = new JFrame("Frame Title");
        f.setSize(400, 300);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
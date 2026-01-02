import javax.swing.JOptionPane;

public class TestIO {
    public static void main(String[] args) {
        String str = JOptionPane.showInputDialog(null, "Type some text: ", "Window Title", JOptionPane.QUESTION_MESSAGE);
        JOptionPane.showMessageDialog(null, "str is: " + str, "Window Title", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showMessageDialog(null, "str is: " + str, "Window Title", JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(null, "str is: " + str, "Window Title", JOptionPane.WARNING_MESSAGE);
        JOptionPane.showMessageDialog(null, "str is: " + str, "Window Title", JOptionPane.ERROR_MESSAGE);
    }
}
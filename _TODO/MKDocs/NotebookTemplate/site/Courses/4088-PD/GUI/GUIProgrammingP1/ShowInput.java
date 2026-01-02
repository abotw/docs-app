import javax.swing.JOptionPane;

public class ShowInput {
    public static void main(String[] args) {
        String str = JOptionPane.showInputDialog("Type some text: ");
        JOptionPane.showMessageDialog(null, "str is: " + str);
    }
}
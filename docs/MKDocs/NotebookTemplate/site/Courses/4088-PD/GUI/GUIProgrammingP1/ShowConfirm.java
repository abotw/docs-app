import javax.swing.JOptionPane;

public class ShowConfirm {
    public static void main(String[] args) {
        int result = JOptionPane.showConfirmDialog(null, "Are you happy?", "Window Title", JOptionPane.YES_NO_CANCEL_OPTION);
        JOptionPane.showMessageDialog(null, "Button clicked: " + result);
    }
}
import javax.swing.*; // Import the Swing library for GUI components
import java.awt.event.ActionEvent; // Import ActionEvent for handling button clicks
import java.awt.event.ActionListener; // Import ActionListener for button click listener

public class SimpleGuiExample {

    public static void main(String[] args) {
        // Create the main frame (window)
        JFrame frame = new JFrame("My First GUI"); // Set the window title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Close operation when the 'X' button is clicked
        frame.setSize(400, 300); // Set the initial size of the window
        frame.setLocationRelativeTo(null); // Center the window on the screen

        // Create a panel to organize components
        JPanel panel = new JPanel();
        frame.add(panel); // Add the panel to the frame

        // Create a button
        JButton button = new JButton("Click Me!"); // Set the button text
        panel.add(button); // Add the button to the panel

        // Add an ActionListener to the button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // This code will be executed when the button is clicked
                JOptionPane.showMessageDialog(frame, "Hello, GUI World!", "Message", JOptionPane.INFORMATION_MESSAGE);
                // Show a message dialog:
                // - 'frame' is the parent component (the window)
                // - "Hello, GUI World!" is the message to display
                // - "Message" is the title of the dialog box
                // - JOptionPane.INFORMATION_MESSAGE sets the icon to an information icon
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
import javax.swing.*; // Import Swing for GUI components
import java.awt.*;    // Import AWT for basic GUI functionalities like Color and BorderLayout
import java.awt.event.ActionEvent; // Import ActionEvent for event handling
import java.awt.event.ActionListener; // Import ActionListener for event handling

public class AdvancedGuiExample {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Advanced GUI Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null); // Center the window

        // --- Create a Menu Bar ---
        JMenuBar menuBar = new JMenuBar(); // Create the menu bar
        frame.setJMenuBar(menuBar); // Set the menu bar for the frame

        // --- Create File Menu ---
        JMenu fileMenu = new JMenu("File"); // Create a "File" menu
        menuBar.add(fileMenu); // Add the "File" menu to the menu bar

        JMenuItem newItem = new JMenuItem("New"); // Create a "New" menu item
        fileMenu.add(newItem); // Add "New" to the "File" menu
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "You selected 'New'!", "Menu Action", JOptionPane.PLAIN_MESSAGE);
            }
        });

        JMenuItem exitItem = new JMenuItem("Exit"); // Create an "Exit" menu item
        fileMenu.add(exitItem); // Add "Exit" to the "File" menu
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int response = JOptionPane.showConfirmDialog(frame,
                        "Are you sure you want to exit?", "Confirm Exit",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                // Show a confirmation dialog:
                // - 'frame' is the parent
                // - "Are you sure..." is the message
                // - "Confirm Exit" is the title
                // - JOptionPane.YES_NO_OPTION provides Yes/No buttons
                // - JOptionPane.QUESTION_MESSAGE sets the icon to a question icon

                if (response == JOptionPane.YES_OPTION) {
                    System.exit(0); // Exit the application if 'Yes' is selected
                }
            }
        });

        // --- Create Options Menu ---
        JMenu optionsMenu = new JMenu("Options"); // Create an "Options" menu
        menuBar.add(optionsMenu); // Add "Options" to the menu bar

        // Create a JPanel that will hold our main content and whose background we will change
        // It's crucial to declare it 'final' or an instance variable if you want to access it inside
        // an anonymous inner class (like the ActionListener).
        final JPanel panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER); // Add panel to the center of the frame
        panel.setBackground(Color.LIGHT_GRAY); // Set initial panel background color

        JMenuItem changeColorItem = new JMenuItem("Change Background Color"); // Create a "Change Color" menu item
        optionsMenu.add(changeColorItem); // Add "Change Color" to the "Options" menu
        changeColorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Randomly generate new RGB values
                int r = (int) (Math.random() * 256);
                int g = (int) (Math.random() * 256);
                int b = (int) (Math.random() * 256);
                
                Color newColor = new Color(r, g, b);
                
                // IMPORTANT FIX: Set the background of the 'panel', not the frame's content pane.
                panel.setBackground(newColor); 
                panel.setOpaque(true); // Ensure the panel is opaque to show its own background
                
                // Request a repaint to ensure the UI updates immediately
                panel.repaint(); // Repaint the panel
                // frame.repaint(); // Repainting the frame also works, as it will repaint its children
            }
        });

        // --- Create a Button for another interaction ---
        // The panel already exists and is added above, so we just add the button to it.
        JButton infoButton = new JButton("Show Information"); // Create an "Information" button
        panel.add(infoButton); // Add the button to the panel
        infoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame,
                        "This is an example of interactive GUI programming.",
                        "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }
}
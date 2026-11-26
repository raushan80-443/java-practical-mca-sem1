/*
 * Q11: Swing GUI and Button Click Event
 * Question: Build a graphical user interface (GUI) using Java Swing components and register action listeners for button click event handling.
 */

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class q11 {
    public static void main(String[] args) {
        // Create the top-level application window
        JFrame frame = new JFrame("Swing Event Handling Demo");
        frame.setSize(350, 180);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Exit app when window closes
        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 15)); // Arrange components left-to-right

        // Create UI components
        JLabel label = new JLabel("Click the button below", SwingConstants.CENTER);
        JButton button = new JButton("Click Me!");

        // Register an ActionListener to handle button clicks
        button.addActionListener(new ActionListener() {
            private int clickCount = 0;

            @Override
            public void actionPerformed(ActionEvent e) {
                clickCount++;
                label.setText("Button clicked " + clickCount + " times!");
            }
        });

        // Add components to the frame and make the window visible
        frame.add(label);
        frame.add(button);
        frame.setVisible(true);
    }
}

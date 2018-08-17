package Panels;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JFrame implements ActionListener {

    // Window Dimensions
    private final int WIN_WIDTH = 800;
    private final int WIN_HEIGHT = 600;

    // Graphical Components
    private JButton clickToStart;

    // Sub-Panels
    private WelcomeScreen welcome;

    public ControlPanel() {
        super();

        createComponents();    // Create buttons
        createWelcomeScreen(); // Create the next panel
        constructFrame();      // Setup this
    }

    /**
     Draws welcome button.
     */
    private void createComponents() {
        clickToStart = new JButton("Click me to Start the game!");
        this.add(clickToStart);
        clickToStart.addActionListener(this);
    }

    /**
     Creates the welcome screen Panel, which is the main menu basically.
     */
    private void createWelcomeScreen() {
        welcome = new WelcomeScreen();
    }

    /**
     Sets Frame details.
     */
    private void constructFrame() {
        setTitle("Asteroids Clone");
        setSize(WIN_WIDTH, WIN_HEIGHT);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // Trap the event source
        Object obj = ae.getSource();

        /* If clickToStart was clicked, draw the next panel. */
        if (obj == clickToStart) {

            // Remove the welcome button
            this.remove(clickToStart);

            // Add the welcome screen
            this.getContentPane().add(welcome, "Center");
            validate();
            repaint();
        }
    }

}

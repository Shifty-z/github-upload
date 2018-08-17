package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomeScreen extends JPanel implements ActionListener {

    // Sub-Panels
    private StartGame startGame;
    private Options options;

    // Buttons corresponding to Panels
    private JButton btnStart;
    private JButton btnOptions;
    private JButton btnExit;

    // Game components
    private int endScore = 0;

    public WelcomeScreen() {
        super();

        createLayout(); // Sets the layout
        createButtons(); // Create Menu Buttons
        createMenuObjects(); // Create Menu Objects
        listenToSubPanelButtons(); // Listens to all sub-panel buttons

    }

    /**
     Set Layout Manager and its values.
     */
    private void createLayout() {
        final int ROWS = 3;
        final int COLUMNS = 1;
        setLayout(new GridLayout(ROWS, COLUMNS));
    }

    /**
     Handles the creation of menu objects.
     */
    private void createMenuObjects() {
        startGame = new StartGame();
        options = new Options();
    }

    /**
     Creates Panel buttons, add them to the panel, then attach listeners.
     */
    private void createButtons() {
        btnStart = new JButton("Start Game");
        btnOptions = new JButton("Options");
        btnExit = new JButton("Exit Game");

        this.add(btnStart);
        this.add(btnOptions);
        this.add(btnExit);

        btnStart.addActionListener(this);
        btnOptions.addActionListener(this);
        btnExit.addActionListener(this);
    }

    /**
     Listens to all sub-panel buttons that have been created.
     */
    private void listenToSubPanelButtons() {
        startGame.getBackButton().addActionListener(this);
        options.getBackButton().addActionListener(this);
    }

    /**
     If a user comes back to the menu, add the menu buttons back to the panel.
     */
    private void drawMenu() {
        this.add(btnStart);
        this.add(btnOptions);
        this.add(btnExit);
    }

    /* Button Event Handling */
    public void actionPerformed(ActionEvent ae) {
        // Trap event source
        Object obj = ae.getSource();

        /* Send the user to sub-panels, or exit, based on what they click */
        if (obj == btnStart) {
            this.removeAll();

            // Set the layout before drawing the new panel
            setLayout(new BorderLayout());
            add(startGame, "Center");

            repaint();
            validate();
        }
        else if (obj == btnOptions) {
            removeAll();

            // Set the layout before drawing the new panel
            setLayout(new BorderLayout());
            add(options, "Center");

            repaint();
            validate();
        }
        else if (obj == btnExit) {
            System.exit(0);
        }

        /* Handle Options panel button clicks */
        else if (obj == options.getResetScore()) {
            // Reset Score
        }
        else if (obj == options.getResetTime()) {
            // Reset Timer
        }
        else if (obj == options.getResetHits()) {
            // Reset number of times object has been hit
        }
        else if (obj == options.getBackButton()) {
            this.removeAll();

            // Redo the layout and redraw menu buttons
            createLayout();
            drawMenu();

            repaint();
            validate();
        }

        /* Handle StartGame button clicks */
        else if (obj == startGame.getBackButton()) {
            this.removeAll();

            // Redo the layout and redraw menu buttons
            createLayout();
            drawMenu();

            repaint();
            validate();
        }
    }
}

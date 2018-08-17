package Panels;

import javax.swing.*;
import java.awt.*;

public class Options extends JPanel {

    // Graphical Components
    private JButton resetScore;
    private JButton resetTime;
    private JButton resetHits;
    private JButton resetGame;
    private JButton back;

    public Options() {
        super();

        createLayout();  // Sets Layout
        createButtons(); // Creates panel buttons

        /* Have an options setting to change the color of the player's shape */
    }

    /**
     Sets the Layout Manager.
     */
    private void createLayout() {
        final int ROWS = 5;
        final int COLUMNS = 1;
        setLayout(new GridLayout(ROWS, COLUMNS));
    }

    /**
     Initializes Panel buttons.
     */
    private void createButtons() {
        resetScore = new JButton("Reset Score");
        resetTime = new JButton("Reset Time");
        resetHits = new JButton("Reset Hit");
        resetGame = new JButton(" Reset Game");
        back = new JButton("Go Back");

        add(resetScore);
        add(resetTime);
        add(resetHits);
        add(resetGame);
        add(back);
    }

    /* Get Options Buttons, just returns them*/
    public JButton getResetScore() {
        return this.resetScore;
    }

    public JButton getResetTime() {
        return this.resetTime;
    }

    public JButton getResetHits() {
        return this.resetHits;
    }

    public JButton getResetGame() {
        return this.resetGame;
    }

    public JButton getBackButton() {
        return this.back;
    }
}

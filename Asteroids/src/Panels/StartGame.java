package Panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StartGame extends JPanel implements ActionListener, KeyListener {

    // Graphical Components
    private JButton back;

    // Game Objects
    private GameObject player;
    private GameObject missle; // If rapid fire, have 5 of these, just recycle them implement an ammo system

    // Game components
    private Timer gameTimer;
    private Timer pixelMovement;
    private int score = 0;
    private int hits = 0;
    private int timeSpent = 0;
    private boolean hasShot = false;

    public StartGame() {
        super();
        setLayout(null);

        createTimer();
        createButtons();
        createGameObjects();
    }

    /**
     Creates Timers used for this game.
     */
    private void createTimer() {
        gameTimer = new Timer(1000, this);
        pixelMovement = new Timer(250, this);
    }

    /**
     Handles the creation of this panel's buttons.
     */
    private void createButtons() {
        back = new JButton("Go Back");

        // xPosition, yPosition, btnWidth, btnHeight
        back.setBounds(5, 480, 100, 75);

        add(back);

        back.addActionListener(this); // So we can stop the timers used here

        repaint();
        validate();
    }

    /**
     Creates all game objects.
     */
    private void createGameObjects() {
        int moveSpeed = 1;
        int health = 25;
        int x = 400; // Half of the window width
        int y = 397; // Should sit on top of the game line

        // Player
        player = new GameObject(moveSpeed, health, x, y);

        // Missle object
        missle = new GameObject(11, health, x, y);
    }

    /**
     Handles timers and button clicks.
     @param ae Event source.
     */
    public void actionPerformed(ActionEvent ae) {
        // Trap the event source
        Object obj = ae.getSource();

        // Keeps track of the time spent playing the game
        if (obj == gameTimer) {
            timeSpent++;


            repaint();
            validate();
        }
        /* Each tick, update the shot location */
        else if (obj == pixelMovement) {

            /* Move the shot until the shot travels a distance */
            if (missle.getYPosition() > 20) {
                // Store the missle's old y position
                int oldY = missle.getYPosition();

                // Have the missle move based on its movement speed
                missle.setYPosition(oldY - missle.getSpeed());

                repaint();
                validate();
            }
            // Prevent the user from "reseting" their shot mid flight
            else if (missle.getYPosition() < 20) {
                hasShot = false;
                pixelMovement.stop();
            }
        }
        // If the user clicks back, stop timers
        else if (obj == back) {
            gameTimer.stop();
            pixelMovement.stop();
        }
    }


    /**
     Handle keyboard inputs.
     @param ke KeyBoard button pressed.
     */
    @Override
    public void keyPressed(KeyEvent ke) {
        int key = ke.getKeyCode();

        // If the user starts the game
        if (key == ke.VK_SPACE) {
            // Start all required timers
            gameTimer.start();
        }
        else if (key == ke.VK_LEFT) {
            // Store the player's current location and add a movement value to it
            final int oldX = player.getXPosition();

            // Move the player left by the movement speed
            player.setXPosition(oldX - player.getSpeed());

            repaint();
            validate();
        }
        else if (key == ke.VK_RIGHT) {
            int oldX = player.getXPosition();

            // Move the player right by the movement speed
            player.setXPosition(oldX + player.getSpeed());

            repaint();
            validate();
        }
        else if (key == ke.VK_S && ! hasShot) {
            // Start drawing their shot pixel
            pixelMovement.start();
            hasShot = true;

            // Store where the shot was fired from (x-axis) so shot doesn't move with player movement
            final int shotFrom = player.getXPosition();

            /* Assign the missle starting x and y positions */
            missle.setXPosition(shotFrom);
            missle.setYPosition(player.getYPosition());
        }
    }


    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        /* Draw instructions */
        g.drawString("Press the space bar to start the game!", 10, 10);

        /* Strings of game information */
        String gameScore = String.format("Score: %d", score);
        String timesHit = String.format("Times Hit: %d", hits);
        String timePlayed = String.format("Time Played: %d", timeSpent);

        /* Draw game stats */
        g.drawString("Game Stats", 705, 10);
        g.drawLine(705, 12, 769, 12);
        g.drawString(gameScore, 725, 25);
        g.drawString(timesHit, 704, 40);
        g.drawString(timePlayed, 689, 55);

        /* Draw Platform line */
        g.drawLine(10, 450, 750, 450);

        /* Draw Player Object */
        g.setColor(Color.RED);
        g.fillRect(player.getXPosition(), player.getYPosition(), 75, 50);

        /* Draw a Missle only if user pressed fire key and prevent the user from resetting the shot mid flight */
        if (pixelMovement.isRunning() && hasShot) {
            g.setColor(Color.BLACK);
            g.fillRect(missle.getXPosition(), missle.getYPosition(), 10, 15);
        }


        /* Key Listener settings */
        setFocusable(true);
        addKeyListener(this); // Attaches Key Listener to this
        requestFocusInWindow();
    }

    /* Getters for Graphical Components added */
    public JButton getBackButton() {
        return this.back;
    }


    /* Do nothing KeyListener methods that must be implemented */
    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }


    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }

}

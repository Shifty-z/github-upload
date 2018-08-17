package Panels;

public class GameObject {

    // Stats all game objects have
    private int speed;
    private int health;
    private int xPosition;
    private int yPosition;

    /**
     Default constructor if no parameters are given
     */
    public GameObject() {
        this.speed = 30;
        this.health = 25;
        this.xPosition = 400;
        this.yPosition = 300;
    }

    /**
     Setup Objects with specific settings.
     @param speed Object movement speed.
     @param health Object Health.
     @param xPosition Object x-axis position.
     @param yPosition Object y-axis position.
     */
    public GameObject(int speed, int health, int xPosition, int yPosition) {
        this.speed = speed;
        this.health = health;
        this.xPosition = xPosition;
        this.yPosition = yPosition;
    }

    /* Getters for all of the GameObject attributes */
    public int getSpeed() {
        return this.speed;
    }

    public int getHealth() {
        return this.health;
    }

    public int getXPosition() {
        return this.xPosition;
    }

    public int getYPosition() {
        return this.yPosition;
    }

    /* Setters for all of the GameObject attributes */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }
}

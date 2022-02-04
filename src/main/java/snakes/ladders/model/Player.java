package snakes.ladders.model;

public class Player {
    int position;

    public Player() {
        position = 1;
        System.out.println("Player starting position: " + position);
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        System.out.println("Player's new position: " + position);
        this.position = position;
    }

}

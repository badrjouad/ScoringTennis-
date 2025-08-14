package fr.dauphine.eu;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Player {
    private final String name;
    private int points; // 0, 1, 2, 3...
    private boolean advantage;

    public Player(String name) {
        this.name = name;
        this.points = 0;
        this.advantage = false;
    }

    public void winPoint() {
        points++;
    }

    public void resetPoints() {
        points = 0;
        advantage = false;
    }

    public String displayPoints() {
        return switch (points) {
            case 0 -> "0";
            case 1 -> "15";
            case 2 -> "30";
            case 3 -> "40";
            default -> "";
        };
    }
}

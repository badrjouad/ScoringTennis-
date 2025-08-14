package fr.dauphine.eu;

import lombok.Data;

import java.util.List;
import java.util.NoSuchElementException;


public class Game {

    private final Player playerA;
    private final Player playerB;
    private GameStatus gameStatus;

    public Game() {
        this.playerA = new Player("A");
        this.playerB = new Player("B");
        this.gameStatus = GameStatus.IN_PROGRESS;
    }

    public boolean isDeuce() {
        return playerA.getPoints() >= 3 &&
                playerB.getPoints() >= 3 &&
                playerA.getPoints() == playerB.getPoints() &&
                !playerA.isAdvantage() &&
                !playerB.isAdvantage();
    }

    public void pointWonBy(String playerName) {
        Player winner = getPlayer(playerName);
        Player loser = getOpponent(playerName);

        if (isDeuce()) {
            winner.setAdvantage(true);
        }
        else if (winner.isAdvantage()) {
            gameStatus = winner == playerA ? GameStatus.WIN_A : GameStatus.WIN_B;
        }
        else if (loser.isAdvantage()) {
            loser.setAdvantage(false); // back to deuce
        }
        else if (winner.getPoints() < 3) {
            winner.winPoint();
        }
        else if (winner.getPoints() == 3 && loser.getPoints() < 3) {
            gameStatus = winner == playerA ? GameStatus.WIN_A : GameStatus.WIN_B;
        }
        else {
            winner.setAdvantage(true);
        }
    }

    public boolean gameOver() {
        return gameStatus == GameStatus.WIN_A || gameStatus == GameStatus.WIN_B;
    }

    public void printScore() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        if (gameOver()) {
            return gameStatus == GameStatus.WIN_A ? "Player A wins" : "Player B wins";
        }
        if (isDeuce()) {
            return "Deuce";
        }
        if (playerA.isAdvantage()) {
            return "Advantage A";
        }
        if (playerB.isAdvantage()) {
            return "Advantage B";
        }
        return String.format("Player A: %s / Player B: %s",
                playerA.displayPoints(), playerB.displayPoints());
    }

    private Player getPlayer(String playerName) {
        if (playerName.equals("A")) return playerA;
        if (playerName.equals("B")) return playerB;
        throw new NoSuchElementException("Player not found: " + playerName);
    }

    private Player getOpponent(String playerName) {
        return getPlayer(playerName.equals("A") ? "B" : "A");
    }
}

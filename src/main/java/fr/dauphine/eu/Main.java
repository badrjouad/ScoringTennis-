package fr.dauphine.eu;


public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        game.printScore();

        game.pointWonBy("A"); // 15-0
        game.printScore();

        game.pointWonBy("B"); // 15-15
        game.printScore();

        game.pointWonBy("A"); // 30-15
        game.printScore();

        game.pointWonBy("B"); // 30-30
        game.printScore();

        game.pointWonBy("A"); // 40-30
        game.printScore();

        game.pointWonBy("B"); // Deuce
        game.printScore();

        game.pointWonBy("A"); // Advantage A
        game.printScore();

        game.pointWonBy("A"); // Player A wins
        game.printScore();
    }
}

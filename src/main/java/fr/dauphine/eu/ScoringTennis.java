package fr.dauphine.eu;

public class ScoringTennis {

    public void scoringTennis(String score) {
        int pointsA = 0;
        int pointsB = 0;
        boolean advantageA = false;
        boolean advantageB = false;

        for (char c : score.toCharArray()) {
            if (c == 'A') {
                if (advantageA) {
                    System.out.println("Player A wins the game");
                    return;
                } else if (advantageB) {
                    advantageB = false;
                } else if (pointsA == 40 && pointsB == 40) {
                    advantageA = true;
                } else if (pointsA == 30) {
                    pointsA = 40;
                } else if (pointsA == 15) {
                    pointsA = 30;
                } else if (pointsA == 0) {
                    pointsA = 15;
                } else {
                    System.out.println("Player A wins the game");
                    return;
                }
            } else if (c == 'B') {
                if (advantageB) {
                    System.out.println("Player B wins the game");
                    return;
                } else if (advantageA) {
                    advantageA = false; // back to deuce
                } else if (pointsA == 40 && pointsB == 40) {
                    advantageB = true;
                } else if (pointsB == 30) {
                    pointsB = 40;
                } else if (pointsB == 15) {
                    pointsB = 30;
                } else if (pointsB == 0) {
                    pointsB = 15;
                } else {
                    System.out.println("Player B wins the game");
                    return;
                }
            }


            if (advantageA) {
                System.out.println("Advantage Player A");
            } else if (advantageB) {
                System.out.println("Advantage Player B");
            } else if (pointsA == 40 && pointsB == 40) {
                System.out.println("Deuce");
            } else {
                System.out.println("Player A : " + pointsA + " / Player B : " + pointsB);
            }
        }
    }
}

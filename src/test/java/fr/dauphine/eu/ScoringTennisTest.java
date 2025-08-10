package fr.dauphine.eu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScoringTennisTest {

    private final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    private ScoringTennis scoringTennis;

    @BeforeEach
    public void setUp() {
        scoringTennis = new ScoringTennis();
        outputStream.reset();
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void test() {
        String input = "ABABAA";

        scoringTennis.scoringTennis(input);

        String expectedOutput =
                "Player A : 15 / Player B : 0\n" +
                        "Player A : 15 / Player B : 15\n" +
                        "Player A : 30 / Player B : 15\n" +
                        "Player A : 30 / Player B : 30\n" +
                        "Player A : 40 / Player B : 30\n" +
                        "Player A wins the game\n";

        assertEquals(expectedOutput.replace("\n", System.lineSeparator()),
                outputStream.toString());
    }

    @Test
    public void testDeuceAndAdvantage() {

        String input = "ABABABAA";
        scoringTennis.scoringTennis(input);

        String expectedOutput =
                "Player A : 15 / Player B : 0\n" +
                        "Player A : 15 / Player B : 15\n" +
                        "Player A : 30 / Player B : 15\n" +
                        "Player A : 30 / Player B : 30\n" +
                        "Player A : 40 / Player B : 30\n" +
                        "Deuce\n" +
                        "Advantage Player A\n" +
                        "Player A wins the game\n";

        assertEquals(expectedOutput.replace("\n", System.lineSeparator()),
                outputStream.toString());
    }

    @Test
    public void testBackToDeuce() {
        String input = "ABABABAB";

        scoringTennis.scoringTennis(input);

        String expectedOutput =
                "Player A : 15 / Player B : 0\n" +
                        "Player A : 15 / Player B : 15\n" +
                        "Player A : 30 / Player B : 15\n" +
                        "Player A : 30 / Player B : 30\n" +
                        "Player A : 40 / Player B : 30\n" +
                        "Deuce\n" +
                        "Advantage Player A\n" +
                        "Deuce\n";

        assertEquals(expectedOutput.replace("\n", System.lineSeparator()),
                outputStream.toString());
    }
}

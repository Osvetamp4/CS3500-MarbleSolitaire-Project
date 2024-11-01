package org.example;

import org.example.solitairemodel.EnglishSolitaireModel;
import org.example.gameboard.Gameboard;
import org.example.interfaces.MarbleSolitaireModel;
import org.example.interfaces.MarbleSolitaireView;
import org.junit.jupiter.api.Test;

import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MarbleSolitaireControllerImplTest {
  Reader reader1 = new StringReader("5 3 3 3\nq");
  Reader reader2 = new StringReader("5 3 3\n5 3 3 p\nq");
  Reader reader3 = new StringReader("3 3 3 5");

  // testing the constructor exceptions
  @Test
  void constructorTest() {
    StringWriter output = new StringWriter();
    MarbleSolitaireModel model1 = new EnglishSolitaireModel(new Gameboard(3, 3, 3));
    MarbleSolitaireView view1 = new MarbleSolitaireTextView(model1, output);

    assertThrows(IllegalArgumentException.class, () -> new
            MarbleSolitaireControllerImpl(model1, view1, null));
    assertThrows(IllegalArgumentException.class, () -> new
            MarbleSolitaireControllerImpl(model1, null, reader1));
    assertThrows(IllegalArgumentException.class, () -> new
            MarbleSolitaireControllerImpl(null, view1, reader1));
  }

  // tests making a move, and then quitting in the method playGame
  @Test
  void playGameTestQuit() {
    StringWriter output = new StringWriter();
    MarbleSolitaireModel model1 = new EnglishSolitaireModel(new Gameboard(3, 3, 3));
    MarbleSolitaireView view1 = new MarbleSolitaireTextView(model1, output);

    MarbleSolitaireControllerImpl c = new MarbleSolitaireControllerImpl(model1, view1, reader1);
    assertEquals("", output.toString());
    c.playGame();

    String expectedOutput = "  0 1 2 3 4 5 6 \n" +
            "0     O O O     \n" +
            "1     O O O     \n" +
            "2 O O O O O O O \n" +
            "3 O O O _ O O O \n" +
            "4 O O O O O O O \n" +
            "5     O O O     \n" +
            "6     O O O     \n" +
            "Score: 32\n" +
            "Enter your next move: \n" +
            "  0 1 2 3 4 5 6 \n" +
            "0     O O O     \n" +
            "1     O O O     \n" +
            "2 O O O O O O O \n" +
            "3 O O O O O O O \n" +
            "4 O O O _ O O O \n" +
            "5     O _ O     \n" +
            "6     O O O     \n" +
            "Score: 31\n" +
            "Enter your next move: \n" +
            "Game quit!\nState of game when quit: \n" +
            "  0 1 2 3 4 5 6 \n" +
            "0     O O O     \n" +
            "1     O O O     \n" +
            "2 O O O O O O O \n" +
            "3 O O O O O O O \n" +
            "4 O O O _ O O O \n" +
            "5     O _ O     \n" +
            "6     O O O     \n" +
            "Score: 31\n";
    assertEquals(expectedOutput, output.toString());
  }

  // tests if bad inputs in the playGame method works
  @Test
  void playGameTestInput() {
    StringWriter output = new StringWriter();
    MarbleSolitaireModel model1 = new EnglishSolitaireModel(new Gameboard(3, 3, 3));
    MarbleSolitaireView view1 = new MarbleSolitaireTextView(model1, output);

    MarbleSolitaireControllerImpl c = new MarbleSolitaireControllerImpl(model1, view1, reader2);
    assertEquals("", output.toString());
    c.playGame();

    String expectedOutput = "  0 1 2 3 4 5 6 \n" +
            "0     O O O     \n" +
            "1     O O O     \n" +
            "2 O O O O O O O \n" +
            "3 O O O _ O O O \n" +
            "4 O O O O O O O \n" +
            "5     O O O     \n" +
            "6     O O O     \n" +
            "Score: 32\n" +
            "Enter your next move: \n" +
            "2 sets of coordinates required.\n" +
            "  0 1 2 3 4 5 6 \n" +
            "0     O O O     \n" +
            "1     O O O     \n" +
            "2 O O O O O O O \n" +
            "3 O O O _ O O O \n" +
            "4 O O O O O O O \n" +
            "5     O O O     \n" +
            "6     O O O     \n" +
            "Score: 32\n" +
            "Enter your next move: \n" +
            "All inputs must be integers.\n" +
            "Invalid move. Play again. At least one set of coordinates were invalid.\n" +
            "  0 1 2 3 4 5 6 \n" +
            "0     O O O     \n" +
            "1     O O O     \n" +
            "2 O O O O O O O \n" +
            "3 O O O _ O O O \n" +
            "4 O O O O O O O \n" +
            "5     O O O     \n" +
            "6     O O O     \n" +
            "Score: 32\n" +
            "Enter your next move: \n" +
            "Game quit!\n" +
            "State of game when quit: \n" +
            "  0 1 2 3 4 5 6 \n" +
            "0     O O O     \n" +
            "1     O O O     \n" +
            "2 O O O O O O O \n" +
            "3 O O O _ O O O \n" +
            "4 O O O O O O O \n" +
            "5     O O O     \n" +
            "6     O O O     \n" +
            "Score: 32\n";
    assertEquals(expectedOutput, output.toString());
  }

  // tests if finishing the game in the playGame method works
  @Test
  void playGameTestEnd() {
    StringWriter output = new StringWriter();
    MarbleSolitaireModel model1 = new EnglishSolitaireModel(new Gameboard(true));
    MarbleSolitaireView view1 = new MarbleSolitaireTextView(model1, output);

    MarbleSolitaireControllerImpl c = new MarbleSolitaireControllerImpl(model1, view1, reader3);
    assertEquals("", output.toString());
    c.playGame();

    String expectedOutput = "  0 1 2 3 4 5 6 \n" +
            "0               \n" +
            "1               \n" +
            "2               \n" +
            "3       O O _   \n" +
            "4               \n" +
            "5               \n" +
            "6               \n" +
            "Score: 2\n" +
            "Enter your next move: \n" +
            "Game over!\n" +
            "  0 1 2 3 4 5 6 \n" +
            "0               \n" +
            "1               \n" +
            "2               \n" +
            "3       _ _ O   \n" +
            "4               \n" +
            "5               \n" +
            "6               \n" +
            "Score: 1\n";
    assertEquals(expectedOutput, output.toString());
  }
}
package org.example;

import org.example.gameboard.EuropeanGameboard;
import org.example.gameboard.Gameboard;
import org.example.interfaces.MarbleSolitaireView;
import org.example.solitairemodel.EnglishSolitaireModel;
import org.example.interfaces.MarbleSolitaireController;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MarbleSolitaireTextViewTest {

  StringWriter output;

  void init() {
    EnglishSolitaireModel m = new EnglishSolitaireModel();
    Readable rd = new StringReader("1 3 3 3");
    Appendable ap = System.out;
    MarbleSolitaireView v = new MarbleSolitaireTextView(m,ap);
    MarbleSolitaireController c = new MarbleSolitaireControllerImpl(m,v,rd);
  }

  // testing the constructor exceptions
  @Test
  void constructorTest() {
    EnglishSolitaireModel m = new EnglishSolitaireModel();
    Appendable ap = System.out;
    assertThrows(IllegalArgumentException.class, () -> new MarbleSolitaireTextView(m, null));
    assertThrows(IllegalArgumentException.class, () -> new MarbleSolitaireTextView(null, ap));
  }

  // tests the toString method
  @Test
  void toStringTest() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(new Gameboard(3, 3, 3));
    MarbleSolitaireTextView v = new MarbleSolitaireTextView(e);
    assertEquals("  0 1 2 3 4 5 6 \n" +
            "0     O O O     \n" +
            "1     O O O     \n" +
            "2 O O O O O O O \n" +
            "3 O O O _ O O O \n" +
            "4 O O O O O O O \n" +
            "5     O O O     \n" +
            "6     O O O     \n", v.toString());

    //testing a European gameboard
    EnglishSolitaireModel e2 = new EnglishSolitaireModel(new EuropeanGameboard(3,3,3));
    MarbleSolitaireTextView v2 = new MarbleSolitaireTextView(e2);
    assertEquals("  0 1 2 3 4 5 6 \n" +
            "0     O O O     \n" +
            "1   O O O O O   \n" +
            "2 O O O O O O O \n" +
            "3 O O O _ O O O \n" +
            "4 O O O O O O O \n" +
            "5   O O O O O   \n" +
            "6     O O O     \n", v2.toString());
  }

  // tests the renderBoard method
  @Test
  void renderBoardTest() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(new Gameboard(3, 3, 3));
    output = new StringWriter();
    MarbleSolitaireTextView v = new MarbleSolitaireTextView(e, output);
    assertEquals("",output.toString());
    try {
      v.renderBoard();
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
    assertEquals("  0 1 2 3 4 5 6 \n" +
                    "0     O O O     \n" +
                    "1     O O O     \n" +
                    "2 O O O O O O O \n" +
                    "3 O O O _ O O O \n" +
                    "4 O O O O O O O \n" +
                    "5     O O O     \n" +
                    "6     O O O     \n",
            output.toString());
  }

  // tests the renderMessage method
  @Test
  void renderMessageTest() {
    EnglishSolitaireModel e = new EnglishSolitaireModel(new Gameboard(3, 3, 3));
    output = new StringWriter();
    MarbleSolitaireTextView v = new MarbleSolitaireTextView(e, output);
    assertEquals("",output.toString());
    try {
      v.renderMessage("The fitness gram pacer test is a multi-");
    } catch (IOException ex) {
      throw new RuntimeException(ex);
    }
    assertEquals("The fitness gram pacer test is a multi-\n",
            output.toString());
  }
}
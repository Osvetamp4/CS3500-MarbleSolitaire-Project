package org.example;

import org.example.gameboard.TriangleGameboard;
import org.example.solitairemodel.EnglishSolitaireModel;
import org.example.solitairemodel.TriangleSolitaireModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleSolitaireTextViewTest {

  // tests the toString method
  @Test
  void toStringTest() {
    TriangleSolitaireModel e = new TriangleSolitaireModel(new TriangleGameboard(4));
    TriangleSolitaireTextView v = new TriangleSolitaireTextView(e);
    assertEquals("0    _    \n" +
            "1   O O   \n" +
            "2  O O O  \n" +
            "3 O O O O \n" +
            "  0 1 2 3 \n", v.toString());

    TriangleSolitaireModel e2 = new TriangleSolitaireModel(
            new TriangleGameboard(5, 2, 1));
    TriangleSolitaireTextView v2 = new TriangleSolitaireTextView(e2);
    assertEquals("0     O     \n" +
            "1    O O    \n" +
            "2   O _ O   \n" +
            "3  O O O O  \n" +
            "4 O O O O O \n" +
            "  0 1 2 3 4 \n", v2.toString());
  }
}
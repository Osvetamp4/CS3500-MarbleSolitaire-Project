package org.example;

import org.example.gameboard.Gameboard;
import org.example.gameboard.TriangleGameboard;
import org.example.interfaces.MarbleSolitaireModelState;
import org.example.solitairemodel.EnglishSolitaireModel;
import org.example.solitairemodel.TriangleSolitaireModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TriangleSolitaireModelTest {

  // testing constructor exceptions
  @Test
  void constructorTest() {
    // Second constructor
    assertThrows(IllegalArgumentException.class, () -> new TriangleSolitaireModel(
            new TriangleGameboard(0,1)));
    assertThrows(IllegalArgumentException.class, () -> new TriangleSolitaireModel(
            new TriangleGameboard(-1,3)));
    assertThrows(IllegalArgumentException.class, () -> new TriangleSolitaireModel(
            new TriangleGameboard(3,4)));

    // Third constructor
    assertThrows(IllegalArgumentException.class, () -> new TriangleSolitaireModel(
            new TriangleGameboard(3)));
    assertThrows(IllegalArgumentException.class, () -> new TriangleSolitaireModel(
            new TriangleGameboard(0)));

    // Fourth constructor
    assertThrows(IllegalArgumentException.class, () -> new TriangleSolitaireModel(
            new TriangleGameboard(4, 0, 1)));
    assertThrows(IllegalArgumentException.class, () -> new TriangleSolitaireModel(
            new TriangleGameboard(3, 1, 1)));
    assertThrows(IllegalArgumentException.class, () -> new TriangleSolitaireModel(
            new TriangleGameboard(5, 5, 0)));
  }

  // tests the method move
  @Test
  void MoveTest() {
    TriangleSolitaireModel sol = new TriangleSolitaireModel(new TriangleGameboard(4));
    assertThrows(IllegalArgumentException.class,
            () -> sol.move(0, 0, 0, 2));
    assertThrows(IllegalArgumentException.class,
            () -> sol.move(1, 0, 3, 0));
    assertThrows(IllegalArgumentException.class,
            () -> sol.move(1, 3, 1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, sol.getSlotAt(0, 0));

    //testing diagonal upwards movement
    sol.move(2, 2, 0, 0);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, sol.getSlotAt(0, 0));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, sol.getSlotAt(1, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, sol.getSlotAt(2, 2));

    //testing horizontal movement
    sol.move(2, 0, 2, 2);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, sol.getSlotAt(2, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, sol.getSlotAt(2, 1));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, sol.getSlotAt(2, 0));
  }


}

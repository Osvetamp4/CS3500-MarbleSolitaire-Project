package org.example;

import org.example.gameboard.EuropeanGameboard;
import org.example.interfaces.MarbleSolitaireModelState;
import org.example.solitairemodel.EnglishSolitaireModel;
import org.example.gameboard.Gameboard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EnglishSolitaireModelTest {

  // testing constructor exceptions
  @Test
  void constructorTest() {
    // Second constructor
    assertThrows(IllegalArgumentException.class, () -> new EnglishSolitaireModel(new Gameboard(0,0)));
    assertThrows(IllegalArgumentException.class, () -> new EnglishSolitaireModel(new Gameboard(5,1)));
    assertThrows(IllegalArgumentException.class, () -> new EnglishSolitaireModel(new Gameboard(1,5)));
    assertThrows(IllegalArgumentException.class, () -> new EnglishSolitaireModel(new Gameboard(6,6)));
    assertThrows(IllegalArgumentException.class, () -> new EnglishSolitaireModel(new Gameboard(-1,3)));
    assertThrows(IllegalArgumentException.class, () -> new EnglishSolitaireModel(new Gameboard(3,7)));

    // Third constructor
    assertThrows(IllegalArgumentException.class, () -> new EnglishSolitaireModel(new Gameboard(8)));
    assertThrows(IllegalArgumentException.class, () -> new EnglishSolitaireModel(new Gameboard(-1)));

    // Fourth constructor
    assertThrows(IllegalArgumentException.class, () ->
            new EnglishSolitaireModel(new Gameboard(1,1,3)));
    assertThrows(IllegalArgumentException.class, () ->
            new EnglishSolitaireModel(new Gameboard(5,3,3)));
    assertThrows(IllegalArgumentException.class, () ->
            new EnglishSolitaireModel(new Gameboard(2,8,5)));

    //european Gameboard tests
    assertThrows(IllegalArgumentException.class, () -> { new EnglishSolitaireModel(
        new EuropeanGameboard(0,1));});
    assertThrows(IllegalArgumentException.class, () -> { new EnglishSolitaireModel(
        new EuropeanGameboard(-1));});
    assertThrows(IllegalArgumentException.class, () -> { new EnglishSolitaireModel(
        new EuropeanGameboard(2));});
    assertThrows(IllegalArgumentException.class, () -> { new EnglishSolitaireModel(
        new EuropeanGameboard(4,3,3));});
    assertThrows(IllegalArgumentException.class, () -> { new EnglishSolitaireModel(
        new EuropeanGameboard(5,12,12));});
  }

  // tests the method move
  @Test
  void MoveTest() {
    EnglishSolitaireModel sol = new EnglishSolitaireModel(new Gameboard(3));
    assertThrows(IllegalArgumentException.class,
            () -> sol.move(1, 3, 1, 1));
    assertThrows(IllegalArgumentException.class,
            () -> sol.move(3, 5, 3, 7));
    assertThrows(IllegalArgumentException.class,
            () -> sol.move(3, 0, 3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, sol.getSlotAt(3, 3));
    sol.move(3, 1, 3, 3);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, sol.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, sol.getSlotAt(3, 2));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, sol.getSlotAt(3, 1));
  }

  // tests the method isGameOver
  @Test
  void isGameOverTest() {
    EnglishSolitaireModel sol = new EnglishSolitaireModel(new Gameboard(3));
    assertEquals(false, sol.isGameOver());
    Gameboard a = new Gameboard();
    a.setPosition(3, 3, MarbleSolitaireModelState.SlotState.Marble);
    EnglishSolitaireModel sol2 = new EnglishSolitaireModel(a);
    assertEquals(true, sol2.isGameOver());
  }

  // tests the method getBoardSize
  @Test
  public void getBoardSizeTest() {
    Gameboard a = new Gameboard();
    assertEquals(7, a.getBoardSize());
    Gameboard b = new Gameboard(7, 6, 6);
    assertEquals(19, b.getBoardSize());
  }

  // tests the method getSlot
  @Test
  public void getSlotTest() {
    EnglishSolitaireModel a = new EnglishSolitaireModel();
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, a.getSlotAt(3, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, a.getSlotAt(2, 3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, a.getSlotAt(0, 0));
    assertThrows(IllegalArgumentException.class, () -> {
      a.getSlotAt(10, 10);
    });


    EnglishSolitaireModel b = new EnglishSolitaireModel(new Gameboard(7,7,7));
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, b.getSlotAt(7, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, b.getSlotAt(6, 7));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, b.getSlotAt(0, 0));
    assertThrows(IllegalArgumentException.class, () -> {
      b.getSlotAt(20, 20);
    });
  }

  // tests the method getScore
  @Test
  public void getScoreTest() {
    EnglishSolitaireModel a = new EnglishSolitaireModel();
    assertEquals(32, a.getScore());

    EnglishSolitaireModel b = new EnglishSolitaireModel(new Gameboard(7));
    assertEquals(216, b.getScore());
  }
}

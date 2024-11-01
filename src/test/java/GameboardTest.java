package org.example;

import org.example.gameboard.Gameboard;
import org.example.interfaces.MarbleSolitaireModelState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

// test class for the Gameboard
public class GameboardTest {

  // Tests if the constructor throws exceptions when it is formed with invalid inputs
  @Test
  public void constructorThrowExceptionTest(){


    assertThrows(IllegalArgumentException.class, () -> {
      new Gameboard(6,6);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Gameboard(-1);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Gameboard(2);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Gameboard(2,3,3);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new Gameboard(3,6,6);
    });
  }

  // tests the method getBoardSize
  @Test
  public void getBoardSizeTest(){
    Gameboard a = new Gameboard();
    assertEquals(7, a.getBoardSize());
    Gameboard b = new Gameboard(7,6,6);
    assertEquals(19, b.getBoardSize());
  }

  // tests the method getSlot
  @Test
  public void getSlotTest(){
    Gameboard a = new Gameboard();
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, a.getSlotAt(3,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, a.getSlotAt(2,3));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, a.getSlotAt(0,0));
    assertThrows(IllegalArgumentException.class, () -> {
      a.getSlotAt(10,10);
    });


    Gameboard b = new Gameboard(7,7,7);
    assertEquals(MarbleSolitaireModelState.SlotState.Empty, b.getSlotAt(7,7));
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, b.getSlotAt(6,7));
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, b.getSlotAt(0,0));
    assertThrows(IllegalArgumentException.class, () -> {
      b.getSlotAt(20,20);
    });
  }

  //tests the method getScore
  @Test
  public void getScoreTest(){
    Gameboard a = new Gameboard();
    assertEquals(32, a.getScore());

    Gameboard b = new Gameboard(7);
    assertEquals(216, b.getScore());
  }

  //tests the method setPosition
  @Test
  public void setPositionTest(){
    Gameboard a = new Gameboard();

    a.setPosition(3,3, MarbleSolitaireModelState.SlotState.Invalid);
    assertEquals(MarbleSolitaireModelState.SlotState.Invalid, a.getSlotAt(3,3));

    Gameboard b = new Gameboard(5,4);

    a.setPosition(5,4, MarbleSolitaireModelState.SlotState.Marble);
    assertEquals(MarbleSolitaireModelState.SlotState.Marble, a.getSlotAt(5,4));
  }

  // tests the method hasValidMove
  @Test
  public void hasValidMoveTest() {
    Gameboard a = new Gameboard();
    assertEquals(true, a.hasValidMove(3,1));
    assertEquals(false, a.hasValidMove(3,2));
  }
}

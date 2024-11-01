package org.example;

import org.example.gameboard.TriangleGameboard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TriangleGameboardTest {

  // Tests if the constructor throws exceptions when it is formed with invalid inputs
  @Test
  public void constructorThrowExceptionTest(){


    assertThrows(IllegalArgumentException.class, () -> {
      new TriangleGameboard(0,1);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new TriangleGameboard(-1);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new TriangleGameboard(2);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new TriangleGameboard(3,3,3);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new TriangleGameboard(5,4,6);
    });
  }

  // tests the method hasValidMove
  @Test
  public void hasValidMoveTest() {
    TriangleGameboard a = new TriangleGameboard(4);
    assertEquals(true, a.hasValidMove(2,2));
    assertEquals(true, a.hasValidMove(2,0));
    assertEquals(false, a.hasValidMove(3,3));
  }
}
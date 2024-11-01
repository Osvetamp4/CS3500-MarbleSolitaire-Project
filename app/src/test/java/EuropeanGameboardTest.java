package org.example;

import org.example.gameboard.EuropeanGameboard;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class EuropeanGameboardTest {

  // Tests if the constructor throws exceptions when it is formed with invalid inputs
  @Test
  public void constructorThrowExceptionTest(){


    assertThrows(IllegalArgumentException.class, () -> {
      new EuropeanGameboard(0,1);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new EuropeanGameboard(-1);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new EuropeanGameboard(2);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new EuropeanGameboard(4,3,3);
    });
    assertThrows(IllegalArgumentException.class, () -> {
      new EuropeanGameboard(5,12,12);
    });
  }

}
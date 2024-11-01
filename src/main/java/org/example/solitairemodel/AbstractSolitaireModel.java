package org.example.solitairemodel;

import org.example.gameboard.AbstractGameboard;
import org.example.interfaces.MarbleSolitaireModel;

public abstract class AbstractSolitaireModel implements MarbleSolitaireModel {
  protected AbstractGameboard g;


  @Override
  public int getBoardSize() {
    return g.getBoardSize();
  }


  @Override
  public SlotState getSlotAt(int row, int col) {
    return g.getSlotAt(row,col);
  }


  @Override
  public int getScore() {
    return g.getScore();
  }


  @Override
  public boolean isGameOver() {
    int len = getBoardSize();
    for (int i = 0; i < len; i ++) {
      for (int j = 0; j < len; j++) {
        if (g.getSlotAt(i, j) == SlotState.Marble) {
          if (g.hasValidMove(i, j)) {
            return false;
          }
        }
      }
    }
    return true;
  }
}

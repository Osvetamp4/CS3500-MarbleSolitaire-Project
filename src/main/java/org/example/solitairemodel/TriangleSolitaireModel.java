package org.example.solitairemodel;

import org.example.gameboard.AbstractGameboard;
import org.example.gameboard.TriangleGameboard;

//class for creating an instance of a triangle marble solitaire game
public class TriangleSolitaireModel extends AbstractSolitaireModel {



  public TriangleSolitaireModel(TriangleGameboard t) {
    this.g = t;
  }




  @Override
  public void move(int fromRow, int fromColumn, int toRow, int toColumn) {
    if(g.getSlotAt(fromRow, fromColumn).equals(SlotState.Invalid) ||
            getSlotAt(toRow, toColumn).equals(SlotState.Invalid)) {
      throw new IllegalArgumentException("Move out of bounds");
    }
    if(g.getSlotAt(fromRow, fromColumn).equals(SlotState.Empty) ||
            g.getSlotAt(((fromRow + toRow) / 2), ((fromColumn + toColumn) / 2))
                    .equals(SlotState.Empty) ||
            g.getSlotAt(toRow, toColumn).equals(SlotState.Marble)) {
      throw new IllegalArgumentException("Move is invalid");
    }
    if((g.getSlotAt(fromRow, fromColumn).equals(SlotState.Marble))
            // middle spot is Marble
            && (g.getSlotAt(((fromRow + toRow) / 2), ((fromColumn + toColumn) / 2))
                    .equals(SlotState.Marble))
            // Marbles are correct distance away
            && ((Math.abs(fromRow-toRow)==2 && Math.abs(fromColumn-toColumn)==0)
            || (Math.abs(fromRow-toRow)==0 && Math.abs(fromColumn-toColumn)==2)
            || (fromRow + 2 == toRow && fromColumn + 2 == toColumn)
            || (fromRow - 2 == toRow && fromColumn - 2 == toColumn))) {
      g.setPosition(fromRow, fromColumn, SlotState.Empty);
      g.setPosition((fromRow + toRow) / 2, (fromColumn + toColumn) / 2, SlotState.Empty);
      g.setPosition(toRow, toColumn, SlotState.Marble);
    }

  }
}

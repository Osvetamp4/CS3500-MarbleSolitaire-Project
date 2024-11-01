package org.example.solitairemodel;


import org.example.gameboard.AbstractGameboard;
import org.example.gameboard.Gameboard;

// class for creating an instance of a marble solitaire game
public class EnglishSolitaireModel extends AbstractSolitaireModel {


  public EnglishSolitaireModel(AbstractGameboard g) {
    this.g = g;
  }



  public EnglishSolitaireModel() {
    this.g = new Gameboard();
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
    if((g.getSlotAt(fromRow, fromColumn).equals(SlotState.Marble)) &&
            (g.getSlotAt(((fromRow + toRow) / 2), ((fromColumn + toColumn) / 2))
              .equals(SlotState.Marble)) && (fromRow == toRow || fromColumn == toColumn) &&
                ((Math.abs(fromRow-toRow)==2 && Math.abs(fromColumn-toColumn)==0) ||
                  (Math.abs(fromRow-toRow)==0 && Math.abs(fromColumn-toColumn)==2))) {
      g.setPosition(fromRow, fromColumn, SlotState.Empty);
      g.setPosition((fromRow + toRow) / 2, (fromColumn + toColumn) / 2, SlotState.Empty);
      g.setPosition(toRow, toColumn, SlotState.Marble);
    }

  }

}

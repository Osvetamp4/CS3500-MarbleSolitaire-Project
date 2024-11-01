package org.example.gameboard;

import org.example.MarbleSolitaireTextView;
import org.example.solitairemodel.EnglishSolitaireModel;

public class EuropeanGameboard extends AbstractGameboard{

  public EuropeanGameboard(){
    super();
    addCorners(3,1);
    setPosition(3,3,SlotState.Empty);
  }

  public EuropeanGameboard(int sRow, int sCol){
    super();
    addCorners(3,1);
    if ((sRow < 0 || sRow >= this.board.length || sCol < 0 || sCol >= this.board.length) || getSlotAt(sRow, sCol) == SlotState.Invalid) throw new IllegalArgumentException("Index must be within the confines of the board.");
    else setPosition(sRow,sCol,SlotState.Empty);
  }


  public EuropeanGameboard(int thick){
    super(thick);
    //add the method that adds corners in.
    addCorners(thick,this.incre);
    setPosition(findMiddle(board.length),findMiddle(board.length),SlotState.Empty);
  }

  public EuropeanGameboard(int thick, int sRow, int sCol){
    super(thick);
    //add the method that adds corners in.
    addCorners(thick,this.incre);
    if ((sRow < 0 || sRow >= this.board.length || sCol < 0 || sCol >= this.board.length) || getSlotAt(sRow, sCol) == SlotState.Invalid){throw new IllegalArgumentException("Index must be within the confines of the board.");}
    setPosition(sRow,sCol,SlotState.Empty);
  }


  /**
   * Generates corners for the currentBoard to differentiate it from a regular English Gameboard
   */
  private void addCorners(int thick,int increment){
    int middle = findMiddle(this.board.length);

    increment ++;
    int decrement = -1 * increment;

    int topLength = this.board.length;
    for (int i = this.board.length - 2 ; i != thick ; i -= 2){
      fillLineChop(middle,middle + increment,(i-1)/2);
      fillLineChop(middle,middle + decrement,(i-1)/2);
      increment ++;
      decrement --;
    }



  }

  /**
   * A helper method for addCorners() that fills in vertical slices of the board with marbles
   */
  private void fillLineChop(int row, int col, int armLength){
    for (int i = 1; i <= armLength; i++){
      this.board[row + i][col] = SlotState.Marble;
      this.board[row - i][col] = SlotState.Marble;
    }
  }



}

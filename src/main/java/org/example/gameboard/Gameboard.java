package org.example.gameboard;

public class Gameboard extends AbstractGameboard {



  public Gameboard(){
    super();
    setPosition(3,3,SlotState.Empty);
  }

  public Gameboard(int sRow, int sCol){
    super();
    if ((sRow < 0 || sRow >= this.board.length || sCol < 0 || sCol >= this.board.length) || getSlotAt(sRow, sCol) == SlotState.Invalid) throw new IllegalArgumentException("Index must be within the confines of the board.");
    else setPosition(sRow,sCol,SlotState.Empty);

  }

  public Gameboard(int thick){
    super(thick);
    setPosition(findMiddle(board.length),findMiddle(board.length),SlotState.Empty);
  }

  public Gameboard(int thick, int sRow, int sCol){
    super(thick);
    if ((sRow < 0 || sRow >= this.board.length || sCol < 0 || sCol >= this.board.length) || getSlotAt(sRow, sCol) == SlotState.Invalid){throw new IllegalArgumentException("Index must be within the confines of the board.");}

    setPosition(sRow,sCol,SlotState.Empty);
  }

  public Gameboard(boolean testing){
    this.board = generateBoard(3);
    setPosition(3,3,SlotState.Marble);
    setPosition(3,4,SlotState.Marble);
    setPosition(3,5,SlotState.Empty);
  }




























}

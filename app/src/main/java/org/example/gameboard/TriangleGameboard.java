package org.example.gameboard;

public class TriangleGameboard extends AbstractGameboard {
  public TriangleGameboard(){
    this.board = generateBoard(4);
    this.paintTriangle();
    setPosition(0,0,SlotState.Empty);
  }

  public TriangleGameboard(int sRow, int sCol){
    super();
    this.board = generateBoard(4);
    this.paintTriangle();
    if ((sRow < 0 || sRow >= this.board.length || sCol < 0 || sCol >= this.board.length) || getSlotAt(sRow, sCol) == SlotState.Invalid){throw new IllegalArgumentException("Index must be within the confines of the board.");}
    else setPosition(sRow,sCol,SlotState.Empty);

  }

  public TriangleGameboard(int thick){
    if (thick < 4) throw new IllegalArgumentException("triangle size must be at least 4");
    this.board = generateBoard(thick);
    this.paintTriangle();
    setPosition(0, 0,SlotState.Empty);
  }

  public TriangleGameboard(int thick, int sRow, int sCol){
    if (thick < 4) throw new IllegalArgumentException("triangle size must be at least 4");
    this.board = generateBoard(thick);
    this.paintTriangle();
    if ((sRow < 0 || sRow >= this.board.length || sCol < 0 || sCol >= this.board.length) || getSlotAt(sRow, sCol) == SlotState.Invalid){throw new IllegalArgumentException("Index must be within the confines of the board.");}
    else setPosition(sRow,sCol,SlotState.Empty);
  }

  @Override
  protected SlotState[][] generateBoard(int thickness){
    int len = thickness;
    SlotState[][] board = new SlotState[len][len];
    for (int i = 0; i < len; i++){
      for (int j = 0; j < len; j++){
        board[i][j] = SlotState.Invalid;
      }
    }
    return board;

  }
  /**
   * Depending on the length of the board, paint the board in a triangle shape.
   */
  private void paintTriangle() {
    int len = board.length;

    for (int i = 0; i < len; i++){
      for (int j=0; j < i+1; j++) {
        board[i][j] = SlotState.Marble;
      }
    }
  }

  @Override
  public boolean hasValidMove(int row, int col){
    int len = board.length-1;
    if (len >= row + 2){
      if((board[row+1][col] == SlotState.Marble)
              && (board[row+2][col] == SlotState.Empty)) {return true;}
    }

    if ((len >= row + 2) && (len >= col + 2)) {
      if ((board[row+1][col+1] == SlotState.Marble)
              && (board[row+2][col+2] == SlotState.Empty)) { return true;}
    }

    if (row >= 2) {
      if(((board[row-1][col] == SlotState.Marble)
          && (board[row-2][col] == SlotState.Empty))) { return true;}
    }
    if ((row >= 2) && (col >= 2)) {
      if(((board[row-1][col-1] == SlotState.Marble)
          && (board[row-2][col-2] == SlotState.Empty))) { return true;}
    }
    if (col >= 2) {
      if((((board[row][col-1] == SlotState.Marble)
          && (board[row][col-2] == SlotState.Empty)))) { return true;}
        }
    if (col + 2 <= len) {
      if((((board[row][col+1] == SlotState.Marble)
          && (board[row][col+2] == SlotState.Empty)))) { return true;}
    }

    return false;
  }
}


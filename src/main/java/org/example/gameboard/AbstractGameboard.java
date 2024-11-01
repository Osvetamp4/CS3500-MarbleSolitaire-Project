package org.example.gameboard;

import org.example.interfaces.MarbleSolitaireModelState;

import java.util.Arrays;

public abstract class AbstractGameboard implements MarbleSolitaireModelState {
  protected SlotState[][] board;
  protected int incre;


  public AbstractGameboard(){
    this.board = generateBoard(3);
    paintVertical(3);
    paintHorizontal(3);
    this.incre = 1;

  }

  public AbstractGameboard(int thick){
    if (thick % 2 == 0 || thick < 0) throw new IllegalArgumentException("Thickness must be a positive odd integer.");
    this.board = generateBoard(thick);
    this.incre = paintVertical(thick);
    paintHorizontal(thick);
  }



  /**
   * Finds the middle index of a given list length
   * @param li the length of a list
   * @return the middle index of a list
   */
  protected int findMiddle(int li){return li/2;}

  /**
   * Return the size of this board. The size is roughly the longest dimension of a board
   *
   * @return the size as an integer
   */
  @Override
  public int getBoardSize() {
    return board.length;
  }


  /**
   * Gets the state at the specified position
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return the state of the slot at the given row and column
   * @throws IllegalArgumentException if the row or the column are beyond
   *                                  the dimensions of the board
   */
  @Override
  public MarbleSolitaireModelState.SlotState getSlotAt(int row, int col) throws IllegalArgumentException {
    int len = board.length;
    for (int i = 0; i < len; i ++){
      for (int j = 0; j < len; j ++){
        if (row == i && col == j) return board[i][j];
      }
    }
    throw new IllegalArgumentException("Index must be within the confines of the board.");
  }


  /**
   * Return the number of marbles currently on the board.
   *
   * @return the number of marbles currently on the board
   */
  @Override
  public int getScore() {
    int len = board.length;
    int count = 0;
    for (int i = 0; i < len; i ++){
      for (int j = 0; j < len;j++){
        if (board[i][j] == SlotState.Marble) count ++;
      }
    }
    return count;
  }

  /**
   * Generates a new board with size calculated by the thickness given
   * @param thickness the thickness of the board arm
   * @return A 2D Array of SlotState[][]
   */

  protected SlotState[][] generateBoard(int thickness){
    int len = thickness + (thickness - 1) + (thickness - 1);
    SlotState[][] board = new SlotState[len][len];
    for (int i = 0; i < len; i++){
      for (int j = 0; j < len; j++){
        board[i][j] = SlotState.Invalid;
      }
    }
    return board;

  }

  /**
   * Sets the specified position to a specific SlotState
   *
   * @return true if successfully set the position, false if not.
   */
  public boolean setPosition(int row, int col, SlotState s){
    int len = board.length;
    for (int i = 0; i < len; i++){
      for (int j = 0; j < len;j++){
        if (i == row && j == col){
          board[i][j] = s;
          return true;
        }
      }
    }
    return false;
  }

  /**
   * Does the given marble have any valid moves?
   *
   * @param row the row of the position sought, starting at 0
   * @param col the column of the position sought, starting at 0
   * @return whether any moves are possible at the given coordinates
   */
  public boolean hasValidMove(int row, int col){
    if (board.length - 1 >= row + 2) {
      if((((board[row+1][col] == SlotState.Marble)
              && (board[row+2][col] == SlotState.Empty)))) { return true;}
    }
    if (row >= 2) {
      if((((board[row-1][col] == SlotState.Marble)
              && (board[row-2][col] == SlotState.Empty)))) { return true;}
    }
    if (board.length - 1 >= col + 2) {
      if((((board[row][col+1] == SlotState.Marble)
              && (board[row][col+2] == SlotState.Empty)))) { return true;}
    }
    if (col >= 2) {
      if((((board[row][col-1] == SlotState.Marble)
              && (board[row][col-2] == SlotState.Empty)))) { return true;}
    }
    return false;
  }

  /**
   * Starting at the middle column, and expanding outwards,
   * Replace every column with SlotState.Marble with respect to t
   * @param t the thickness of the board arm
   */
  protected int paintVertical(int t){
    int len = board.length;
    int middle = findMiddle(len);

    for (int i = 0; i < len; i++){
      board[i][middle] = SlotState.Marble;
      int decrement = 0;
      int increment = 0;
      for (int j = t - 1; j > 0; j-=2){
        decrement --;
        increment ++;
        board[i][middle + decrement] = SlotState.Marble;
        board[i][middle + increment] = SlotState.Marble;
      }
      if (i == len - 1) return increment;
    }
    return 6969;
  }


  /**
   * Starting at the middle row, and expanding outwards,
   * Replace every row with fillMarble() with respect to t
   * @param t the thickness of the board arm
   */

  protected void paintHorizontal(int t){
    int len = board.length;
    int middle = findMiddle(len);
    int decrement = 0;
    int increment = 0;
    board[middle] = fillMarble();
    for (int i = t - 1; i > 0 ; i -=2){
      decrement --;
      increment ++;
      board[middle + decrement] = fillMarble();
      board[middle + increment] = fillMarble();
    }
  }

  /**
   * Generates an array of the same length of the board and fills it with SlotState.Marble.
   *
   * @return an array with length board.length with every value being SlotState.Marble
   */

  protected SlotState[] fillMarble(){
    SlotState[] S = new SlotState[board.length];
    Arrays.fill(S, SlotState.Marble);
    return S;
  }
}




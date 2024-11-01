package org.example;

import org.example.interfaces.MarbleSolitaireModel;
import org.example.interfaces.MarbleSolitaireModelState;

import java.io.IOException;

// subclass to recreate the view for triangle solitaire
public class TriangleSolitaireTextView extends MarbleSolitaireTextView {

  public TriangleSolitaireTextView(MarbleSolitaireModel model) {
    super(model);
  }

  public TriangleSolitaireTextView(MarbleSolitaireModel model, Appendable destination) {
    super(model, destination);
  }

  //Return a string that represents the current state of the triangle solitaire board.
  @Override
  public String toString(){
    String output = "";

    for (int i = 0; i < eModel.getBoardSize();i++){
      output += (i % 10) + " " + space(i, eModel.getBoardSize());
      for (int j = 0; j < (i+1);j++){
        if (eModel.getSlotAt(i,j) == MarbleSolitaireModelState.SlotState.Empty) output += "_ ";
        else if (eModel.getSlotAt(i,j) == MarbleSolitaireModelState.SlotState.Marble) output += "O ";
        else output += "  ";
      }
      output += space(i, eModel.getBoardSize()) + "\n";
    }
     output += "  ";
    for (int i = 0; i < eModel.getBoardSize();i++){
      output+= (i % 10) + " ";

    }
    output += "\n";

    return output;
  }

  private String space(int row, int size) {
    String s = "";
    for (int i = 0; i < (size - (row+1)); i++) {
      s += " ";
    }
    return s;
  }
}

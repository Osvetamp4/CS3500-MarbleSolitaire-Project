package org.example;

import org.example.interfaces.MarbleSolitaireModel;
import org.example.interfaces.MarbleSolitaireModelState;
import org.example.interfaces.MarbleSolitaireView;

import java.io.IOException;

// Class representing the view of a marble solitaire game
public class MarbleSolitaireTextView implements MarbleSolitaireView {
  protected MarbleSolitaireModel eModel;
  protected Appendable destination;

  public MarbleSolitaireTextView(MarbleSolitaireModel e){
    eModel = e;
    this.destination = System.out;
  }

  public MarbleSolitaireTextView(MarbleSolitaireModel e,Appendable a){
    if (e == null) throw new IllegalArgumentException("MarbleSolitaireModelState is null.");
    else if (a == null) throw new IllegalArgumentException("Appendable Destination is null.");
    this.eModel = e;
    this.destination = a;

  }

  @Override
  public String toString(){
    String output = "  ";
    for (int i = 0; i < eModel.getBoardSize();i++){
      output+= (i % 10) + " ";

    }
    output += "\n";

    for (int i = 0; i < eModel.getBoardSize();i++){
      output += "" + (i % 10) + " ";
      for (int j = 0; j < eModel.getBoardSize();j++){
        if (eModel.getSlotAt(i,j) == MarbleSolitaireModelState.SlotState.Invalid) output += "  ";
        else if (eModel.getSlotAt(i,j) == MarbleSolitaireModelState.SlotState.Marble) output += "O ";
        else output += "_ ";
      }
      output += "\n";
    }
    return output;
  }

  @Override
  public void renderBoard() throws IOException {

    this.destination.append(this.toString());
  }

  @Override
  public void renderMessage(String message) throws IOException {
    try{
      destination.append(message).append("\n");
    }catch (IOException e) {
      throw new IllegalStateException(e.getMessage());
    }
  }


}

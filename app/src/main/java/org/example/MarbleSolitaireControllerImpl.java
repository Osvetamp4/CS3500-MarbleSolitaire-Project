package org.example;

import org.example.interfaces.MarbleSolitaireController;
import org.example.interfaces.MarbleSolitaireModel;
import org.example.interfaces.MarbleSolitaireView;

import java.io.IOException;
import java.util.Scanner;

public class MarbleSolitaireControllerImpl implements MarbleSolitaireController {
  MarbleSolitaireModel model;
  MarbleSolitaireView view;
  Readable reader;

  public MarbleSolitaireControllerImpl(MarbleSolitaireModel model,
                                       MarbleSolitaireView view, Readable reader) {
    if (model == null || view == null || reader == null) {
      throw new IllegalArgumentException("No fields can be null.");
    } else {
      this.model = model;
      this.view = view;
      this.reader = reader;
    }

  }

  public void playGame() throws IllegalStateException {
    Scanner sc = new Scanner(reader);
    String userInstruction;
    String[] userList;


    while (!model.isGameOver()){

      queryGameRender();

      if (!sc.hasNextLine()) {
        throw new IllegalStateException("Expected more input, but none was found.");
      }
      userInstruction = sc.nextLine();



      if (userInstruction.toLowerCase().equals("q")){
        quitGameRender();
        return;
      }


      userList = userInstruction.split(" ");




      if (userList.length != 4){
        try{


          view.renderMessage("2 sets of coordinates required.");

        }catch (IOException e){
          throw new IllegalArgumentException();
        }

        continue;
      }
      int[] numUserList = new int[4];


      for (int i = 0; i < 4; i++){
        try{
          numUserList[i] = Integer.parseInt(userList[i]);
        }catch (NumberFormatException e){
          try{
            view.renderMessage("All inputs must be integers.");
          }catch(IOException j){
            throw new IllegalArgumentException();
          }

          continue;
        }
      }


      try{
        this.model.move(numUserList[0],numUserList[1],numUserList[2],numUserList[3]);
      }catch (IllegalArgumentException e){
        try{
          view.renderMessage("Invalid move. Play again. At least one set of coordinates were invalid.");
        }catch (IOException j){
          throw new IllegalArgumentException();
        }

        continue;
      }


    }
    endGameRender();
    sc.close();



  }

  private void endGameRender() throws IllegalArgumentException {
    try {
      view.renderMessage("Game over!");
      view.renderBoard();
      view.renderMessage("Score: " + model.getScore());
    }catch (IOException e){
      throw new IllegalArgumentException();
    }

  }

  private void quitGameRender() throws IllegalArgumentException{
    try{
      view.renderMessage("Game quit!\nState of game when quit: ");
      view.renderBoard();
      view.renderMessage("Score: " + model.getScore());
    }catch (IOException e){
      throw new IllegalArgumentException();
    }

  }

  private void queryGameRender() throws IllegalArgumentException{
    try{
      this.view.renderBoard();
      view.renderMessage("Score: " + model.getScore());
      view.renderMessage("Enter your next move: ");
    }catch(IOException e){
      throw new IllegalArgumentException();
    }

  }
}
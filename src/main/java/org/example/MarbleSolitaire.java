package org.example;

import org.example.gameboard.AbstractGameboard;
import org.example.gameboard.EuropeanGameboard;
import org.example.gameboard.Gameboard;
import org.example.gameboard.TriangleGameboard;
import org.example.interfaces.MarbleSolitaireController;
import org.example.interfaces.MarbleSolitaireModel;
import org.example.interfaces.MarbleSolitaireView;
import org.example.solitairemodel.AbstractSolitaireModel;
import org.example.solitairemodel.EnglishSolitaireModel;
import org.example.solitairemodel.TriangleSolitaireModel;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;

// Method to play game upon running, which takes in arguments to decide which version of
// marbleSolitaire to run
public class MarbleSolitaire {
  public static void main(String[] args) throws IOException {

    String modelName;
    AbstractSolitaireModel model;
    MarbleSolitaireView view;
    MarbleSolitaireController controller;
    //This intialization should not work, only serve to appease java error handling
    model = new EnglishSolitaireModel(new Gameboard(3,3,3));
    //model = new TriangleSolitaireModel(new TriangleGameboard(4,3,3));
    view = new MarbleSolitaireTextView(model);
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    controller = new MarbleSolitaireControllerImpl(model,view, inputStreamReader);
    AbstractGameboard gameboard;


    int size = -69;
    int row = -69;
    int col = -69;

    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case "-size":
          size = Integer.parseInt(args[i+1]);
          i++;
          break;
        case "-hole":
          row = Integer.parseInt(args[i+1]);
          i++;
          col = Integer.parseInt(args[i+1]);
          i++;
          break;
      }
    }

    if (col == -69 && size == -69){
      switch(args[0]){
        case "english":
          model = new EnglishSolitaireModel();
          view = new MarbleSolitaireTextView(model);
          controller = new MarbleSolitaireControllerImpl(model,view, inputStreamReader);
          break;
        case "european":
          model = new EnglishSolitaireModel(new EuropeanGameboard());
          view = new MarbleSolitaireTextView(model);
          controller = new MarbleSolitaireControllerImpl(model,view, inputStreamReader);
          break;
        case "triangle":
          model = new TriangleSolitaireModel(new TriangleGameboard());
          view = new TriangleSolitaireTextView(model);
          controller = new MarbleSolitaireControllerImpl(model,view, inputStreamReader);
          break;
      }
    }
    else if (col == -69 && size != -69){
      switch(args[0]){
        case "english":
          model = new EnglishSolitaireModel(new Gameboard(size));
          view = new MarbleSolitaireTextView(model);
          controller = new MarbleSolitaireControllerImpl(model,view, inputStreamReader);
          break;
        case "european":
          model = new EnglishSolitaireModel(new EuropeanGameboard(size));
          view = new MarbleSolitaireTextView(model);
          controller = new MarbleSolitaireControllerImpl(model,view, inputStreamReader);
          break;
        case "triangle":
          model = new TriangleSolitaireModel(new TriangleGameboard(size));
          view = new TriangleSolitaireTextView(model);
          controller = new MarbleSolitaireControllerImpl(model,view, inputStreamReader);
          break;
      }
    }
    else if (col != -69 && size == -69){
      switch(args[0]){
        case "english":
          model = new EnglishSolitaireModel(new Gameboard(row,col));
          view = new MarbleSolitaireTextView(model);
          controller = new MarbleSolitaireControllerImpl(model,view, inputStreamReader);
          break;
        case "european":
          model = new EnglishSolitaireModel(new EuropeanGameboard(row,col));
          view = new MarbleSolitaireTextView(model);
          controller = new MarbleSolitaireControllerImpl(model,view, inputStreamReader);
          break;
        case "triangle":
          model = new TriangleSolitaireModel(new TriangleGameboard(row,col));
          view = new TriangleSolitaireTextView(model);
          controller = new MarbleSolitaireControllerImpl(model,view, inputStreamReader);
          break;
      }
    }
    else if (col != -69 && size != -69){
      switch(args[0]){
        case "english":
          model = new EnglishSolitaireModel(new Gameboard(size,row,col));
          view = new MarbleSolitaireTextView(model);
          controller = new MarbleSolitaireControllerImpl(model,view, inputStreamReader);
          break;
        case "european":
          model = new EnglishSolitaireModel(new EuropeanGameboard(size,row,col));
          view = new MarbleSolitaireTextView(model);
          controller = new MarbleSolitaireControllerImpl(model,view, inputStreamReader);
          break;
        case "triangle":
          model = new TriangleSolitaireModel(new TriangleGameboard(size,row,col));
          view = new TriangleSolitaireTextView(model);
          controller = new MarbleSolitaireControllerImpl(model,view, inputStreamReader);
          break;
      }
    }
    controller.playGame();
  }




}

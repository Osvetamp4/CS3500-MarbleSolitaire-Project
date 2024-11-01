package org.example.interfaces;

import java.io.IOException;

public interface MarbleSolitaireController {
  /**throw an IllegalStateException only if the controller is unable to
  successfully read input or transmit output.
   Plays a game with real time user input or prerecorded input.
   **/

  public void playGame() throws IOException;
}

# CS3500 MarbleSolitaire Project
 Final Project for my CS3500 class where me and my partner, Daniel Vesga, had to create a text based Marble Solitaire game with three different versions: English Solitaire, European Solitaire, or TriangleSolitaire.

 Our run configurations look like so:

 european -size 5

 A string passed into Args in the main function seperated into substrings by spaces:
  First substring determines the type of game you wanted to play: English, European, or Triangle
  Second substring can be either -size or -hole in which the following substring determined either the size of the board or the coordinates of the hole.
  If no -size or -hole respectively were inputted into configurations, there are default values selected for those specific substrings.

 
We tested our code in the respective testing folder. We ran and tested our code by running the main file MarbleSolitaire.java which is responsible for putting the entire game together and simulating a user run of it. We used run configurations to tell the program which game we wanted to run wether it be an English, European, or Triangle Solitaire game.
 
We implemented the game using the MVC design pattern with the following files:

Models:

 EnglishSolitaireModel
 
 TriangleSolitaireModel
 
Views:

 EnglishSolitaireTextView
 
 TriangleSolitaireTextView
 
Controllers:

 MarbleSolitaireControllerImpl

In addition to those files, we had set of subclasses that were built to encapsulate more of the code surrounding the solitaire models:
 Gameboard
 EuropeanGameboard
 TriangleGameboard
Our project didn't explicitly state that we needed them but we decided that in order to further simplify our code, we would encapsulate more of the initialization of the playing board to those gameboard classes.

We obviously got the green light to implement them as to make sure we weren't directly disobeying instructions.

To address what appears to be a discrepancy in our file system, we realized that both the Gameboard and EuropeanGameboards had extremely similar initialization methods in the EnglishSolitaireModel so we decided to merge them together instead of seperating the EuropeanGameboard into its own EuropeanSolitaireModel. However, TriangleSolitaireModel was its own beast with a completely different initialization method which neccessitated a seperate TriangleSolitaireModel. In hindsight, it was probably a better idea to stick to naming conventions and give EuropeanGameboard its own EuropeanSolitaireModel to sticky by naming conventions and have consistency in our filesystem.

We also implemented Abstraction classes to abstract most of the redundant code away from most of our model and gameboard files:
 AbstractGameboard
 AbstractSolitaireModel

We also implemented Interfaces to further simplify the code and allow for easier upkeep:
 MarbleSolitaireController
 MarbleSolitaireModel
 MarbleSolitaireModelState
 MarbleSolitaireView

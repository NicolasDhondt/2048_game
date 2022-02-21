Hello, this README will explain my code about the game 2048.

First, I create a main that call the start of the application in the controler, called App. The controler create a view in the console and a FX view beside a game. The board of the game is initalized with a first number (2 or 4) at this moment. The title is printed and the scene colored. 

At each movements from the user's decision, the game is playing (Play method in class Game) and all numbers move and merge. 

With this modification of the board, the controler update the board and the current score. At this moment, the status of the game is checked : if the game is won (any case don't be equal to 2048) or lose (there are one cell empty at least or no fusion of numbers possible), it's printed and it's the end of the game. if it is not, the game continue.
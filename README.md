# Dice Game and Simulations

by Bardia Parmoun


## DESCRIPTION
- This repository contains a simple dice game and a simple dice simulator
- The dice game is a simple betting game that you can play against the computer.
- The dice simulator, simulates rolling any number of dice that is required by the user and than generates a bar graph based on all the rolls.

## COMPILING
### Compiling mydicegame

- First navigate to the mydicegame folder then use the following command:
```
javac Die.java DiceGame.java
```

- Then run the program using:
```
java mydicegame/DiceGame
```

### Compiling simulation
- First navigate to the simulation folder then use the following command:
```
javac Dice.java DiceClient.java
```

- Then run the program using:
```
java simulation/DiceClient
```
## USAGE
### Using the dice game:

When you call the dicegame you can enter the number of the dice and the number of sides on each dice. Then each player starts with 100 dollars and can then place bets. Each round you can see what each player rolled.

- Here is an example using 10 3-sided dice:
  
```
>>> java mydicegame/DiceGame 3 10

Welcome to the Game of Dice!
Starting a game with 10 3-sided dice.
---------------------------------------
You have $100
The computer has $100
Place your bet (-1 to quit playing) >>>50
10 Dice :: You rolled > { 1 3 2 1 3 3 2 2 1 3 }
10 Dice :: Computer rolled > { 3 2 2 3 2 2 3 3 1 2 }
The computer wins this round!
---------------------------------------
You have $50
The computer has $150
Place your bet (-1 to quit playing) >>>50
10 Dice :: You rolled > { 2 1 2 1 1 3 1 1 1 2 }
10 Dice :: Computer rolled > { 2 3 2 1 2 1 3 3 1 3 }
The computer wins this round!
Oh no, you're out of credit!
Good Bye!
```

### Using the dice game:
- The program can be called using the following method:

```
>>> java simulation/DiceClient.java

The average roll was: 3.498666666666667
The histograms of the rolls is: 
1(514)***************************************************
2(478)***********************************************
3(520)****************************************************
4(483)************************************************
5(496)*************************************************
6(509)**************************************************
```
## CREDITS
Author: Bardia Parmoun

Copyright © 2021 Bardia Parmoun. All rights reserved

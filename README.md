# Wordle Java Edition

This is a console-based version of the popular word-guessing game, Wordle, built entirely in Java. The project provides a classic, engaging Wordle experience within a terminal, complete with a main menu and color-coded feedback.

## Features

*   **Classic Wordle Gameplay:** Guess the secret five-letter word in five tries or less.
*   **Color-Coded Feedback:** Uses ANSI escape codes to provide feedback in the console:
    *   **Green:** The letter is in the correct position.
    *   **Yellow:** The letter is in the word but in the wrong position.
    *   **White:** The letter is not in the word.
*   **User-Friendly Menu:** A main menu allows the user to play the game, read the rules, or exit.
*   **Valid Word Checking:** Ensures that all guesses are valid five-letter words found in the game's dictionary (`wordleWords.txt`).
*   **Random Word Selection:** A new secret word is chosen at random from a list of over 2,300 words every time you play.
  
## Prerequisites

*   Java Development Kit (JDK) installed and configured.

## How to Run the Program

1.  **Clone the repository (or download the files):**
    ```sh
    git clone https://github.com/DeaconSham/Wordle.git
    ```
2.  **Navigate to the project directory:**
    ```sh
    cd Wordle
    ```
3.  **Compile the Java source code:**
    ```sh
    javac Main.java
    ```
4.  **Run the compiled program:**
    ```sh
    java Main
    ```
    *Note: Your terminal must support ANSI escape codes to display the colors correctly.*

## How to Play

1.  Run the application to see the main menu.
2.  Select `1` to start a new game.
3.  You have five attempts to guess the secret word. Enter your five-letter guess and press Enter.
4.  After each guess, the program will display the results using the color-coded feedback.
5.  Continue guessing until you have either guessed the word correctly or run out of attempts.
6.  After a game, you will be returned to the main menu to play again or exit.

## File Structure

*   **`Main.java`**: The single source file containing all the game logic, including the main menu, game loop, user input handling, and display logic.
*   **`wordleWords.txt`**: The text file containing the list of all possible secret words. This file must be in the same directory as `Main.java` for the program to run correctly.

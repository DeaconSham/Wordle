# Wordle: Java Edition

A console-based Wordle clone written in Java.

This program allows the player to guess a five-letter word within five attempts, with coloured feedback indicating the accuracy of each letter.

## Features

- **Classic Wordle Gameplay** – Guess a five-letter word in 5 tries.
- **Coloured Hints**:
  - 🟩 **Green** – Letter is correct and in the correct position.
  - 🟨 **Yellow** – Letter is correct but in the wrong position.
  - ⬜ **White** – Letter is incorrect.
- **Interactive Menu**:
  - Play the game
  - View rules and instructions
  - Quit anytime
- **Dynamic Word Selection** – Words are loaded from `wordleWords.txt`.

## Requirements

- Java 8 or higher
- Terminal/console that supports **ANSI colour codes**

## File Structure

Main.java # Main program file
wordleWords.txt # List of valid 5-letter words
README.md # Documentation

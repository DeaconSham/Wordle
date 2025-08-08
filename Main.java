import java.io.*;
import java.util.*;

public class Main {
    public static Scanner ui = new Scanner(System.in);
    public static final String ANSI_WHITE  = "\u001b[37m";
    public static final String ANSI_BLACK  = "\u001b[30m";
    public static final String ANSI_RED    = "\u001b[31m";
    public static final String ANSI_GREEN  = "\u001b[32m";
    public static final String ANSI_YELLOW = "\u001b[33m";
    public static final String ANSI_RESET  = "\u001b[0m";
    public static void main(String[] args) throws Exception {
        clear();
        while (true) {
            clear();
            System.out.println(ANSI_RESET);
            title();
            System.out.println("\n1. Play Game\n2. Rules and Information\n3. Quit and Exit Program");
            int input = Integer.parseInt(ui.nextLine());
            if (input == 1) {
                game(wordList());
            } else if (input == 2) {
                clear();
                rules();
            } else if (input == 3) {
                clear();
                System.out.println("Goodbye, thanks for playing!");
            } else {
                System.out.println("Sorry, but " + input + " is not an available option.");
                Enter();
            }
        }
    }
    public static void title() {
        System.out.println("░██╗░░░░░░░██╗░█████╗░██████╗░██████╗░██╗░░░░░███████╗");
        System.out.println("░██║░░██╗░░██║██╔══██╗██╔══██╗██╔══██╗██║░░░░░██╔════╝");
        System.out.println("░╚██╗████╗██╔╝██║░░██║██████╔╝██║░░██║██║░░░░░█████╗░░");
        System.out.println("░░████╔═████║░██║░░██║██╔══██╗██║░░██║██║░░░░░██╔══╝░░");
        System.out.println("░░╚██╔╝░╚██╔╝░╚█████╔╝██║░░██║██████╔╝███████╗███████╗");
        System.out.println("░░░╚═╝░░░╚═╝░░░╚════╝░╚═╝░░╚═╝╚═════╝░╚══════╝╚══════╝");
        System.out.println("Java Edition by Deacon Sham");
    }
    public static int game(String[] wordList) {
        String s = chooseWord(wordList);
        String[][] pastGuess = new String[0][];
        char[] word = s.toCharArray();
        for (int i = 5; i > 0; i--) {
            clear();
            printGame(pastGuess);
            char[] guess = ui.nextLine().toCharArray();
            if (validGuess(guess, wordList)) {
                String[] tempArray = new String[5];
                if (Arrays.equals(word, guess)) {
                    for (int j = 0; j < guess.length; j++) {
                        tempArray[j] = ANSI_GREEN + guess[j];
                    }
                    pastGuess = append(pastGuess, tempArray);
                    clear();
                    printGame(pastGuess);
                    System.out.println("Congratulations, you win!");
                    Enter();
                    return 5 - i;
                } else {
                    for (int j = 0; j < guess.length; j++) {
                        if (guess[j] == word[j]) {
                            tempArray[j] = ANSI_GREEN + guess[j];
                        } else if (inArray(word, guess[j])) {
                            tempArray[j] = ANSI_YELLOW + guess[j];
                        } else {
                            tempArray[j] = ANSI_WHITE + guess[j];
                        }
                    }
                    pastGuess = append(pastGuess, tempArray);
                }
            } else {
                System.out.println("Input invalid");
                Enter();
                i++;
            }
        }
        System.out.println("Better luck next time!");
        Enter();
        return -1;
    }
    public static void printGame(String[][] pastGuess) {
        if (pastGuess.length > 0) {
            for (String[] y : pastGuess) {
                for (String x : y) {
                    if (x != null) {
                        System.out.print(x + " ");
                    }
                }
                System.out.println();
            }
        }

        System.out.print(ANSI_WHITE);
        for (int i = 0; i < 5 - pastGuess.length; i++) {
            System.out.println("☐ ☐ ☐ ☐ ☐");
        }
    }
    public static String[] wordList() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("wordleWords.txt"));
            String[] wordlist = new String[2315];
            String word = br.readLine();
            int iterator = 0;

            while (word != null) {
                wordlist[iterator] = word;
                iterator++;
                word = br.readLine();
            }

            br.close();
            return wordlist;
        } catch (Exception e) {
            System.out.println("An error occurred while attempting to read the word list or text file.");
            return new String[0];
        }
    }
    public static String chooseWord(String[] wordList) {
        int word = (int) Math.floor(Math.random() * wordList.length);
        return wordList[word];
    }
    public static Boolean validGuess(char[] guess, String[] wordList) {
        if (guess.length != 5) {
            return false;
        }
        for (int x : guess) {
            if (x > 122 || x < 97) {
                return false;
            }
        }
        for (String s : wordList) {
            if (Arrays.equals(s.toCharArray(), guess)) {
                return true;
            }
        }
        return false;
    }
    public static void rules() {
        System.out.println("Welcome to Wordle: Java Edition!");
        System.out.println("In this version of Wordle you have to guess a five letter word within five guesses.");
        System.out.println("\nLetters will be coloured to hint how the word is spelt:");
        System.out.println(ANSI_WHITE + "White: the inputted letter is wrong.");
        System.out.println(ANSI_YELLOW + "Yellow: the inputted letter is in the wrong place.");
        System.out.println(ANSI_GREEN + "Green: The inputted letter is correct." + ANSI_WHITE);
        System.out.println("\nThis project was created by Deacon Sham for the class ICS3U at Colonel By Secondary School.");
        Enter();
    }
    // utility methods
    public static void clear() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
    public static void Enter() {
        System.out.print("\nPress the enter key to continue.");
        ui.nextLine();
    }
    public static String[][] append(String[][] arr, String[] x) {
        String[][] newArr = new String[arr.length + 1][];
        newArr[arr.length] = x;
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
    public static String[] append(String[] arr, String x) {
        String[] newArr = new String[arr.length + 1];
        newArr[arr.length] = x;
        for (int i = 0; i < arr.length; i++) {
            newArr[i] = arr[i];
        }
        return newArr;
    }
    public static Boolean inArray(char[] arr, char x) {
        for (char i : arr) {
            if (i == x) {
                return true;
            }
        }
        return false;
    }
}

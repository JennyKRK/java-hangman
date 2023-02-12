package pl.edu.agh.hangman;

import java.util.Scanner;

public class Hangman {

    public static final String[] HANGMANPICS = new String[]{
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========"
    };

    public static void main(String[] args) {
        RandomWord randomWord = new RandomWord();
        WordComparator wordComparator = new WordComparator();
        Scanner scanner = new Scanner(System.in);
        int counter = 0;
        do {
            System.out.println("Type a letter or word: ");
            String userAnswer = scanner.next();

            boolean finalResult = false;

            if (userAnswer.length() == 1) {
                finalResult = wordComparator.compareLetters(randomWord.returnWord(), userAnswer);
                if (finalResult == false){
                    counter++;
                }
            } else if (userAnswer.length() > 1) {
                finalResult = wordComparator.compareWords(randomWord.returnWord(), userAnswer);
                if (finalResult == false){
                    counter++;
                }
            } else {
                System.out.println("Error!");
            }

            Screen screen = new Screen();
            screen.updateScreen(finalResult, counter);
        } while (counter < 6);

    }
}

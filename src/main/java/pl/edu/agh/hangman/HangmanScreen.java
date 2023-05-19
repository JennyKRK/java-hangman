package pl.edu.agh.hangman;

public class HangmanScreen {

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


    public void printWelcomeScreen(){
        System.out.println("Hello. Please type one letter. You can also type your solution");
        System.out.println("Good luck!");
    }

    public void printCongratulations(){
        System.out.println("YOU WON THE GAME");
    }

    public void printHangManVersion(int guessesMade){
        System.out.println("Bad luck!");
        System.out.println(HANGMANPICS[guessesMade]);
        int guessesLeft = 6 - guessesMade;
        System.out.println("Guesses left: " + guessesLeft);
    }

    public void printGoodStatus(String currentStatus,int guessesMade){
        System.out.println("Your guess was correct");
        System.out.println(currentStatus);
        int guessesLeft = 6 - guessesMade;
        System.out.println("Guesses left: " + guessesLeft);
    }

    public void finishTheGame(){
        System.out.println("Sorry. You lost.");
    }
}

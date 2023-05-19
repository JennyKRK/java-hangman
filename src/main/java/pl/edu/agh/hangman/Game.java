package pl.edu.agh.hangman;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    private HangmanScreen hs;
    private RandomWord randomWord;
    private String wordToGuess;
    private String gameType;
    private CheckAndReturnAnswer checkAndReturnAnswer;
    private CheckWordnik checkWordnik;

    public Game(){
        this.hs = new HangmanScreen();
        this.randomWord = new RandomWord();
        this.checkAndReturnAnswer = new CheckAndReturnAnswer();
        this.checkWordnik = new CheckWordnik();
    }

    public void beginTheGame() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please type N for normal game. L if you want to specify the length of the word.");
        System.out.println("E if you want to use externally-generated word. X if you want to exit");
        String answer = scanner.nextLine();
        switch(answer){
            case("N"): {
                String word = getTheWord();
                playAGame(word);
                break;
            }
            case("X"):{
                System.exit(0);
            }
            case("E"):{
                String word = getTheWordFromWordnik();
                playAGame(word);
                break;
            }
            case("L"):{
                System.out.println("Please give me the number");
                int length = scanner.nextInt();
                //to add - error handling
                String word = getTheWord(length);
                playAGame(word);
                break;
            }
            default:{
                System.out.println("Wrong answer");
            }
        }
    }

    public String getTheWord(){
        String wordToGuess = randomWord.returnWord();
        return wordToGuess;
    }

    public String getTheWord(int given){
        String wordToGuess = randomWord.returnWord(given);
        return wordToGuess;
    }

    public String getTheWordFromWordnik() throws IOException {
        return checkWordnik.returnNewWord();
    }

    public void playAGame(String wordToGuess){
        hs.printWelcomeScreen();
        int howManyLetters = wordToGuess.length();
        Scanner scanner = new Scanner(System.in);
        boolean isItFinal = false;
        int guessesMade = 0;
        String whatIsKnown = generateFirstString(howManyLetters);
        List<Boolean> results = new ArrayList<>();
        do {
            String usersAnswer = scanner.nextLine();
            results = checkAndReturnAnswer.analyzeTheAnswer(wordToGuess,usersAnswer);
            if (results.get(0)){
                isItFinal = true;
                gameWon();
            }
            else {
                if (!results.get(1)){
                    guessesMade ++;
                    wrongGuess(guessesMade);
                }
                else {
                    whatIsKnown = checkAndReturnAnswer.whatWeKnow(whatIsKnown,wordToGuess,usersAnswer);
                    currentStatus(whatIsKnown, guessesMade);
                }
            }
        }
        while (!isItFinal && guessesMade<6);

        if(guessesMade==6){
            gameLost(wordToGuess);
        }
    }

    public void wrongGuess(int i){
        hs.printHangManVersion(i);
    }

    public String generateFirstString(int howManyLetters){
        String firstString = "";
        for (int a = 0; a < howManyLetters; a++){
            firstString += "*";
        }
        return firstString;
    }

    public void currentStatus(String alreadyKnown, int guessesMade){
        hs.printGoodStatus(alreadyKnown, guessesMade);
    }










    public void gameWon(){
        hs.printCongratulations();
    }

    public void gameLost(String wordToGuess){
        hs.finishTheGame();
        System.out.println("The correct word " + wordToGuess);
    }


}

package pl.edu.agh.hangman;

import java.util.ArrayList;
import java.util.List;

public class CheckAndReturnAnswer {

    public String whatWeKnow (String alreadyKnown, String wordToGuess, String userAnswer){
        int numberToAnalyze = wordToGuess.length();
        String[] lettersToGuess = splitWordToLetters(wordToGuess);
        StringBuilder alreadyKnownUpdated = new StringBuilder(alreadyKnown);

        for (int i = 0; i <numberToAnalyze; i++){
            if (lettersToGuess[i].equals(userAnswer)){
                alreadyKnownUpdated.setCharAt(i, userAnswer.charAt(0));
            }
        }
        return alreadyKnownUpdated.toString();
    }

    public List analyzeTheAnswer(String randomWord, String userAnswer){
        boolean didWeGuessTheWord = false;
        boolean didWeGuessALetter = false;

        if (userAnswer.length()>1){
            didWeGuessTheWord = compareWords(randomWord, userAnswer);
        }
        else {
            didWeGuessALetter = compareLetters(randomWord, userAnswer);
        }

        List<Boolean> resultOfCheck = new ArrayList<>();
        resultOfCheck.add(0,didWeGuessTheWord);
        resultOfCheck.add(1,didWeGuessALetter);
        return resultOfCheck;
    }

    public String[] splitWordToLetters (String Word){
        String [] splitedWord = Word.toLowerCase().split("");
        return splitedWord;
    }

    public boolean compareLetters(String randomWord, String userAnswer) {
        String[] splitedWord = splitWordToLetters(randomWord);
        userAnswer.toLowerCase();
        boolean result = false;

        for (String letter : splitedWord) {
            if (letter.equals(userAnswer)) {
                result = true;
            }
        }
        return result;
    }

    public boolean compareWords (String randomWord, String userAnswer) {
        boolean result = false;
        if (randomWord.toLowerCase().equals(userAnswer.toLowerCase())){
            result = true;
        }
        return result;
    }
}

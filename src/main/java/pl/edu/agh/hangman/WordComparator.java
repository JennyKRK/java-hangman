package pl.edu.agh.hangman;

import java.util.Locale;

public class WordComparator {

    public WordComparator(){

    }

    public String[] splitWordToLetters (String randomWord){
        String [] splitedWord = randomWord.toLowerCase().split("");
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

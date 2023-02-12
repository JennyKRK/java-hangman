package pl.edu.agh.hangman;

import java.util.Locale;

public class WordComparator {

    public WordComparator(){

    }

    public String[] splitWordToLetters (String randomWord){
        String [] splitedWord = randomWord.toLowerCase().split("");
        return splitedWord;
    }

    public boolean compareLetters(String randomWord, String userLetter) {
        String[] splitedWord = splitWordToLetters(randomWord);
        userLetter.toLowerCase();
        boolean result = false;

        for (String letter : splitedWord) {
            if (letter.equals(userLetter)) {
                result = true;
            }
        }
        return result;
    }

    public boolean compareWords (String randomWord, String userLetter) {
        boolean result = false;
        if (randomWord.toLowerCase().equals(userLetter.toLowerCase())){
            result = true;
        }
            return result;
    }

}

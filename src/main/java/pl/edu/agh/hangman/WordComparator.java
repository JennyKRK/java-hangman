package pl.edu.agh.hangman;

import java.util.Locale;

public class WordComparator {

    public WordComparator(){

    }

    public String[] splitWordToLetters (String randomWord){
        String [] splitedWord = randomWord.toLowerCase().split("");
        return splitedWord;
    }

    public boolean compare(String randomWord, String userLetter) {
        String[] splitedWord = splitWordToLetters(randomWord);
        boolean result = false;

        for (String letter : splitedWord) {
            if (letter.equals(userLetter)) {
                result = true;
            }
        }
        return result;

    }

}

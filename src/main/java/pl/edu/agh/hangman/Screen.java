package pl.edu.agh.hangman;

import java.util.ArrayList;

public class Screen {
    private ArrayList givenLetters = new ArrayList();
    private ArrayList splitWord = new ArrayList();

    public ArrayList getGivenLetters() {
        return givenLetters;
    }

    public void setGivenLetters(ArrayList givenLetters) {
        this.givenLetters = givenLetters;
    }

    public void addUserLetter(String letter){
        this.givenLetters.add(letter);
    }

    Screen(){
     }

    public void updateScreen(boolean result, int counter){

        String[] pictures = Hangman.HANGMANPICS;
        String currentPicture = "";
        if (result == false){
            currentPicture = pictures[counter];
            System.out.println(currentPicture);
            System.out.println("Sorry, letter was not found");
            System.out.println();
        }
        else {
            currentPicture = pictures[counter];
            System.out.println(currentPicture);
            System.out.println("Your letter was found");
            System.out.println();
        }
    }


}

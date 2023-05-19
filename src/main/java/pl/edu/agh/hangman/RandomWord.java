package pl.edu.agh.hangman;

import java.util.List;
import java.util.Random;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class RandomWord {

    RandomWord() {
    }

    public ArrayList returnListOfWords(){
        String filename = "src/main/resources/slowa.txt";
        ArrayList words = new ArrayList();
        try {
            File newFile = new File(filename);
            Scanner scanner = new Scanner(newFile);
            while (scanner.hasNext()) {
                String line = scanner.nextLine().replaceAll("[()/]", "").replace("  "," ").trim();
                words.add(line);
            }
            scanner.close();
        } catch (Exception e) {
            System.err.format("Exception: %s", e);
        }
        return words;
    }

    public String returnWord(){
        List listOfWords = returnListOfWords();
        Random random = new Random();
        int maxIndex = listOfWords.size() ;
        int chosenIndex = random.nextInt(maxIndex);
        String chosenWord = listOfWords.get(chosenIndex).toString();
        return chosenWord;
    }

    public String returnWord(int i){
        List<String> listOfWords = returnListOfWords();
        List<String> newListOfWords = listOfWords.stream().filter(w -> w.length() == i).collect(Collectors.toList());
        Random random = new Random();
        int maxIndex = newListOfWords.size() ;
        int chosenIndex = random.nextInt(maxIndex);
        String chosenWord = newListOfWords.get(chosenIndex).toString();
        return chosenWord;
    }
}







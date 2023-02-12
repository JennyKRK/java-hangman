package pl.edu.agh.hangman;

import java.util.Random;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class RandomWord {

    RandomWord() {
    }

    public String returnWord() {
        Random random = new Random();
        String filename = "src/main/resources/slowa.txt";
        ArrayList words = new ArrayList();
        try {
            File newFile = new File(filename);
            Scanner scanner = new Scanner(newFile);
            while (scanner.hasNext()) {
                String line = scanner.next().trim();
                words.add(line);
            }
            scanner.close();
        } catch (Exception e) {
            System.err.format("Exception: %s", e);
        }
        int maxIndex = words.size() ;
        int chosenIndex = random.nextInt(0, maxIndex);
        String chosenWord = words.get(chosenIndex).toString();
        return chosenWord;
    }
}









package pl.edu.agh.hangman;
import java.util.Scanner;

public class Testy {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        RandomWord rw = new RandomWord();



        System.out.println("give me a letter");
        String letter = scanner.next();

        WordComparator wc = new WordComparator();
        wc.compare(rw.returnWord(), letter);
    }
}

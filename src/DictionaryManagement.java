import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

public class DictionaryManagement {
    Dictionary dictionary;

    DictionaryManagement(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void insertFromCommandline() {
        Scanner sc = new Scanner(System.in);
        Word a = new Word();
        a.setWord_target(sc.nextLine());
        a.setWord_explain(sc.nextLine());
        dictionary.words[dictionary.numOfWord++] = a;
    }

    public void insertFromFile() {
        String path = "C:/Users/an/IdeaProjects/DictionaryApp/src/input.txt";
        try {
            File f = new File(path);
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String line;
            while((line = br.readLine()) != null) {
                line = line.trim();
                if(!line.equals("")) {
                    String[] word = line.split("\\t");
                    Word input = new Word();
                    input.setWord_target(word[0]);
                    if (word.length > 1) {
                        input.setWord_explain(word[1]);
                    }
                    //Word input = new Word(line.split("\\t")[0], line.split("\\t")[1]);
                    dictionary.words[dictionary.numOfWord++] = input;
                }
            }
            fr.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
    public void dictionaryLookup() {
        Scanner sc = new Scanner(System.in);
        String lookup = sc.nextLine();
        if (lookup.equals("Look up")) {
            System.out.print("Type in your word: ");
            String wordLookup = sc.nextLine();
            int count = 0;
            for (int i = 0; i < dictionary.numOfWord; i++) {
                if (wordLookup.equals(dictionary.words[i].getWord_target())) {
                    System.out.println("The word you looking for: " + dictionary.words[i].getWord_target() + " - " + dictionary.words[i].getWord_explain());
                    count++;
                    break;
                }
            }
            if (count == 0) {
                System.out.println("Not found!");
            }
        }
    }
}

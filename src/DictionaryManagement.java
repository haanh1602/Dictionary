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
}

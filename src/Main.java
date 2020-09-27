public class Main {
    /**
     * Main.
     *
     * @param args args
     */
    public static void main(String[] args) {
        Dictionary a = new Dictionary();
        //a.dictionaryManagement.insertFromCommandline();
        a.dictionaryManagement.insertFromFile();
        a.dictionaryCommandline.showAllWords();
        a.dictionaryManagement.dictionaryLookup();
        //a.dictionaryCommandline.dictionaryBasic();
        //System.out.println(a.words[0]);
    }
}

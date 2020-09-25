public class DictionaryCommandline {
    Dictionary dictionary;

    DictionaryCommandline(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    public void showAllWords() {
        System.out.println("No " + "  | " + "English" + "         | " + "Vietnamese");
        for (int i = 0; i < dictionary.numOfWord; i++) {
            System.out.println(i + "    | " + dictionary.words[i].getWord_target()
                    + "         | " + dictionary.words[i].getWord_explain());
        }
    }

    public void dictionaryBasic() {
        DictionaryManagement dictionaryManagement = new DictionaryManagement(dictionary);
        dictionaryManagement.insertFromCommandline();
        showAllWords();
    }
}

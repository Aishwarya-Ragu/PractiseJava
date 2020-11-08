package May;

import java.util.HashMap;
import java.util.Map;

public class TrieImplementation {
    TrieNode root =new TrieNode();


    public static void main(String args[]){
        TrieImplementation.trie();
    }

    private static void trie() {
        TrieImplementation m = new TrieImplementation();
        m.insert("apple");
        System.out.println(m.search("apple"));
        System.out.println(m.search("app"));
        System.out.println(m.startsWith("ap"));
        System.out.println(m.startsWith("e"));
    }



    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode current = root;
        int i =0;
        while(i<word.length()){
            current = current.getMap().computeIfAbsent(word.charAt(i),c-> new TrieNode());
            i++;
        }
        current.setEndOFWord(true);
        System.out.println(current);

    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        int i =0;
        while(i<word.length()){
            TrieNode node = current.getMap().get(word.charAt(i));
            if(node == null){
                return false;
            }else{
                current =node;
            }
            i++;
        }
        return current.isEndOFWord();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        int i =0;
        while(i<prefix.length()){
            TrieNode node = current.getMap().get(prefix.charAt(i));
            if(node == null){
                return false;
            }else{
                current = node;
            }
            i++;
        }
        return true;
    }



}

class TrieNode{
    public Map<Character, TrieNode> getMap() {
        return map;
    }

    public void setMap(Map<Character, TrieNode> map) {
        this.map = map;
    }

    public boolean isEndOFWord() {
        return isEndOFWord;
    }

    public void setEndOFWord(boolean endOFWord) {
        isEndOFWord = endOFWord;
    }

    Map<Character,TrieNode> map = new HashMap<>();
    boolean isEndOFWord;

}

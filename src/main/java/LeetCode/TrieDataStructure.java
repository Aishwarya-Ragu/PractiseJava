package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class TrieDataStructure {
    TrieNode root = new TrieNode();
    public static void main(String[] args) {
        TrieDataStructure td = new TrieDataStructure();
        td.addWord("pad");
        td.addWord("add");
        td.addWord("mad");
        System.out.println(td.search("mad"));
        System.out.println(td.search("..d"));
    }


    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode current = root;
        int i = 0;
        while(i < word.length()){
            current = current.getMap().computeIfAbsent(word.charAt(i), c-> new TrieNode());
            i++;
        }
        current.setIsWord(true);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        boolean wordExist = false;
        int i = 0;
        TrieNode current = root;
        while(i < word.length()){
            char c = word.charAt(i);
            if(c == '.'){

            }else{

            }
            TrieNode node = current.getMap().get(word.charAt(i));
            if(node == null)
                return false;
            else
                current = node;
            i++;
        }
        return current.isWord();
    }


    public boolean searchWord(String word, int i, TrieNode node){
        if(node == null)
            return false;
        if(i == word.length()) return node.isWord();
        char c = word.charAt(i);
        if(c == '.'){
            Map<Character,TrieNode> entryMap = node.getMap();
            for(Map.Entry<Character,TrieNode> maps: entryMap.entrySet()){
                return searchWord(word,i+1,maps.getValue());
            }
        }else{
            return searchWord(word,i+1,node.getMap().get(word.charAt(i)));
        }
        return false;

    }
}

class TrieNode{
    Map<Character,TrieNode> map = new HashMap<>();
    boolean isWord;

    public void setIsWord(boolean isWord){
        this.isWord= isWord;
    }

    public void setMap(Map<Character,TrieNode> map){
        this.map = map;
    }

    public boolean isWord(){
        return this.isWord;
    }


    public Map<Character,TrieNode> getMap(){
        return this.map;
    }
}

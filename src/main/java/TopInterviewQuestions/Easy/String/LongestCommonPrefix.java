package TopInterviewQuestions.Easy.String;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonPrefix {
    Trie head = new Trie();
    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] arrayString = {"codable","code","coder","coding"};
        for(int i =0;i<arrayString.length;i++){
            lcp.insertTrie(arrayString[i]);
        }
        System.out.println(lcp.findLcp());
    }

    public void insertTrie(String str){
        Trie current = head;
        for(int i =0;i<str.length();i++){
             current.getTrieMap().computeIfAbsent(str.charAt(i),c->new Trie());
            current=current.getTrieMap().get(str.charAt(i));
        }
        current.setEndOfWord(true);
    }

    public String findLcp(){
        StringBuffer sb = new StringBuffer();
        Trie current = head;
        while(current!=null && !current.isEndOfWord &&current.getTrieMap().size()==1){
            System.out.println(current.getTrieMap().size());
            for(Map.Entry<Character,Trie> map:current.getTrieMap().entrySet()){
                sb.append(map.getKey());
                current = map.getValue();
            }
        }
        return sb.toString();
    }

}

class Trie{
    boolean isEndOfWord;
    Map<Character,Trie> trieMap = new HashMap<>();

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public Map<Character, Trie> getTrieMap() {
        return trieMap;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }

    public void setTrieMap(Map<Character, Trie> trieMap) {
        this.trieMap = trieMap;
    }
}

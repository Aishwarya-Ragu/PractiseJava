package May;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class UniqueCharacterInString {
    public static void main(String args[]){
        String s ="letcode";
        int len = s.length();
        Map<Character,Integer> linkMap = new LinkedHashMap<>();
        for(int i =0;i<len;i++){
            linkMap.put(s.charAt(i),linkMap.get(s.charAt(i))!=null?
                                  linkMap.get(s.charAt(i))+1 : 1);
        }
        int index =-1;
        for(Map.Entry<Character,Integer> entry:linkMap.entrySet()){
            if(entry.getValue() == 1){
                index =s.indexOf(entry.getKey());
                break;
            }
        }
        System.out.println(index);

    }
}

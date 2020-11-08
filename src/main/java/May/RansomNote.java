package May;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RansomNote {
    public static void main(String args[]){
    String ransomNote="a";
    String magazine = "b";
    System.out.println(canConstruct(ransomNote,magazine));

}

    private static boolean canConstruct(String ransomNote, String magazine) {
        char[] magazineArray = magazine.toCharArray();
        char [] ransomArray = ransomNote.toCharArray();
        int ransomLength = ransomArray.length;
        int magazineLength = magazineArray.length;
        Map<Character,Integer> magazineMap = new HashMap<>();
        Map<Character,Integer> ransomMap = new HashMap<>();
        int ransomIndex=0;
        int magazineIndex=0;
        if(ransomLength > magazineLength){
            return false;
        }else{
            while(magazineIndex<magazineLength){
                magazineMap.put(magazineArray[magazineIndex],magazineMap.get(magazineArray[magazineIndex])!=null?
                         magazineMap.get(magazineArray[magazineIndex])+1:1);
                magazineIndex++;
                if(ransomIndex<ransomLength){
                    ransomMap.put(ransomArray[ransomIndex],ransomMap.get(ransomArray[ransomIndex])!=null?
                            ransomMap.get(ransomArray[ransomIndex])+1:1);
                    ransomIndex++;
                }
            }
        }
        boolean check =true;
        for(Map.Entry<Character,Integer> entry:ransomMap.entrySet()){
            Integer ransomKey = ransomMap.get(entry.getKey())!=null? ransomMap.get(entry.getKey()):0;
            Integer magazineKey = magazineMap.get(entry.getKey())!=null? magazineMap.get(entry.getKey()):0;
            if(ransomKey < magazineKey){
                check &=true;
            }else{
                check &=false;
            }

        }
        return check;





    }

}

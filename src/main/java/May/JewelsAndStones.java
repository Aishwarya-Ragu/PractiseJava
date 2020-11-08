package May;

import java.util.*;
import java.util.stream.Collectors;

public class JewelsAndStones {
    public static void main(String args[]){
        String J="aAB";
        String S = "aAABbbb";
        System.out.println(numJewelsInStones(J,S));

    }

    private static int numJewelsInStones(String j, String s) {
        char[] jewelArray = s.toCharArray();

        List<Character> stoneList =
                j.chars().mapToObj(c -> (char) c).collect(Collectors.toList());
        int i = 0;
        int checkCount=0;
        while(i<jewelArray.length){
            if(stoneList.contains(jewelArray[i])){
                checkCount++;
            }
            i++;
        }  return checkCount;  }
}




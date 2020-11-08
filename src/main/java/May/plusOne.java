package May;

import org.w3c.dom.ls.LSInput;
import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class plusOne {
    public static void main(String[] args) {
        plusOne po = new plusOne();
        po.plusOne(new int[]{9,8,7,6,5,4,3,2,1,0});

    }
    public int[] plusOne(int[] digits) {
        /*long num =0;
        for(int a : digits){
            num = (num*10)+a;
        }
         num = num+1;

        LinkedList<Long> list = new LinkedList<>();

        while(num%10 != num){
            list.addFirst(num%10);
            num = num/10;
        }
        list.addFirst(num);

        return list.stream().mapToInt(i -> i.intValue()).toArray();*/

        int[] num = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> list = Arrays.stream(num).mapToObj(a->(int)a).collect(Collectors.toList());
        int[] nums = list.stream().mapToInt(a->a).toArray();
        String s = "Aishwarya";
        List<Character> charsa = s.chars().mapToObj(a ->(char)a).collect(Collectors.toList());
        Character[] abc = charsa.toArray(new Character[charsa.size()]);
        return null;

    }
}

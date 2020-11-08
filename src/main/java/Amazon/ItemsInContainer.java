package Amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ItemsInContainer {
    public static void main(String[] args) {
        ItemsInContainer ic = new ItemsInContainer();
        String str = "|**|";
        List<Integer> startIndices = Arrays.asList(1);
        List<Integer> endIndices = Arrays.asList(4);

        List<Integer> a = ic.numberOfItems(str, startIndices, endIndices);
        System.out.println(a);
    }

    public static List<Integer> numberOfItems(String s,
                                              List<Integer> startIndices, List<Integer> endIndices) {
        int i =0;
        List<Integer> output = new ArrayList<>();
        while (i<startIndices.size() && i<endIndices.size()){
            int startIndex = startIndices.get(i);
            int endIndex = endIndices.get(i);
            Stack<Character> stack = new Stack<>();
            int count =0;
            if(startIndex > s.length() || endIndex > s.length())
                return output;
            for(int j = startIndex-1 ;j <endIndex;j++){
                    if(!stack.isEmpty() && s.charAt(j) == '*') stack.push(s.charAt(j));
                    while(!stack.isEmpty() && s.charAt(j) == '|'){
                        char ch  = stack.pop();
                        if(ch == '*'){
                            count++;
                        }
                    }
                    if(s.charAt(j) == '|') stack.push(s.charAt(j));
            }
            i++;
            output.add(count);
        }
        return output;
    }
}

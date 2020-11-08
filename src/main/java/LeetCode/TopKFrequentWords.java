package LeetCode;


import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;
import static java.util.Map.Entry.comparingByValue;

//https://leetcode.com/problems/top-k-frequent-words/
public class TopKFrequentWords {
    public static void main(String args[]){
        String[] words = {"i", "love", "leetcode", "i", "love", "coding"};

        //{"i", "love", "leetcode", "i", "love", "coding"};
        //{"the", "day","a","a", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        int k =1;
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(int i =0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        LinkedHashMap<String, Integer> a = map.entrySet().stream().sorted(Collections.reverseOrder(comparingByValue())).collect(
                Collectors.toMap(e -> e.getKey(), e -> e.getValue(), (e1, e2) -> e2, LinkedHashMap::new));

        List<Map.Entry<String ,Integer>> entries = new LinkedList<Map.Entry<String,Integer>>(a.entrySet());

        Collections.sort(entries, new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue() == o2.getValue()){
                    return o1.getKey().compareTo(o2.getKey());
                }else{
                    return 0;
                }
            }
        });

        List<String> mapString = new ArrayList<String>();
        int j =0;
        for(Map.Entry<String,Integer> entry:entries){
            if(j<k){
                mapString.add(entry.getKey());
                j++;
            }
        }
        System.out.println(mapString);



    }
}

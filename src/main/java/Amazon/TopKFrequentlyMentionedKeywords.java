package Amazon;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByValue;

//https://leetcode.com/discuss/interview-question/542597/

public class TopKFrequentlyMentionedKeywords {
    public static void main(String args[]){
        List<String> keyword = Arrays.asList("anacell", "betacellular", "cetracular", "deltacellular", "eurocell");
        int k =2;
        List<String> review = Arrays.asList( "I love anacell Best services; Best services provided by anacell",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than anacell",
                "Betacellular is better than deltacellular.");
        Map<String,Integer> map = keyword.stream().collect(Collectors.toMap(e->e, e->0));

            review.forEach(reviews ->{
                    for(String keywords:keyword){
                        if(reviews.toLowerCase().contains(keywords)){
                            map.put(keywords,map.getOrDefault(keywords,0)+1);
                        }
                }
            });


       Map<String, Integer> a = map.entrySet().stream().
               sorted(Collections.reverseOrder(comparingByValue())).
               collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue(),(e1, e2) -> e2, LinkedHashMap::new));
        System.out.println(a);
       Set<String> keys = a.keySet();
        List<String> list = new ArrayList<>();
        //keys.stream().collect(Collectors.toList());
        int j =0;
        for(String key:keys){
            if(j<k){
                list.add(key);
                j++;
            }
        }
        System.out.println(list);

    }
}

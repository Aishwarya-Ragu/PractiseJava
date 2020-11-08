package TopInterviewQuestions.Medium.String;

import java.util.*;

public class GroupAnagram {
    public static void main(String[] args) {
        String[] strs={"eat","tea","tan","ate","nat","bat"};
        GroupAnagram ga = new GroupAnagram();
        System.out.println(ga.groupAnagrams(strs));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        int count[] = new int[26];
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0;i<strs.length;i++){
            String str = strs[i];
            Arrays.fill(count,0);
            int len = str.length();
            for(int j=0;j<len;j++) {
                int num = str.charAt(j) - 'a';
                count[str.charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int k =0;k<26;k++){
                sb.append("#");
                sb.append(count[k]);
            }

            String key = sb.toString();

            if(!map.containsKey(key))
                map.put(key,new ArrayList<>());
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
